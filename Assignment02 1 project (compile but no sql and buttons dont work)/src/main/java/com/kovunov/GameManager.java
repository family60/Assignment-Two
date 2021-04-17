package com.kovunov;


import com.kovunov.model.Inventory;

import java.util.List;

public interface GameManager {
    void add(Inventory inventory);
    List<Inventory> getInventory();
    void delete(Inventory inventory);

    List<Inventory> getItem();
}
