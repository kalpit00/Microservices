package com.kalpit00.order.client;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


public interface InventoryClient {
    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam(name = "skuCode") String skuCode,
                      @RequestParam(name = "quantity") Integer quantity);
}