package com.pokhrel.coreJavaTesters;

import com.pokhrel.bank.CheckingAccount;
import com.pokhrel.bank.IAccount;
import com.pokhrel.bank.SavingsAccount;

public class BankTester {

	public static void main(String[] args) {
		
		IAccount ca = new CheckingAccount();
		
		int cBalance = ca.deposit(1000);
		System.out.println("Checking Balance is: "+ cBalance);
		
		cBalance = ca.withdraw(400);
		System.out.println("\nChecking Balance is: "+ cBalance);
		

		IAccount sa = new SavingsAccount();
		
		int sBalance = sa.deposit(1000);
		System.out.println("\nSavings Balance is: "+sBalance);
		
		sBalance = sa.withdraw(400);
		System.out.println("\nSavings Balance is: "+sBalance);
		
		sBalance = sa.withdraw(200);
		System.out.println("\nSavings Balance is: "+sBalance);
		
		
	
		
	}

}
