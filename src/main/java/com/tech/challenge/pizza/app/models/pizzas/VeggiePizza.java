package com.tech.challenge.pizza.app.models.pizzas;

import org.springframework.stereotype.Service;

@Service
public class VeggiePizza extends Pizza implements IPizza {

    public VeggiePizza(){
        name = "Veggie Pizza";
        ingredients.add("Crust");
        ingredients.add("Marinara sauce");
        ingredients.add("Shredded mozzarella");
        ingredients.add("Grated parmesan");
        ingredients.add("Diced onion");
        ingredients.add("Sliced mushrooms");
        ingredients.add("Sliced red pepper");
        ingredients.add("Sliced black olives");
    }

    @Override
    public boolean shouldInvoke(String type) {
        return PizzaEnum.VEGGIE.getType().equalsIgnoreCase(type);
    }
}
