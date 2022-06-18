package com.example.gamehouse.response;

public interface ReturnCode {

    String SUCCESS = "000000";
    String USER_ADD_FAILED = "000001";

    String USER_NOT_EXIST = "000100";
    String USER_PASS_NOT_RIGHT = "000101";

    String HOUSER_WEST_NOT_EXIST = "000200";
    String HOUSER_EAST_NOT_EXIST = "000201";
    String HOUSER_NORTH_NOT_EXIST = "000202";
    String HOUSER_SOUTH_NOT_EXIST = "000203";

    String HOUSE_BACK_FAILED = "000300";
    String BEAR_IS_NOT_ENOUGH = "000400";

}
