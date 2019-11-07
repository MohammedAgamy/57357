package com.rocket.a57357.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.rocket.a57357.R;
import com.rocket.a57357.auth.Login.Login;

public class splash extends AppCompatActivity {
    ImageView mImage;
    Animation mAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        iniview();
        Anim();
        Splash();


    }


    public void iniview() {
        mImage = findViewById(R.id.logo);
        mAnim = AnimationUtils.loadAnimation(this, R.anim.anmi_splash);
    }

    private void Anim() {
        mAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImage.startAnimation(mAnim);

    }



    private void Splash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this, Login.class));
            }
        },2000);
    }
}
