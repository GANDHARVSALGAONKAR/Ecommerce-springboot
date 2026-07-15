package com.study.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.ecommerce.entities.Cart;
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

}
