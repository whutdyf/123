package com.example.gamehouse.service;
import com.example.gamehouse.Entity.User;

public interface IUserService{

    public boolean addUser(User user);
    public boolean updateUser(User user);
    public User findUser(String userName);
}
