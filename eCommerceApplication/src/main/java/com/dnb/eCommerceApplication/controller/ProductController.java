package com.dnb.eCommerceApplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dnb.eCommerceApplication.dto.Product;
import com.dnb.eCommerceApplication.exceptions.IdNotFoundException;
import com.dnb.eCommerceApplication.exceptions.NotUniqueNameException;
import com.dnb.eCommerceApplication.payload.request.ProductPayloadRequest;
import com.dnb.eCommerceApplication.service.ProductService;
import com.dnb.eCommerceApplication.utils.RequestToEntityMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	RequestToEntityMapper requestToEntityMapper;

	@PostMapping("") //@RequestMapping + post method - from spring 4.3.x
	public ResponseEntity<?> createAccount( @Valid @RequestBody ProductPayloadRequest product) throws IdNotFoundException {

		System.out.println("checking");
		Product product1 = productService.createProduct(requestToEntityMapper.getProduct(product));
		return new ResponseEntity(product1, HttpStatus.CREATED);
	}
	
	@GetMapping("/getProduct/{productId}")
	public ResponseEntity<?> getProductById(@PathVariable("productId") String productId) throws IdNotFoundException  {
		java.util.Optional<Product> optional = productService.getProductById(productId);
		if(optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		else {
			throw new IdNotFoundException("given product id does not exist");
		}
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllProducts(){
		List<Product> products = new ArrayList<>();
		products = productService.getAllProducts();
		return ResponseEntity.ok(products);
		
	}
	
	@DeleteMapping("/delete/{productId}")
	public ResponseEntity<?> deleteProductById(@PathVariable("productId") String productId) throws IdNotFoundException {
		if(productService.deleteProductById(productId)) {
			return ResponseEntity.noContent().build();
		}
		else
			throw new IdNotFoundException("id not found");
			
	}
	
	@PutMapping("{productId}")
	public ResponseEntity<?> updateProductById(@PathVariable("productId") String productId, 
			@RequestBody Product product) {
		product.setProductId(productId);
		Product prod;
		try {
			prod = productService.updateProductById(product, productId);
			return new ResponseEntity(prod, HttpStatus.CREATED);
		} catch (IdNotFoundException | NotUniqueNameException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
}
