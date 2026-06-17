package com.study.ecommerce.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.ecommerce.dtos.ProductDto;
import com.study.ecommerce.entities.Product;
import com.study.ecommerce.repositories.ProductRepository;
import com.study.ecommerce.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDto addProduct(ProductDto productDto) {
//		MAP METHOD WILL HELP YOU CONVERT DTO TO ENTITY
		Product product = modelMapper.map(productDto, Product.class);
//		SAVE METHOD WILL ADD OBJECT INTO THE TABLE
		Product saveProduct = productRepository.save(product);
		return modelMapper.map(saveProduct, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto getProductById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto updateProduct(Integer id, ProductDto productDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
