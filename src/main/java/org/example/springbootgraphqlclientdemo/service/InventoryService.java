package org.example.springbootgraphqlclientdemo.service;

import org.example.springbootgraphqlclientdemo.client.InventoryClient;
import org.example.springbootgraphqlclientdemo.dto.Item;
import org.example.springbootgraphqlclientdemo.dto.ItemRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryClient inventoryClient;

    public List<Item> getItems() {
        return inventoryClient.getProducts();
    }

    public List<Item> getProductsByCat(String cat) {
        return inventoryClient.getItemsByCategory(cat);
    }

    public Item updateStrock(ItemRequestDto itemRequestDto) {
        return inventoryClient.updateStock(itemRequestDto);
    }
}
