package com.pokhrel.coreJavaTesters;

import com.pokhrel.parentChild.Child;
import com.pokhrel.parentChild.Parent;

public class ParentChildTester {

	public static void main(String[] args) {
		
		
		Parent parent = new Parent();
		
		String pName = parent.getParentName();
		
		System.out.println(" Parent's name is: "+pName);
		
		Child child = new Child();
		
		String cName = child.getChildName();
		
		System.out.println(" Child's name is: "+cName);
		
		String pNameFromChild = child.getParentName();
		
		System.out.println(" Parent's name from child class is: "+ pNameFromChild);

	}

}
