package com.lostfound.dao;

import java.util.List;
import com.lostfound.dto.Item;

public interface ItemDAO {

    void addItem(Item item);

    List<Item> getAllItems();

    void updateItemStatus(int id, String status);

    void deleteItem(int id);
}