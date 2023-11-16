package com.example.prominvest.payment;

public interface PaymentService {
    boolean processPayment(String cardPan, String cardExpiryDate, double amount, String bankAccountNumber);
    boolean validateCard(String cardPan, String cardExpiryDate);
    // Add more methods as needed
}

