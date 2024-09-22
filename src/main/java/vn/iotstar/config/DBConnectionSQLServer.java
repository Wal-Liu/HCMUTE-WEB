package vn.iotstar.config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionSQLServer {
//	 private final String serverName = "localhost";
	 private final String serverName = "WALL-LIU";
	 private final String dbName = "WEB";
	 private final String portNumber = "1433";
	 private final String instance = "";
	 private final String userID= "sa";
	 private final String password= "123";
	 
	 public String getServername()
	 {
		 return this.serverName;
	 }

//Kết nối SQL Server với Windows Authentication
	 public Connection getConnection() throws Exception {
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
			if (instance == null || instance.trim().isEmpty())
				url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			return DriverManager.getConnection(url, userID, password);
		}

public static void main(String[] args) {
	 try {
	 System.out.println(new DBConnectionSQLServer().getConnection());
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }
}