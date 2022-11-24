package com.shopping.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class ProductTests {
	
	@Test
	void test_ProductLoadedOrNot()
	{
		Product product=new Product();
		assertNotNull(product);
	}
	
	@Test
	void test_ProductModel()
	{
		Product product=Product.builder()
				.id("123")
				.productName("Realme GT Master Edition")
				.productDescription("realme GT Master Edition in India is equipped with Snapdragon 778G 5G Processor | 120Hz Super AMOLED Display")
				.productStatus("Available")
				.qty(10)
				.price(26999)
				.features(Stream.of("8 GB RAM | 128 GB ROM","Qualcomm Snapdragon 778G Processor").toList())
				.build();
		assertEquals("123",product.getId());
		assertEquals("Realme GT Master Edition",product.getProductName());
		assertEquals("realme GT Master Edition in India is equipped with Snapdragon 778G 5G Processor | 120Hz Super AMOLED Display",product.getProductDescription());
		assertEquals("Available",product.getProductStatus());
		assertEquals(10,product.getQty());
		assertEquals(2,product.getFeatures().size());
	}
	@Test
	void test_ProductConstructor()
	{
		Product product=new Product(Stream.of("8 GB RAM | 128 GB ROM","Qualcomm Snapdragon 778G Processor").toList());
		assertEquals(2,product.getFeatures().size());
	}

}
