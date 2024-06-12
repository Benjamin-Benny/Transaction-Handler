package com.project.transaction_handler.controller;

import com.project.transaction_handler.model.Transaction;
import com.project.transaction_handler.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TransactionController.java
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Transaction>> getTransactions(@RequestParam Long userId) {
        return ResponseEntity.ok(transactionService.getTransactions(userId));
    }

    @PostMapping
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.saveTransaction(transaction));
    }
}
