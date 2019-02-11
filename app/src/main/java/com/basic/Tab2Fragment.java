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

public class Tab2Fragment extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private Button button;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.tab2_fragment,container,false);


        button = view.findViewById(R.id.tab2_button);
        button.setOnClickListener((view1) ->{
            Toast.makeText(getActivity(), "test Button toast 2", Toast.LENGTH_LONG).show();
        } );


        return view;
    }
}
