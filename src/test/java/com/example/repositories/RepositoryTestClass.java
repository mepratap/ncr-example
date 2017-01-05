package com.example.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryTestClass {
	@InjectMocks
	private ProductRepository productRepository;
	
	@Test
	public void getProductByCountReturnsListOfProducts(){
		assertNotNull(productRepository.getProductByCount(2));
		assertEquals(2, productRepository.getProductByCount(5).size());
		assertEquals(0, productRepository.getProductByCount(6).size());
	}

}
