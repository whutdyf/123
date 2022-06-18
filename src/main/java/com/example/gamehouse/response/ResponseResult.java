package com.example.gamehouse.response;

public class ResponseResult<T> {

    //当前状态码
    public String resultCode;
    //当前响应信息
    String resultMsg;
    T result;


    public ResponseResult(String resultCode) {
        this.resultCode = resultCode;
    }

    public ResponseResult(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public ResponseResult(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }

    public ResponseResult(String resultCode, String resultMsg, T result) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.result = result;
    }
}
