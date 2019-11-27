package com.zaets39.billing.constants;

import lombok.Getter;

@Getter
public class Fares {
    //minimum tariff (UAH / km)
    public static final double ECONOM_FARE = 33;
    public static final double BUSINESS_FARE = 55;
    public static final double VIP_FARE = 60;
    public static final double MINIVAN_FARE = 90;

    //fare per 1 km
    public static final double ECONOM_PER_KM = 6.5;
    public static final double BUSINESS_PER_KM = 7.5;
    public static final double VIP_PER_KM = 9;
    public static final double MINIVAN_PER_KM = 10;

    //downtime price per minute
    public static final double DOWNTIME = 1.5;
    public static final double MINIVAN_DOWNTIME = 2;

    //Additional Services
    public static final double CONDITIONER_FARE = 15;
    public static final double PETS_FARE = 20;
    public static final double COURIER_FARE = 30;
    public static final double ENGLISH_DRIVER = 10;
    public static final double OTHER_SERVICES= 10;

    //additionals per km
    public static final double MIN_PRICE = 33;
    public static final double MAX_PRICE = 175;
}
