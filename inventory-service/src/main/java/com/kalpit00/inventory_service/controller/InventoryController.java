package com.kalpit00.inventory_service.controller;

import com.kalpit00.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam(name = "skuCode") String skuCode,
                             @RequestParam(name = "quantity") Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }

}