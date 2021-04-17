package com.shah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Request.findAll", query = "Select r FROM Request r")
public class Request implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @Column(length = 255)
    private String requestText;

    @ManyToOne
    @JoinColumn(name= "id_inventory")
    private Inventory inventory;

    public Request(String requestText){this.requestText = requestText;}
}
