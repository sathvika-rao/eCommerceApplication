package com.dnb.eCommerceApplication.dto;

import java.time.LocalDate;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.dnb.eCommerceApplication.utils.CustomIdGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//creating a product entity with fields like Id, Name, Description, Expiry Date, Price, Category where Id is automatically generated

@Data
@NoArgsConstructor
@ToString
@Entity
public class Product {
	
	@Id
	@NotBlank(message = "id is not valid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq") //if generator is specified, then it'll know to use its wrapper class
	@GenericGenerator(name = "product_seq", strategy = "com.dnb.eCommerceApplication.utils.CustomIdGenerator",
			parameters = {@Parameter(name = "CustomIdGenerator.INCREMENT_PARAM", value = "50"),
			@Parameter(name=CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "prod_"),
			@Parameter(name=CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d"),
	}
	)
	private String productId;
	private String productName;
	private String productDescription;
	private LocalDate productExpiry;
	private float productPrice;
	private String productCategory;
}
