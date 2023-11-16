package com.example.prominvest.card;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
    // You can add custom query methods if needed
}

