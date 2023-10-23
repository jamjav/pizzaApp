package com.tech.challenge.pizza.app.models.pizzas;

import org.springframework.stereotype.Service;

@Service
public class CheesePizza extends Pizza implements IPizza {

    public CheesePizza(){
        name = "Cheese Pizza";
        ingredients.add("Regular Crust");
        ingredients.add("Marinara Pizza Sauce");
        ingredients.add("Fresh Mozzarella");
        ingredients.add("Parmesan");
    }

    @Override
    public boolean shouldInvoke(String type) {
        return PizzaEnum.CHEESE.getType().equalsIgnoreCase(type);
    }
}
