package com.example.roomdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Sunday";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.query:
                AppExecutors.getInstance().io(() -> {
                    List<User> users = MyDatabase.getInstance(this).userDao().queryUsersByName("张三");
                    for (User user :
                            users) {
                        Log.d(TAG, "user:" + user.toString());
                    }
                });

                break;
            case R.id.insert:
                AppExecutors.getInstance().io(() -> {
                    User user = new User();
                    user.setAge(10);
                    user.setName("张三");
                    MyDatabase.getInstance(this).userDao().insertUser(user);
                    Log.d(TAG, "insert data");
                });
                break;
            default:
                break;
        }
    }
}
