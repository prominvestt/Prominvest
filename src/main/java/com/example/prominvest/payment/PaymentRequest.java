package com.example.prominvest.payment;

public class PaymentRequest {

    private String cardPan;
    private String cardExpiryDate;
    private double amount;
    private String bankAccountNumber;

    public PaymentRequest() {
    }

    public PaymentRequest(double amount, String bankAccountNumber) {
        this.amount = amount;
        this.bankAccountNumber = bankAccountNumber;
    }

    public PaymentRequest(String cardPan, String cardExpiryDate, double amount, String bankAccountNumber) {
        this.cardPan = cardPan;
        this.cardExpiryDate = cardExpiryDate;
        this.amount = amount;
        this.bankAccountNumber = bankAccountNumber;
    }
    // Getters and setters

    public String getCardPan() {
        return cardPan;
    }

    public void setCardPan(String cardPan) {
        this.cardPan = cardPan;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }


    // You can add validation or additional fields based on your requirements
}
