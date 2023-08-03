package com.tienda.services;

import com.tienda.models.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServices implements IItemServices {

    @Override
    public List<Item> consulta() {

        return simularConsultaDB();
    }

    @Override
    public List<Item> searchByName(String name) {
        List<Item> itemList = simularConsultaDB();
        List<Item> filteredItems = itemList.stream().filter(item -> item.getName()
                .equalsIgnoreCase(name)).collect(Collectors.toList());
        //return filteredItems.isEmpty() ? itemList : filteredItems;
        if (filteredItems.size() == 0) {
            //throw new RuntimeException("items no encontrado");
            return itemList;
        }
        else{
            return filteredItems;
        }
    }

    @Override
    public String saveItem(Item item) {
        System.out.println("Name item: " + item.getName());
        return "Successful saving";
    }


    private List<Item> simularConsultaDB(){
        Item item1 = new Item();
        item1.setName("Item 1");
        item1.setIdentifier(1);
        item1.setUnique(true);
        Item item2 = new Item();
        item2.setName("Item 2");
        item2.setIdentifier(1);
        item2.setUnique(true);
        Item item3 = new Item();
        item3.setName("Item 3");
        item3.setIdentifier(1);
        item3.setUnique(true);
        Item item4 = new Item();
        item4.setName("Item 4");
        item4.setIdentifier(2);
        item4.setUnique(false);
        return Arrays.asList(item1, item2, item3, item4);
    }
}
