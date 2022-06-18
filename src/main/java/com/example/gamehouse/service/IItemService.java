package com.example.gamehouse.service;

import com.example.gamehouse.Entity.Item;

import java.util.List;

public interface IItemService{

    boolean addItem(Item item);
    boolean updateItem(Item item);
    List<Item> findItemByLocation(String currentLocation);
    Item find(String Item);

}
