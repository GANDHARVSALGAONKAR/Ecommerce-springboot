package com.study.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.study.ecommerce.entities.Category;

@RepositoryRestResource(path="categories")
public interface CategoryRespository extends JpaRepository<Category, Integer> {
	

}
