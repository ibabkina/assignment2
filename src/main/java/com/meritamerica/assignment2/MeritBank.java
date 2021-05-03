package com.meritamerica.assignment2;

/**
 * This program creates account holders for a bank  and adds his accounts. It provides information 
 * about an account holder and their accounts.
 * 
 * @author Irina Babkina 
 */

import static java.lang.Math.pow;

import java.util.Arrays;
import java.util.Random;

public class MeritBank {
	
	static AccountHolder[] accountHolders = new AccountHolder[0]; 
	static CDOffering[] cdOfferings; 
	static int numberOfAccountHolders = 0;
	static int numberOfCDOfferings = 0;
	static CDOffering bestCDOffering;
	static CDOffering secondBestCDOffering;
	static long nextAccountNumber = 1000;
	
	/**
	 * default constractor
	 */
	public MeritBank() {}
	
	
	/**
	 * @param accountHolder
	 */
	static void addAccountHolder(AccountHolder accountHolder) {
		
		accountHolders = addToAccHoldArray(accountHolder, accountHolders);
		numberOfAccountHolders++;
	}
	
	/**
	 * @return the accountHolder[] 
	 */
	static AccountHolder[]getAccountHolders() {
		return accountHolders;
	}
	
	/**
	 * @return the checkingAccount[] 
	 */
	static CheckingAccount[] addAccToChkArray (CheckingAccount item, CheckingAccount[] items) {

		CheckingAccount[] temp = new CheckingAccount[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
 		}
		temp[temp.length - 1] = item;
		items = temp;
		
		return items;
	}
	
	/**
	 * @return the savingsAccount[] 
	 */
	static SavingsAccount[] addAccToSavArray (SavingsAccount item, SavingsAccount[] items) {

		SavingsAccount[] temp = new SavingsAccount[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
			}
		temp[temp.length - 1] = item;
		items = temp;
		
		return items;
	}

	/**
	 * @return the accountHolder[] 
	 */
	static AccountHolder[] addToAccHoldArray (AccountHolder item, AccountHolder[] items) {

		AccountHolder[] temp = new AccountHolder[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
			}
		temp[temp.length - 1] = item;
		items = temp;
		
		return items;
	}
	
	/**
	 * @return the CDAccount[] 
	 */
	static CDAccount[] addToCDAccArray (CDAccount item, CDAccount[] items) {

		CDAccount[] temp = new CDAccount[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
 		}
		temp[temp.length - 1] = item;
		items = temp;
		
		return items;
	}

	static void addItemToArray (Object item, Object[] items) {
		
		Object[] temp = new Object[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
 		}
		temp[temp.length - 1] = item;
		items = temp;
	}
	
	/**
	 * @return the cdOfferings
	 */
	public static CDOffering[] getCDOfferings() {
		return cdOfferings;
	}
	
	/**
	 * @param depositAmount
	 * @return the bestOffering
	 */
	public static CDOffering getBestCDOffering(double depositAmount) {

		if (cdOfferings == null || MeritBank.cdOfferings.length <= 0) {
			System.out.println("Sorry there are no offerings at this time");
			return null;
		}
		CDOffering bestOffering = cdOfferings[0];
		for(int i = 0; i < cdOfferings.length; i++) {
			if(bestOffering.getInterestRate() < cdOfferings[i].getInterestRate())
				bestOffering = cdOfferings[i];
		}
		return bestOffering;
	}

	/**
	 * @param depositAmount
	 * @return the secondBestCDOffering
	 */
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		
		if (cdOfferings == null || MeritBank.cdOfferings.length <= 0) {
			System.out.println("Sorry there are no offerings at this time");
			return null;
		}
		CDOffering temp;
	      //sort the array
	      for (int i = 0; i < cdOfferings.length; i++) {
	         for (int j = i + 1; j < cdOfferings.length; j++) {
	            if (cdOfferings[i].getInterestRate() > cdOfferings[j].getInterestRate()) {
	               temp = cdOfferings[i];
	               cdOfferings[i] = cdOfferings[j];
	               cdOfferings[j] = temp;
	            }
	         }
	      }
	      
	      //return second largest element
	      return cdOfferings[cdOfferings.length - 2];
	}
	
	/**
	 * Removes all offerings
	 */
	public static void clearCDOfferings() {
		cdOfferings = null; //new CDOffering[0]; 
	}
	
	/**
	 * @param cdOfferings the cdOfferings to set
	 */
	public static void setCDOfferings(CDOffering[] offerings) {
		MeritBank.cdOfferings = offerings; 
	}

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
						
	/**
	 * @return the balance of all accounts
	 */
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
	 * @param presentValue
	 * @param interestRate
	 * @param term: number of periods in years
	 * @return the future value
	 */
	static double futureValue(double presentValue, double interestRate, int term) {
		return presentValue * pow(1 + interestRate, term); 
	}
}