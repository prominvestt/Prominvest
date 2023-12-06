package com.example.prominvest.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/process-payment")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/makePayment")
    public ResponseEntity<String> makePayment(@RequestBody PaymentRequest paymentRequest) {
        if (paymentService.processPayment(
                paymentRequest.getCardPan(),
                paymentRequest.getCardExpiryDate(),
                paymentRequest.getAmount(),
                paymentRequest.getBankAccountNumber())) {
            return ResponseEntity.ok("Payment successful");
        } else {
            return ResponseEntity.badRequest().body("Payment failed");
        }
    }
}

