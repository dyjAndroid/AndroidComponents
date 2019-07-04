package com.example.viewmodelsdemo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * created by Sunday
 * on 2019-07-04 13:45
 */
public class MyViewModel extends ViewModel {

    private MutableLiveData<User> mUser = new MutableLiveData<>();

    public MutableLiveData<User> getUser() {
        return mUser;
    }

    /**
     * setValue：只能在主线程中调用
     * postValue：后台线程和主线程都可以调用
     */
    public void setUsers(User user) {
//        mUser.setValue(user);
        mUser.postValue(user);
    }

}
