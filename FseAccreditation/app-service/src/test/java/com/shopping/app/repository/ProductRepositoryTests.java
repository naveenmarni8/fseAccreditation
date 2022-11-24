package com.shopping.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.shopping.app.model.Product;


@SpringBootTest
class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository productRepository;
	
	private Product product;
	
	@BeforeEach
	void init()
	{
	product=Product.builder()
			.id("123")
			.productName("Realme GT Master Edition")
			.productDescription("realme GT Master Edition in India is equipped with Snapdragon 778G 5G Processor | 120Hz Super AMOLED Display")
			.productStatus("Available")
			.qty(10)
			.price(26999)
			.features(Stream.of("8 GB RAM | 128 GB ROM","Qualcomm Snapdragon 778G Processor").toList())
			.build();
			
			
	}
	@Test
	void test_saveMethod()
	{
		assertEquals(product,productRepository.save(product));
	}
	@Test
	void test_findbyId()
	{
		productRepository.save(product);
		assertTrue(productRepository.findById(product.getId()).isPresent());
	}
	@Test
	void test_deleteById()
	{
		productRepository.save(product);
		productRepository.deleteById(product.getId());
		assertTrue(productRepository.findById(product.getId()).isEmpty());
	}
	@Test
	void test_findAll()
	{
		productRepository.save(product);
		assertTrue(productRepository.findAll().size()>0);
	}

}
