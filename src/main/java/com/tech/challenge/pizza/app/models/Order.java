package com.tech.challenge.pizza.app.models;

import com.tech.challenge.pizza.app.models.pizzas.Pizza;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Order {
    String id;
    Pizza pizza;
    boolean isChecked;
    String status;
    String message;

    public Order( Pizza pizza, boolean isChecked) {
        this.id =   UUID.randomUUID().toString();;
        this.pizza = pizza;
        this.isChecked = isChecked;
        this.status = "Order Received";

        if (pizza == null) {
            this.status = "Order Rejected";
            this.message = "Pizza not found";
        }

        if (!isChecked) {
            this.status = "Order Rejected";
            this.message = "Out of stock";
        }

    }

}
