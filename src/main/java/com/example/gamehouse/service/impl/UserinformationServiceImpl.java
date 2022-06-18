package com.example.gamehouse.service.impl;

import com.example.gamehouse.Entity.User;
import com.example.gamehouse.Entity.UserInformation;
import com.example.gamehouse.repostitory.IUserInformationRepostory;
import com.example.gamehouse.service.IUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinformationServiceImpl implements IUserInformationService {

    @Autowired
    IUserInformationRepostory iUserInformationRepostory;

    @Override
    public boolean addUserInformation(UserInformation userInformation){
        UserInformation save = iUserInformationRepostory.save(userInformation);
        return (save != null);
    }

    @Override
    public boolean updateUserInformation(UserInformation userInformation){
        UserInformation save = iUserInformationRepostory.save(userInformation);
        return (save != null);
    }

    @Override
    public UserInformation findUserInformation(String userName){

        UserInformation find = iUserInformationRepostory.findById(userName).orElse(null);
        return find;
    }

}
