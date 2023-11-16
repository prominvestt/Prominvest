package com.example.prominvest.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/create")
    public ResponseEntity<Card> createCard(@RequestBody CardRequest cardRequest) {
        Card card = cardService.createCard(cardRequest.getCardPan(), cardRequest.getCardExpiryDate());
        return ResponseEntity.ok(card);
    }
}

