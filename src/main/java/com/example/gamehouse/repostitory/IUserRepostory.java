package com.example.gamehouse.repostitory;

import com.example.gamehouse.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepostory extends JpaRepository<User, String> {

}
