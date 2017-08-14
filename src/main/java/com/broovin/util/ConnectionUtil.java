package com.broovin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "reimburse";
		String password = "p4ssw0rd";
		OracleDriver driver = new OracleDriver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection(url, username, password);
	}
}