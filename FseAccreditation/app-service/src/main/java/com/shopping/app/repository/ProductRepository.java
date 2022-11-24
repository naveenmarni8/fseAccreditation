package com.shopping.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.app.model.Product;


@Repository
public interface ProductRepository extends MongoRepository<Product,String>{

@Query(value="{'productName':?0}")
Product findByProductName(String productName);
}
