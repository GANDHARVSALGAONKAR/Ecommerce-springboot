package com.study.ecommerce.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.entities.Address;
import com.study.ecommerce.entities.User;
import com.study.ecommerce.repositories.UserRespository;
import com.study.ecommerce.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private UserRespository userRespository;
	@Override
	public Address addAddress(String userId, Address address) {
		User user = userRespository.findById(userId)
				.orElseThrow(()->new RuntimeException("User Not Found"));
		return null;
	}

}
