package com.study.ecommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

	private String razorpayOrderId;
	private String razorpayPaymentId;
	private String razorpaySignature;
	private Integer addressId;
}
