import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from './models/transaction';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  
  private baseUrl = 'http://localhost:8080/api/transactions';

  constructor(private http: HttpClient) {}

  getTransactions(): Observable<Transaction[]> {
    return this.http.get<Transaction[]>(`${this.baseUrl}`);
  }

  getTransaction(id: number): Observable<any> {
    throw new Error('Method not implemented.');
  }

  addTransaction(transaction: Transaction): Observable<Transaction> {
    return this.http.post<Transaction>(`${this.baseUrl}`, transaction);
  }

  // Other CRUD operations...
}
