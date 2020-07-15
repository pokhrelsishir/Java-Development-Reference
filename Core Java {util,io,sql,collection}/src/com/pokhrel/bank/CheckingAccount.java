package com.pokhrel.bank;

public class CheckingAccount implements IAccount {
	
	private int cBalance = 0;

	@Override
	public int deposit(int depositAmount) {
		
		cBalance = cBalance + depositAmount;
		return cBalance;
	}

	@Override
	public int withdraw(int withdrawAmount) {
		
		if (withdrawAmount < cBalance)
		{
			cBalance = cBalance - withdrawAmount;
		}
		else
		{
			System.out.println("Insufficient balance to Withdraw...!!!");
		}
		
		return cBalance;
		
	}

}
