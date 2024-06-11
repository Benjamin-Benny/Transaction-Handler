import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Transaction } from '../models/transaction';
import { TransactionService } from '../transaction.service';
import { CommonModule, DatePipe } from '@angular/common';

@Component({
  selector: 'app-transaction-details',
  standalone: true,
  imports: [CommonModule],
  providers: [DatePipe],
  templateUrl: './transaction-details.component.html'
})
export class TransactionDetailsComponent implements OnInit {
  transaction!: Transaction;

  constructor(private route: ActivatedRoute, private transactionService: TransactionService) { }
  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    const numericId = id ? +id : 0;
    if (numericId) {
      this.transactionService.getTransaction(numericId).subscribe(transaction => {
        this.transaction = transaction;
      });
    }
  }
}

