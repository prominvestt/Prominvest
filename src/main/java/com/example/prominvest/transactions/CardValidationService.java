package com.example.prominvest.transactions;

import org.springframework.stereotype.Service;

@Service
public class CardValidationService {

    public boolean isValidCard(String cardPan, String cardExpiryDate, String cardholderName, String cvv) {
        // Basic PAN format check for a prestige card (16 digits starting with 5)
        if (isValidPANFormat(cardPan) && isValidExpiryDate(cardExpiryDate)
                && isValidCardholderName(cardholderName) && isValidCVV(cvv)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isValidPANFormat(String cardPan) {
        // Check if the PAN matches the format of a prestige card
        return cardPan.matches("^5\\d{15}$");
    }

    private boolean isValidExpiryDate(String cardExpiryDate) {
        // Check expiry date format (MM/YY)
        return cardExpiryDate.matches("^(0[1-9]|1[0-2])/(\\d{2})$");
    }

    private boolean isValidCardholderName(String cardholderName) {
        // Check if the cardholder name is not empty (you may add more checks)
        return cardholderName != null && !cardholderName.trim().isEmpty();
    }

    private boolean isValidCVV(String cvv) {
        // Check CVV format (3 digits for simplicity, adjust as needed)
        return cvv.matches("^\\d{3}$");
    }
}

