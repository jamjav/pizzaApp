package com.tech.challenge.pizza.app.processor;

import com.tech.challenge.pizza.app.models.Inventory;
import com.tech.challenge.pizza.app.models.Order;
import com.tech.challenge.pizza.app.models.requests.RequestOrder;
import com.tech.challenge.pizza.app.models.pizzas.Pizza;
import com.tech.challenge.pizza.app.models.pizzas.PizzaManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class OrderProcessor {

    private PizzaManager serviceManager;
    private InventoryProcessor processor;

    public Order create(RequestOrder request) {

        System.out.println("OrderProcessor.execute()");
        System.out.println("request = [" + request.toString() + "]");

        Pizza pizza  = (Pizza) serviceManager.getService(request.getTypePizza());
        boolean isChecked = checkOrder(pizza);
        if (isChecked) {
            process(pizza);
        }
        return new Order(pizza, isChecked);
    }

    public void process(Pizza pizza) {

        List<Inventory> listProducts =  processProducts(pizza);
        processor.update(listProducts);
    }

    public List<Inventory> processProducts(Pizza pizza){

        List<Inventory> listProducts =  new ArrayList<>();
        for (String ingredient : pizza.getIngredients()) {
            Inventory inventory = new Inventory();
            inventory.setName(ingredient.toLowerCase());
            inventory.setQuantity(-1);
            listProducts.add(inventory);
        }
        return listProducts;
    }


    public boolean checkOrder(Pizza pizza) {
        List<Inventory> listProducts =  processProducts(pizza);
        return  processor.isAvailable(listProducts);

    }
}
