package com.study.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.ecommerce.entities.User;

public interface UserRespository extends JpaRepository<User, String> {
	
//	existsByEmail          AND THEN ANY FIELD NAME LIKE FirstName,LastName,Email,etc....

	//THIS IS CALLED CUSTOM QUERY METHOD  findByFieldName   exsitsByFieldName
	boolean existsByEmail(String email);
	Optional<User> findByEmail(String email);
}
