package com.dnb.eCommerceApplication.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dnb.eCommerceApplication.dto.Product;
import com.dnb.eCommerceApplication.payload.request.ProductPayloadRequest;

//This connects with the database and performs crud based operations automatically using jpa dependency
public interface ProductRepository extends CrudRepository<Product, String> {

	boolean existsByProductName(String productName);
	
	//@Query("update Customer u set u.phone = :phone where u.id = :id")
	@Query("SELECT p.productName FROM Product p where p.productId = :productId")
	String getProductName(@Param(value = "productId") String productId);
	
}
