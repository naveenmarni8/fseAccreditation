package com.shopping.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {
	private String id;
	private String productName;
	private String productDescription;
	private double price;
	private List<String> features;
	private String productStatus;
    private int qty;
    @JsonCreator
    public ProductRequestDto(List<String> features)
    {
    	this.features=features;
    }
}
