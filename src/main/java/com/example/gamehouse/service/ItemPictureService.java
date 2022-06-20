package com.example.gamehouse.service;

import com.example.gamehouse.Entity.ItemPicture;

public interface ItemPictureService {
    boolean add(ItemPicture itemPicture);
    boolean update(ItemPicture itemPicture);
    ItemPicture findPicture(String itemName);
}
