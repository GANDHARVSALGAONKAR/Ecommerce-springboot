package com.study.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.ecommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
