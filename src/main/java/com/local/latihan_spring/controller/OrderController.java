package com.local.latihan_spring.controller;


import com.local.latihan_spring.model.dto.RequestOrder;
import com.local.latihan_spring.model.dto.ResponseOrder;
import com.local.latihan_spring.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/request-order")
    public ResponseEntity<?> createOrder(@RequestBody RequestOrder orderRequest){
        log.info("create-order-request: " + orderRequest.getCustomerName());
        return new ResponseEntity<>(orderService.createOrderService(orderRequest), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public Page<ResponseOrder> allOrder(@PageableDefault Pageable pageable, @RequestParam String customerName){
        return orderService.findOrderByCustName(pageable,customerName);

    }

    @GetMapping("/product/{idProduct}")
    public ResponseEntity<?> getProduct(@PathVariable(name = "idProduct") UUID idProduct){
        log.info("get product detail: " + idProduct);
        return new ResponseEntity<>(orderService.productDetail(idProduct), HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<?> productList(){
        log.info("get product list");
        return new ResponseEntity<>(orderService.listProduct(), HttpStatus.OK);
    }
}