package com.example.gamehouse.controller;

import com.example.gamehouse.Entity.User;
import com.example.gamehouse.response.ResponseResult;
import com.example.gamehouse.response.ResponseResultFactory;
import com.example.gamehouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping("/addUser")
    public ResponseResult addUser(User user){

        boolean a = userService.addUser(user);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        return responseResult;
    }

    @PostMapping("/changeUser")
    public ResponseResult change(User user){
        boolean a = userService.addUser(user);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        return responseResult;
    }

    @PostMapping("/hello")
    public String hello(){
        return "hellp world";
    }
}
