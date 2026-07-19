package com.study.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.ecommerce.entities.Address;

public interface AddressRespository extends JpaRepository<Address, Integer> {

}
