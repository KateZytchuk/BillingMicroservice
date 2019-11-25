package com.zaets39.billing.controllers;

import com.zaets39.billing.dao.PostgresBillDAO;
import com.zaets39.billing.models.Bill;
import com.zaets39.billing.services.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillingController {

    private final BillingService billingService;
    private final PostgresBillDAO  postgresBillDAO;

    @Autowired
    public BillingController(BillingService billingService, PostgresBillDAO postgresBillDAO) {
        this.billingService = billingService;
        this.postgresBillDAO = postgresBillDAO;
    }

    @GetMapping("/all")
    public List<Bill> showAll() {
        List<Bill> bills = billingService.getAllBills();
        for (Bill bill : bills) {
            billingService.countAmount(bill);
        }
        return bills;
    }

    @PostMapping("/count")
    public double countAmount(Bill bill) {
        return billingService.countAmount(bill);
    }

    @PostMapping("/add")
    public Bill addWithoutAmount(Bill bill) {
        return postgresBillDAO.add(bill);
    }
}
