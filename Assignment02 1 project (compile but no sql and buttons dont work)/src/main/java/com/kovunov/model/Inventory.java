package com.kovunov.model;

import java.util.Date;

public abstract class Inventory {
    private String name;
    private String sport;
    private int quantity;
    private double pricePerUnit;
    private Date dateUpdated;

    public Inventory(String name, String sport, int quantity, double pricePerUnit, Date dateUpdated) {
        this.name = name;
        this.sport = sport;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.dateUpdated = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
