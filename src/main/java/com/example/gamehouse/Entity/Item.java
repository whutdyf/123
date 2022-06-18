package com.example.gamehouse.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

  @Id
  private String itemName;
  @Column
  private String currentLocation;
  @Column
  private long currentX;
  @Column
  private long currentY;
  @Column
  private long weight;


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }


  public String getCurrentLocation() {
    return currentLocation;
  }

  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }


  public long getCurrentX() {
    return currentX;
  }

  public void setCurrentX(long currentX) {
    this.currentX = currentX;
  }


  public long getCurrentY() {
    return currentY;
  }

  public void setCurrentY(long currentY) {
    this.currentY = currentY;
  }


  public long getWeight() {
    return weight;
  }

  public void setWeight(long weight) {
    this.weight = weight;
  }

}
