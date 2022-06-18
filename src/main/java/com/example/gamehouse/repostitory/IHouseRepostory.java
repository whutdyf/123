package com.example.gamehouse.repostitory;

import com.example.gamehouse.Entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHouseRepostory extends JpaRepository<House, String> {
}
