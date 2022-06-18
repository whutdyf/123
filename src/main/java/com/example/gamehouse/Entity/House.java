package com.example.gamehouse.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class House {

  @Id
  private String houseName;
  @Column
  private String east;
  @Column
  private String south;
  @Column
  private String west;
  @Column
  private String north;
  @Column
  private String description;


  public String getHouseName() {
    return houseName;
  }

  public void setHouseName(String houseName) {
    this.houseName = houseName;
  }

  public String getEast() {
    return east;
  }

  public void setEast(String east) {
    this.east = east;
  }


  public String getSouth() {
    return south;
  }

  public void setSouth(String south) {
    this.south = south;
  }


  public String getWest() {
    return west;
  }

  public void setWest(String west) {
    this.west = west;
  }


  public String getNorth() {
    return north;
  }

  public void setNorth(String north) {
    this.north = north;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
