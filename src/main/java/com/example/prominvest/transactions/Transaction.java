package com.example.prominvest.transactions;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionType;
    private String cardPan;
    private String cardExpiryDate;
    private double amount;
    private String note;
    private String CardholderName;
    private String Cvv;
    private String ReceiverBankAccountNumber;

    public Transaction() {
    }



    public Transaction(String transactionType, String cardPan, String cardExpiryDate, double amount, String cvv) {
        this.transactionType = transactionType;
        this.cardPan = cardPan;
        this.cardExpiryDate = cardExpiryDate;
        this.amount = amount;
        Cvv = cvv;
    }

    public Transaction(String transactionType, String cardPan, String cardExpiryDate, double amount, String note, String cardholderName, String cvv) {
        this.transactionType = transactionType;
        this.cardPan = cardPan;
        this.cardExpiryDate = cardExpiryDate;
        this.amount = amount;
        this.note = note;
        CardholderName = cardholderName;
        Cvv = cvv;
    }

    public Transaction(Long id, String transactionType, String cardPan, String cardExpiryDate, double amount, String note, String cardholderName, String cvv, String receiverBankAccountNumber) {
        this.id = id;
        this.transactionType = transactionType;
        this.cardPan = cardPan;
        this.cardExpiryDate = cardExpiryDate;
        this.amount = amount;
        this.note = note;
        CardholderName = cardholderName;
        Cvv = cvv;
        ReceiverBankAccountNumber = receiverBankAccountNumber;
    }

    public String getCardholderName() {
        return CardholderName;
    }

    public void setCardholderName(String cardholderName) {
        CardholderName = cardholderName;
    }

    public String getCvv() {
        return Cvv;
    }

    public void setCvv(String cvv) {
        Cvv = cvv;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverBankAccountNumber() {
        return ReceiverBankAccountNumber;
    }

    public void setReceiverBankAccountNumber(String receiverBankAccountNumber) {
        ReceiverBankAccountNumber = receiverBankAccountNumber;
    }
}
