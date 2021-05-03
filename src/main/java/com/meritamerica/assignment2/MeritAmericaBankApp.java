package com.meritamerica.assignment2;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		
		CDOffering[] cd =  {new CDOffering(1, 0.018), 
							new CDOffering(2, 0.019), 
							new CDOffering(3, 0.020),
							new CDOffering(5, 0.025),
							new CDOffering(10, 0.022)};
		MeritBank.setCDOfferings(cd);
		
//		System.out.println(cdOffering1);
//		System.out.println(cdOffering2);
//		System.out.println(cdOffering3);
//		System.out.println(cdOffering4);
//		System.out.println(cdOffering5);
		
		AccountHolder ah1 = new AccountHolder("John", "James", "Doe", "123-45-6789"); 
		
		System.out.println(ah1.toString());	
		
		ah1.addCheckingAccount(1000);
		ah1.addSavingsAccount(10000);
		
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		
		ah1.addCheckingAccount(50000);
		ah1.addSavingsAccount(500000);
		
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
		
		
		CheckingAccount lastChck = ah1.addCheckingAccount(5000);
		SavingsAccount lastSvgs= ah1.addSavingsAccount(50000);
		
		System.out.println(lastChck == null); // confirm the account was not created 
		System.out.println(lastSvgs == null); // confirm the account was not created 
//		CDOffering of = MeritBank.getBestCDOffering(4000.00); //getBestCDOffering(4000.00);
//		System.out.println("of = " + of);
		ah1.addCDAccount(MeritBank.getBestCDOffering(4000.00), 4000.00);
//		System.out.println(MeritBank.getBestCDOffering(4000.0).getInterestRate());
//		System.out.println(MeritBank.getSecondBestCDOffering(4000.0).getInterestRate());
		MeritBank.addAccountHolder(ah1);
		System.out.println(MeritBank.accountHolders[0]);
		AccountHolder ah2 = new AccountHolder("Sarah", "Dona", "Brown", "477-32-1998"); 
		ah2.addCheckingAccount(1000);
		ah2.addSavingsAccount(10000);
		
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(7500.00), 7500.00);
		MeritBank.addAccountHolder(ah2);
		System.out.println(MeritBank.accountHolders[1]);
		MeritBank.clearCDOfferings();
//
//				System.out.println(cdOffering); // == null);
//				System.out.println(MeritBank.getCDAccount())
		AccountHolder ah3 = new AccountHolder("James", "Thomas", "Smith", "327-32-1588");
		System.out.println(ah3.addCDAccount(MeritBank.getSecondBestCDOffering(5000.00), 5000.00));
		ah3.addCheckingAccount(1000);
		ah3.addSavingsAccount(10000);
		MeritBank.addAccountHolder(ah3);
		System.out.println(MeritBank.totalBalances());
		
		
		
		
		
		
		
		
		//accHolder.getCheckingAccount().deposit(500.00);
//		ah1.getSavingsAccount().withdraw(800.00);	
//		System.out.print(accHolder.getCheckingAccount().toString());		
//		System.out.print(accHolder.getSavingsAccount().toString());
//		

//		accHolder2.getCheckingAccount().deposit(-500.00);
//		accHolder2.getSavingsAccount().withdraw(600.00);
//		System.out.println(accHolder2);	
//		System.out.println(accHolder2.getCheckingAccount().toString());		
//		System.out.println(accHolder2.getSavingsAccount().toString());	
	}	
	}
