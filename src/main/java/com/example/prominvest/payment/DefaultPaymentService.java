package com.example.prominvest.payment;

import com.example.prominvest.card.CardValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPaymentService implements PaymentService {

    private final CardValidationService cardValidationService;
    private final BankService bankService; // You may need to create a BankService

    @Autowired
    public DefaultPaymentService(CardValidationService cardValidationService, BankService bankService) {
        this.cardValidationService = cardValidationService;
        this.bankService = bankService;
    }

    @Override
    public boolean processPayment(String cardPan, String cardExpiryDate, double amount, String bankAccountNumber) {
        if (validateCard(cardPan, cardExpiryDate) && hasSufficientFunds(cardPan, amount)) {
            // Perform payment logic
            // You may want to log the transaction, update balances, etc.
            bankService.sendPayment(amount, bankAccountNumber);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean validateCard(String cardPan, String cardExpiryDate) {
        return cardValidationService.isValidCard(cardPan, cardExpiryDate);
    }

    private boolean hasSufficientFunds(String cardPan, double amount) {
        // Implement logic to check if the card has sufficient funds
        // This could involve querying a database or an external system
        // For simplicity, this is a placeholder implementation
        return true;
    }
}

