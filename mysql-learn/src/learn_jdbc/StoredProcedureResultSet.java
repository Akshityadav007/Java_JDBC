package learn_jdbc;

import java.sql.*;

public class StoredProcedureResultSet {

	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet res = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		
		final String callQuery = "{call get_details_of(?)}";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
			myStmt = myConn.prepareCall(callQuery);			
			
			myStmt.setInt(1, 20);	// prints details of people with age greater than 20
			myStmt.execute();
			
			res = myStmt.getResultSet();
			System.out.println("Stored Procedure called successfully!");
			System.out.println("The details are:");
			
			
			while(res.next()) {
				System.out.print("ID: " + res.getInt("id"));
	            System.out.print(", Age: " + res.getInt("age"));
	            System.out.print(", First: " + res.getString("first"));
	            System.out.println(", Last: " + res.getString("last"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();;
		}
		finally {
			if(res!=null) {
				res.close();
			}
		}

	}

}
