package com.local.latihan_spring.repositories;

import com.local.latihan_spring.model.Order;
import com.local.latihan_spring.model.dto.OrderDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

}
