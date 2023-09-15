package com.dnb.eCommerceApplication.payload.request;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

//Constraints are given for some fields in the Product entity
//Product Name should be unique, product description should not be blank and the price should not be less that zero

@Data
//@Table(uniqueConstraints=
//            @UniqueConstraint(columnNames="product_name"))
public class ProductPayloadRequest {
	
	@Column(unique = true)
	private String productName;
	@NotBlank(message = "Enter description. Product description should not be blank.")
	private String productDescription;
	private LocalDate productExpiry;
	@Min(value = 0,message="Price cannot be negative.")
	private float productPrice;
	private String productCategory;
}
