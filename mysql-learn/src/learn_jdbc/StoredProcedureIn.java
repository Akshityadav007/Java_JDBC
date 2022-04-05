package learn_jdbc;

import java.sql.*;

public class StoredProcedureIn {

	public static void main(String[] args){
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		
		final String callQuery = "{call increase_age_by_one(?)}";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
			myStmt = myConn.prepareCall(callQuery);			
			
			myStmt.setInt(1, 103);
			myStmt.execute();
			System.out.println("Stored Procedure called successfully!");
			
		}
		catch (SQLException e) {
			e.printStackTrace();;
		}

	}

}
