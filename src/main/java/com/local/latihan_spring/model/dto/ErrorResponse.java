package com.local.latihan_spring.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ErrorResponse {
    String errorCode;
    String message;
}
