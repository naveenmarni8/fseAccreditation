package com.shopping.orders.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.shopping.orders.dto.ProductDto;
import com.shopping.orders.model.OrderModel;

@SpringBootTest
class OrderModelRepositoryTests {
	@Autowired
	private OrderModelRepository orderModelRepository;
	private OrderModel orderModel;
	private ProductDto productDto;
	@BeforeEach
	void init()
	{
		
		productDto=ProductDto.builder()
				.id("123")
				.productName("Realme GT Master Edition")
				.qty(10)
				.build();
		
		orderModel=OrderModel.builder()
				  .id("345")
				  .orderId("#123895")
		          .productDtoList(Stream.of(productDto).toList())
		          .build();
		
		          
	}
	@Test
	void test_SaveOrderData()
	{
		assertNotNull(orderModelRepository.save(orderModel));
	}
}
