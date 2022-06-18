package com.example.gamehouse.controller;

import com.example.gamehouse.Entity.House;
import com.example.gamehouse.Entity.UserInformation;
import com.example.gamehouse.response.ResponseResult;
import com.example.gamehouse.response.ResponseResultFactory;
import com.example.gamehouse.response.ReturnCode;
import com.example.gamehouse.service.IHouseService;
import com.example.gamehouse.service.IUserInformationService;
import com.example.gamehouse.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.gamehouse.Entity.User;

import java.util.LinkedList;
import java.util.List;


@RestController
@RequestMapping("/player")
@CrossOrigin
public class PlayController {

    private List<House> back_line;

    @Autowired
    IUserInformationService iUserInformationService;

    @Autowired
    IUserService iUserService;

    @Autowired
    IHouseService iHouseService;

    /**
     *
     * @param userName 登录账号
     * @param userPass 登录密码
     * @return 返回结果
     */
    @GetMapping("/login")
    public ResponseResult login(String userName, String userPass){
        User user = iUserService.findUser(userName);
        if(user == null){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(ReturnCode.USER_NOT_EXIST);
            return  responseResult;
        }
        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        if(!user.getUserPass().equals(userPass)){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(userInformation.getCurrentHouse() + " " + ReturnCode.USER_PASS_NOT_RIGHT);
            return  responseResult;
        }
        //更改登录状态
        userInformation.setUserStatus(1);
        iUserInformationService.updateUserInformation(userInformation);

        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        back_line = new LinkedList<House>();
        return  responseResult;
    }

    @GetMapping("/getNeighbours")
    public String getNeighbours(String userName, String direction){
        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        House house = iHouseService.findHouse(userInformation.getCurrentHouse());
        if(direction.equals("West"))
            return house.getWest();
        else if(direction.equals("East"))
            return house.getEast();
        else if(direction.equals("North"))
            return house.getNorth();
        else if(direction.equals("South"))
            return house.getSouth();
        else
            return null;
    }

    @GetMapping("/turnWest")
    public ResponseResult turnWest(String userName){

        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        House currentHouse = iHouseService.findHouse(userInformation.getCurrentHouse());
        House newHouse = iHouseService.findHouse(currentHouse.getWest());
        if(newHouse == null){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(currentHouse.getHouseName()+ " " + ReturnCode.HOUSER_WEST_NOT_EXIST);
            return  responseResult;
        }
        back_line.add(currentHouse);
        userInformation.setCurrentHouse(newHouse.getHouseName());
        iUserInformationService.updateUserInformation(userInformation);

        ResponseResult responseResult = ResponseResultFactory.buildResponseResult(newHouse.getHouseName() + back_line.size());
        return  responseResult;
    }

    @GetMapping ("/turnEast")
    public ResponseResult turnEast(String userName){

        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        House currentHouse = iHouseService.findHouse(userInformation.getCurrentHouse());
        House newHouse = iHouseService.findHouse(currentHouse.getEast());
        if(newHouse == null){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(currentHouse.getHouseName()+ " " + ReturnCode.HOUSER_EAST_NOT_EXIST);
            return  responseResult;
        }
        back_line.add(currentHouse);
        userInformation.setCurrentHouse(newHouse.getHouseName());
        iUserInformationService.updateUserInformation(userInformation);

        ResponseResult responseResult = ResponseResultFactory.buildResponseResult(newHouse.getHouseName() + back_line.size());
        return  responseResult;
    }

    @GetMapping("/turnNorth")
    public ResponseResult turnNorth(String userName){

        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        House currentHouse = iHouseService.findHouse(userInformation.getCurrentHouse());
        House newHouse = iHouseService.findHouse(currentHouse.getNorth());
        if(newHouse == null){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(currentHouse.getHouseName()+ " " + ReturnCode.HOUSER_NORTH_NOT_EXIST);
            return  responseResult;
        }
        back_line.add(currentHouse);
        userInformation.setCurrentHouse(newHouse.getHouseName());
        iUserInformationService.updateUserInformation(userInformation);

        ResponseResult responseResult = ResponseResultFactory.buildResponseResult(newHouse.getHouseName() + back_line.size());
        return  responseResult;
    }

    @GetMapping("/turnSouth")
    public ResponseResult turnSouth(String userName){

        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        House currentHouse = iHouseService.findHouse(userInformation.getCurrentHouse());
        House newHouse = iHouseService.findHouse(currentHouse.getSouth());
        if(newHouse == null){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(currentHouse.getHouseName()+ " " + ReturnCode.HOUSER_SOUTH_NOT_EXIST);
            return  responseResult;
        }
        back_line.add(currentHouse);
        userInformation.setCurrentHouse(newHouse.getHouseName());
        iUserInformationService.updateUserInformation(userInformation);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult(newHouse.getHouseName() + back_line.size());
        return  responseResult;
    }


    @GetMapping("/back")
    public ResponseResult back(){

        if(back_line.size() == 0){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(ReturnCode.HOUSE_BACK_FAILED);
            return  responseResult;
        }
        House currentHouse = back_line.get(back_line.size() - 1);
        back_line.remove(back_line.size() - 1);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult(currentHouse.getHouseName() + back_line.size());
        return  responseResult;
    }




}

//http://localhost:8080/player/login?userName=dyf&userPass=123
