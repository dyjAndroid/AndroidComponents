package com.example.paggingdemo;

/**
 * created by Sunday
 * on 2019-07-09 12:01
 */
public class User {

    private int mId;
    private String mName;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name + ":" + mId;
    }
}
