package com.example.gamehouse.service.impl;

import com.example.gamehouse.Entity.Item;
import com.example.gamehouse.repostitory.ItemRepostory;
import com.example.gamehouse.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    ItemRepostory itemRepostory;

    @Override
    public boolean addItem(Item item){
        Item save = itemRepostory.save(item);
        return (save != null);
    }

    @Override
    public boolean updateItem(Item item){
        Item save = itemRepostory.save(item);
        return (save != null);
    }

    @Override
    public List<Item> findItemByLocation(String currentLocation){
        //List<Item> Items = itemRepostory.findAll();
        List<Item> Items = itemRepostory.findByCurrentLocation(currentLocation);
        return Items;
    }

    @Override
    public Item find(String itemName){
        Item item = itemRepostory.findById(itemName).orElse(null);
        return item;
    }

}
