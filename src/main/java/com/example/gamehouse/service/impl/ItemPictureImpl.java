package com.example.gamehouse.service.impl;

import com.example.gamehouse.Entity.ItemPicture;
import com.example.gamehouse.repostitory.ItemPictureRepostory;
import com.example.gamehouse.service.ItemPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemPictureImpl implements ItemPictureService {

    @Autowired
    ItemPictureRepostory itemPictureRepostory;

    @Override
    public boolean add(ItemPicture itemPicture){
        ItemPicture save = itemPictureRepostory.save(itemPicture);
        return (save != null);
    }

    @Override
    public boolean update(ItemPicture itemPicture){
        ItemPicture save = itemPictureRepostory.save(itemPicture);
        return (save != null);
    }

    @Override
    public ItemPicture findPicture(String itemName){

        ItemPicture itemPicture = itemPictureRepostory.findById(itemName).orElse(null);
        return itemPicture;
    }
}
