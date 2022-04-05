package learn_jdbc;

import java.sql.*;

public class PrepStatement {

	public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet res = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		
		final String prepQuery = "SELECT * FROM test where age > ?";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			myStmt = myConn.prepareStatement(prepQuery);
			myStmt.setInt(1,20);
			
			//execute SQL query
			res = myStmt.executeQuery();
			
			// display results
			System.out.println("Updates Result:");
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
