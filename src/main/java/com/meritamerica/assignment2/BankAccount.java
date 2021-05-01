/**
 * 
 */
package com.meritamerica.assignment2;

/**
 * @author Irina Babkina
 *
 */

import static java.lang.Math.*;

public abstract class BankAccount {
	
	private double balance;
	private double interestRate; 
	private long accountNumber;
	
	
/*	/**
	 * 
	 */
//	public BankAccount() {
//		// TODO Auto-generated constructor stub
//	}
	
	
	/**
	 * @param openingBalance
	 */
	public BankAccount(double openingBalance) {
		this.balance = openingBalance;
	}
	
	/**
	 * @param balance
	 */
	public BankAccount(double balance, double interestRate) {
		//super();
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		//super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	
	/**
	 * @return the account number
	 */
	public long getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}
	
	/**
	 * @param amount
	 * @return boolean: success or fail
	 */
	boolean withdraw(double amount) {
		if (amount < 0.0 || amount > balance) {
			return false;
		}
		balance -= amount;
		return true;	
	}
	
	/**
	 * @param amount
	 * @return boolean: success or fail
	 */
	boolean deposit(double amount) {
		if (amount < 0.0) {
			return false;
		}
		balance += amount;
		return true;	
	}
	
	/**
	 * Calculates the future value of the account balance based on the interest 
	 * and number of years
	 * @param years: number of periods in years
	 * @return the future value
	 */
	double futureValue(int years) {
		return balance * pow(1 + interestRate, years); 
	}

	@Override
	public String toString() {
		return "\nChecking Account Balance: $" + String.format("%.2f", this.getBalance())
		+ "\nChecking Account Interest Rate: " + String.format("%.4f", this.getInterestRate())
		+ "\nChecking Account Balance in 3 years: " + String.format("%.2f", this.futureValue(3));
	}		
}	
