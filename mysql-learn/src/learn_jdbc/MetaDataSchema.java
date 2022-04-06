package learn_jdbc;

import java.sql.*;

public class MetaDataSchema {

	public static void main(String[] args) throws SQLException{
		Connection myConn = null;
		ResultSet res = null;
		
		final String dbUrl = "jdbc:mysql://localhost/test";
		final String user = "akshit";
		final String pass = "akshit";
		String catalog = null;
		String schemaPattern = null;
		String tableNamePattern = null;
		String columnNamePattern = null;
		String[] types = null;
		try {
			myConn = DriverManager.getConnection(dbUrl,user,pass);
				System.out.println("Database Connection Successful!");
				
			DatabaseMetaData dbMetaData = myConn.getMetaData(); // get metadata
			
			// get list of tables
			
			System.out.println("List of Tables");
			System.out.println("--------------");
			
			res = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
			while(res.next()) {
				System.out.println(res.getString("TABLE_NAME"));
			}
			
			// get list of columns
			System.out.println("\n\n List of Columns");
			System.out.println("----------------");
			
			res = dbMetaData.getColumns(catalog, schemaPattern, "test", columnNamePattern);
			while(res.next()) {
				System.out.println(res.getString("COLUMN_NAME"));
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
