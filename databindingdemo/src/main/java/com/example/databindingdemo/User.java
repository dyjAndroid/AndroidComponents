package com.example.databindingdemo;

/**
 * created by Sunday
 * on 2019-07-05 09:49
 */
public class User {

    private String mName;
    private int mAge;

    public User(String name, int age) {
        mName = name;
        mAge = age;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
