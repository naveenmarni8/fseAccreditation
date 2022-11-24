package com.shopping.orders.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
 class ExceptionDataTests {
	
	@Test
	void test_ExceptionLoadedorNot()
	{
		LocalDateTime localDateTime=LocalDateTime.now();
		CustomException customException =new CustomException();
		ExceptionData exceptionData=new ExceptionData("message",localDateTime,customException );
		assertNotNull(exceptionData);
	}
	@Test
	void test_ExceptionData()
	{
		LocalDateTime localDateTime=LocalDateTime.now();
		CustomException customException =new CustomException();
		ExceptionData exceptionData=new ExceptionData("message",localDateTime,customException );
		assertEquals("message",exceptionData.getMessage());
		assertEquals(localDateTime,exceptionData.getLocalDateTime());
		assertEquals(customException ,exceptionData.getThrowable());
	}

}
