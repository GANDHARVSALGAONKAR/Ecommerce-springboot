package com.study.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.ecommerce.entities.Cart;
import com.study.ecommerce.entities.CartItem;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.security.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@GetMapping
	public ResponseEntity<Cart> getCart(@AuthenticationPrincipal User user)
	{
		return ResponseEntity.ok(cartService.getCart(user.getId()));
	}
	
	@PostMapping("/{productId}")
	public ResponseEntity<Cart> addToCart(@AuthenticationPrincipal User user,
			@PathVariable Integer productId,@RequestBody CartItem cartItem)
	{
		Cart cart = cartService.addToCart(user.getId(), productId, cartItem);
		return ResponseEntity.ok(cart);
	}
	
	@DeleteMapping("/{cartItemId}")
	public ResponseEntity<String> deleteCartItem(@PathVariable Integer cartItemId)
	{
		cartService.deleteCartItem(cartItemId);
		return ResponseEntity.ok("CartItem Deleted");
	}

}
