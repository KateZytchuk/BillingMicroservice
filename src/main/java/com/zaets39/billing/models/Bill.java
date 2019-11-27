package com.zaets39.billing.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private double amount;

    private boolean babySeat;
    private boolean englishDriver;
    private boolean conditioner;
    private boolean pet;
    private boolean courier;
    private boolean nonSmoker;
    private boolean silence;
    @NotBlank
    private String carType;
    @NonNull
    private double distance;
    @NotBlank
    private String paymentMode;

    //I`m not sure, about my need for these fields
    // private String startAddress;
    // private String destinationAddress;
    public Bill() {
    }

    //Rewrite constructor
    public Bill(@JsonProperty("babySeat") boolean babySeat,
                @JsonProperty("english") boolean englishDriver,
                @JsonProperty("conditioner") boolean conditioner,
                @JsonProperty("pet") boolean pet,
                @JsonProperty("courier") boolean courier,
                @JsonProperty("nonsmoker") boolean nonSmoker,
                @JsonProperty("silence") boolean silence,
                @JsonProperty("type") String carType,
                @JsonProperty("distance") double distance,
                @JsonProperty("paymentMode") String paymentMode) {
        this.babySeat = babySeat;
        this.englishDriver = englishDriver;
        this.conditioner = conditioner;
        this.pet = pet;
        this.courier = courier;
        this.nonSmoker = nonSmoker;
        this.silence = silence;
        this.carType = carType;
        this.distance = distance;
        this.paymentMode = paymentMode;
    }
}
