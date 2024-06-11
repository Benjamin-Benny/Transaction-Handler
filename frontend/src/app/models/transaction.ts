export interface Transaction {
    id?: number;
    amount: number;
    currency: string;
    timestamp: Date;
    userId?: number;
    isFraudulent: boolean;
  }
  