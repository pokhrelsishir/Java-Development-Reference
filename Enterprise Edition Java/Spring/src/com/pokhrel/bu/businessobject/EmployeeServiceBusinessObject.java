package com.pokhrel.bu.businessobject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pokhrel.bu.dataaccessobject.EmployeeServiceDataAccessObject;
import com.pokhrel.bu.datatransferobject.EmployeeDataTransferObject;
import com.pokhrel.bu.services.EmployeeBottomUpService;




public class EmployeeServiceBusinessObject {

	Logger log = Logger.getLogger(EmployeeServiceBusinessObject.class);

//	@Autowired
//	EmployeeServiceDataAccessObject empDao;
	
	public EmployeeDataTransferObject getEmployeeInfo(String empId) throws Exception
	{
		//System.out.println("	EmployeeServiceBusinessObject.getEmployeeInfo - start: ");
		
		
		log.debug("	EmployeeServiceBusinessObject.getEmployeeInfo - start: ");
		
		EmployeeDataTransferObject empDto = null;
		
		if(empId != null && empId.trim().length() > 0)
		{
			try {
			//EmployeeServiceDataAccessObject empDao = new EmployeeServiceDataAccessObject();

			ApplicationContext context = new ClassPathXmlApplicationContext("springAppConfig.xml");

			EmployeeServiceDataAccessObject empDao = (EmployeeServiceDataAccessObject) context.getBean("employeeDataAO");
			
			empDto = empDao.getEmployeeInfoUsingHibernate(empId);	
		}
		catch(Exception e)
		{
			log.error("EmployeeServiceBusinessObject - error: ");
			e.printStackTrace();
		}
			
		}
		else {
			//System.out.println("Please provide valid request...");
			log.debug("Please provide valid request...");	
		} 
		//System.out.println("	EmployeeServiceBusinessObject.getEmployeeInfo - end: ");
		log.debug("	EmployeeServiceBusinessObject.getEmployeeInfo - end: ");
		
		return empDto;
	
	}
	public String addEmployeeInfo(String empId, String firstName, String lastName, String email, String salary) throws Exception   
	{
		//System.out.println("	EmployeeServiceBusinessObject.addEmployeeInfo - start: ");
		
		log.debug("	EmployeeServiceBusinessObject.addEmployeeInfo - start: ");
		
		EmployeeServiceDataAccessObject empDao = new EmployeeServiceDataAccessObject();
		
		EmployeeDataTransferObject empDto = new EmployeeDataTransferObject(Integer.parseInt(empId),firstName,lastName,email,salary);
		
		String result  = empDao.addEmployeeInfoUsingHibernate(empDto);
		
		//System.out.println("	EmployeeServiceBusinessObject.addEmployeeInfo - end: " );
		
		log.debug("	EmployeeServiceBusinessObject.addEmployeeInfo - end: " );
		
		return result;
	}
	

}
