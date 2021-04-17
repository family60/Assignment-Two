package com.shah;

import com.shah.admin.PasscodeService;
import com.shah.entity.Inventory;
import com.shah.entity.Request;
import com.shah.inventory.InventoryService;
import org.primefaces.PrimeFaces;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@SessionScoped
@Named
public class InventoryAppBean implements Serializable {

    @NotEmpty
    private String inventoryName;

    @NotEmpty
    private String sportName;

    @NotEmpty
    private String passcode;

    @NotEmpty
    private String requestText;

    private boolean isAdmin = false;

        @EJB
        private InventoryService inventoryService;

        @EJB
        private PasscodeService passcodeService;

        public void viewRequests(){
            Map<String, Object> options = new HashMap<>();
            options.put("resizable",false);
            PrimeFaces.current().dialog().openDynamic("requests",options,null);
        }

        public void addRequest(){inventoryService.addPlayerRequest(inventoryName, new Request(requestText));}

        public List<Inventory> getInventoryList(){return inventoryService.getInventoryList();}

        public List<Inventory> getWaitList(){return inventoryService.getWaitList();}

    public String addInventory() {
        Inventory inventory = new Inventory(inventoryName,sportName);
        Optional<Inventory> inventoryExists = inventoryService.getInventoryList().stream().filter(p ->
                p.getInventoryName().equals(inventoryName) && p.getSportName().equals(sportName)).findFirst();
        if (inventoryExists.isPresent()) {
            inventoryService.removeFromList(inventory);
        }
        else {
            inventoryService.addToList(inventory);
        }
        clearFields();
        return "inventoryList";
    }

    private void clearFields() {
            setAdmin(false);
            setInventoryName("");
            setSportName("");
            setPasscode("");
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
