package com.example.navigationdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class BlankFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(MainActivity.TAG, "first fragment onCreate:" + this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(MainActivity.TAG, "first fragment onCreateView:" + this);
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        view.findViewById(R.id.toSecond).setOnClickListener(view1 -> Navigation.findNavController(view).navigate(R.id.action_first_to_second));
        return view;
    }


}
