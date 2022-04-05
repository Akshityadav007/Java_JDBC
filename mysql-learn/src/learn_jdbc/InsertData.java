package learn_jdbc;
import java.sql.*;

public class InsertData {
	
	public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet res = null;
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		final String insertQuery1 = "INSERT INTO test " + "(id,age,first,last) " + "values " + "(101,29,'Amar','Singh')";
		final String insertQuery2 ="INSERT INTO test " + "(id,age,first,last) " + "values " + "(102,20,'Aditya','Sachan')";
		final String insertQuery3 ="INSERT INTO test " + "(id,age,first,last) " + "values " + "(103,18,'Gaurav','Pal')";
		final String insertQuery4 ="INSERT INTO test " + "(id,age,first,last) " + "values " + "(104,29,'Indrasen','Yadav')";
		final String insertQuery5 ="INSERT INTO test " + "(id,age,first,last) " + "values " + "(105,30,'Akshay','Singh')";
		final String showQuery = "SELECT * FROM test";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(insertQuery1);
			myStmt.executeUpdate(insertQuery2);
			myStmt.executeUpdate(insertQuery3);
			myStmt.executeUpdate(insertQuery4);
			myStmt.executeUpdate(insertQuery5);
			res = myStmt.executeQuery(showQuery);
			
			// display results
			System.out.println("Updated Result:");
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
