package com.example.gamehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.gamehouse.Entity.House;

public interface IHouseService{
    boolean addHouse(House house);
    boolean updateHouse(House house);
    House findHouse(String houseName);
}
