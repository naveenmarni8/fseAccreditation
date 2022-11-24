package com.shopping.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
 class ProductDtoTests {
	@Test
	void test_ProductDtoLoadedOrNot()
	{
		ProductDto productDto=new ProductDto();
		assertNotNull(productDto);
	}
	
	@Test
	void test_ProductDto()
	{
		ProductDto productDto=ProductDto.builder()
				.id("123")
				.productName("Realme GT Master Edition")
				.qty(10)
				.build();
		assertEquals("123",productDto.getId());
		assertEquals("Realme GT Master Edition",productDto.getProductName());
		assertEquals(10,productDto.getQty());
	}
}
