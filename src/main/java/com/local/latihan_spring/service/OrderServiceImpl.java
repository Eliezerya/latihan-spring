package com.local.latihan_spring.service;

import com.local.latihan_spring.exception.GeneralException;
import com.local.latihan_spring.mapper.OrderMapper;
import com.local.latihan_spring.mapper.ProductMapper;
import com.local.latihan_spring.model.Order;
import com.local.latihan_spring.model.Product;
import com.local.latihan_spring.model.dto.ProductDto;
import com.local.latihan_spring.model.dto.RequestOrder;
import com.local.latihan_spring.model.dto.RequestOrderItem;
import com.local.latihan_spring.model.dto.ResponseOrder;
import com.local.latihan_spring.repositories.OrderRepository;
import com.local.latihan_spring.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseOrder createOrderService(RequestOrder request) {
        Order order = new Order(request.getCustomerName());
        order.markAsPending();
        for(RequestOrderItem orderDetail : request.getItems()){
            order.addItem(getProductById(orderDetail.getProductId()),orderDetail.getQuantity());
        }
        Order savedOrder = orderRepository.save(order);

        return ResponseOrder.builder()
                .status(savedOrder.getStatus())
                .orderDetails(orderMapper.toDetailsDTO(savedOrder.getOrderDetails()))
                .id(savedOrder.getId())
                .totalPrice(savedOrder.getTotalPrice())
                .build();
    }

    @Override
    public ProductDto productDetail(UUID id) {
        log.info("service product detail :" + id);
        return productMapper.toProductDTO(getProductById(id));
    }

    @Override
    public List<ProductDto> listProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : products){
            productDtoList.add(productMapper.toProductDTO(product));
        }
        return (productDtoList);
    }

    public Product getProductById(UUID id){
        return productRepository.findById(id)
                .orElseThrow(() -> new GeneralException("Product not found","getProductById"));
    }

}
