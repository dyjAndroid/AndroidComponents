package com.example.databindingdemo;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * created by Sunday
 * on 2019-07-06 12:57
 */
public class ObservableUser extends BaseObservable {

    private int mAge;
    private String mName;

    public ObservableUser(int age, String name) {
        mAge = age;
        mName = name;
    }

    @Bindable
    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
        notifyPropertyChanged(BR.age);
//        notifyChange();
    }

    @Bindable
    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
        notifyPropertyChanged(BR.name);
    }
}
