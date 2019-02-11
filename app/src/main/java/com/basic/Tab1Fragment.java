package com.basic;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Tab1Fragment extends Fragment {
    private static final String TAG = "Tab1Fragment";

    private Button button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.tab1_fragment,container,false);


        button = view.findViewById(R.id.tab1_button);
        button.setOnClickListener((view1) ->{
            Toast.makeText(getActivity(), "test Button toast 1", Toast.LENGTH_LONG).show();
        } );


        return view;
    }
}
