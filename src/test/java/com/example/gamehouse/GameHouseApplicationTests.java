package com.example.gamehouse;

import com.example.gamehouse.Entity.House;
import com.example.gamehouse.Entity.UserInformation;
import com.example.gamehouse.response.ResponseResult;
import com.example.gamehouse.response.ResponseResultFactory;
import com.example.gamehouse.service.IHouseService;
import com.example.gamehouse.service.IItemService;
import com.example.gamehouse.service.IUserInformationService;
import com.example.gamehouse.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.gamehouse.Entity.User;
import com.example.gamehouse.Entity.Item;

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

}
