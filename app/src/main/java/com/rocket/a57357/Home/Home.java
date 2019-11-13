package com.rocket.a57357.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;

import com.rocket.a57357.R;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CardView zakatEelmal_view = findViewById(R.id.zakat_elmal);
        zakatEelmal_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstFragment fragment = new firstFragment();
                Bundle arg = new Bundle();
                arg.putParcelable("Information",new InformationOB(R.string.zakatElmalHeader,R.string.zakah_elmal));
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).addToBackStack( "tag" ).commit();
                fragment.setArguments(arg);

            }
        });
        CardView elsadkaElgarayaView = findViewById(R.id.elsadka_elgarya);
        elsadkaElgarayaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,new SecondFragment()).addToBackStack( "tag" ).commit();
            }
        });
    }
}
