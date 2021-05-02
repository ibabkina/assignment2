package com.meritamerica.assignment2;

import java.util.Arrays;

/**
 * This program creates an account holder and instantiates their checking 
 * and savings accounts. it allows to get information about an account holder and 
 * their accounts.
 * 
 * @author Irina Babkina 
 */

public class AccountHolder {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn; //Social Security Number
	private CheckingAccount checkingAccount;
	private SavingsAccount savingsAccount;
	private CDAccount cdAccount;
	//private static final int MAX_SIZE = 500;
	private static final double MAX_COMBINED_BALANCE = 250000.00;
	CheckingAccount[] checkingAccounts = new CheckingAccount[0]; 
	SavingsAccount[] savingsAccounts = new SavingsAccount[0];
	CDAccount[] cdAccounts = new CDAccount[0]; 
	int numberOfCheckingAccounts = 0;
	int numberOfSavingsAccounts = 0;
	int numberOfCDAccounts = 0;
	

	public AccountHolder() {}
	
	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param ssn
	 */
	public AccountHolder(String firstName, 
							String middleName, 
							String lastName,
							String ssn) { 
		
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;
		//this.checkingAccount = new CheckingAccount(checkingAccountOpeningBalance);
		//this.savingsAccount = new SavingsAccount(savingsAccountOpeningBalance);
	}
	
//	/**
//	 * @param firstName
//	 * @param middleName
//	 * @param lastName
//	 * @param ssn
//	 * @param checkingAccountOpeningBalance
//	 * @param savingsAccountOpeningBalance
//	 */
//	public AccountHolder(String firstName, 
//							String middleName, 
//							String lastName,
//							String ssn, 
//							double checkingAccountOpeningBalance,
//							double savingsAccountOpeningBalance) {
//		//super();
//		this.firstName = firstName;
//		this.middleName = middleName;
//		this.lastName = lastName;
//		this.ssn = ssn;
//		this.checkingAccount = new CheckingAccount(checkingAccountOpeningBalance);
//		this.savingsAccount = new SavingsAccount(savingsAccountOpeningBalance);
//	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the ssn
	 */
	public String getSSN() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	/**
	 * @param openingBalance
	 * @return the CheckingAccount
	 */
	CheckingAccount addCheckingAccount(double openingBalance) {
		System.out.println(" getCheckingBalance() : " + getCheckingBalance());
		System.out.println(" getSavingsBalance() : " + getSavingsBalance());
//		if(getCheckingBalance() + getSavingsBalance() + openingBalance >= MAX_COMBINED_BALANCE) {
//			System.out.println("Please wait until combined balance is under 250k!");
//			return null;
//		}
//		else {
//			checkingAccount = new CheckingAccount(openingBalance);
//			addCheckingAccount(checkingAccount);
			return checkingAccount;
		//}
	}
	
