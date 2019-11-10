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
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        iniview();


    }

    private void iniview() {

        mEmail = findViewById(R.id.Email_Sign_IN);
        mPass = findViewById(R.id.Password_Sign_IN);
        mLogin = findViewById(R.id.Go_Home_From_LogIN);
        mLogin.setOnClickListener(this);
        mSignUp = findViewById(R.id.Go_SignUp_From_LogIN);
        mSignUp.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Go_Home_From_LogIN:
                if (chach())
                    setData(mEmail.getText().toString(), mPass.getText().toString());

                break;
            case R.id.Go_SignUp_From_LogIN:
                startActivity(new Intent(Login.this, SignUp.class));
                break;
        }

    }

    public void setData(String email, String Pass) {
        mAuth.signInWithEmailAndPassword(email, Pass).addOnCompleteListener(this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Login.this, "تم التسجيل بنجاح ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, Home.class));
                        }
                        else{
                            Toast.makeText(Login.this, "الرجاء ادخال البيانات صحيحه", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }

    boolean chach() {
        if (mEmail.getText().toString().isEmpty()) {
            Toast.makeText(Login.this, "الرجاء ادخال البيانات ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (mPass.getText().toString().isEmpty()) {
            Toast.makeText(Login.this, "الرجاء ادخال كلمة المرور ", Toast.LENGTH_SHORT).show();
            return false;
        } else return true;
    }
}
