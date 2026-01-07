package com.local.latihan_spring.model.dto;

import com.local.latihan_spring.model.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderDetailDto {
    private UUID id;
    private ProductDto product;
    private Integer quantity;
    private BigDecimal priceAtOrder;
    private BigDecimal subTotal;
}
