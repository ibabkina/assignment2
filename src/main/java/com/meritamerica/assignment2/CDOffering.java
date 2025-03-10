package com.meritamerica.assignment2;

/**
 * This program creates CD offerings for a bank.
 * 
 * @author Irina Babkina 
 * 
 */

public class CDOffering {
	
	private int term;
	private double interestRate;
	
	/**
	 * @param term
	 * @param interestRate
	 */
	public CDOffering(int term, double interestRate){
		this.term = term;
		this.interestRate = interestRate;
	}

	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}

	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public String toString() {
		return "\nCD Offering Term : " + this.getTerm()
		+ "\nCD Offering Rate : " + this.getInterestRate();
	}
}