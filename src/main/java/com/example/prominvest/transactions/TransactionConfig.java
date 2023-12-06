package com.example.prominvest.transactions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class TransactionConfig {

    @Bean
    CommandLineRunner commandLineRunner(TransactionRepository repository){
        return args -> {
            Transaction unique = new Transaction(
                    "Online",
                    "5399412012069998",
                    "02/24",
                    200.00,
                    "Payment for Item 7"
            );

            Transaction buying = new Transaction(
                    "In person",
                    "5399412012069998",
                    "02/24",
                    300.00,
                    "Payment for Item 7"
            );

            repository.saveAll(
                    List.of(unique, buying)
            );
        };
    }
}
