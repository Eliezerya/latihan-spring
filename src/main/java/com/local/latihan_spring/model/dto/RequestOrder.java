package com.local.latihan_spring.model.dto;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class RequestOrder {
    private List<RequestOrderItem> items;
    private String customerName;
}
