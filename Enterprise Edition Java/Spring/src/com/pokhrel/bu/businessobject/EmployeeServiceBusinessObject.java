package com.pokhrel.bu.businessobject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pokhrel.bu.dataaccessobject.EmployeeServiceDataAccessObject;
import com.pokhrel.bu.datatransferobject.EmployeeDataTransferObject;


public class EmployeeServiceBusinessObject {

	public EmployeeDataTransferObject getEmployeeInfo(String empId)
	{
		EmployeeDataTransferObject empDto = null;
		
		if(empId != null && empId.trim().length() > 0)
		{
			//EmployeeServiceDataAccessObject empDao = new EmployeeServiceDataAccessObject();
			
			ApplicationContext context = new ClassPathXmlApplicationContext("springAppConfig.xml");
			EmployeeServiceDataAccessObject empDao = (EmployeeServiceDataAccessObject) context.getBean("employeeDataAccessObject");
			
			
			
			empDto = empDao.getEmployeeInfoUsingHibernate(empId);
			
			
			
		}
		else {
			System.out.println("Please provide valid request...");
		} 
		
		return empDto;
	}
	
	public String addEmployeeInfo(String empId, String firstName, String lastName, String email, String salary)
	{
		System.out.println("	EmployeeServiceBusinessObject.addEmployeeInfo - start: ");
		EmployeeServiceDataAccessObject empDao = new EmployeeServiceDataAccessObject();
		
		EmployeeDataTransferObject empDto = new EmployeeDataTransferObject(Integer.parseInt(empId),firstName,lastName,email,salary);
		
		String result  = empDao.addEmployeeInfoUsingHibernate(empDto);
		System.out.println("	EmployeeServiceBusinessObject.addEmployeeInfo - end: " );
		return result;
	}
	

}
