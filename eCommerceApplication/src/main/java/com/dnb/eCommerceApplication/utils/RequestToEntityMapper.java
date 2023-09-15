package com.dnb.eCommerceApplication.utils;

import org.springframework.stereotype.Component;

import com.dnb.eCommerceApplication.dto.Product;
import com.dnb.eCommerceApplication.payload.request.ProductPayloadRequest;

//used to map entity fields from request body to declared entity fields in the application

@Component
public class RequestToEntityMapper {

	public Product getProduct(ProductPayloadRequest productRequest) {
		Product product = new Product();
		product.setProductName(productRequest.getProductName());
		product.setProductCategory(productRequest.getProductCategory());
		product.setProductDescription(productRequest.getProductDescription());
		product.setProductExpiry(productRequest.getProductExpiry());
		product.setProductPrice(productRequest.getProductPrice());
		return product;
	}
}
