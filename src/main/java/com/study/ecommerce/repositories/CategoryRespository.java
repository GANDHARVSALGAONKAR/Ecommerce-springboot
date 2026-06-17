package com.study.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.ecommerce.entities.Category;

public interface CategoryRespository extends JpaRepository<Category, Integer> {
	

}
