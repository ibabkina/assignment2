package com.meritamerica.assignment2;

public class SavingsAccount extends BankAccount {
	
	//private double balance;
	private double interestRate = 0.01;
	
	public SavingsAccount(double openingBalance) {
		super(openingBalance);
	}
}