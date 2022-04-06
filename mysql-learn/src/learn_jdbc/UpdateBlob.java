package learn_jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

public class UpdateBlob{

	public static void main(String[] args) throws Exception{
		Connection myConn = null;
		PreparedStatement prepStmt = null;
		
		FileInputStream input = null;
		
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			
			// update candidate info to the column
			final String myStatement = "UPDATE candidate SET resume = ? WHERE first_name = 'Akshit'";
			prepStmt = myConn.prepareStatement(myStatement);
			
			//get the file
			File theFile = new File("Akshit's_Resume.pdf");
			input = new FileInputStream(theFile);
			prepStmt.setBinaryStream(1,input);
			
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
