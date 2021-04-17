package com.shah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i")
@NamedQuery(name = "Inventory.getByUserName", query = "SELECT i from Inventory i where i.inventoryName = :inventoryName")
@NamedQuery(name = "Inventory.clearAll", query = "DELETE FROM Inventory")
public class Inventory implements Comparable<Inventory>, Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String inventoryName;
    private String sportName;

    private Date signedUpDate;

    @OneToMany(mappedBy = "inventory", fetch = FetchType.EAGER)
    private List<Request> requestList;

    @PrePersist
    void createdAt(){this.signedUpDate = new Date();}

    @PreUpdate
    void updateAt(){this.signedUpDate = new Date();}

    public Inventory(String inventoryName,String sportName)
    {
    this.inventoryName=inventoryName;
    this.sportName=sportName;
    }

    @Override
    public int compareTo(Inventory o) {
        return signedUpDate.compareTo(o.signedUpDate);
    }
}
