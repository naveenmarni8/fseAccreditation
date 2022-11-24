package com.shopping.orders.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shopping.orders.model.OrderModel;

public interface OrderModelRepository extends MongoRepository<OrderModel,String> {

}
