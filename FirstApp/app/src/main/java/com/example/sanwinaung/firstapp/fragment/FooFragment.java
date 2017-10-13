package com.example.sanwinaung.firstapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sanwinaung.firstapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FooFragment extends Fragment {


    public FooFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_foo, container, false);
    }

}
