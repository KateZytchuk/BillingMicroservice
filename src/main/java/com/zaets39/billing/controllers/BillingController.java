package com.zaets39.billing.controllers;

import com.zaets39.billing.models.Bill;
import com.zaets39.billing.repositories.BillRepository;
import com.zaets39.billing.services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class BillingController {
    @Autowired
    private BillingService billingService;
    @Autowired
    private BillRepository billRepository;

//    @Autowired
//    public BillingController(BillingService billingService, BillRepository billRepository) {
//        this.billingService = billingService;
//        this.billRepository = billRepository;
//    }

    @GetMapping("/all")
    public List<Bill> showAll() {
        return billRepository.findAll();
    }

    @PostMapping("/countInRange")
    public double countAmount(Bill bill) {
        return billingService.countAmount(bill);
    }

    @PostMapping("/add")
    public long add(@RequestBody Bill newBill) {
        billRepository.save(newBill);
        return newBill.getId();
    }
/*
    @PostMapping("/count")
    public Bill addWithoutAmount(Bill bill) {
        //
    }
 */
}
