package com.local.latihan_spring.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class RequestOrderItem {

    private UUID productId;
    private Integer quantity;
}
