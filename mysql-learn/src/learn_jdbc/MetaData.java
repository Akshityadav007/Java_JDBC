package learn_jdbc;

import java.sql.*;

public class MetaData {

	public static void main(String[] args) {
		Connection myConn = null;
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
				
			DatabaseMetaData dbMetaData = myConn.getMetaData(); // get metadata
			
			// display info about db
			
			System.out.println("Product name: " +dbMetaData.getDatabaseProductName());
			System.out.println("Product version: " +dbMetaData.getDatabaseProductVersion());
			
			// display info about JDBC driver

			System.out.println("JDBC driver name: " +dbMetaData.getDriverName());
			System.out.println("JDBC driver version: " +dbMetaData.getDriverVersion());
			
		}
		catch (SQLException e) {
			e.printStackTrace();;
		}

	}

}
