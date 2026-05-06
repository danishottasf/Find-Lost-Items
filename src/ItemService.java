package com.lostfound.service;

import java.util.List;

import com.lostfound.dao.ItemDAO;
import com.lostfound.daoimpl.ItemDAOImpl;
import com.lostfound.dto.Item;

public class ItemService {

    private ItemDAO dao = new ItemDAOImpl();

    public void reportItem(Item item) {
        if (item.getItemName() == null || item.getItemName().trim().isEmpty()) {
            System.out.println("Item name cannot be empty");
            return;
        }
        dao.addItem(item);
    }

    public List<Item> viewItems() {
        return dao.getAllItems();
    }

    public void claimItem(int id) {
        dao.updateItemStatus(id, "CLAIMED");
    }

    public void removeItem(int id) {
        dao.deleteItem(id);
    }
}