package com.microservice.manager.exception;

public class BaseException extends  Exception{
    private int code;
    private String message;

    public BaseException(int code,String message){
        this.code=code;
        this.message=message;
    }
}
