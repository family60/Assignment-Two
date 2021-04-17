package com.kovunov.model;

import java.util.List;

public abstract class Store {
    private int id;
    private String name;
    private String location;
    private List<Inventory> inventoryList;

    public Store(int id, String name, String location, List<Inventory> inventoryList){
        this.id = id;
        this.name = name;
        this.location = location;
        this.inventoryList = inventoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }
}
