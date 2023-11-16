package com.example.prominvest.card;

public interface CardValidationService {

    boolean isValidCard(String cardPan, String cardExpiryDate);

    boolean isValidCard(String cardPan, String cardExpiryDate, String cardholderName, String cvv);

    // You can add more methods for additional validation checks if needed
}

