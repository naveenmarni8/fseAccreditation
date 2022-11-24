package com.shopping.users.exception;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomExceptionTest {
	
	CustomException customException =new CustomException();
	@Test
	void test_CustomExceptionLoadingorNot()
	{
		assertNotNull(customException);
	}

}
