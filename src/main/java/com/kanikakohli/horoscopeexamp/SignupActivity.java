package com.kanikakohli.horoscopeexamp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    EditText etname,etemail,etpass,etconfrimpass;
    Button signup;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        etname=findViewById(R.id.username);
        etemail=findViewById(R.id.emailid);
        etpass=findViewById(R.id.password);
        etconfrimpass=findViewById(R.id.confrimPass);
        signup=findViewById(R.id.signup);

        mAuth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString();
                String email=etemail.getText().toString();
                String pass=etpass.getText().toString();
                String confrimpass=etconfrimpass.getText().toString();

                if (TextUtils.isEmpty(name)){
                    etname.setError("Enter Full Name");
                }
                if (TextUtils.isEmpty(email)){
                    etemail.setError("Enter Email");
                }
                if (TextUtils.isEmpty(pass)){
                    etpass.setError("Enter Password");
                }
                if (TextUtils.isEmpty(confrimpass)){
                    etconfrimpass.setError("Enter Confrim Password");
                }
                if (!pass.equals(confrimpass)){
                    etconfrimpass.setError("Enter Correct Password");
                }

                mAuth.createUserWithEmailAndPassword(email,pass)
           .addOnCompleteListener(task -> {
               if (task.isSuccessful()){
                   Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                   startActivity(intent);
                   Toast.makeText(getApplicationContext(),"Sign Up Successful",Toast.LENGTH_SHORT).show();
                        finish();
               }else{
                   Toast.makeText(getApplicationContext(),"Authentication failed",Toast.LENGTH_SHORT).show();
               }

                });
            }

        });


    }
}