package com.study.ecommerce.services.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;
import com.study.ecommerce.entities.Product;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.repositories.CartItemRepository;
import com.study.ecommerce.repositories.CartRespository;
import com.study.ecommerce.repositories.ProductRepository;
import com.study.ecommerce.repositories.UserRespository;
import com.study.ecommerce.security.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private UserRespository userRespository;
	
	@Autowired
	private CartRespository cartRespository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;

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
		
		Cart cart = getCart(userId);
		
		Product product = productRepository.findById(productId)
		.orElseThrow(()->new RuntimeException("Product Not Found"));
		
		for(CartItem item:cart.getCartItems())
		{
			if(item.getProduct().getId().equals(productId))
			{
				item.setQuantity(item.getQuantity()+cartItem.getQuantity());
				cartItemRepository.save(item);
				return getCart(userId);
			}
		}
		
		cartItem.setProduct(product);
		cartItem.setCart(cart);
		
		cartItemRepository.save(cartItem);
		
		return cart;
	}

	@Override
	public void deleteCartItem(Integer cartItemId) {
		
		CartItem cartItem = cartItemRepository.findById(cartItemId)
		.orElseThrow(()->new RuntimeException("CartItem Not Found"));
		
		cartItemRepository.delete(cartItem);
		
	}

}
