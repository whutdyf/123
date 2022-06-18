package com.example.gamehouse.service.impl;

import com.example.gamehouse.Entity.House;
import com.example.gamehouse.repostitory.IHouseRepostory;
import com.example.gamehouse.service.IHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements IHouseService {

    @Autowired
    IHouseRepostory iHouseRepostory;

    @Override
    public boolean addHouse(House house){
        House save = iHouseRepostory.save(house);
        return (save != null);
    }

    @Override
    public boolean updateHouse(House house){
        House save = iHouseRepostory.save(house);
        return (save != null);
    }

    @Override
    public House findHouse(String houseName){

        House house = iHouseRepostory.findById(houseName).orElse(null);
        return house;

    }

}
