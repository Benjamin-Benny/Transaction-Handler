package com.project.transaction_handler.service;

import com.project.transaction_handler.model.Transaction;
import org.springframework.stereotype.Service;

// FraudDetectionService.java
@Service
public class FraudDetectionService {
    public boolean isFraudulent(Transaction transaction) {
        // Implement simple fraud detection logic (e.g., amount > threshold)
        return transaction.getAmount() > 10000;
    }
}