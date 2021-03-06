package com.pokhrel.microservice;

import java.util.List;

public interface EmployeeService {
	
	public EmployeeResponse addEmployeeInfo(Employee emp);
	public List<Employee> getEmployeeInfoAll();
	public List<Employee> getEmployeeInfoByLastName(String lastName);
}
