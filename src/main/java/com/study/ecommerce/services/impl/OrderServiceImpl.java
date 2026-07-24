package com.study.ecommerce.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.entities.Address;
import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;
import com.study.ecommerce.entities.Order;
import com.study.ecommerce.entities.OrderItem;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.repositories.AddressRepository;
import com.study.ecommerce.repositories.CartItemRepository;
import com.study.ecommerce.repositories.OrderItemRepository;
import com.study.ecommerce.repositories.OrderRepository;
import com.study.ecommerce.repositories.UserRespository;
import com.study.ecommerce.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	
	@Override
	public Order createOrder(String userId, Integer addressId) {
		
		User user = userRespository.findById(userId)
		.orElseThrow(()->new RuntimeException("User Not Found"));
		
		Address address = addressRepository.findById(addressId)
		.orElseThrow(()->new RuntimeException("Address Not Found"));
		
		Cart cart = user.getCart();
		
		int total=0;
		
		for(CartItem item: cart.getCartItems())
		{
			total+=item.getQuantity()*item.getProduct().getPrice();
		}
		
		Order order = new Order();
		
		order.setUser(user);
		order.setAddress(address);
		order.setStatus("PLACED");
		order.setPaymentStatus("SUCCESS");
		
		orderRepository.save(order);
		
		for(CartItem item : cart.getCartItems())
		{
			OrderItem orderItem = new OrderItem();
			
			orderItem.setOrder(order);
			orderItem.setProduct(item.getProduct());
			orderItem.setQuantity(item.getQuantity());
			
			orderItemRepository.save(orderItem);
			
			cartItemRepository.deleteAll(cart.getCartItems());
		}
		
		return order;
	}

	@Override
	public List<Order> getOrders(String userId) {
		User user = userRespository.findById(userId)
				.orElseThrow(()->new RuntimeException("User Not Found"));
		
		List<Order> orders = user.getOrders();
		return orders;
	}

	@Override
	public Order getOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId)
		.orElseThrow(()->new RuntimeException("Order Not Found"));
		
		return order;
	}

}
