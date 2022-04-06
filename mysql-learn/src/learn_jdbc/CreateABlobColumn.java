package learn_jdbc;

import java.sql.*;

public class CreateABlobColumn{

	public static void main(String[] args){
		Connection myConn = null;
		Statement myStmt = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		final String dropQuery = "DROP TABLE IF EXISTS candidate";
		final String createTableQuery = "CREATE TABLE candidate(id int NOT NULL,age int,first_name varchar(255),last_name varchar(255),resume LONGBLOB,PRIMARY KEY (id))";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(dropQuery);
			int rowsAffected = myStmt.executeUpdate(createTableQuery);
				System.out.println("Table created successfully!\n" + rowsAffected +" rows Affected.");
			
		}
		catch (SQLException e) {
			e.printStackTrace();;
		}
	}

}
