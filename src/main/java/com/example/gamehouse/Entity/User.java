package com.example.gamehouse.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

  @Id
  private String userName;
  @Column
  private String userPass;
  @Column
  private long role;


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPass() {
    return userPass;
  }

  public void setUserPass(String userPass) {
    this.userPass = userPass;
  }


  public long getRole() {
    return role;
  }

  public void setRole(long role) {
    this.role = role;
  }

}
