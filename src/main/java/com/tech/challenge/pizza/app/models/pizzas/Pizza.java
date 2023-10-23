package com.tech.challenge.pizza.app.models.pizzas;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Pizza  {

    String name;
    List<String> ingredients = new ArrayList<>();

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }


}
