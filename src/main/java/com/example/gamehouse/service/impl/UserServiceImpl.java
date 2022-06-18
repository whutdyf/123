package com.example.gamehouse.service.impl;

import com.example.gamehouse.Entity.User;
import com.example.gamehouse.repostitory.IUserRepostory;
import com.example.gamehouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepostory userRepostory;

    @Override
    public boolean addUser(User user){
        User save = userRepostory.save(user);
        return true;
    }

    @Override
    public boolean updateUser(User user){
        User save = userRepostory.save(user);
        return true;
    }

    @Override
    public User findUser(String userName){

        User find = userRepostory.findById(userName).orElse(null);
        return find;

    }

}
