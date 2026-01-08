package com.local.latihan_spring.exception;

import com.local.latihan_spring.model.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class GlobalHandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequest(BadRequestException e){

        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .errorCode(e.getFeature())
                        .message(e.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> unexpectedHandler(Exception e){
        StackTraceElement ste = findAppStack(e);
        String location = ste == null
                ? "unknown"
                : ste.getClassName() + ".java:" + ste.getLineNumber();

        log.error("Unexpected error at {}", location, e);
        return ResponseEntity
                .internalServerError()
                .body(ErrorResponse.builder()
                        .errorCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                        .message(e.getMessage())
                        .build());
    }

    private StackTraceElement findAppStack(Exception e) {
        return Arrays.stream(e.getStackTrace())
                .filter(st -> st.getClassName().contains(".latihan_spring"))
                .findFirst()
                .orElse(null);
    }


}
