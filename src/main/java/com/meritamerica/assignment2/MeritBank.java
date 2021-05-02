package com.meritamerica.assignment2;

import static java.lang.Math.pow;

import java.util.Arrays;
import java.util.Random;

//import com.meritamerica.assignment1.AccountHolder;

public class MeritBank {
	//private static final int MAX_SIZE = 1000;
	static AccountHolder[] accountHolders = new AccountHolder[0]; 
	static CDOffering[] cdOfferings; // = new CDOffering[MAX_SIZE]; 
	static int numberOfAccountHolders = 0;
	static int numberOfCDOfferings = 0;
	static CDOffering bestCDOffering;
	static CDOffering secondBestCDOffering;
	static long nextAccountNumber = 0;
	//static double totalBalances();
	
	public MeritBank() {}
	
	static void addAccountHolder(AccountHolder accountHolder) {
		addItemToArray(accountHolder, accountHolders);
		numberOfAccountHolders++;
		
//		if (numberOfAccountHolders < MAX_SIZE) {
//			accountHolders[numberOfAccountHolders++] = accountHolder;
//		}
//		else 
//			System.out.println("Need more room for a new account holder");	
	}
	
	static AccountHolder[]getAccountHolders() {
		return accountHolders;
	}
	
	static void addItemToArray (Object item, Object[] items) {
		
		System.out.println("Add the following item to array: " + item.toString());
		Object[] temp = new Object[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
 		}
		temp[temp.length - 1] = item;
		items = temp;
	}

	//dynamic size
//	static boolean addItemToArray (Object item, Object[] items) {
//		Object[] temp = Arrays.copyOf(items, items.length + 1);	
//		temp[temp.length - 1] = item;
//		items = temp;
//		return true; }
	
			

		
	
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
		cdOfferings = new CDOffering[0]; 
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
		nextAccountNumber++;
		
//		Random rand = new Random();
//		boolean success = false;
//		
//		while(success) {
//			long nextAccountNumber = rand.nextLong();
//			for(long an : BankAccount.accountNumbers) {
//				if(nextAccountNumber != an) {
//					success = true;
//					//return nextAccountNumber;
//				}
//				break;
//			}
//		}
		return nextAccountNumber;
	}
						
			
//		}
//			if(nextAccountNumber != an)
//				return n
//			else
//				nextAccountNumber
//		}return nextAccountNumber;
//	}

//	

	static double totalBalances() {
		double balance = 0.0;
		for(AccountHolder ah : accountHolders) {
			balance += ah.getCombinedBalance();
		}
		return balance;
	}
	
	/**
	 * Calculates the future value of the account balance based on the interest 
	 * and number of years
	 * @param years: number of periods in years
	 * @return the future value
	 */
	static double futureValue(double presentValue, double interestRate, int term) {
		return presentValue * pow(1 + interestRate, term); 
	}
	
}
