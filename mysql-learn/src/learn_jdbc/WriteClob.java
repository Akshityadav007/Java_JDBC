package learn_jdbc;

import java.io.*;
import java.sql.*;

public class WriteClob{

	public static void main(String[] args) throws Exception{
		Connection myConn = null;
		PreparedStatement prepStmt = null;
		
		FileReader input = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			
			// insert candidate info to the column
			final String myStatement = "INSERT INTO clob " + "values " + "(001,23,'Akshit','Yadav',?)";
			prepStmt = myConn.prepareStatement(myStatement);
			
			//get the file
			File theFile = new File("sample_text");
			input = new FileReader(theFile);
			prepStmt.setCharacterStream(1,input);
			
			System.out.println("Reading input file: " + theFile.getAbsolutePath());
			
			// execute Statement
			System.out.println("\n Storing resume in database: " + theFile);
			System.out.println(myStatement);
			
			prepStmt.execute();
			System.out.println("\nCompleted Succefully!");
			
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
	}

}
