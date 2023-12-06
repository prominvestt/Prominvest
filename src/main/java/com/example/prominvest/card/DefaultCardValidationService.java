package com.example.prominvest.card;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DefaultCardValidationService implements CardValidationService {

    @Override
    public boolean isValidCard(String cardPan, String cardExpiryDate) {
        // Implement your card validation logic here
        // This is a placeholder; you'll need to implement the actual validation based on your requirements

        // For example, you might check the format of the card PAN, validate the expiry date, etc.
        // You may also want to consider using a dedicated library for more complex validation

        return true; // Placeholder, replace with actual validation logic
    }

    @Override
    public boolean isValidCard(String cardPan, String cardExpiryDate, String cardholderName, String cvv) {
        // Basic PAN format check for a prestige card (16 digits starting with 5)
        if (!cardPan.matches("^4\\d{15}$")) {
            return false;
        }

        // Check expiry date format (MM/YY)
        if (!cardExpiryDate.matches("^(0[1-9]|1[0-2])/(\\d{2})$")) {
            return false;
        }

        // Check if the card has not expired
        if (isCardExpired(cardExpiryDate)) {
            return false;
        }

        // Check cardholder name (assuming it should not be empty)
        if (cardholderName == null || cardholderName.trim().isEmpty()) {
            return false;
        }

        // Check CVV format (3 digits for simplicity, adjust as needed)
        if (!cvv.matches("^\\d{3}$")) {
            return false;
        }

        // Additional checks can be added here based on your specific requirements

        // If all checks pass, the card is considered valid
        return true;
    }

    private boolean isCardExpired(String cardExpiryDate) {
        // Parse the expiry date string into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        LocalDate expiryDate = LocalDate.parse(cardExpiryDate, formatter);

        // Check if the card has not expired
        return LocalDate.now().isAfter(expiryDate.withDayOfMonth(expiryDate.lengthOfMonth()));
    }
}

