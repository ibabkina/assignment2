package com.meritamerica.assignment2;

import static java.lang.Math.pow;

public class SavingsAccount extends BankAccount {
	
	//private double balance;
	private double interestRate = 0.01;
	
	public SavingsAccount(double openingBalance) {
		super(openingBalance);
	}
	
	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return this.interestRate;
	}
	
	/**
	 * Calculates the future value of the account balance based on the interest 
	 * and number of years
	 * @param years: number of periods in years
	 * @return the future value
	 */
	double futureValue(int years){
		return this.balance * pow(1 + interestRate, years); 
	}
	
	@Override
	public String toString() {
		return "\nSavings Account Number: " + this.getAccountNumber()
		+ "\nSavings Account Balance: $" + String.format("%.2f", this.getBalance())
		+ "\nSavings Account Interest Rate: " + String.format("%.4f", this.getInterestRate())
		+ "\nSavings Account Balance in 3 years: " + String.format("%.2f", this.futureValue(3));
	}		
}