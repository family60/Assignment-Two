package com.kovunov.model;

import java.util.Date;

public class Item extends Inventory{

    public Item(String name, String sport, int quantity, double pricePerUnit, Date dateUpdated) {
        super(name, sport, quantity, pricePerUnit, dateUpdated);
    }
}
