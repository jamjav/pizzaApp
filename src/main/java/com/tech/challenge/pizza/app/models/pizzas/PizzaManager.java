package com.tech.challenge.pizza.app.models.pizzas;

import com.tech.challenge.pizza.app.models.pizzas.IPizza;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PizzaManager {
    private List<IPizza> pizzas;


    public IPizza getService(String type) {
        System.out.println("PizzaFactory.createPizza()");

        return pizzas.stream().filter(pizza -> pizza.shouldInvoke(type)).findFirst().orElse(null);
    }
}


