package com.study.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.study.ecommerce.entities.Category;
import com.study.ecommerce.projection.CategoryProjection;

@RepositoryRestResource(path="categories",excerptProjection = CategoryProjection.class)
@CrossOrigin
public interface CategoryRespository extends JpaRepository<Category, Integer> {

	

}
