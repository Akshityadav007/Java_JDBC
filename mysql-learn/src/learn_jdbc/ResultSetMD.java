package learn_jdbc;

import java.sql.*;

public class ResultSetMD {

	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet res = null;
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		final String myQuery = "SELECT * FROM test";
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
				
			// run query to get result set from the table
			myStmt = myConn.createStatement();
			res = myStmt.executeQuery(myQuery);
			
			
			ResultSetMetaData resMetaData = res.getMetaData(); // get result set metadata
			
			//display info
			int columnCount = resMetaData.getColumnCount();
			System.out.println("Column count: " + columnCount + "\n");
			
			for(int i = 1;i <= columnCount;i++) {
				System.out.println("Column name: " + resMetaData.getColumnName(i));
				System.out.println("Column type name: " + resMetaData.getColumnTypeName(i));
				System.out.println("Is Nullable: " + resMetaData.isNullable(i));
				System.out.println("Is Auto Increment: " + resMetaData.isAutoIncrement(i));
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
