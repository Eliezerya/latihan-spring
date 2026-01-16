package com.local.latihan_spring.service;


import com.local.latihan_spring.model.dto.ProductDto;
import com.local.latihan_spring.model.dto.RequestOrder;
import com.local.latihan_spring.model.dto.ResponseOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;


public interface OrderService {
    ResponseOrder createOrderService(RequestOrder order);

    Page<ResponseOrder> findOrderByCustName(Pageable pageable, String customerName);

    ProductDto productDetail(UUID id);

    List<ProductDto> listProduct();
}
