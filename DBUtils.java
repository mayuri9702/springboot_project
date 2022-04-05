package com.citi.ex.utils;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
	
	public static void main(String[] args) {
		System.out.println(getConnection()!=null);
	}
	
	public static Connection getConnection() {
		Connection connection=null;
		Properties properties=readProperties();
		
		try {
		connection=DriverManager.getConnection(properties.getProperty("db.url"),
						properties.getProperty("db.username"),
						properties.getProperty("db.password"));
		return connection;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static Properties readProperties() {
		InputStream inputStream=DBUtils.class.getResourceAsStream("/application.properties");
		
		Properties properties=new Properties();
		
		try {
			properties.load(inputStream);
		    System.out.println(properties);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	}