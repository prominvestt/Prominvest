package com.example.prominvest.card;

import com.example.prominvest.payment.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class PaymentService {

    private final CardValidationService cardValidationService;
    private final BankService bankService;

    @Autowired
    public PaymentService(CardValidationService cardValidationService, BankService bankService) {
        this.cardValidationService = cardValidationService;
        this.bankService = bankService;
    }

    public void processPayment(Scanner scanner) {
        // Step 1: Input card details
        System.out.print("Enter Prestige Card PAN: ");
        String cardPan = scanner.nextLine();

        System.out.print("Enter Card Expiry Date: ");
        String cardExpiryDate = scanner.nextLine();

        System.out.print("Enter Cardholder Name: ");
        String cardholderName = scanner.nextLine();

        System.out.print("Enter CVV: ");
        String cvv = scanner.nextLine();

        // Additional inputs as needed

        // Step 2: Input bank account number
        System.out.print("Enter Bank Account Number: ");
        String bankAccountNumber = scanner.nextLine();

        double transactionAmount = getTransactionAmount(scanner);

        // Step 3: Validate card details
        if (!cardValidationService.isValidCard(cardPan, cardExpiryDate, cardholderName, cvv)) {
            System.out.println("Invalid card details. Payment failed.");
            return;
        }

        // Step 4: Perform additional checks (e.g., check for sufficient funds)
        double accountBalance = bankService.getAccountBalance(cardPan); // Assume a method to get the account balance
        if (accountBalance < transactionAmount) {
            System.out.println("Insufficient funds. Payment failed.");
            return;
        }


        // Step 5: Send payment to the bank
        bankService.sendPayment(getTransactionAmount(scanner), bankAccountNumber);

        // Step 6: Log the transaction
        logTransaction(cardPan, bankAccountNumber);
    }

    private double getTransactionAmount(Scanner scanner) {
        System.out.print("Enter Transaction Amount: ");
        return Double.parseDouble(scanner.nextLine());
    }

    private void logTransaction(String cardPan, String bankAccountNumber) {
        // Implement logic to log the transaction details to a database or other storage
        // This could include the cardholder's information, timestamp, transaction ID, etc.
        // For simplicity, this is a placeholder implementation
        System.out.println("Transaction logged - Card: " + cardPan + ", Receiver Account: " + bankAccountNumber);
    }
}

