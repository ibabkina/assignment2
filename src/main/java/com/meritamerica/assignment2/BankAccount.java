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
	static Long[] accountNumbers = new Long[0];
		
	
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
		this.accountNumber = MeritBank.getNextAccountNumber();
		MeritBank.addItemToArray(this.accountNumber, accountNumbers);
	}
	
	/**
	 * @param balance
	 */
	public BankAccount(double balance, double interestRate) {
		//super();
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountNumber = MeritBank.getNextAccountNumber();
		MeritBank.addItemToArray(this.accountNumber, accountNumbers);
	}
	
	
	public BankAccount(long accountNumber, double balance, double interestRate) {
		//super();
		
		this.balance = balance;
		this.interestRate = interestRate;
		for(long an : accountNumbers)
			if(an != accountNumber) {
				this.accountNumber = accountNumber;
				MeritBank.addItemToArray(accountNumber, accountNumbers);
			}
			else {
				this.accountNumber = MeritBank.getNextAccountNumber();
				MeritBank.addItemToArray(accountNumber, accountNumbers);
			}
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
		return "\nAccount Balance: $" + String.format("%.2f", this.getBalance())
		+ "\nAccount Interest Rate: " + String.format("%.4f", this.getInterestRate())
		+ "\nAccount Balance in 3 years: " + String.format("%.2f", this.futureValue(3));
	}		
}	
