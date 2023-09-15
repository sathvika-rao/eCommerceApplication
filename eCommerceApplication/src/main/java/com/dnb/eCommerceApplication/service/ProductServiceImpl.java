package com.dnb.eCommerceApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnb.eCommerceApplication.dto.Product;
import com.dnb.eCommerceApplication.exceptions.IdNotFoundException;
import com.dnb.eCommerceApplication.exceptions.NotUniqueNameException;
import com.dnb.eCommerceApplication.payload.request.ProductPayloadRequest;
import com.dnb.eCommerceApplication.repository.ProductRepository;

//This class includes the implementation of the de

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
//	@Autowired
//	ProductPayloadRequest productPayloadRequest;

	@Override
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> getProductById(String productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
			
	}

	@Override
	public boolean deleteProductById(String productId) {
		// TODO Auto-generated method stub
		if(productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
			return true;
		}
		else 
			return false;
	}

	@Override
	public Product updateProductById(Product product, String productId) throws IdNotFoundException, NotUniqueNameException {
		// TODO Auto-generated method stub
//		Optional<Product> prod;
//		if(productRepository.existsById(productId)) {
//			if(productRepository.existsByProductName(product.getProductName())) {
//				prod = productRepository.findById(productId);
//				String str = prod.get().getProductName();
//				if(str.equals(product.getProductName())){
//					return productRepository.save(product);
//				}
//				else
//					throw new NotUniqueNameException("name is not unique");
//				
//			}
//			else {
//				return productRepository.save(product);
//			}
//				
//		}
//		else
//			throw new IdNotFoundException("id not found");
//		}
		
		if(productRepository.existsById(productId)) {
			if(productRepository.existsByProductName(product.getProductName())) {
				String name = productRepository.getProductName(productId);
				if(name.equals(product.getProductName())) {
					return productRepository.save(product);
				}
				else {
					throw new NotUniqueNameException("name is not unique");
				}
			}
			else {
				return productRepository.save(product);
			}
		}
		else
			throw new IdNotFoundException("id not found");
		}
}
