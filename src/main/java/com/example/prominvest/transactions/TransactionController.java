package com.example.prominvest.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processTransaction(@RequestBody Transaction transaction) {
        // Validate and process the transaction using the TransactionService
        String result = transactionService.processTransaction(transaction);

        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<Transaction> getTransactions(){
        return transactionService.getTransaction();
    }

    @PostMapping
    public void newTransaction(@RequestBody Transaction transaction){
        TransactionService.newTransaction(transaction);
    }

    @DeleteMapping(path = "{transactionId}")
    public void deleteTransaction(@PathVariable("transactionId") Long transactionId){
        transactionService.deleteTransaction(transactionId);
    }

    @PutMapping(path = "{transactionId}")
    public void updateTransaction(
            @PathVariable("transactionId") Long transactionId,
            @RequestParam(required = false) String transactionType,
            @RequestParam(required = false) String amount){
        transactionService.updateTransaction(transactionId, transactionType, amount);
    }

    // Additional endpoints for retrieving transaction history, details, etc.
}

