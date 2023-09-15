package com.dnb.eCommerceApplication.service;

import java.util.List;
import java.util.Optional;

import com.dnb.eCommerceApplication.dto.Product;
import com.dnb.eCommerceApplication.exceptions.IdNotFoundException;
import com.dnb.eCommerceApplication.exceptions.NotUniqueNameException;
import com.dnb.eCommerceApplication.payload.request.ProductPayloadRequest;

//This interface defines the different operations that are to be performed by the application
public interface ProductService {
	
	public Product createProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Optional<Product> getProductById(String productId);
	
	public boolean deleteProductById(String productId);
	
	public Product updateProductById(Product product, String productId) throws IdNotFoundException, NotUniqueNameException;
}
