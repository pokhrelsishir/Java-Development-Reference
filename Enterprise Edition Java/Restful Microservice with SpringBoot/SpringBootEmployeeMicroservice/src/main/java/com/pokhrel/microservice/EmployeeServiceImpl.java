package com.pokhrel.microservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDBRepository employeeDBRepository;

	public EmployeeResponse addEmployeeInfo(Employee emp) {
		
		System.out.println("	EmployeeServiceImpl.addEmployeeInfo : Start : ");

		EmployeeResponse resp = new EmployeeResponse();
		try {

			if(emp.getLastName() != null && emp.getLastName().trim().length()>0)
			{
			
			employeeDBRepository.save(emp);

			resp.setStatus("OK...!!!");
			
			resp.setResponseMessage("Employee successfully added...!!!");
			}
			else
			{
				resp.setStatus("LASTNAME VALIDATION_ERROR...!!!");
				
				resp.setResponseMessage("Please provide the mandatory field : LAST_NAME...!!!");
			}
		} catch (Exception e) {
			
			resp.setStatus("INTERNAL ERROR...NOT OK...!!!");
			
			resp.setResponseMessage(e.getMessage());
			
		}

		System.out.println("	EmployeeServiceImpl.addEmployeeInfo : End : ");

		return resp;

	}

	public List<Employee> getEmployeeInfoAll() {

//		Employee emp = new Employee();
//		emp.setEmpId("1001");
//		emp.setFirstName("Cypress");
//		emp.setLastName("State");
//		emp.setEmail("cypressstate@gmail.com");
//
//		Employee emp1 = new Employee();
//		emp1.setEmpId("1000");
//		emp1.setFirstName("Pelican");
//		emp1.setLastName("State");
//		emp1.setEmail("pelicanstate@gmail.com");
//
//		List<Employee> empList = new ArrayList<Employee>();
//		empList.add(emp);
//		empList.add(emp1);

		System.out.println("EmployeeServiceImpl.getEmployeeInfoAll : Start : ");
		List<Employee> empList = (List<Employee>) employeeDBRepository.findAll();
		System.out.println("EmployeeServiceImpl.getEmployeeInfoAll : End : ");

		return empList;
	}

	public List<Employee> getEmployeeInfoByLastName(String lastName) {

//		Employee emp = new Employee();
//		emp.setEmpId("1000");
//		emp.setFirstName("Pelican");
//		emp.setLastName("State");
//		emp.setEmail("pelicanstate@gmail.com");
//
//		List<Employee> empList = new ArrayList<Employee>();
//		empList.add(emp);
		System.out.println("EmployeeServiceImpl.getEmployeeInfoByLastName : Start : ");

		List<Employee> empList = employeeDBRepository.findByLastName(lastName);

		System.out.println("EmployeeServiceImpl.getEmployeeInfoByLastName : End : ");

		return empList;
	}

}
