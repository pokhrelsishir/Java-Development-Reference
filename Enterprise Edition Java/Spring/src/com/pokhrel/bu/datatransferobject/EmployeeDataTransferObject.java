package com.pokhrel.bu.datatransferobject;

public class EmployeeDataTransferObject {

	private int empId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String salary;
	
	

	public EmployeeDataTransferObject(int empId, String firstName, String lastName, String emailId, String salary)
	{
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.salary = salary;
	}
	
	public EmployeeDataTransferObject()
	{

	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmailId() {
		return emailId;
	}
	
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

}
