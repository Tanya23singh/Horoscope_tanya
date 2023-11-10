package com.kanikakohli.horoscopeexamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotesEventActivity extends AppCompatActivity {

    Button thought, prediction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_event);


        thought=findViewById(R.id.thought);
        prediction=findViewById(R.id.prediction);


        thought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ThoughtActivity.class);
                startActivity(intent);

            }
        });
        prediction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent=new Intent(getApplicationContext(),PredictionEventActivity.class);
            startActivity(intent);

            }
        });
    }
}