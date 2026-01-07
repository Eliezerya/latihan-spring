package com.local.latihan_spring.controller;


import com.local.latihan_spring.model.dto.RequestOrder;
import com.local.latihan_spring.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/request-order")
    public ResponseEntity<?> createOrder(@RequestBody RequestOrder orderRequest){

        return new ResponseEntity<>(orderService.createOrderService(orderRequest), HttpStatus.OK);
    }

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "idProduct") UUID idProduct){

        return new ResponseEntity<>(orderService.productDetail(idProduct), HttpStatus.OK);
    }

}