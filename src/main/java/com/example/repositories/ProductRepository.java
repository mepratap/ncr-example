package com.example.repositories;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.models.Product;

@Repository
public class ProductRepository {
	private final static List<Product> products;
	
	static{
		products = Arrays.asList(new Product(123, "iPhone 6s 32GB", 900, 5),
				new Product(234, "iPhone 6s Plus 32GB", 900, 2),
				new Product(123, "iPhone 6s 32GB", 901, 5));
	}
	
	public List<Product> getProductById(long id) {
		return products.stream().filter(product -> product.getSku() == id).collect(Collectors.toList());
	}
	
	public List<Product> getProductByCount(long count) {
		return products.stream().filter(product-> product.getCount() == count).collect(Collectors.toList());
	}
	
	public List<Product> updateProductByCount(Product productToUpdate){
		final long productId = productToUpdate.getSku();
		List<Product> products = this.getProductById(productId);
		products.forEach(product -> {
			product.setCount(productToUpdate.getCount());
		});
		return products;
	}
}
