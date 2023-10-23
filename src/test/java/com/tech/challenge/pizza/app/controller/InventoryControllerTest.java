


package com.tech.challenge.pizza.app.controller;

import com.tech.challenge.pizza.app.models.Inventory;
import com.tech.challenge.pizza.app.processor.InventoryProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class InventoryControllerTest {

    private InventoryController inventoryController;

    @Mock
    private InventoryProcessor inventoryProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        inventoryController = new InventoryController();
        inventoryController.processor = inventoryProcessor;
    }

    @Test
    public void testCreateInventory() {
        // Arrange
        List<Inventory> request = new ArrayList<>();

        Inventory productA = new Inventory();
        productA.setName("Product A");
        productA.setQuantity(1);

        Inventory productB = new Inventory();
        productB.setName("Product B");
        productB.setQuantity(2);


        request.add(productA);
        request.add(productB);

        List<Inventory> response = new ArrayList<>();
        response.add(productA);
        response.add(productB);

        Mockito.when(inventoryProcessor.create(request)).thenReturn(response);

        // Act
        ResponseEntity<Object> result = inventoryController.createInventory(request);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(response, result.getBody());
    }

    @Test
    public void testGetInventory() {
        // Arrange
        List<Inventory> response = new ArrayList<>();
        Inventory productA = new Inventory();
        productA.setName("Product A");
        productA.setQuantity(1);

        Inventory productB = new Inventory();
        productB.setName("Product B");
        productB.setQuantity(2);

        response.add(productA);
        response.add(productB);

        Mockito.when(inventoryProcessor.getAll()).thenReturn(response);

        // Act
        ResponseEntity<Object> result = inventoryController.getInventory();

        // Assert
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(response, result.getBody());
    }



}