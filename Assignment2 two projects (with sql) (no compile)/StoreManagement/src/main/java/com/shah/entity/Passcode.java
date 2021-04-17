package com.shah.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passcode implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String passCode;
    private boolean isAdmin;
}
