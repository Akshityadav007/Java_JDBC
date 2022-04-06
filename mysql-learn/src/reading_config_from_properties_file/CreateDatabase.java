package reading_config_from_properties_file;
import java.sql.*;

public class CreateDatabase {

	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet rs = null;
		
	   final String dbUrl = "jdbc:mysql://localhost/";
	   final String user = "akshit";
	   final String pass = "akshit";
	   final String myQuery = "CREATE DATABASE IF NOT EXISTS new";
	      
	   try {	   
			   myConn = DriverManager.getConnection(dbUrl, user, pass);
			   		System.out.println("Database Connection Successful!");
		       myStmt = myConn.createStatement();
		       myStmt.executeUpdate(myQuery);
		   
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
