package com.pokhrel.bu.services;

import com.pokhrel.bu.businessobject.EmployeeServiceBusinessObject;
import com.pokhrel.bu.datatransferobject.EmployeeDataTransferObject;


public class EmployeeBottomUpService {

	
	
	public EmployeeDataTransferObject getEmployeeInfo(String empId)
	{
		System.out.println("EmployeeBottomUpService.getEmployeeInfo - invoked: "+empId);
		
		EmployeeServiceBusinessObject bo = new EmployeeServiceBusinessObject();
		EmployeeDataTransferObject dto = bo.getEmployeeInfo(empId); 
		
		return dto;
		
		//return "The entered value is : "+empId + ": Success !!!";
	}
	
	public String addEmployeeInfo(String empId, String firstName, String lastName, String email)
	{
		System.out.println("EmployeeBottomUpService.addEmployeeInfo - invoked: "+empId);
		
		return "Success - added : "+empId;
	}

}
