package com.local.latihan_spring.model;

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
import java.util.UUID;

@Table(name = "tb_order_detail")
@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "priceAtOrder")
    private BigDecimal priceAtOrder;
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt;
    @Column(name = "subTotal")
    private BigDecimal subTotal;

    protected OrderDetail(){
    }

    OrderDetail(Order order,Product product, Integer quantity){
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.priceAtOrder = product.getBasePrice();
        this.subTotal = this.priceAtOrder.multiply(BigDecimal.valueOf(quantity));
    }
}
