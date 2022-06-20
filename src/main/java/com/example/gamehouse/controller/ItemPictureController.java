package com.example.gamehouse.controller;


import com.example.gamehouse.Entity.ItemPicture;
import com.example.gamehouse.service.ItemPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;


@RestController
@RequestMapping("/picture")
public class ItemPictureController {

    @Autowired
    ItemPictureService ItemPictureService;



    @GetMapping(value = "/getPicture",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPicture(String itemName) throws Exception {

        ItemPicture itemPicture = ItemPictureService.findPicture(itemName);
        byte[] bytes = Base64.getDecoder().decode(itemPicture.getPicture());
        return bytes;

    }

}
