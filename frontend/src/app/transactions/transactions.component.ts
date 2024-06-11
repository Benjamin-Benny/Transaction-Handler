import { Component, OnInit } from '@angular/core';
import { Transaction } from '../models/transaction';
import { TransactionService } from '../transaction.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-transactions',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './transactions.component.html',
  styleUrls: ['./transactions.component.css']
})
export class TransactionsComponent implements OnInit {
  transactions: Transaction[] = [];
  transaction: Transaction = { amount: 0, currency: '', timestamp: new Date(), isFraudulent: false };

  constructor(private transactionService: TransactionService) {}

  ngOnInit() {
    this.loadTransactions();
  }

  loadTransactions() {
    this.transactionService.getTransactions().subscribe(transactions => {
      this.transactions = transactions;
    });
  }

  addTransaction() {
    this.transactionService.addTransaction(this.transaction).subscribe(transaction => {
      this.transactions.push(transaction);
      this.transaction = { amount: 0, currency: '', timestamp: new Date(), isFraudulent: false };
    });
  }
}
