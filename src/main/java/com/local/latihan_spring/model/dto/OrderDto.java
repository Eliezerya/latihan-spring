package com.local.latihan_spring.model.dto;


import com.local.latihan_spring.Enum.StatusEnum;
import com.local.latihan_spring.model.OrderDetail;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class OrderDto {
    private UUID id;
    private List<OrderDetailDto> orderDetail;
    private StatusEnum status;
    private String customerName;
}
