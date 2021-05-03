package com.meritamerica.assignment2;

/**
 * This program creates a CD account for a client.
 * 
 * @author Irina Babkina 
 * 
 */

import static java.lang.Math.pow;

import java.util.Date;

public class CDAccount extends BankAccount{
	
	private double interestRate;
	private int term;
	Date date = new Date();
	
	/**
	 * @param offering
	 * @param openingBalance 
	 */
	public CDAccount(CDOffering offering, double openingBalance) {
		super(openingBalance); 
		this.term = offering.getTerm();
		this.interestRate = offering.getInterestRate();
	}
	
	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return this.interestRate;
	}
	
	/**
	 * @return the term
	 */
	int getTerm() {
		return term;
	}

	/**
	 * @return the data: java.util.Date
	 */
	java.util.Date getStartDate() {
//		System.out.println("Date " + date);
		return date;
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
		return "\nCD Account Number: " + this.getAccountNumber()
			+ "\nCD Account Balance: $" + String.format("%.2f", this.getBalance())
			+ "\nCD Account Interest Rate: " + String.format("%.4f", this.getInterestRate())
			+ "\nCD Account Term: " + this.getTerm()
			+ "\nCD Account Start Date: " + this.getStartDate()
			+ "\nCD Account Balance in " + this.getTerm() + " years: " + String.format("%.2f", this.futureValue(this.getTerm()));
	}
}