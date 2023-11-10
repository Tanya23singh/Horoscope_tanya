package com.kanikakohli.horoscopeexamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThoughtActivity extends AppCompatActivity {

TextView mythought;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thought);

        mythought=findViewById(R.id.Mythought);

        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);

        Call<List<Modal>> call=apiInterface.getModal();




        call.enqueue(new Callback<List<Modal>>() {
            @Override
            public void onResponse(Call<List<Modal>> call, Response<List<Modal>> response) {
              if (!response.isSuccessful()){

                  mythought.setText("Code:"+response.code());
                  return;
              }
              List<Modal> modals=response.body();
              for (Modal modal :modals){
                String content="";

                content += " ' " + modal.getEvent()+" ' ";

                mythought.append(content);
              }

            }

            @Override
            public void onFailure(Call<List<Modal>> call, Throwable t) {

            }
        });











    }
}