package com.tech.challenge.pizza.app.models.responses;

import com.tech.challenge.pizza.app.models.Inventory;

import java.util.List;

public class ResponseInventory {
    Boolean success;
    List<Inventory> products;

    public ResponseInventory(boolean success, List<Inventory> listProducts) {
        this.success = success;
        this.products = listProducts;
    }
}
