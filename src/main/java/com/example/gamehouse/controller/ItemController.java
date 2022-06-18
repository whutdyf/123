package com.example.gamehouse.controller;

import com.example.gamehouse.Entity.Item;
import com.example.gamehouse.Entity.UserInformation;
import com.example.gamehouse.response.ResponseResult;
import com.example.gamehouse.response.ResponseResultFactory;
import com.example.gamehouse.response.ReturnCode;
import com.example.gamehouse.service.IItemService;
import com.example.gamehouse.service.IUserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    IItemService iItemService;

    @Autowired
    IUserInformationService iUserInformationService;

    @PostMapping("addItem")
    public ResponseResult changeItemTake(Item item){
        iItemService.addItem(item);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        return responseResult;
    }

    /**
     * 判断物品重量是否小于玩家承重
     * @param itemName 物品名称
     * @param userName 玩家姓名
     * @return 是否拾取成功
     */
    @RequestMapping("/takeItem")
    public ResponseResult takeItem(String itemName, String userName){

        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        Item item = iItemService.find(itemName);
        if(userInformation.getBear() < item.getWeight()){
            ResponseResult responseResult = ResponseResultFactory.buildResponseResult(ReturnCode.BEAR_IS_NOT_ENOUGH);
                  }
        //更改物品位置信息
        item.setCurrentLocation(userName);
        item.setCurrentX(-1);
        item.setCurrentY(-1);
        boolean a = iItemService.updateItem(item);
        //更加玩家承重信息
        long bear = userInformation.getBear() - item.getWeight();
        userInformation.setBear(bear);
        boolean b = iUserInformationService.updateUserInformation(userInformation);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        return responseResult;
    }

    @RequestMapping("/dropItem")
    public ResponseResult dropItem(String itemName, String userName, int locationX, int locationY){
        UserInformation userInformation = iUserInformationService.findUserInformation(userName);
        Item item = iItemService.find(itemName);
        item.setCurrentX(locationX);
        item.setCurrentY(locationY);
        item.setCurrentLocation(userInformation.getCurrentHouse());
        long bear = item.getWeight() + userInformation.getBear();
        userInformation.setBear(bear);
        boolean a = iItemService.updateItem(item);
        boolean b = iUserInformationService.updateUserInformation(userInformation);
        ResponseResult responseResult = ResponseResultFactory.buildResponseResult();
        return responseResult;
    }

    @GetMapping("/itemByLocation")
    public List<Item> findAllItemByLocation(String location){
        List<Item> Items = iItemService.findItemByLocation(location);
        return Items;
    }

}
