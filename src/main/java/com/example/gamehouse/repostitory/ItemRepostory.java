package com.example.gamehouse.repostitory;

import com.example.gamehouse.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepostory extends JpaRepository<Item, String> {

    public List<Item> findByCurrentLocation(String location);

}
