package com.pokhrel.bu.dataaccessobject;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.pokhrel.bu.businessobject.EmployeeServiceBusinessObject;
import com.pokhrel.bu.constants.AppConstants;
import com.pokhrel.bu.datatransferobject.EmployeeDataTransferObject;
import com.pokhrel.bu.props.ApplicationProperties;

public class EmployeeServiceDataAccessObject {

	Logger log = Logger.getLogger(EmployeeServiceDataAccessObject.class);

	
	public EmployeeDataTransferObject getEmployeeInfo(String empId) throws SQLException{
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

	public EmployeeDataTransferObject getEmployeeInfoUsingHibernate(String empId) throws Exception{
		
		List<EmployeeDataTransferObject> empList = null;
		
		//System.out.println("	EmployeeServiceDataAccessObject.getEmployeeInfoUsingHibernate - start: ");
		log.debug("	EmployeeServiceDataAccessObject.getEmployeeInfoUsingHibernate - start: ");

		try {
		Session ses = getHibernateSession();
		Query query = ses.createQuery(" from EmployeeDataTransferObject where empId ="+empId);
		empList = query.list();

		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		
		//System.out.println("	EmployeeServiceDataAccessObject.getEmployeeInfoUsingHibernate - end: ");
		log.debug("	EmployeeServiceDataAccessObject.getEmployeeInfoUsingHibernate - end: ");

		return empList.get(0);
	}
	
	public String addEmployeeInfoUsingHibernate(EmployeeDataTransferObject empDto) throws Exception
	{
		//System.out.println("		EmployeeServiceDataAccessObject.addEmployeeInfoUsingHibernate - start: ");
		log.debug("		EmployeeServiceDataAccessObject.addEmployeeInfoUsingHibernate - start: ");
		
		Session ses = getHibernateSession();
		String result = "Employee Record added sucessfully...";
		try {
			
			if(empDto!=null)
			{
				ses.getTransaction().begin();
				ses.save(empDto);
				ses.getTransaction().commit();
			}
			
//		EmployeeDataTransferObject empDto = new EmployeeDataTransferObject();
//		empDto.setEmpId(Integer.parseInt(empId));
//		empDto.setFirstName(firstName);
//		empDto.setLastName(lastName);
//		empDto.setEmailId(email);
		
		}
		catch(Exception e)
		{
			ses.getTransaction().rollback();
			result = "Error in adding record in employee table...";
			log.error("		EmployeeServiceDataAccessObject.addEmployeeInfoUsingHibernate - end: " + e.getMessage());
			throw e;
		}
		finally {
			ses.close();
		}
		//System.out.println("		EmployeeServiceDataAccessObject.addEmployeeInfoUsingHibernate - end: ");
		log.debug("		EmployeeServiceDataAccessObject.addEmployeeInfoUsingHibernate - end: ");
		
		return result;
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
			log.error(" Exception occured..");
			throw e;

		} catch (SQLException e) {

			e.printStackTrace();
			log.error(" Exception occured..");
			throw e;
		}

		return con;

	}

}
