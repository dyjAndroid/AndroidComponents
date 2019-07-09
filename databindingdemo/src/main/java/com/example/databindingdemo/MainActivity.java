package com.example.databindingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;
import android.view.View;

import com.example.databindingdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private User mUser;

    private ObservableUser mObservableUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mUser = new User("Dark", 18);
        mObservableUser = new ObservableUser(20, "App");
//        binding.setUser(mUser);
        binding.setObservableUser(mObservableUser);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.set:
//                mUser.setAge(20);
                mObservableUser.setAge(18);
                break;
            default:
                break;
        }
    }
}
