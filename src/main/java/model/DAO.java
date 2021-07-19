package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	
		ResultSet resultSet;
		Connection connection;
		PreparedStatement statement;
		
		private static final String DATABASE = "dbavaliacao?serverTimeZone=UTC";
		private static final String USER 	 = "root";
		private static final String PASS     = "nordeste";
		private static final String DRIVER   = "com.mysql.cj.jdbc.Driver";
		private static final String URL      = "jdbc:mysql://localhost:3306/";
		
		
	
	
	public void open() throws Exception {
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL+DATABASE, USER, PASS);
	}
	
	public void close() throws Exception {
		if(!connection.isClosed()) {
			connection.close();
		}
	}

}
