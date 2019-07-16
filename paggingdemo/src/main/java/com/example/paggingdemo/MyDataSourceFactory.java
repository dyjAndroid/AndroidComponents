package com.example.paggingdemo;

import androidx.paging.DataSource;

/**
 * created by Sunday
 * on 2019-07-09 12:24
 */
public class MyDataSourceFactory extends DataSource.Factory<Integer, User> {
    @Override
    public DataSource<Integer, User> create() {
        return new MyDataSource();
    }
}
