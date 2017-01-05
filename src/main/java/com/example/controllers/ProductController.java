package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Product;
import com.example.repositories.ProductRepository;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProducts(@RequestParam("count") Long count){
		List<Product> products = this.productRepository.getProductByCount(count);
		
		if(products.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProductCount(@RequestBody Product product){
		return Optional.ofNullable(product).map(p -> {
			List<Product> products = this.productRepository.updateProductByCount(p);
			if(products.isEmpty()){
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}).orElse(ResponseEntity.badRequest().build());
	}
}
