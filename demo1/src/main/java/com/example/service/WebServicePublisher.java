package com.example.service;

import javax.xml.ws.Endpoint;
public class WebServicePublisher {
    public static void main(String[] args) {
        String url = "http://localhost:8080/IncomeTaxCalculator";
        Endpoint.publish(url, new IncomeTaxCalculatorImpl());
        System.out.println("Web Service is published at: " + url);
    }
}
