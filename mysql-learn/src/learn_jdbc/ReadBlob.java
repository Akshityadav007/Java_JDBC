package learn_jdbc;

import java.io.*;
import java.sql.*;

public class ReadBlob{

	public static void main(String[] args) throws Exception{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet res = null;
		
		InputStream input = null;
		FileOutputStream output = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			
			// get the Result set from the table
			myStmt = myConn.createStatement();
			final String myQuery = "SELECT resume FROM candidate where id = 1";
			res = myStmt.executeQuery(myQuery);
			
			//get the file
			File theFile = new File("resume_from_db.pdf");
			output = new FileOutputStream(theFile);
			
			if(res.next()) {
				input = res.getBinaryStream("resume");
				System.out.println("Reading resume from database... ");
				System.out.println(myQuery);
				
				 byte[] buffer = new byte[60000];
				 while(input.read(buffer) > 0) {
					 output.write(buffer);
				 }
				 
				 System.out.println("\n Saved to file: " + theFile.getAbsolutePath());
				 System.out.println("\nCompleted Successfully!");
				
			}
			
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if(input!=null) {
				input.close();
			}
			if(output!=null) {
				output.close();
			}
		}
	}

}
