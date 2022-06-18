package com.example.gamehouse.Entity;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserInformation {

  @Id
  private String userName;
  @Column
  private String currentHouse;
  @Column
  private long coordinatesX;
  @Column
  private long coordinatesY;
  @Column
  private long userStatus;
  @Column
  private long bear;

  public long getBear() {
    return bear;
  }

  public void setBear(long bear) {
    this.bear = bear;
  }

  public long getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(long userStatus) {
    this.userStatus = userStatus;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getCurrentHouse() {
    return currentHouse;
  }

  public void setCurrentHouse(String currentHouse) {
    this.currentHouse = currentHouse;
  }


  public long getCoordinatesX() {
    return coordinatesX;
  }

  public void setCoordinatesX(long coordinatesX) {
    this.coordinatesX = coordinatesX;
  }


  public long getCoordinatesY() {
    return coordinatesY;
  }

  public void setCoordinatesY(long coordinatesY) {
    this.coordinatesY = coordinatesY;
  }

}
