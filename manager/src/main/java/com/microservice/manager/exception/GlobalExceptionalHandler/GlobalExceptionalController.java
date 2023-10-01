package com.microservice.manager.exception.GlobalExceptionalHandler;

import com.microservice.manager.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionalController {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse>handleException(Exception e){
        String mess= e.getMessage();
        ApiResponse build = ApiResponse.builder().message(mess).build();
        return new ResponseEntity<ApiResponse>(build, HttpStatus.NOT_FOUND);
    }
}
