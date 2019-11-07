package com.rocket.a57357.auth.SignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.rocket.a57357.Home.Home;
import com.rocket.a57357.R;
import com.rocket.a57357.auth.Login.Login;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    Button mLogin, mSignUp;
    EditText mName, mEmail, mPass;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        iniview();
    }

    private void iniview() {
        mName = findViewById(R.id.Name);
        mEmail = findViewById(R.id.Email_Sign_IN);
        mPass = findViewById(R.id.Password_Sign_IN);
        mLogin = findViewById(R.id.Go_Log_in);
        mLogin.setOnClickListener(this);
        mSignUp = findViewById(R.id.Go_Home);
        mSignUp.setOnClickListener(this);
        mAuth=FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Go_Log_in:
                startActivity(new Intent(SignUp.this, Login.class));
                break;

            case R.id.Go_Home:
                if(check())
                    setData(mEmail.getText().toString(),mPass.getText().toString());
                break;
        }
    }

    private void setData(String Email,String Password) {
        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Toast.makeText(SignUp.this,"تم تسجيل بنجاح",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(SignUp.this, Home.class));
                }
                else{
                    Toast.makeText(SignUp.this, "لم يتم التسجيل بنجاح",Toast.LENGTH_LONG).show();
                }

            }
        });



    }

    boolean check() {
        if (mName.getText().toString().isEmpty()) {
            Toast.makeText(SignUp.this, "الرجاء ادخال الحساب", Toast.LENGTH_LONG).show();
            return false;}
        else if (mEmail.getText().toString().isEmpty()) {
            Toast.makeText(SignUp.this, "الرجاء ادخال الحساب", Toast.LENGTH_LONG).show();
            return false;
        } else if (mPass.getText().toString().isEmpty()) {
            Toast.makeText(SignUp.this, "الرجاء ادخال الرقم السرى", Toast.LENGTH_LONG).show();
            return false;
        } else
            return true;
    }}
