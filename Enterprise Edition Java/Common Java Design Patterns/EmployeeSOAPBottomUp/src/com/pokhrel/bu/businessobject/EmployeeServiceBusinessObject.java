package com.pokhrel.bu.businessobject;

import com.pokhrel.bu.dataaccessobject.EmployeeServiceDataAccessObject;
import com.pokhrel.bu.datatransferobject.EmployeeDataTransferObject;


public class EmployeeServiceBusinessObject {

	public EmployeeDataTransferObject getEmployeeInfo(String empId)
	{
		EmployeeDataTransferObject empDto = null;
		
		if(empId != null && empId.trim().length() > 0)
		{
			EmployeeServiceDataAccessObject empDao = new EmployeeServiceDataAccessObject();
			empDto = empDao.getEmployeeInfo(empId);
			
			//System.out.println("EmployeeServiceBusinessObject.getEmployeeInfo - invoked ");
		}
		else {
			System.out.println("Please provide valid request...");
		}
		
		return empDto;
	}
	

}
