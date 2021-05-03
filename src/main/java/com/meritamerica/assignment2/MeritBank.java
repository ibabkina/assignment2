package com.meritamerica.assignment2;

import static java.lang.Math.pow;

import java.util.Arrays;
import java.util.Random;

//import com.meritamerica.assignment1.AccountHolder;

public class MeritBank {
	//private static final int MAX_SIZE = 1000;
	static AccountHolder[] accountHolders = new AccountHolder[0]; 
	static CDOffering[] cdOfferings; // = new CDOffering[0];
	static int numberOfAccountHolders = 0;
	static int numberOfCDOfferings = 0;
	static CDOffering bestCDOffering;
	static CDOffering secondBestCDOffering;
	static long nextAccountNumber = 1000;
	//static double totalBalances();
	
	public MeritBank() {}
	
	static void addAccountHolder(AccountHolder accountHolder) {
		accountHolders = addToAccHoldArray(accountHolder, accountHolders);
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
	
	static CheckingAccount[] addAccToChkArray (CheckingAccount item, CheckingAccount[] items) {
//		System.out.println("Here");
//		System.out.println("Add the following item to array: " + item.toString());
//		System.out.println("\n\n\n\n");
		CheckingAccount[] temp = new CheckingAccount[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
 		}
		temp[temp.length - 1] = item;
		items = temp;
		
//		System.out.println("Size of checking Array inside add account to chk array now  is:" + items.length);
		return items;
	}
	

	static SavingsAccount[] addAccToSavArray (SavingsAccount item, SavingsAccount[] items) {
//		System.out.println("Here");
//		System.out.println("Add the following item to array: " + item.toString());
//		System.out.println("\n\n");
		SavingsAccount[] temp = new SavingsAccount[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
			}
		temp[temp.length - 1] = item;
		items = temp;
		
		System.out.println("Size of savings Array inside add account to sav array now  is:" + items.length);
		return items;
	}



	static AccountHolder[] addToAccHoldArray (AccountHolder item, AccountHolder[] items) {
//		System.out.println("Here");
//		System.out.println("Add the following item to array: " + item.toString());
//		System.out.println("\n\n");
		AccountHolder[] temp = new AccountHolder[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
			}
		temp[temp.length - 1] = item;
		items = temp;
		
		System.out.println("Size of account holder Array inside add to account holder array now  is:" + items.length);
		return items;
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
	
	static CDAccount[] addToCDAccArray (CDAccount item, CDAccount[] items) {
//		System.out.println("Here");
//		System.out.println("Add the following item to array: " + item.toString());
//		System.out.println("\n\n\n\n");
		CDAccount[] temp = new CDAccount[items.length + 1]; 
		for(int i = 0; i < items.length; i++) {
			temp[i] = items[i];
 		}
		temp[temp.length - 1] = item;
		items = temp;
		
		System.out.println("Size of cd Array inside add account to cd array now  is:" + items.length);
		return items;
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
//		for(CDOffering cd : cdOfferings) {
//		System.out.println(cdOfferings == null); //toString()); // is :" + cd);
//		}
		if (cdOfferings == null || MeritBank.cdOfferings.length <= 0) {
			System.out.println("Sorry there are no offerings at this time");
			return null;
		}
		CDOffering bestInterest = cdOfferings[0];
		for(int i = 0; i < cdOfferings.length; i++) {
			if(bestInterest.getInterestRate() < cdOfferings[i].getInterestRate())
				bestInterest = cdOfferings[i];
		}
		return bestInterest;
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
		
	
		
		
		
		
		
//		for(int i = 0; i < cdOfferings.length; i++) {
//			if(bestInterest.getInterestRate() < cdOfferings[i].getInterestRate())
//				bestInterest = cdOfferings[i];
//			
//		}
//		CDOffering bestInterest = cdOfferings[0];
//		for(int i = 0; i < cdOfferings.length; i++) {
//			if(bestInterest.getInterestRate() < cdOfferings[i].getInterestRate())
//				bestInterest = cdOfferings[i];
//		}
//		return bestInterest;
//		return secondBest;
		
	}
	
	public static void clearCDOfferings() {
		cdOfferings = null; //new CDOffering[0]; 
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
