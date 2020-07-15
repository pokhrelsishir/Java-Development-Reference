package com.pokhrel.bank;

public class SavingsAccount implements IAccount {
	
	private int sBalance = 0;

	@Override
	public int deposit(int depositAmount) {
		
		sBalance = sBalance + depositAmount;
		return sBalance;
	}

	@Override
	public int withdraw(int withdrawAmount) {
		
		if (withdrawAmount<sBalance && (sBalance-withdrawAmount) > 500)
		{
			sBalance = sBalance - withdrawAmount;
			
		}
		else
		{
			System.out.println("Insufficient balance to withdraw...!!!");
		}
		
		return sBalance;
	}

}
