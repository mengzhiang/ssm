package com.zhiang.dao;

import com.zhiang.po.User;

import java.util.List;


public interface UserDao {

    public void insert(User user);
    
    public User findUserById (int userId);
    
    public List<User> findAllUsers();


    
}