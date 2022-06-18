package com.example.gamehouse.repostitory;

import com.example.gamehouse.Entity.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserInformationRepostory extends JpaRepository<UserInformation, String> {
}
