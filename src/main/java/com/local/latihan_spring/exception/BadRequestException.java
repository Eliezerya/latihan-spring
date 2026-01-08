package com.local.latihan_spring.exception;

public class BadRequestException extends AppException {
    public BadRequestException(String message, String feature){
        super(message, feature);
    }
}
