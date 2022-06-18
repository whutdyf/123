package com.example.gamehouse.response;

public class ResponseResultFactory<T> {

    /**
     * 构建通用成功返回结果
     * @return
     */
    public static ResponseResult buildResponseResult(){
        return new ResponseResult(ReturnCode.SUCCESS);
    }

    public static ResponseResult buildResponseResult(String Code){
        return new ResponseResult(Code);
    }

    public static <T> ResponseResult buildResponseResult(String Code, T obj) {
        return new ResponseResult(Code, obj);
    }
}
