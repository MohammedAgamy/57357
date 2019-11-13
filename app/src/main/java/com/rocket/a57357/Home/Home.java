package com.rocket.a57357.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

import com.rocket.a57357.R;

public class Home extends AppCompatActivity {
    firstFragment firstFragment = new firstFragment();
    Bundle arg = new Bundle();
    InformationOB information;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CardView zakatEelmal_view = findViewById(R.id.zakat_elmal);
        zakatEelmal_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                information = new InformationOB(R.string.zakatElmalHeader,R.string.zakah_elmal);
                goingToFirstFragment(information);
            }
        });
        CardView companyProgramView = findViewById(R.id.company_program);
        companyProgramView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                information = new InformationOB(R.string.company_program,R.string.company_program_dis);
                goingToFirstFragment(information);
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
        CardView eltabroaElshahriView = findViewById(R.id.eltabra_elshahri);
        eltabroaElshahriView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                information = new InformationOB(R.string.eltabra_elshahri,R.string.eltabra_elshahri_dis);
                goingToFirstFragment(information);
            }
        });
        CardView kfaltElmaridView = findViewById(R.id.kfaltElmarid_view);
        kfaltElmaridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                information = new InformationOB(R.string.kfala_alag,R.string.kfala_alag_dis);
                goingToFirstFragment(information);
            }
        });
    }
    private void goingToFirstFragment(InformationOB information){
        arg.putParcelable("Information",information);
        FragmentManager fragmentManger = getSupportFragmentManager();
        fragmentManger.beginTransaction().replace(R.id.fragment_container,firstFragment).addToBackStack("tag").commit();
        firstFragment.setArguments(arg);
    }
}
