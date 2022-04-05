package learn_jdbc;

import java.sql.*;

public class StoredProcedureInOut {

	public static void main(String[] args){
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		
		final String callQuery = "{call greet_person(?)}";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
			myStmt = myConn.prepareCall(callQuery);			
			
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setInt(1, 103);
			myStmt.execute();
			
			String person = myStmt.getString(1);
			System.out.println("Stored Procedure called successfully!");
			System.out.println("Hello " + person +"!");
			
		}
		catch (SQLException e) {
			e.printStackTrace();;
		}

	}

}
