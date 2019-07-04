package com.example.roomdemo;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.List;

/**
 * created by Sunday
 * on 2019-07-04 19:10
 */
public class UserViewModel extends AndroidViewModel {

    private MediatorLiveData<List<User>> mUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        Log.d(MainActivity.TAG, "UserViewModel Thread name:" + Thread.currentThread().getName() + ",id:" + Thread.currentThread().getId());
        mUsers = new MediatorLiveData<>();
        LiveData<List<User>> listLiveData = UserDatabase.getInstance(application).userDao().queryUsersByName();
        mUsers.addSource(listLiveData, mUsers::setValue);
    }


    public MediatorLiveData<List<User>> getUsers() {
        return mUsers;
    }
}
