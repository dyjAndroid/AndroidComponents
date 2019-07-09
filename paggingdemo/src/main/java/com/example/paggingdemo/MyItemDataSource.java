package com.example.paggingdemo;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * created by Sunday
 * on 2019-07-09 13:51
 */
public class MyItemDataSource extends ItemKeyedDataSource<Integer, User> {

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<User> callback) {
        callback.onResult(loadData(0, 10));
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<User> callback) {
        Log.d(MainActivity.TAG, "load after");
        callback.onResult(loadData(params.key, 10));
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<User> callback) {
        Log.d(MainActivity.TAG, "load before");
    }

    @NonNull
    @Override
    public Integer getKey(@NonNull User item) {
        return item.getId();
    }

    private List<User> loadData(int startPosition, int count) {
        List<User> users = new ArrayList<>();
        Log.d(MainActivity.TAG,"Thread id:" + Thread.currentThread().getId());
        for (int i = 0; i < count-2; i++) {
            User user = new User();
            user.setId(startPosition + i);
            user.setName("name:");
            users.add(user);
        }
        return users;
    }
}
