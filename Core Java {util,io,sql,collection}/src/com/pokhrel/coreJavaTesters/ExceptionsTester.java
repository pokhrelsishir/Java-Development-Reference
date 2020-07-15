package com.pokhrel.coreJavaTesters;

import com.pokhrel.exceptionsHandaling.ApplicationException;
import com.pokhrel.exceptionsHandaling.ExceptionSample;

public class ExceptionsTester {

	public static void main(String[] args)
	{
		
		try {
			ExceptionSample sample = new ExceptionSample();
			sample.sampleMethod();
		}
		catch(ApplicationException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
