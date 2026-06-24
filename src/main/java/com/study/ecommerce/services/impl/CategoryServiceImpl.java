package com.study.ecommerce.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.dtos.ProductDto;
import com.study.ecommerce.entities.Category;
import com.study.ecommerce.entities.Product;
import com.study.ecommerce.repositories.CategoryRespository;
import com.study.ecommerce.repositories.ProductRepository;
import com.study.ecommerce.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRespository categoryRespository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	 
	@Override
	public void addProductToCategory(int categoryId, int productId) {
		
		Category category = categoryRespository.findById(categoryId)
		.orElseThrow(()->new RuntimeException("Category not found"));
		
		Product product = productRepository.findById(productId)
		.orElseThrow(()->new RuntimeException("Product not found"));
		
		product.setCategory(category);
		productRepository.save(product);
		
	}

	@Override
	public List<ProductDto> getProducts(int categoryId) {
		
		Category category = categoryRespository.findById(categoryId)
		.orElseThrow(()->new RuntimeException("Category not found"));
		
		List<Product> products = category.getProducts();
		return products.stream().map(p->modelMapper.map(p, ProductDto.class)).toList();
	}

}
