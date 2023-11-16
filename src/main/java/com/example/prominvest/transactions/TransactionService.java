package com.example.prominvest.transactions;

import com.example.prominvest.payment.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private CardValidationService cardValidationService;
    private BankService bankService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public static void newTransaction(Transaction transaction) {
    }

    public String processTransaction(Transaction transaction) {
        if (!cardValidationService.isValidCard(transaction.getCardPan(),
                transaction.getCardExpiryDate(),
                transaction.getCardholderName(),
                transaction.getCvv())) {
            throw new IllegalArgumentException("Invalid card details");
        }

        // Step 2: Additional validation and processing (e.g., check for duplicate transactions, etc.)
        // Add any business logic specific to your application

        // Step 3: Perform the transaction and update the database
        try {
            // Example: Send payment to the bank
            bankService.sendPayment(transaction.getAmount(), transaction.getReceiverBankAccountNumber());

            // Example: Save the transaction to the database
            transactionRepository.save(transaction);
        } catch (Exception e) {
            // Handle exceptions, log errors, and possibly revert any changes made
            throw new RuntimeException("Transaction failed: " + e.getMessage(), e);
        }
        return null;
    }

    public List<Transaction> getTransaction() {
        return transactionRepository.findAll();
    }

    public void deleteTransaction(Long transactionId) {
    }

    public void updateTransaction(Long transactionId, String name, String email) {
    }
}
