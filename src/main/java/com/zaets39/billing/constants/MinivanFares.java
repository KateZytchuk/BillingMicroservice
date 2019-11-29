package com.zaets39.billing.constants;

import java.util.Map;

public class MinivanFares extends Fares {
    public static final double MINIMUM_TARIFF = 90;
    public static final double TARIFF_PER_KM = 10;

    @Override
    public Map<String, Double> getInfo() {
        Map<String, Double> economFares = getAdditionalServices();
        economFares.put("MINIMUM_TARIFF", MINIMUM_TARIFF);
        economFares.put("TARIFF_PER_KM", TARIFF_PER_KM);
        return economFares;
    }
}
