package com.revature.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.OracleDriver;
public class Connecting {
	public static Connection getConnection() throws SQLException, IOException{

		String url = "jdbc:oracle:thin:@mydbinstance.cyai9rb3tqzc.us-east-2.rds.amazonaws.com:1521:ORCL";
		String user = "ataylor8294";
		String password = "ataylor8294";
		DriverManager.registerDriver(new OracleDriver());
		Connection connect = DriverManager.getConnection(url , user, password);
		return connect;
	}
}

