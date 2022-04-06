package learn_jdbc;
import java.sql.*;
import java.util.Scanner;

public class Transactions {

	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet res = null;
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		final String insertQuery = "INSERT INTO test " + "(id,age,first,last) " + "values " + "(106,32,'Akhil','Chopra')";
		final String showQuery = "SELECT * FROM test";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
			myConn.setAutoCommit(false);  // set auto-commit false
			
			myStmt = myConn.createStatement();
			myStmt.executeUpdate(insertQuery);		
			
			boolean ok = askUserIfOkToSave();
			if(ok) {
				myConn.commit();
				System.out.println("Transaction has been completed successfully!");
			}
			else {
				myConn.rollback();
				System.out.println("Transaction has been cancelled!");
			}
			
			
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
	
	static boolean askUserIfOkToSave() {
		boolean save = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to save.\nPress 0 to cancel: ");
		int s = sc.nextInt();
		if(s == 1)
			save = true;
		sc.close();
		return save;
	}

}
