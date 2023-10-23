package com.tech.challenge.pizza.app.processor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.challenge.pizza.app.models.Inventory;
import com.tech.challenge.pizza.app.services.FileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@AllArgsConstructor
public class InventoryProcessor {

    private FileService fileService;

    public List<Inventory> create(List<Inventory> request)  {

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Inventory> listProducts =  merge(getAll(), request);
            String products = mapper.writeValueAsString(listProducts);
            fileService.writeFile(products);
            return listProducts;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Inventory> update(List<Inventory> request)  {

        List<Inventory> listProducts =  new ArrayList<>();
        for (Inventory inventory : request) {
            listProducts = update(inventory);
        }
        return listProducts;
    }

    public List<Inventory> update(Inventory request)  {

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Inventory> listNewProducts =  List.of(request);
            List<Inventory> listProducts =  merge(getAll(), listNewProducts);
            if (isAvailable(listProducts)) {
                String products = mapper.writeValueAsString(listProducts);
                fileService.writeFile(products);
            } else {
                throw new RuntimeException("Invalid quantity");
            }

            return listProducts;

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Inventory> getAll()  {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = fileService.readFile();
            return mapper.readValue(json, new TypeReference<List<Inventory>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Inventory> merge(List<Inventory> currentInventory, List<Inventory> newInventory)  {

                currentInventory.addAll(newInventory);
            Map<String, Integer> map = new HashMap<>();

            for (Inventory inventory : currentInventory) {
                String name = inventory.getName().toLowerCase();
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + inventory.getQuantity());
                } else {
                    map.put(name, inventory.getQuantity());
                }
            }

            List<Inventory> listInventory = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                Inventory inventory = new Inventory();
                inventory.setName(entry.getKey());
                inventory.setQuantity(entry.getValue());
                listInventory.add(inventory);
            }
            return listInventory;
    }

    public boolean isAvailable(List<Inventory> request)  {

        //check if contains values negatives
        List<Inventory> listProducts =  merge(getAll(), request);
        for (Inventory inventory : listProducts) {
            if (inventory.getQuantity() < 0) {
                return false;
            }
        }
        return true;



    }


}
