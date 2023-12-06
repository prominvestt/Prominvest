package com.example.prominvest.card;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardPan;
    private String cardExpiryDate;

    public void setCardPan(String cardPan) {
    }

    public void setCardExpiryDate(String cardExpiryDate) {
    }

    public Card() {
    }

    public Card(Long id, String cardPan, String cardExpiryDate) {
        this.id = id;
        this.cardPan = cardPan;
        this.cardExpiryDate = cardExpiryDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardPan() {
        return cardPan;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    // Constructors, getters, and setters

    // You can add more fields and methods based on your requirements


    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", cardPan='" + cardPan + '\'' +
                ", cardExpiryDate='" + cardExpiryDate + '\'' +
                '}';
    }
}

