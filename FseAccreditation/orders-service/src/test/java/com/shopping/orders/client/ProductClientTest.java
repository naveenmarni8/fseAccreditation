package com.shopping.orders.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductClientTest {
	
	@Autowired
	ProductClient productClient;
	
	@Test
	void test_ProductClientLoadingornot()
	{
		assertNotNull(productClient);
	}

}
