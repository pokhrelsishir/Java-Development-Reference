package com.pokhrel.parentChild;

public class Child extends Parent{
	
	public String cName = "Child";
	
	public String getChildName()
	{
		System.out.println("Invoked - Child.getChildName");
		return cName;
	}

}
