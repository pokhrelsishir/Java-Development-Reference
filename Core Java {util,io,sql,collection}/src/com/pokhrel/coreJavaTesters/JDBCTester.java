package com.pokhrel.coreJavaTesters;

import java.sql.Connection;
import java.sql.SQLException;

import com.pokhrel.jdbc.DBHelper;

public class JDBCTester {

	public static void main(String[] args) {

		Connection con = null;

		try {

			DBHelper dh = new DBHelper();
			con = dh.getConnection();
			
			

			// dh.getEmployeeInfo("King", con);

			// dh.addEmployeeInfo("1002", "Travis", "Scott", "travisthescott.com", con);

			// dh.updateEmployeeInfo("1001", "PonyTheMa", con);

			// dh.deleteEmployeeInfo("1000", con);

			// dh.mixedTransactions("1000", con);

			// dh.getEmployeeInfoUsingPreparedStmt("King", con);

			// dh.addEmployeeInfoUsingPreparedStmt("1005", "Alex", "Jim", "alex@jim.com", con);

			 //dh.addEmployeeInfoUsingCallableStmt("1006", "Roberto", "Firmino", "robertofirmino.com", con);

			dh.getAllEmployeesInfo(con);

			// con.commit();

			System.out.println("Done !!!");

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

	}

}
