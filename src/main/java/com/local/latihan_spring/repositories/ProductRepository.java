package com.local.latihan_spring.repositories;

import com.local.latihan_spring.model.Order;
import com.local.latihan_spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

}
