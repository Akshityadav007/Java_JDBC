package learn_jdbc;
import java.sql.*;

public class UpdateData {
	
	public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet res = null;
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		final String updateQuery = "Update test " + "SET age = 30,first = 'Rohan',last ='Rathore' " + "WHERE id = 105";
		final String showQuery = "SELECT * FROM test";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(updateQuery);
			res = myStmt.executeQuery(showQuery);
			
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
