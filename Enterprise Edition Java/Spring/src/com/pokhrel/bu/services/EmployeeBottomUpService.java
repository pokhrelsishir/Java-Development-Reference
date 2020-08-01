package com.pokhrel.bu.services;


import org.apache.log4j.Logger;

import com.pokhrel.bu.businessobject.EmployeeServiceBusinessObject;
import com.pokhrel.bu.datatransferobject.EmployeeDataTransferObject;


public class EmployeeBottomUpService {

	
	Logger log = Logger.getLogger(EmployeeBottomUpService.class);
	
	public EmployeeDataTransferObject getEmployeeInfo(String empId)
	{
		EmployeeDataTransferObject dto = null;
		try {
		log.debug("EmployeeBottomUpService.getEmployeeInfo - start: ");
		
		log.info("EmployeeBottomUpService.getEmployeeInfo - start: "+ empId);
		
		//System.out.println("EmployeeBottomUpService.getEmployeeInfo - start: "+empId);
		
		EmployeeServiceBusinessObject bo = new EmployeeServiceBusinessObject();
		
		dto = bo.getEmployeeInfo(empId); 
		
		//System.out.println("EmployeeBottomUpService.getEmployeeInfo - end: ");
		
		log.debug("EmployeeBottomUpService.getEmployeeInfo - end: ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			log.error("EmployeeBottomUpService.getEmployeeInfo - Error occured" + e.getMessage() );
		}
		return dto;
	}
	
	public String addEmployeeInfo(String empId, String firstName, String lastName, String email, String salary) 
	{
		String result = null;
		try {
		//System.out.println("EmployeeBottomUpService.addEmployeeInfo - start: "+empId);
		
		log.debug("EmployeeBottomUpService.addEmployeeInfo - start: "+empId);
		
		EmployeeServiceBusinessObject bo = new EmployeeServiceBusinessObject();
		
		
		
		result = bo.addEmployeeInfo(empId, firstName, lastName, email, salary);
		
		
		log.debug("EmployeeBottomUpService.addEmployeeInfo - end: "+empId);
		
		//System.out.println("EmployeeBottomUpService.addEmployeeInfo - end: "+empId);
		
		} catch (Exception e) {
			
			
			log.error("EmployeeBottomUpService.addEmployeeInfo - Error occured: " + e.getMessage());
		}

		return result;
	}

}
