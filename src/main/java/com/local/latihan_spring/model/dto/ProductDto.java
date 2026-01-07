package com.local.latihan_spring.model.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class ProductDto {
    private UUID id;
    private String name;
    private long stock;
    private BigDecimal basePrice;
    private String createdAt;
}
