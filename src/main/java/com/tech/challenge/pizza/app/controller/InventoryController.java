package com.tech.challenge.pizza.app.controller;

import com.tech.challenge.pizza.app.models.Inventory;
import com.tech.challenge.pizza.app.processor.InventoryProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {

    @Autowired protected InventoryProcessor processor;

    @PostMapping("/inventory/products")
    public ResponseEntity<Object> createInventory(
            @RequestBody List<Inventory> request) {

        List<Inventory> response = processor.create(request);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/inventory/products")
    public ResponseEntity<Object> getInventory() {

        List<Inventory> response = processor.getAll();
        return ResponseEntity.ok(response);

    }

    @PutMapping("/inventory/product/{name}/increase/{quantity}")
    public ResponseEntity<Object> increaseInventory(
            @PathVariable String name,
            @PathVariable int quantity) {

        Inventory request = new Inventory();
        request.setName(name);
        request.setQuantity(quantity);
        List<Inventory> response = processor.update(request);
        return ResponseEntity.ok(response);

    }

    @PutMapping("/inventory/product/{name}/decrease/{quantity}")
    public ResponseEntity<Object> decreaseInventory(
            @PathVariable String name,
            @PathVariable int quantity) {

        Inventory request = new Inventory();
        request.setName(name);
        request.setQuantity(-quantity);
        List<Inventory> response = processor.update(request);
        return ResponseEntity.ok(response);

    }

}
