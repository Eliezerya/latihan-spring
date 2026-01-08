package com.local.latihan_spring.model.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestOrder {
    private List<RequestOrderItem> items;
    private String customerName;
}
