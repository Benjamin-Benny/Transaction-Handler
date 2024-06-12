package com.project.transaction_handler.controller;

import com.project.transaction_handler.model.Transaction;
import com.project.transaction_handler.service.FraudDetectionService;
import com.project.transaction_handler.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// TransactionListener.java
@Component
public class TransactionListener {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private FraudDetectionService fraudDetectionService;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(Transaction transaction) {
        transaction.setFraud(fraudDetectionService.isFraudulent(transaction));
        transactionService.saveTransaction(transaction);
    }
}
