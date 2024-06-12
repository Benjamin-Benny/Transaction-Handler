package com.project.transaction_handler.service;

import com.project.transaction_handler.model.Transaction;
import com.project.transaction_handler.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }

//    public boolean isFraudulent(Transaction transaction) {
//        // Simple fraud detection logic (to be improved)
//        return transaction.getAmount().compareTo(new BigDecimal("10000")) > 0;
//    }

    public List<Transaction> getTransactions(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
