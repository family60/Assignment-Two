package com.kovunov;

import com.kovunov.model.Inventory;
import com.kovunov.model.Item;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class GameManagementService implements com.kovunov.GameManager
{
    private List<Inventory> inventoryList;

    @PostConstruct
    public void addForza()
    {
        inventoryList = new ArrayList<>();
        inventoryList.add(new Item("Soccer Ball", "Soccer", 50, 15.99, new Date()));
    }

    @Override
    public List<Inventory> getItem(){
        return inventoryList;
    }

    @Override
    public void delete(@Observes @DeleteGame Inventory inventory){
        inventoryList = new ArrayList<>();
        inventoryList.remove(inventory);
    }

    @Override
    public void add(@Observes @com.kovunov.AddGame Inventory inventory){
        inventoryList = new ArrayList<>();
        inventoryList.add(inventory);
    }

    @Override
    public List<Inventory> getInventory() {
        return inventoryList;
    }


}
