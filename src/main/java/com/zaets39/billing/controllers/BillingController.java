package com.zaets39.billing.controllers;

import com.zaets39.billing.models.Bill;
import com.zaets39.billing.repositories.BillRepository;
import com.zaets39.billing.services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BillingController {

    private BillingService billingService;
    private BillRepository billRepository;

    @Autowired
    public BillingController(BillingService billingService, BillRepository billRepository) {
        this.billingService = billingService;
        this.billRepository = billRepository;
    }

    @GetMapping("/all")
    public List<Bill> showAll() {
        return billingService.getAllBills();
    }

    @PostMapping("/add")
    public long add(@RequestParam String paymentMode,
                    @RequestParam boolean pet,
                    @RequestParam boolean conditioner,
                    @RequestParam boolean courier,
                    @RequestParam boolean englishDriver,
                    @RequestParam boolean babySeat,
                    @RequestParam boolean nonSmoker,
                    @RequestParam boolean silence,
                    @RequestParam String carType,
                    @RequestParam double distance) {
        Bill newBill = new Bill(babySeat, englishDriver, conditioner, pet,
                courier, nonSmoker, silence, carType, distance,
                paymentMode);
        double amount = billingService.countAmount(newBill);
        newBill.setAmount(amount);
        billRepository.save(newBill);
        return newBill.getId();
    }
}
