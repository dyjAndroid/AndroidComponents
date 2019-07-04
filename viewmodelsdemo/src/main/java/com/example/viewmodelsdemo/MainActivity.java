package com.example.viewmodelsdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Sunday";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.name);

        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
        Log.d(TAG, "onCreate model:" + model);
        model.getUser().observe(this, user -> {
            Log.d(TAG, "onChanged...");
            mTextView.setText(user.getName());
        });
    }

    public void onClick(View view) {

        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);

        User user = new User();
        user.setName("hahhhahhahahhahhah");
        model.setUsers(user);
        Log.d(TAG, "onClick modle:" + model);
/*
        new Thread(() -> {
            User user = new User();
            user.setName("hahhhahhahahhahhah");
            model.setUsers(user);
            Log.d(TAG, "onClick modle:" + model);

        }).start();
*/
    }
}
