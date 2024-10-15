package com.kalpit00.order.controller;

import com.kalpit00.order.dto.OrderRequest;
import com.kalpit00.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        boolean orderPlaced = orderService.placeOrder(orderRequest);
        return orderPlaced ? "Order Placed Successfully" : "Product with code " + orderRequest.getSkuCode() + " is not in stock";
    }
}
