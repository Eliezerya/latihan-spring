package com.local.latihan_spring.service;


import com.local.latihan_spring.model.Order;
import com.local.latihan_spring.model.dto.ProductDto;
import com.local.latihan_spring.model.dto.RequestOrder;
import com.local.latihan_spring.model.dto.ResponseOrder;

import java.util.UUID;


public interface OrderService {
    ResponseOrder createOrderService(RequestOrder order);

    ProductDto productDetail(UUID id);
}
