package com.rocket.a57357.auth.Login;

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
import com.rocket.a57357.auth.SignUp.SignUp;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button mLogin, mSignUp;
    EditText mEmail, mPass;
    FirebaseAuth mAth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        iniview();


    }

    private void iniview() {

        mSignUp = findViewById(R.id.Go_SignUp);
        mSignUp.setOnClickListener(this);
        mLogin = findViewById(R.id.Go_Home);
        mLogin.setOnClickListener(this);
        mEmail = findViewById(R.id.Email_Sign_IN);
        mPass = findViewById(R.id.Password_Sign_IN);
        mAth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Go_SignUp:
                startActivity(new Intent(Login.this, SignUp.class));
                break;
            case R.id.Go_Home:
                if (check())
                setdata(mEmail.getText().toString(), mPass.getText().toString());

                break;
        }
    }

    boolean check() {
        if (mEmail.getText().toString().isEmpty()) {
            Toast.makeText(Login.this, "الرجاء ادخال الحساب", Toast.LENGTH_LONG).show();
            return false;
        } else if (mPass.getText().toString().isEmpty()) {
            Toast.makeText(Login.this, "الرجاء ادخال الرقم السرى", Toast.LENGTH_LONG).show();
            return false;
        } else
            return true;
    }

    private void setdata(String email, String password) {
        mAth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(Login.this, Home.class));

                        } else {
                            Toast.makeText(Login.this, "تاكد من ادخالك المعلومات الصحيحه", Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

}

