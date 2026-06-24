package com.study.ecommerce.services;

import java.util.List;

import com.study.ecommerce.dtos.ProductDto;

public interface CategoryService {

	void addProductToCategory(int categoryId,int productId);
	
	List<ProductDto> getProducts(int categoryid);
}
