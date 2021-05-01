package com.meritamerica.assignment2;

public class CheckingAccount extends BankAccount {
	
	//private double balance;
	private double interestRate = 0.0001;
	
	public CheckingAccount(double openingBalance){
		super(openingBalance); //, this.interestRate);
	}
}