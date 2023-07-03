package com.dht.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JdbcUtils {
	public static Connection getConnection() {
		  Connection c =null;
		  
		
		  try {
			DriverManager.registerDriver( new com.mysql.jdbc.Driver());
		
			
			 String url="jdbc:mySQL://localhost:3306/ontap";
			 String username="root";
			 String password="";
			 
			 c= DriverManager.getConnection(url,username,password);
		  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return c;

    } 
}