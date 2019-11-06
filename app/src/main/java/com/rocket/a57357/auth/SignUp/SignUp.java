package com.rocket.a57357.auth.SignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rocket.a57357.Home.Home;
import com.rocket.a57357.R;

public class SignUp extends AppCompatActivity {
Button btn,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn=findViewById(R.id.Go_Home);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startActivity(new Intent(SignUp.this, Home.class));
            }
        });
    }
}
