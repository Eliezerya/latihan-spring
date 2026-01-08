package com.local.latihan_spring.exception;


import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final String feature;

    protected AppException(String message, String feature){
        super(message);
        this.feature = feature;
    }

}
