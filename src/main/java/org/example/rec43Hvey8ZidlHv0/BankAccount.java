package org.example.rec43Hvey8ZidlHv0;

public class BankAccount {
  private int balance;

  public BankAccount(int currentSum) {
    this.balance = currentSum;
  }

  public synchronized void deposit(int amount) {
    balance += amount;
    System.out.println("Deposited: " + amount + ", Total balance: " + balance);
  }

  public synchronized void withdraw(int amount) {
    if (amount > balance) throw new IllegalArgumentException();
    balance -= amount;
    System.out.println("Withdrawn: " + amount + ", total balance: " + balance);
  }

  public synchronized int getBalance() {
    return balance;
  }
}
