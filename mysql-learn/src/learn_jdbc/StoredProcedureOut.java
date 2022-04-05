package learn_jdbc;

import java.sql.*;

public class StoredProcedureOut {

	public static void main(String[] args){
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		
		final String callQuery = "{call get_count_of_people(?)}";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
			myStmt = myConn.prepareCall(callQuery);			
			
			myStmt.registerOutParameter(1, Types.INTEGER);
			myStmt.execute();
			
			int count = myStmt.getInt(1);
			System.out.println("Stored Procedure called successfully!");
			System.out.println("There are " + count + " people.");
			
		}
		catch (SQLException e) {
			e.printStackTrace();;
		}

	}

}
