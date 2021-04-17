package com.kovunov.decorator;

import com.kovunov.GameManagementService;
import com.kovunov.GameManager;
import com.kovunov.model.Inventory;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;
import java.util.List;

@Decorator
public class GameManagementServiceDecorator implements GameManager {

    @Inject
    @Delegate
    private GameManagementService gameManagementService;

    @Override
    public List<Inventory> getInventory(){
        return gameManagementService.getInventory();
    }

    @Override
    public void delete(Inventory inventory){
        gameManagementService.delete(inventory);
    }

    @Override
    public List<Inventory> getItem() {
        return getItem();
    }

    @Override
    public void add(Inventory inventory){
        gameManagementService.add(inventory);
    }




}
