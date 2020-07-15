package com.pokhrel.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.pokhrel.constants.AppConstants;
import com.pokhrel.singleton.ApplicationProperties;

public class DBHelperWithProperties {
	
	public Connection getConnection() throws Exception {

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

	public void getEmployeeInfoUsingPreparedStmt(String last, Connection con) throws Exception {

		ResultSet rs = null;

		try {

			PreparedStatement pstmt = con.prepareStatement("select * from employees where last_name = ? ");

			pstmt.setString(1, "King");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String empId = rs.getString("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");

				System.out.println(empId + " : " + firstName + " : " + lastName + " : " + email);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			rs.close();
		}

	}

	public void addEmployeeInfoUsingPreparedStmt(String empId, String lastName, String firstName, String email,
			Connection con) throws Exception {
		try {

			PreparedStatement pstmt = con
					.prepareStatement("insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL) values (?,?,?,?)");

			pstmt.setString(1, empId);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, email);

			int result = pstmt.executeUpdate();
			con.commit();

			System.out.println(" Is inserted : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addEmployeeInfoUsingCallableStmt(String empId, String lastName, String firstName, String email,
			Connection con) throws Exception {
		try {

			CallableStatement cstmt = con.prepareCall("{call add_emp_info(?,?,?,?,?)}");

			cstmt.setInt(1, Integer.parseInt(empId));
			cstmt.setString(2, lastName);
			cstmt.setString(3, firstName);
			cstmt.setString(4, email);

			cstmt.registerOutParameter(5, Types.VARCHAR);

			cstmt.executeUpdate();

			String result = cstmt.getString(5);

			System.out.println("Is Inserted using stored procedure: " + result);

		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}
	}

	public void getEmployeeInfo(String last, Connection con) throws Exception {

		ResultSet rs = null;

		try {

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery("select * from employees where last_name ='" + last + "'");

			while (rs.next()) {
				String empId = rs.getString("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");

				System.out.println(empId + " : " + firstName + " : " + lastName + " : " + email);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			rs.close();
		}

	}

	public void addEmployeeInfo(String empId, String lastName, String firstName, String email, Connection con)
			throws Exception {
		try {
			Statement stmt = con.createStatement();
			int result = stmt
					.executeUpdate("insert into employees(EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE) values('"
							+ empId + "','" + firstName + "','" + lastName + "','" + email + "',SYSDATE)");
			con.commit();
			System.out.println(" Is inserted " + result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void updateEmployeeInfo(String empId, String lastName, Connection con) throws Exception {
		try {
			Statement stmt = con.createStatement();
			int result = stmt
					.executeUpdate("update employees set last_name ='" + lastName + "' where employee_id = 1000");
			con.commit();
			System.out.println(" Updated Sucessfully " + result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void deleteEmployeeInfo(String empId, Connection con) throws Exception {
		try {
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate("delete from employees where employee_id =" + empId);
			con.commit();
			System.out.println(" Deleted Info Successfully " + result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void mixedTransactions(String empId, Connection con) throws Exception {
		try {
			Statement stmt = con.createStatement();

			int result0 = stmt.executeUpdate("update employees set last_name = 'TEST' where employee_id =" + empId);
			System.out.println("Updated !!! " + result0);

			int result1 = stmt.executeUpdate("delete from employees where employee_id =" + empId);
			System.out.println(" Deleted " + result1);

			con.commit();
			System.out.println("Both transactions completed and Commited !!!");

		} catch (SQLException e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}
	}
	
	
	public void getAllEmployeesInfo(Connection con) throws Exception {

		ResultSet rs = null;

		try {

			Statement stmt = con.createStatement();

			rs = stmt.executeQuery("select * from employees");

			while (rs.next()) {
				String empId = rs.getString("EMPLOYEE_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String email = rs.getString("EMAIL");

				System.out.println(empId + " : " + firstName + " : " + lastName + " : " + email);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}

		finally {
			rs.close();
		}

	}

}




