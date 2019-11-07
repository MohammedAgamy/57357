package com.rocket.a57357.auth.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rocket.a57357.R;
import com.rocket.a57357.auth.SignUp.SignUp;

public class Login extends AppCompatActivity {
Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


btn2=findViewById(R.id.Go_SignUp);
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(Login.this, SignUp.class));
        Toast.makeText(Login.this,"agamy",Toast.LENGTH_LONG).show();
    }
});

    }
}
