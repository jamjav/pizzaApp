package com.tech.challenge.pizza.app.models.requests;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestOrder {

    private String typePizza;


    @Override
    public String toString() {
        return "OrderRequest{" +
                "TypePizza='" + typePizza + '\'' +
                '}';
    }
}
