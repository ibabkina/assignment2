package com.meritamerica.assignment2;

/**
 * This program creates an account holder and adds his accounts. It provides information 
 * about an account holder and their accounts.
 * 
 * @author Irina Babkina 
 */

public class AccountHolder {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn; //Social Security Number
	private static final double MAX_COMBINED_BALANCE = 250000.00;
	CheckingAccount[] checkingAccounts = new CheckingAccount[0]; 
	SavingsAccount[] savingsAccounts = new SavingsAccount[0];
	CDAccount[] cdAccounts = new CDAccount[0]; 
	int numberOfCheckingAccounts = 0;
	int numberOfSavingsAccounts = 0;
	int numberOfCDAccounts = 0;
	

	/**
	 * Default constructor 
	 */
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
	}

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
		if(getCheckingBalance() + getSavingsBalance() + openingBalance >= MAX_COMBINED_BALANCE) {
			System.out.println("You combined balance would be: " 
							+ (getCheckingBalance() + getSavingsBalance() + openingBalance));
			System.out.println("Please wait until combined balance is under 250k!");
			return null;
		}
		else {
			CheckingAccount checkingAccount = new CheckingAccount(openingBalance);
			addCheckingAccount(checkingAccount);
			return checkingAccount;
		}
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
	
		else {
			checkingAccounts = MeritBank.addAccToChkArray(checkingAccount, checkingAccounts);
			numberOfCheckingAccounts = checkingAccounts.length;
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
	 * @return the combined balance of checking accounts
	 */
	double getCheckingBalance() {
		return combinedBalanceByType(checkingAccounts);
	}
	
	/**
	 * @param openingBalance
	 * @return the SavingsAccount
	 */
	SavingsAccount addSavingsAccount(double openingBalance) {
		if(getCheckingBalance() + getSavingsBalance() + openingBalance >= MAX_COMBINED_BALANCE) {
			System.out.println("You combined balance would be: " 
					+ (getCheckingBalance() + getSavingsBalance() + openingBalance));
			System.out.println("Please wait until combined balance is under 250k!");
			return null;
		}
		else {
			SavingsAccount savingsAccount = new SavingsAccount(openingBalance);
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
			savingsAccounts = MeritBank.addAccToSavArray(savingsAccount, savingsAccounts);
			numberOfSavingsAccounts = savingsAccounts.length;
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
	 * @return the number of savings accounts
	 */
	public int getNumberOfSavingsAccounts() {
		return numberOfSavingsAccounts;
	}
	
	/**
	 * @return the combined balance of savings accounts
	 */
	double getSavingsBalance() {
		return combinedBalanceByType(savingsAccounts); 
	}
	
	/**
	 * @param openingBalance
	 * @param offering
	 * @return the CDAccount
	 */
	CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		if (offering == null || MeritBank.cdOfferings.length <= 0 ) { 
			System.out.println("The CD account could not be created! No CD offerings are available.");
			return null;
			}
		CDAccount cdAccount = new CDAccount(offering, openingBalance);
		addCDAccount(cdAccount); 
		return cdAccount;
	}
	
	/**
	 * @param cdAccount
	 * @return the cdAccount
	 */
	CDAccount addCDAccount(CDAccount cdAccount) {
		if (cdAccount == null) { 
		System.out.println("The CD account could not be created.");
		return null;
		}
		cdAccounts = MeritBank.addToCDAccArray(cdAccount, cdAccounts);
		numberOfCDAccounts = cdAccounts.length;
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
	 * @return the combined balance of cd accounts
	 */
	double getCDBalance() {
		return combinedBalanceByType(cdAccounts); 
	}
	
	/**
	 * @return the combined balance of checking, savings and cd accounts 
	 */
	double getCombinedBalance() {
		return combinedBalanceByType(checkingAccounts)
				+ combinedBalanceByType(savingsAccounts)
				+ combinedBalanceByType(cdAccounts);
	}
	
	/**
	 * @return the combined balance of checking || savings || cd accounts 
	 */
	double combinedBalanceByType(BankAccount[] accounts) {
		double combinedBalance = 0.0;

		for (int i = 0; i < accounts.length; i++) {
			combinedBalance += accounts[i].getBalance();
		}
		return combinedBalance;
	}

	@Override
	public String toString() {
		return "\n\nName: " +  this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName()
				+ "\nSSN: " + this.getSSN(); 
	}	
}