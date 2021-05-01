package com.meritamerica.assignment2;

import static java.lang.Math.pow;

import java.util.Arrays;
import java.util.Random;

//import com.meritamerica.assignment1.AccountHolder;

public class MeritBank {
	private static final int MAX_SIZE = 1000;
	static AccountHolder[] accountHolders = new AccountHolder[MAX_SIZE]; 
	static CDOffering[] cdOfferings; // = new CDOffering[MAX_SIZE]; 
	static int numberOfAccountHolders = 0;
	static int numberOfCDOfferings = 0;
	static CDOffering bestCDOffering;
	static CDOffering secondBestCDOffering;
	static long nextAccountNumber;
	//static double totalBalances();
	
	public MeritBank() {}
	
	static void addAccountHolder(AccountHolder accountHolder) {
		
		//accountHolders = Arrays.copyOf(accountHolders, accountHolders.length +1);
		
		//dynamic size
		AccountHolder[] temp = Arrays.copyOf(accountHolders, accountHolders.length +1);
		temp[temp.length - 1] = accountHolder;
		accountHolders = temp;
		
		
		if (numberOfAccountHolders < MAX_SIZE) {
			accountHolders[numberOfAccountHolders++] = accountHolder;
		}
		else 
			System.out.println("Need more room for a new account holder");	
	}
	
	static AccountHolder[]getAccountHolders() {
		return accountHolders;
	}
	
	/**
	 * @return the cdOfferings
	 */
	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}
	
	/**
	 * @param depositAmount
	 * @return the bestCDOffering
	 */
	public static CDOffering getBestCDOffering(double depositAmount) {
		
	
		return bestCDOffering;
	}

	/**
	 * @param depositAmount
	 * @return the secondBestCDOffering
	 */
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
	
		return secondBestCDOffering;
	}
	
	public static void clearCDOfferings() {
		cdOfferings = new CDOffering[MAX_SIZE]; 
		//DOffering bestCDOffering; ?
		//CDOffering secondBestCDOffering; ?
	}
	
	/**
	 * @param cdOfferings the cdOfferings to set
	 */
	public static void setCDOfferings(CDOffering[] offerings) {
		MeritBank.cdOfferings = offerings; 
	}

//	/**
//	 * @param bestCDOffering the bestCDOffering to set
//	 */
//	public static void setBestCDOffering(CDOffering bestCDOffering) {
//		MeritBank.bestCDOffering = bestCDOffering;
//	}

	
//	/**
//	 * @param secondBestCDOffering the secondBestCDOffering to set
//	 */
//	public static void setSecondBestCDOffering(CDOffering secondBestCDOffering) {
//		MeritBank.secondBestCDOffering = secondBestCDOffering;
//	}
	
	/**
	 * @return the nextAccountNumber
	 */
	public static long getNextAccountNumber() {
		return nextAccountNumber;
	}

//	

	static double totalBalances() {
		return
	}
	
	/**
	 * Calculates the future value of the account balance based on the interest 
	 * and number of years
	 * @param years: number of periods in years
	 * @return the future value
	 */
	static double futureValue(double presentValue, double interestRate, int term) {
		return balance * pow(1 + interestRate, term); 
	}
	
}
