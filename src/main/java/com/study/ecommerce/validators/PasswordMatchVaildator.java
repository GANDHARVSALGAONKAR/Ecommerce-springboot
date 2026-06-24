package com.study.ecommerce.validators;

import com.study.ecommerce.dtos.UserDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchVaildator implements ConstraintValidator<PasswordMatch, UserDto> {

	@Override
	public boolean isValid(UserDto value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		return value.getPassword().equals(value.getConfirmPassword());
	}
	
	

}
