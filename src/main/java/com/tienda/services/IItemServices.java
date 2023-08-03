package com.tienda.services;

import com.tienda.models.Item;

import java.util.List;

public interface IItemServices {
    List<Item> consulta();

    List<Item> searchByName(String name);

    String saveItem(Item item);
}

