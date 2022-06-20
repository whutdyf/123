package com.example.gamehouse;

import com.example.gamehouse.Entity.*;
import com.example.gamehouse.response.ResponseResult;
import com.example.gamehouse.response.ResponseResultFactory;
import com.example.gamehouse.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

@SpringBootTest
class GameHouseApplicationTests {

    @Autowired
    IUserService userService;

    @Autowired
    IItemService iItemService;

    @Autowired
    IHouseService iHouseService;

    @Autowired
    IUserInformationService iUserInformationService;

    @Autowired
    ItemPictureService itemPictureService;

    @Test
    void contextLoads() {

        User user = new User();
        user.setUserName("whut");
        user.setUserPass("123");
        user.setRole(0);

        userService.addUser(user);

        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        System.out.println(responseResult);
    }

    @Test
    void Itemtest(){
        Item item = new Item();
        item.setItemName("desk");
        item.setCurrentLocation("lab");
        item.setCurrentX(40);
        item.setCurrentY(50);
        item.setWeight(10);
        iItemService.addItem(item);

    }

    @Test
    void houseTest(){
        House house = new House();
        house.setHouseName("office");
        house.setEast("");
        house.setNorth("");
        house.setSouth("");
        house.setWest("lab");
        house.setDescription("in the computing admin office");
        iHouseService.addHouse(house);
    }

    @Test
    void userInformationTest(){
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName("zhang");
        userInformation.setUserStatus(0);
        userInformation.setCurrentHouse("lab");
        userInformation.setCoordinatesX(20);
        userInformation.setCoordinatesY(20);
        userInformation.setBear(50);
        iUserInformationService.addUserInformation(userInformation);
    }

    @Test
    void itemPicture() throws Exception{

        File file = new File("/Users/seishunbukyoku/Desktop/garbage.png");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data, 0, inputStream.available());

        String code = Base64.getEncoder().encodeToString(data);

        ItemPicture itemPicture = new ItemPicture();
        itemPicture.setItemName("garbage");
        itemPicture.setPicture(code);
        itemPictureService.add(itemPicture);

    }

}
