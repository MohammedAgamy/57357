package com.rocket.a57357.Home;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rocket.a57357.R;

public class firstFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            InformationOB information = bundle.getParcelable("Information");
            TextView headerText = rootView.findViewById(R.id.header_text_view);
            headerText.setText(information.getHeader());
            TextView descriptionTextView = rootView.findViewById(R.id.description_text_view);
            descriptionTextView.setText(information.getDescription());
        }
        return  rootView;
    }
}