package com.study.ecommerce.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)                             //TYPE MEANS CLASS,FLIED MEANS VARIABLE
@Constraint(validatedBy = PasswordMatchVaildator.class)
public @interface PasswordMatch {

	String message() default "Password and Confirm Password is not same";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
