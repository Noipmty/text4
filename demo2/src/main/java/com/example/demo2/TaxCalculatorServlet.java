package com.example.demo2;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/tax-calculator")
public class TaxCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String incomeStr = request.getParameter("income");
        double tax = 0;
        if (incomeStr != null) {
            double income = Double.parseDouble(incomeStr);
            tax = new IncomeTaxCalculator().calculateIncomeTax(income);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("Tax: " + tax);
        } else {
            response.getWriter().println("Please enter a valid income amount.");
        }
    }
}