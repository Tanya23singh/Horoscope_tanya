package com.kanikakohli.horoscopeexamp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText Eemail,epassword;
    Button login,sign;
    FirebaseAuth mAuth;
public static String PREFS_NAME="MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Eemail=findViewById(R.id.editTextTextEmailAddress);
        epassword=findViewById(R.id.editTextTextPassword);
        login=findViewById(R.id.login);
        sign=findViewById(R.id.sign);

        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=Eemail.getText().toString();
                String password=epassword.getText().toString();

                if (TextUtils.isEmpty(email)){
                    Eemail.setError("Enter email");
                }
                if (TextUtils.isEmpty(password)){
                    epassword.setError("Enter Passowrd");
                }


                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                              if (task.isSuccessful()){
                                  SharedPreferences sharedPreferences=getSharedPreferences(MainActivity.PREFS_NAME,0);
                                  SharedPreferences.Editor editor= sharedPreferences.edit();


                                  editor.putBoolean("hasLoggedIn",true);
                                  editor.commit();

                                  startActivity(new Intent(MainActivity.this,NotesEventActivity.class));
                                  finish();

                              } else{

                                  Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).toString(),Toast.LENGTH_SHORT).show();
                              }
                            }
                        });


            }
        });


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

    }
}