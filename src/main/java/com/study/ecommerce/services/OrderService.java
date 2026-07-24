package com.study.ecommerce.services;

import java.util.List;

import com.study.ecommerce.entities.Order;

public interface OrderService {

	Order createOrder(String userId,Integer addressId);
	
	List<Order> getOrders(String userId);
	
	Order getOrder(Integer orderId);
}
