package com.meritamerica.assignment2;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		
//		CDOffering cdOffering1 = new CDOffering(1, 0.018);
//		CDOffering cdOffering2 = new CDOffering(2, 0.019);
//		CDOffering cdOffering3 = new CDOffering(3, 0.020);
//		CDOffering cdOffering4 = new CDOffering(5, 0.025);
//		CDOffering cdOffering5 = new CDOffering(10, 0.022);
		
		AccountHolder ah1 = new AccountHolder("John", "James", "Doe", "123-45-6789"); 
		
		System.out.println(ah1.toString());	
		
		//System.out.print(accHolder.getCheckingAccount().toString());	
		//System.out.print(accHolder.getSavingsAccount().toString());
		ah1.addCheckingAccount(1000);
		ah1.addSavingsAccount(10000);
		
		ah1.addCheckingAccount(5000);
		ah1.addSavingsAccount(50000);
//		
//		ah1.addCheckingAccount(50000);
//		ah1.addSavingsAccount(500000);
//		
//		CheckingAccount lastChck = ah1.addCheckingAccount(5000);
//		SavingsAccount lastSvgs= ah1.addSavingsAccount(50000);
		
//		System.out.println(lastChck); //confirm not created ?
//		System.out.println(lastSvgs); //confirm not created ?
		
		// ah1.addCDAccount(MeritBank.getBestCDOffering(openingBalance), )
//		MeritBank.addAccountHolder(ah1);
//		AccountHolder ah2 = new AccountHolder("Sarah", "Dona", "Brown", "477-32-1998"); 
//		ah2.addCheckingAccount(1000);
//		ah2.addSavingsAccount(10000);
//		
//		MeritBank.addAccountHolder(ah2);
//		MeritBank.clearCDOfferings();
//		
//		AccountHolder ah3 = new AccountHolder("James", "Thomas", "Smith", "327-32-1588"); 
//		ah3.addCheckingAccount(1000);
//		ah3.addSavingsAccount(10000);
//		MeritBank.addAccountHolder(ah3);
//		System.out.println(MeritBank.totalBalances());
//		
		
		
		
		
		
		
		
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
