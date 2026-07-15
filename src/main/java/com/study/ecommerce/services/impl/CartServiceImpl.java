package com.study.ecommerce.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.repositories.CartRespository;
import com.study.ecommerce.repositories.UserRespository;
import com.study.ecommerce.security.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private CartRespository cartRespository;

	@Override
	public Cart getCart(String userId) {
	   
		User user = userRespository.findById(userId)
		.orElseThrow(()->new RuntimeException("User Not Found"));
		
		Cart cart = user.getCart();
		if(cart==null)
		{
			cart = new Cart();
			cart.setUser(user);
			cart.setCartItems(new ArrayList<CartItem>());
			cart = cartRespository.save(cart);
		}
		 
		return cart;
	}

	@Override
	public Cart addToCart(String userId, Integer productId, CartItem cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

}
