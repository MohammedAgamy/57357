package com.rocket.a57357.Home;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.rocket.a57357.R;

public class Home extends AppCompatActivity {
    ImageView mImageview;
    DrawerLayout mLyout;
    LinearLayout mLiner;
    ViewPager mPager;
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        iniview();
        SLIDER();
        openDrawer();
        getDataInCard();

        mImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mLyout.openDrawer(Gravity.LEFT);

            }
        });


    }

    private void getDataInCard() {
        CardView zakatEelmal_view = findViewById(R.id.zakat_elmal);
        zakatEelmal_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstFragment fragment = new firstFragment();
                Bundle arg = new Bundle();
                arg.putParcelable("Information", new InformationOB(R.string.zakatElmalHeader, R.string.zakah_elmal));
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack("tag").commit();
                fragment.setArguments(arg);
            }
        });



    }

    private void iniview() {
        mImageview = findViewById(R.id.Home_nav);
        mLyout = findViewById(R.id.fragment_container);
        mLiner = findViewById(R.id.SliderDots);
        mPager = findViewById(R.id.V_page);


    }

    public void openDrawer() {

    }

    private void SLIDER() {

        viewPagerAdapter viewPagerAdapter = new viewPagerAdapter(this);
        mPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            mLiner.addView(dots[i], params);

        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.activity_dot));

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.activity_dot));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}

