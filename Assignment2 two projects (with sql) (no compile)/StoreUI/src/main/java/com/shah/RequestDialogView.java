package com.shah;

import com.shah.entity.Request;
import com.shah.inventory.InventoryService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RequestDialogView implements Serializable {

    @EJB
    private InventoryService inventoryService;

public List<Request> getRequestList(){return inventoryService.getAllRequest();}
}
