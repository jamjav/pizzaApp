package com.tech.challenge.pizza.app.models.pizzas;

import lombok.Getter;

@Getter
public enum PizzaEnum {

        CHEESE("Cheese"),
        PEPPERONI("Pepperoni"),
        CLAM("Clam"),
        VEGGIE("Veggie");

        private String type;

        PizzaEnum(String type) {
            this.type = type;
        }

        public static PizzaEnum fromValue(String text) {
            for (PizzaEnum b : PizzaEnum.values()) {
                if (b.type.equalsIgnoreCase(text)) {
                    return b;
                }
            }
            return null;
        }
}
