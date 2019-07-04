package com.example.roomdemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * created by Sunday
 * on 2019-07-04 17:34
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE name = :name")
    List<User> queryUsersByName(String name);

    @Query("SELECT * FROM user")
    LiveData<List<User>> queryUsersByName();
}
