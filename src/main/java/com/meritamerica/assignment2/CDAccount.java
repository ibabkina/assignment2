package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount extends BankAccount{
	
	//private double balance;
	//private CDOffering cdOffering;
	private double interestRate;
	private int term;
	Date date = new Date();
	
	public CDAccount(CDOffering offering, double openingBalance) {
		super(openingBalance); //, offering.getInterestRate());
		this.term = offering.getTerm();
		this.interestRate = offering.getInterestRate();
	}
	
	/**
	 * @return the term
	 */
	int getTerm() {
		return term;
	}

	/**
	 * @return the term
	 */
	java.util.Date getStartDate() {
		System.out.println("Date " + date);
		return date;
	}


}
