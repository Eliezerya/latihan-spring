package com.local.latihan_spring.model;


import com.local.latihan_spring.Enum.StatusEnum;
import com.local.latihan_spring.exception.BadRequestException;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.type.SqlTypes;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "tb_order")
@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.DRAFT;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "totalPrice")
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)

    private Instant createdAt;
    @LastModifiedDate

    @Column(name = "updated_at")
    private Instant updatedAt;

    protected Order (){
    }

    public Order(String customerName){
        if (customerName == null || customerName.isBlank()){
            throw new BadRequestException("CustomerName is null or empty", "entity order");
        }
        this.customerName = customerName;
    }

    public void markAsPending(){
        if (this.status == StatusEnum.DRAFT){
            this.status = StatusEnum.PENDING;
        }
    }

    public void addItem(Product product, Integer quantity){
        if (quantity < 1 ) throw new IllegalArgumentException("quantity can't less from 1 ");
        OrderDetail orderDetail = new OrderDetail(this, product, quantity);
        this.totalPrice = this.totalPrice.add(orderDetail.getSubTotal());
        this.orderDetails.add(orderDetail);
    }


}
