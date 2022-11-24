package com.shopping.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Products")
@Builder
public class Product {
	@Id
	private String id;
	private String productName;
	private String productDescription;
	private double price;
	private List<String> features;
	private String productStatus;
    private int qty;
    @JsonCreator
    public Product(List<String> features)
    {
    	this.features=features;
    }
}
