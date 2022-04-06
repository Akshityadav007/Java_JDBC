package learn_jdbc;

import java.io.*;
import java.sql.*;

public class ReadClob{

	public static void main(String[] args) throws Exception{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet res = null;
		
		Reader input = null;
		FileWriter output = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			
			// get the Result set from the table
			myStmt = myConn.createStatement();
			final String myQuery = "SELECT clobText FROM clob where id = 1";
			res = myStmt.executeQuery(myQuery);
			
			//get the file
			File theFile = new File("sample_text_from_db");
			output = new FileWriter(theFile);
			
			if(res.next()) {
				input = res.getCharacterStream("clobText");
				System.out.println("Reading text file from database... ");
				System.out.println(myQuery);
				
				 int theChar;
				 while((theChar = input.read()) > 0) {
					 output.write(theChar);
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
