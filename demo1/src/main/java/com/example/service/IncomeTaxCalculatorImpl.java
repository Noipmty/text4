package com.example.service;

import javax.jws.WebService;
import jakarta.servlet.ServletException;

@WebService(endpointInterface = "com.example.service.IncomeTaxCalculator")
public class IncomeTaxCalculatorImpl implements IncomeTaxCalculator {
    @Override
    public double calculateIncomeTax(double income) {
        double tax;
        if (income <= 5000) {
            tax = 0;
        } else if (income <= 8000) {
            tax = (income - 5000) * 0.1;
        } else if (income <= 15000) {
            tax = (3000 * 0.1) + (income - 8000) * 0.2;
        } else if (income <= 30000) {
            tax = (3000 * 0.1) + (7000 * 0.2) + (income - 15000) * 0.25;
        } else {
            tax = (3000 * 0.1) + (7000 * 0.2) + (15000 * 0.25) + (income - 30000) * 0.3;
        }
        return tax;
    }
}