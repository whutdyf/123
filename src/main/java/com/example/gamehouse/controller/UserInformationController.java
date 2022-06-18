package com.example.gamehouse.controller;


import com.example.gamehouse.Entity.UserInformation;
import com.example.gamehouse.response.ResponseResult;
import com.example.gamehouse.response.ResponseResultFactory;
import com.example.gamehouse.service.IUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInf")
public class UserInformationController {

    @Autowired
    IUserInformationService iUserInformationService;

    @PostMapping("/addUserInf")
    public ResponseResult addUserInf(UserInformation userInformation){
        iUserInformationService.addUserInformation(userInformation);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        return responseResult;
    }

    @PostMapping("/updateUserInf")
    public ResponseResult updateUserInf(UserInformation userInformation){
        iUserInformationService.updateUserInformation(userInformation);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        return responseResult;
    }

    @PostMapping("/updateLocation")
    public void updateLocation(String userName, String houseName){
        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        userInformation.setCurrentHouse(houseName);
        iUserInformationService.updateUserInformation(userInformation);
    }

}
