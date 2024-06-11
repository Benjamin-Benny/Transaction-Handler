package com.project.transcaction_handler.controller;

import com.project.transcaction_handler.config.JwtUtil;
import com.project.transcaction_handler.model.Transaction;
import com.project.transcaction_handler.service.TransactionService;
import com.project.transcaction_handler.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private KafkaTemplate<String, Transaction> kafkaTemplate;

    private static final String TOPIC = "transactions";

    @GetMapping
    public ResponseEntity<?> getTransactions(HttpServletRequest request) {
        Long userId = getUserIdFromToken(request);
        List<Transaction> transactions = transactionService.findByUserId(userId);
        return ResponseEntity.ok(transactions);
    }

    @PostMapping
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction, HttpServletRequest request) {
        Long userId = getUserIdFromToken(request);
        transaction.setUserId(userId);
        transaction.setFraudulent(transactionService.isFraudulent(transaction));
        Transaction newTransaction = transactionService.save(transaction);
        kafkaTemplate.send(TOPIC, newTransaction);
        return ResponseEntity.ok(newTransaction);
    }

    private Long getUserIdFromToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        String jwt = authorizationHeader.substring(7);
        return jwtUtil.extractUserId(jwt);
    }
}
