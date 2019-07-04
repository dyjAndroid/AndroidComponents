package com.example.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Sunday";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        userViewModel.getUsers().observe(this, users -> {
            for (User user : users) {
                Log.d(MainActivity.TAG, "observer Thread name:" + Thread.currentThread().getName() + ",id:" + Thread.currentThread().getId());
                Log.d(TAG, "user:" + user.toString());
            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.query:
                AppExecutors.getInstance().io(() -> {
                    List<User> users = UserDatabase.getInstance(this).userDao().queryUsersByName("张三");
                    for (User user :
                            users) {
                        Log.d(TAG, "user:" + user.toString());
                    }
                });

                break;
            case R.id.insert:
                AppExecutors.getInstance().io(() -> {
                    Log.d(MainActivity.TAG, "Insert data Thread name:" + Thread.currentThread().getName() + ",id:" + Thread.currentThread().getId());
                    User user = new User();
                    user.setAge(10);
                    user.setName("张三");
                    UserDatabase.getInstance(this).userDao().insertUser(user);
                    Log.d(TAG, "insert data");
                });
                break;
            default:
                break;
        }
    }
}
