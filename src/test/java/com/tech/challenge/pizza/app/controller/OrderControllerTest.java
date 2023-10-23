package com.tech.challenge.pizza.app.controller;

import com.tech.challenge.pizza.app.models.Inventory;
import com.tech.challenge.pizza.app.models.Order;
import com.tech.challenge.pizza.app.models.pizzas.Pizza;
import com.tech.challenge.pizza.app.models.requests.RequestOrder;
import com.tech.challenge.pizza.app.processor.InventoryProcessor;
import com.tech.challenge.pizza.app.processor.OrderProcessor;
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

class OrderControllerTest {

    private OrderController orderController;

    @Mock
    private InventoryProcessor inventoryProcessor;

    @Mock
    private OrderProcessor orderProcessor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        orderController = new OrderController();
        orderController.processor = orderProcessor;

    }

    @Test
    public void testCreateOrder() {
        // Arrange
        RequestOrder request = new RequestOrder();
        request.setTypePizza("Pizza A");

        Pizza pizza = new Pizza();
        Order response = new Order(pizza, true);


        Mockito.when(orderProcessor.create(request)).thenReturn(response);

        // Act
        ResponseEntity<Object> result = orderController.createOrder(request);

        // Assert
        Assertions.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assertions.assertEquals(response, result.getBody());
    }

}