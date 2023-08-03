package com.tienda.controllers;

import com.tienda.models.Item;
import com.tienda.services.IItemServices;
import com.tienda.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Name;
import java.util.List;

@RestController
@RequestMapping("tiendamompos")
public class ItemController {
    @Autowired
    private IItemServices services;
    @GetMapping("/items/name")
    public List<Item> getGreetings() {
        return services.consulta();
    }

    @GetMapping("/items/name/find")
    public List<Item> getGreetingsByName(@RequestParam String name) {
        return services.searchByName(name);
    }

    @PostMapping("items/name/saveitem")
    public String saveGreetings(@RequestBody Item item){
        return services.saveItem(item);
    }
}
