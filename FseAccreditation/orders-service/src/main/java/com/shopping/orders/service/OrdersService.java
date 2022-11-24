package com.shopping.orders.service;




import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.shopping.orders.dto.ProductDtoList;
import com.shopping.orders.model.OrderModel;
import com.shopping.orders.repository.OrderModelRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OrdersService {
	
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	@Autowired
	private OrderModelRepository orderModelRepository;
	
	private CountDownLatch countDownLatch = new CountDownLatch(1);
	
	private OrderModel payload;



public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}


	public OrderModel getPayload() {
		return payload;
	}



	



public void sendOrderData(ProductDtoList productDtoList)
{
	kafkaTemplate.send("orders-topic",  productDtoList);
}



@KafkaListener(topics = { "orders-topic" })
public void customerOrderData(ProductDtoList productDtoList)
{
	UUID uuId=UUID.randomUUID();
	OrderModel order=new OrderModel();
	order.setOrderId(uuId.toString());
	order.setProductDtoList(productDtoList.getProductDtoList());
	log.info("Order details: "+productDtoList.toString());
	countDownLatch.countDown();
	payload=order;
	orderModelRepository.save(order);
}

}
