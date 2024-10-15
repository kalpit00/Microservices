package com.kalpit00.order.service;


import com.kalpit00.order.client.InventoryClient;
import com.kalpit00.order.dto.OrderRequest;
import com.kalpit00.order.model.Order;
import com.kalpit00.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional

public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public boolean placeOrder(OrderRequest orderRequest) {
        boolean isProductInStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());
        if (isProductInStock) {
            var order = mapToOrder(orderRequest);
            orderRepository.save(order);
        }
        return isProductInStock;
    }

    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.getPrice());
        order.setQuantity(orderRequest.getQuantity());
        order.setSkuCode(orderRequest.getSkuCode());
        return order;
    }
}
