package com.example.gamehouse.service;

import com.example.gamehouse.Entity.User;
import com.example.gamehouse.Entity.UserInformation;

public interface IUserInformationService {
    public boolean addUserInformation(UserInformation userInformation);
    public boolean updateUserInformation(UserInformation userInformation);
    public UserInformation findUserInformation(String userName);
}
