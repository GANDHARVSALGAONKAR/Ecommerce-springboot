package com.study.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.ecommerce.entities.User;
import com.study.ecommerce.repositories.UserRespository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRespository userRespository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRespository.findByEmail(username)
		.orElseThrow(()->new RuntimeException("Email Not Found"));
		return user;
	}

}
