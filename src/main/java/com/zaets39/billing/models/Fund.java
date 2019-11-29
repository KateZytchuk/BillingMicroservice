package com.zaets39.billing.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "funds")
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //???
    private UUID driver_id;
    private double fundBalance;
    public  Fund(@JsonProperty UUID id_driver){
        this.driver_id = id_driver;
    }
}
