package com.study.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false,length = 60)               //name = "productName" TO CHANGE THE CLOUMN NAME
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Integer price;
	
	@ManyToOne
	@JsonManagedReference
	private Category category;
	
}
