package com.kanikakohli.horoscopeexamp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataPredictActivity extends AppCompatActivity {

    TextView predtdetail,Color1,ColorName1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_predict);


        predtdetail=findViewById(R.id.PredictDetails);
        Color1=findViewById(R.id.color);
        ColorName1=findViewById(R.id.ColorName);

        ApiInterface apiInterface=ApiClient.getRetrofit().create(ApiInterface.class);

        Call<List<Modal>> call=apiInterface.getModals();




        call.enqueue(new Callback<List<Modal>>() {
            @Override
            public void onResponse(Call<List<Modal>> call, Response<List<Modal>> response) {
                if (!response.isSuccessful()){

                   predtdetail.setText("Code:"+response.code());
                   ColorName1.setText("Code:"+response.code());
                    return;
                }
                List<Modal> modals=response.body();
                for (Modal modal :modals){
                    String predict="";
                    String colors="";

                    predict += " ' " + modal.getPredict()+" ' ";
                    colors +=" " +modal.getColor()+" ";

                    predtdetail.append(predict);
                    ColorName1.append(colors);

                }

            }

            @Override
            public void onFailure(Call<List<Modal>> call, Throwable t) {

            }
        });








    }
}