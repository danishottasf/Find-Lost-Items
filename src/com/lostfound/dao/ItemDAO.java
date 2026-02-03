package com.lostfound.dao;

import com.lostfound.dto.Item;
import java.util.List;

public interface ItemDAO {
    void addItem(Item item);
    List<Item> getAllItems();
    void markAsClaimed(int id);
    void deleteItem(int id);
}
