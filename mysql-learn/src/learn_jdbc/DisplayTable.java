package learn_jdbc;
import java.sql.*;

public class DisplayTable {
	
	public static void main(String[] args) throws SQLException{
		
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet rs = null;
			
		   final String dbUrl = "jdbc:mysql://localhost/test";
		   final String user = "akshit";
		   final String pass = "akshit";
		   final String myQuery = "SELECT * FROM test";
		      
		   try {	   
				   myConn = DriverManager.getConnection(dbUrl, user, pass);
				   		System.out.println("Database Connection Successful!");
			       myStmt = myConn.createStatement();
			       rs = myStmt.executeQuery(myQuery);
			   
			         while (rs.next()) {
			            System.out.print("ID: " + rs.getInt("id"));
			            System.out.print(", Age: " + rs.getInt("age"));
			            System.out.print(", First: " + rs.getString("first"));
			            System.out.println(", Last: " + rs.getString("last"));
			         }
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		   finally {
				if(rs!=null) {
					rs.close();
				}
			}
	}
}