	/**
	 * @param checkingAccount
	 * @return the CheckingAccount
	 */
	CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		if(getCheckingBalance() + getSavingsBalance() + checkingAccount.getBalance() >= MAX_COMBINED_BALANCE) {  
			System.out.println("Please wait until combined balance is under 250k!");
			return null;
		}
	//	else {
			//checkingAccounts[numberOfCheckingAccounts++] = checkingAccount;
		// }
		else {
			MeritBank.addItemToArray(checkingAccount, checkingAccounts);
			numberOfCheckingAccounts++;
		}
		return checkingAccount;
	}

	/**
	 * @return the CheckingAccount[]
	 */
	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccounts;
	}
	
	/**
	 * @return the number of checking accounts
	 */
	public int getNumberOfCheckingAccounts() {
		return numberOfCheckingAccounts;
	}
	
	/**
	 * @return the checking balance
	 */
	double getCheckingBalance() {
		return combinedBalanceByType(checkingAccounts, numberOfCheckingAccounts);
	}
	
	/**
	 * @param openingBalance
	 * @return the SavingsAccount
	 */
	SavingsAccount addSavingsAccount(double openingBalance) {
		if(getCheckingBalance() + getSavingsBalance() + openingBalance >= MAX_COMBINED_BALANCE) {
			System.out.println("Please wait until combined balance is under 250k!");
			return null;
		}
		else {
			savingsAccount = new SavingsAccount(openingBalance);
			addSavingsAccount(savingsAccount); 
			return savingsAccount;
		}
	}
	
	/**
	 * @param savingsAccount
	 * @return the SavingAccount
	 */
	SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		if(getCheckingBalance() + getSavingsBalance() + savingsAccount.getBalance() >= MAX_COMBINED_BALANCE) {  
			System.out.println("Please wait until combined balance is under 250k!");
			return null;
		}
		else {
			MeritBank.addItemToArray(savingsAccount, savingsAccounts);
			numberOfSavingsAccounts++;
		}
		return savingsAccount;
	}

	/**
	 * @return the SavingsAccount[]
	 */
	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccounts;
	}
	
	/**
	 * @return the number of checking accounts
	 */
	public int getNumberOfSavingsAccounts() {
		return numberOfSavingsAccounts;
	}
	
	/**
	 * @return the savings balance
	 */
	double getSavingsBalance() {
		return combinedBalanceByType(savingsAccounts, numberOfSavingsAccounts);
	}
	
	/**
	 * @param openingBalance
	 * @return the CDAccount
	 */
	CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		cdAccount = new CDAccount(offering, openingBalance);
		addCDAccount(cdAccount); 
		return cdAccount;
	}
	
	/**
	 * @param checkingAccount
	 * @return the CheckingAccount
	 */
	CDAccount addCDAccount(CDAccount cdAccount) {
//		if (numberOfCDAccounts < MAX_SIZE) {
//		cdAccounts[numberOfCDAccounts++] = cdAccount; 
//		}
//		else 
//			System.out.println("Need more room for a new cd account");
		MeritBank.addItemToArray(cdAccount, cdAccounts);
		numberOfCDAccounts++;
		return cdAccount;
	}

	/**
	 * @return the CDAccount[]
	 */
	public CDAccount[] getCDAccounts() {
		return cdAccounts;
	}
	
	/**
	 * @return the number of cd accounts
	 */
	public int getNumberOfCDAccounts() {
		return numberOfCDAccounts;
	}
	
	/**
	 * @return the cd balance
	 */
	double getCDBalance() {
		return combinedBalanceByType(cdAccounts, numberOfCDAccounts);
	}
	
	/**
	 * @return the combined balance
	 */
	double getCombinedBalance() {
		return combinedBalanceByType(checkingAccounts, numberOfCheckingAccounts) 
				+ combinedBalanceByType(savingsAccounts, numberOfSavingsAccounts) 
				+ combinedBalanceByType(cdAccounts, numberOfCDAccounts); 
	}
	
	double combinedBalanceByType(BankAccount[] accounts, int numOfAccounts) {
		
		double combinedBalance = 0;
//		if (accounts.length == 0) {
//			return 0;
//		}
		for (int i = 0; i < numOfAccounts; i++) {
			combinedBalance += accounts[i].getBalance();
		}
		System.out.println("number of account for acc holder: " + numOfAccounts);
		return combinedBalance;
	}
	
	
//	/**
//	 * @return the SavingsAccount
//	 */
//	public SavingsAccount getSavingsAccount() {
//		return savingsAccount;
//	}
	
	

//	/**
//	 * @return the CheckingAccount
//	 */
//	public CheckingAccount getCheckingAccount() {
//		return checkingAccount;
//	}

	@Override
	public String toString() {
		return "\n\nName: " +  this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName()
				+ "\nSSN: " + this.getSSN(); 
//				+ this.getCheckingAccount().toString()
//				+ this.getSavingsAccount().toString();
	}	
}