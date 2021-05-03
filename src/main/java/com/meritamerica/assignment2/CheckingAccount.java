package com.meritamerica.assignment2;

/**
 * This program creates a checking account for a client.
 * 
 * @author Irina Babkina 
 * 
 */
 
import static java.lang.Math.*;

public class CheckingAccount extends BankAccount {
	
	private double interestRate = 0.0001;
	
	/**
	 * @param openingBalance
	 */
	public CheckingAccount(double openingBalance){
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
		return "\nChecking Account Number: " + this.getAccountNumber()
			+ "\nChecking Account Balance: $" + String.format("%.2f", this.getBalance())
			+ "\nChecking Account Interest Rate: " + String.format("%.4f", this.getInterestRate())
			+ "\nChecking Account Balance in 3 years: " + String.format("%.2f", this.futureValue(3));
	}		
}