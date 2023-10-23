package com.tech.challenge.pizza.app.controller;


import com.tech.challenge.pizza.app.models.Order;
import com.tech.challenge.pizza.app.models.requests.RequestOrder;
import com.tech.challenge.pizza.app.processor.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired protected OrderProcessor processor;

    @PostMapping("/order")
    public ResponseEntity<Object> createOrder(
            @RequestBody RequestOrder request) {

        Order response = processor.create(request);
        return ResponseEntity.ok(response);

    }













}
