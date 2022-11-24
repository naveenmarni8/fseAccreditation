package com.shopping.orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="app-service",url= "${PRODUCT.URL}")
public interface ProductClient {
@GetMapping("/api/v1.0/shopping/check/{productId}/{productQty}")
public boolean checkProduct(@PathVariable String productId,@PathVariable int productQty);
}
