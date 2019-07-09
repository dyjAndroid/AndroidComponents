package com.example.paggingdemo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Sunday
 * on 2019-07-09 12:20
 */
public class MyDataSource extends PositionalDataSource<User> {
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<User> callback) {
        callback.onResult(loadData(0, 10), 0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<User> callback) {
        Log.d(MainActivity.TAG, "startPosition:" + params.startPosition);
        callback.onResult(loadData(params.startPosition, 10));
    }

    private List<User> loadData(int startPosition, int count) {
        List<User> users = new ArrayList<>();
        Log.d(MainActivity.TAG,"Thread id:" + Thread.currentThread().getId());
        for (int i = 0; i < count; i++) {
            User user = new User();
            user.setId(startPosition + i);
            user.setName("name:");
            users.add(user);
        }
        return users;
    }
}
