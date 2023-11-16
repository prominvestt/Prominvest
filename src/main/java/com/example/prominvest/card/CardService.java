package com.example.prominvest.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {


    private final CardRepository cardRepository;
    private final CardValidationService cardValidationService;

    @Autowired
    public CardService(CardRepository cardRepository, CardValidationService cardValidationService) {
        this.cardRepository = cardRepository;
        this.cardValidationService = cardValidationService;
    }


    public Card createCard(String cardPan, String cardExpiryDate) {
        if (cardValidationService.isValidCard(cardPan, cardExpiryDate)) {
            Card card = new Card();
            card.setCardPan(cardPan);
            card.setCardExpiryDate(cardExpiryDate);

            return cardRepository.save(card);
        } else {
            // Handle invalid card case (throw an exception, return a specific response, etc.)
            throw new IllegalArgumentException("Invalid card details");
        }
    }

    // You can add more methods as needed
}

