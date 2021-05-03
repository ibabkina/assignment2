package com.meritamerica.assignment2;

/**
 * This program creates an account for a client.
 * 
 * @author Irina Babkina 
 * 
 */
 
public abstract class BankAccount {
	
	protected double balance;
	private double interestRate; 
	private long accountNumber;
	static Long[] accountNumbers = new Long[0];
		
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
	 * @param interestRate 
	 */
	public BankAccount(double balance, double interestRate) {
		this(balance);
		this.interestRate = interestRate;
	}
	
	/**
	 * @param accountNumber
	 * @param balance
	 * @param interestRate 
	 */
	public BankAccount(long accountNumber, double balance, double interestRate) {
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
	abstract public double getInterestRate();
	
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
	abstract double futureValue(int years);

	@Override
	public String toString() {
		return "\nAccount Balance: $" + String.format("%.2f", this.getBalance())
			+ "\nAccount Interest Rate: " + String.format("%.4f", this.getInterestRate())
			+ "\nAccount Balance in 3 years: " + String.format("%.2f", this.futureValue(3));
	}		
}	