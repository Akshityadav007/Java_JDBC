package reading_config_from_properties_file;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class CreateTableFromPropertiesFile {
	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet rs = null;

		final String dropQuery = "DROP TABLE IF EXISTS test";
		final String createTableQuery = "CREATE TABLE test(id int NOT NULL,age int,first varchar(255),last varchar(255),PRIMARY KEY (id))";
	      
	   try {	
		   
		   		Properties props = new Properties();
		   		String filePath = "/home/akshit/eclipse-workspace/mysql-learn/src/reading_config_from_properties_file/config.properties";
		   		props.load(new FileInputStream(filePath));
		   		
		   		final String theDbUrl = props.getProperty("dbUrl");
		 	    final String theUser = props.getProperty("username");
		 	    final String thePass = props.getProperty("password");
		 	    
		 	    System.out.println("Connecting to database... ");
		 	    System.out.println("Database URL: " + theDbUrl);
		 	    System.out.println("User: "+ theUser);
		   		
			   myConn = DriverManager.getConnection(theDbUrl, theUser, thePass);
			   		System.out.println("Database Connection Successful!");
		       myStmt = myConn.createStatement();
			myStmt.executeUpdate(dropQuery);
				int rowsAffected = myStmt.executeUpdate(createTableQuery);
					System.out.println("Table created successfully!\n" + rowsAffected +" rows Affected.");
		   
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	   finally {
			if(rs!=null) {
				rs.close();
			}
	   }
}
}
