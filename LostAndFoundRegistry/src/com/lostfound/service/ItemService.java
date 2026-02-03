package com.lostfound.service;

import com.lostfound.dao.ItemDAO;
import com.lostfound.daoimpl.ItemDAOImpl;
import com.lostfound.dto.Item;

import java.util.List;

public class ItemService {

    private ItemDAO dao = new ItemDAOImpl();

    public void reportItem(Item item) {
        dao.addItem(item);
    }

    public List<Item> viewItems() {
        return dao.getAllItems();
    }

    public void claimItem(int id) {
        dao.markAsClaimed(id);
    }

    public void removeItem(int id) {
        dao.deleteItem(id);
    }
}
