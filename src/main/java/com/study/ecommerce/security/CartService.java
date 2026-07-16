package com.study.ecommerce.security;

import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;

public interface CartService {

	// TO FETCH CART OF USER WHOSE ID IS PROVIDED
	Cart getCart(String userId);
	
	Cart addToCart(String userId,Integer productId,CartItem cartItem);
	
	void deleteCartItem(Integer cartItemId);
}
