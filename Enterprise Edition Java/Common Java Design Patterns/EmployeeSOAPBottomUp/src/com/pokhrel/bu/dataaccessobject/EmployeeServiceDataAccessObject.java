package com.pokhrel.bu.dataaccessobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pokhrel.bu.constants.AppConstants;
import com.pokhrel.bu.props.ApplicationProperties;
import com.pokhrel.datatransferobject.EmployeeDataTransferObject;

public class EmployeeServiceDataAccessObject {

	public EmployeeDataTransferObject getEmployeeInfo(String empId)
	{
		EmployeeDataTransferObject empDto = null;
		Connection con = null;
		
		try {
			con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employees where employee_id = ?");
			pstmt.setString(1, empId);
			ResultSet rs = pstmt.executeQuery();
			
			
			
			while(rs.next())
			{
				empDto = new EmployeeDataTransferObject();
				
				// String employeeId = rs.getString("EMPLOYEE_ID");
				// String firstName = rs.getString("FIRST_NAME");
				// String lastName = rs.getString("LAST_NAME");
				// String emailId = rs.getString("EMAIL");
			
				// empDto.setEmpId(employeeId);
				// empDto.setFirstName(firstName);
				// empDto.setLastName(lastName);
				// empDto.setEmailId(emailId);
				
				empDto.setEmpId(rs.getString("EMPLOYEE_ID"));
				empDto.setFirstName(rs.getString("FIRST_NAME"));
				empDto.setLastName(rs.getString("LAST_NAME"));
				empDto.setEmailId(rs.getString("EMAIL"));


				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return empDto;
	}
	
	
	private Connection getConnection() throws Exception {

		Connection con = null;
		
		ApplicationProperties props = null;
		

		try {
			
			props = ApplicationProperties.getInstance();
			
			Class.forName(props.getProperty(AppConstants.driver));

			con = DriverManager.getConnection(props.getProperty(AppConstants.url), props.getProperty(AppConstants.user), props.getProperty(AppConstants.password));
			con.setAutoCommit(false);

		}

		catch (ClassNotFoundException e) {

			e.printStackTrace();
			throw e;
			
		} catch (SQLException e) {

			e.printStackTrace();
			throw e;
		}

		return con;

	}
	
	
}
