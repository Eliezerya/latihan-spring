package com.local.latihan_spring.model.dto;

import com.local.latihan_spring.Enum.StatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ResponseOrder {
    private UUID id;
    private List<OrderDetailDto> orderDetails;
    private StatusEnum status;
    private BigDecimal totalPrice;
}
