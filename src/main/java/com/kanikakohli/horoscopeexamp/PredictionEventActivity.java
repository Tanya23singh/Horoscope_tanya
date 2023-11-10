package com.kanikakohli.horoscopeexamp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class PredictionEventActivity extends AppCompatActivity {

    String[] ari,taur,gemi,can,le,virg,libr,scorpi,sagittar,capricor,pisce,aquari;
    String[][] predict= {
            ari = new String[]{"Chu", "Che", "Cho", "La", "Li", "Le", "Lo", "A", "C", "L"},
            taur = new String[]{"E", "V", "Ai", "O", "Vaa", "Vu", "Ve", "Vo", "Vi"},
            gemi = new String[]{"Ka", "Ki", "Ku", "Gh", "Chh", "Ke", "Ko", "Ha", "K"},
            can = new String[]{"Hi", "Hu", "He", "Ho", "Da", "Di", "Du", "De", "Do"},
            le = new String[]{"M", "Mi", "Mu", "Me", "Mo", "Ta", "Ti", "Tu", "Te"},
            virg = new String[]{"To", "Pa", "Pi", "Pe", "Sha", "Thha", "Pe", "Po"},
            libr = new String[]{"Ra", "Ri", "Ro", "Ru", "Re", "Taa", "Ti", "Tu", "Te"},
            scorpi = new String[]{"To", "N", "Ni", "Nu", "Ne", "No", "Ya", "Yi", "Yu"},
            sagittar = new String[]{"Ye", "Yo", "Bha", "Bhi", "Bhu", "Dha", "Pha", "Dhha", "Bhe"},
            capricor = new String[]{"Bho", "Ja", "Ji", "Khi", "Khu", "Khoo", "Khe", "Kho", "Ga", "Gi"},
            aquari = new String[]{"Gu", "Ge", "Go", "Sa", "Si", "Soo", "Se", "So", "Da"},
            pisce = new String[]{"Di", "Du", "Thha", "Jha", "Jya", "De", "Do", "Ch", "Chi"}};

    ImageView imageView;
    EditText etname;
    Button button;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction_event);

        imageView=findViewById(R.id.predictionImage);
        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.image_anim);
        imageView.startAnimation(animation);

        button=findViewById(R.id.button);
        etname=findViewById(R.id.Name);






        //choose daily,month,yearly
        Spinner dropdown=findViewById(R.id.spinner1);
        String[] items=new String[]{"Choose","Today","Monthly","Yearly"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter);

     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
                 Intent intent =  new Intent(PredictionEventActivity.this,DataPredictActivity.class);
                 startActivity(intent);


         }
     });

    }
}