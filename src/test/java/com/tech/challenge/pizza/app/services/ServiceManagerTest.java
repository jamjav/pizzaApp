package com.tech.challenge.pizza.app.services;

import com.tech.challenge.pizza.app.models.pizzas.IPizza;
import com.tech.challenge.pizza.app.models.pizzas.PizzaManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class ServiceManagerTest {

    @Mock
    private IPizza pizza1;

    @Mock
    private IPizza pizza2;

    private PizzaManager serviceManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        List<IPizza> pizzas = Arrays.asList(pizza1, pizza2);
        serviceManager = new PizzaManager(pizzas);
    }

    @Test
    public void testGetService() {
        String type = "Margherita";
        when(pizza1.shouldInvoke(type)).thenReturn(false);
        when(pizza2.shouldInvoke(type)).thenReturn(true);

        IPizza actualPizza = serviceManager.getService(type);

        Assertions.assertEquals(pizza2, actualPizza);
    }

    @Test
    public void testGetServiceNotFound() {
        String type = "Pepperoni";
        when(pizza1.shouldInvoke(type)).thenReturn(false);
        when(pizza2.shouldInvoke(type)).thenReturn(false);

        IPizza actualPizza = serviceManager.getService(type);

        Assertions.assertNull(actualPizza);
    }
}