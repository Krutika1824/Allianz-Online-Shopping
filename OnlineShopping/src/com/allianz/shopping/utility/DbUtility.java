package com.allianz.shopping.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtility {
	
	public static Connection getConnection() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?serverTimezone=UTC","root","");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}

}
