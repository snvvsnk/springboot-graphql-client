package org.example.springbootgraphqlclientdemo.controller;

import org.example.springbootgraphqlclientdemo.client.InventoryClient;
import org.example.springbootgraphqlclientdemo.dto.Item;
import org.example.springbootgraphqlclientdemo.dto.ItemRequestDto;
import org.example.springbootgraphqlclientdemo.service.InventoryService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    private final InventoryService inventoryService;
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping("/products")
    public List<Item> getProducts() {
        return inventoryService.getItems();
    }

    @GetMapping("/products/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category) {
        return inventoryService.getProductsByCat(category);
    }

    @PostMapping("/updatestock")
    public Item updateStock(@RequestBody ItemRequestDto itemRequestDto) {
        return inventoryService.updateStrock(itemRequestDto);
    }


}
