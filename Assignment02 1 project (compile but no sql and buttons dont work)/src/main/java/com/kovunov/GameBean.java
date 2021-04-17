package com.kovunov;


import com.kovunov.interceptor.Logged;
import com.kovunov.model.Item;
import com.kovunov.model.Inventory;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Model
public class GameBean
{
    private String name;
    private String sport;
    private int quantity;
    private Double pricePerUnit;
    private Date dateUpdated;

    @Inject
    @com.kovunov.AddGame
    private Event<Item> gameAddGame;

    @Inject
    @DeleteGame
    private Event<Item> gameDeleteGame;

    @Inject
    private GameManager gameService;

    public List<Inventory> getInventory(){
        return gameService.getItem();
    }

    @Logged

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

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Logged
    public void addGame(){
        gameAddGame.fire(new Item(name, sport, quantity, pricePerUnit, dateUpdated));
    }

    @Logged
    public void deleteGame(){
        gameDeleteGame.fire(new Item(name, sport, quantity, pricePerUnit, dateUpdated));
    }
}
