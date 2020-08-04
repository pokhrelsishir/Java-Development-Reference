package com.pokhrel.microservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/EmployeeRestMicroService")
public class EmployeeServiceController {

	@Autowired 
	EmployeeService empService; 
	
	@RequestMapping(value = "/getEmployeeInfoAll", 
			method = RequestMethod.GET, 
			produces = { "application/json " })
	public List<Employee> getEmployeeInfoAll() {
		System.out.println("EmployeeServiceController.getEmployeeInfoAll : Start : ");

		List<Employee> empList = empService.getEmployeeInfoAll();
		
		System.out.println("EmployeeServiceController.getEmployeeInfoAll : Size : " + empList.size());

		System.out.println("EmployeeServiceController.getEmployeeInfoAll : End : ");
		
		return empList;

	}

	@RequestMapping(value = "/getEmployeeInfoByLastName/{lastName}", 
			method = RequestMethod.GET, 
			produces = {"application/json " })
	public List<Employee> getEmployeeInfoByLastName(@PathVariable("lastName") String lastName) {
		
		System.out.println("EmployeeServiceController.getEmployeeInfoByLastName : Start : ");
		
		List<Employee> empList = empService.getEmployeeInfoByLastName(lastName);

		System.out.println("EmployeeServiceController.getEmployeeInfoByLastName : Size : " + empList.size());

		
		
		System.out.println("EmployeeServiceController.getEmployeeInfoByLastName : End : ");
		return empList;
	}

}
