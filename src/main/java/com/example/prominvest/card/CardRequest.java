package com.example.prominvest.card;

public class CardRequest {

    private String cardPan;
    private String cardExpiryDate;

    public String getCardPan() {
        return null;
    }

    public String getCardExpiryDate() {
        return null;
    }

    public CardRequest() {
    }

    public CardRequest(String cardPan, String cardExpiryDate) {
        this.cardPan = cardPan;
        this.cardExpiryDate = cardExpiryDate;
    }

    public void setCardPan(String cardPan) {
        this.cardPan = cardPan;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    // Getters and setters

    // You can add validation or additional fields based on your requirements
}

