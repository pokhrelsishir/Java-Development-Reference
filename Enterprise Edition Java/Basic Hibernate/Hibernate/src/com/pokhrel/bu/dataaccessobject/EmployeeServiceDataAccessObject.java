package com.pokhrel.bu.dataaccessobject;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pokhrel.bu.constants.AppConstants;
import com.pokhrel.bu.datatransferobject.EmployeeDataTransferObject;
import com.pokhrel.bu.props.ApplicationProperties;

public class EmployeeServiceDataAccessObject {

	public EmployeeDataTransferObject getEmployeeInfo(String empId) {
		EmployeeDataTransferObject empDto = null;
		Connection con = null;

		try {
			con = getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from employees where employee_id = ?");
			pstmt.setString(1, empId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				empDto = new EmployeeDataTransferObject();

				empDto.setEmpId(Integer.parseInt(rs.getString("EMPLOYEE_ID")));
				empDto.setFirstName(rs.getString("FIRST_NAME"));
				empDto.setLastName(rs.getString("LAST_NAME"));
				empDto.setEmailId(rs.getString("EMAIL"));

			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return empDto;
	}
	
	public Session getHibernateSession()
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ses = sf.openSession();
		return ses;
	}

	public EmployeeDataTransferObject getEmployeeInfoUsingHibernate(String empId) {
		
		List<EmployeeDataTransferObject> empList = null;
		try {
		Session ses = getHibernateSession();
		Query query = ses.createQuery(" from EmployeeDataTransferObject where empId ="+empId);
		empList = query.list();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return empList.get(0);
	}

	private Connection getConnection() throws Exception {

		Connection con = null;

		ApplicationProperties props = null;

		try {

			props = ApplicationProperties.getInstance();

			Class.forName(props.getProperty(AppConstants.driver));

			con = DriverManager.getConnection(props.getProperty(AppConstants.url), props.getProperty(AppConstants.user),
					props.getProperty(AppConstants.password));
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
