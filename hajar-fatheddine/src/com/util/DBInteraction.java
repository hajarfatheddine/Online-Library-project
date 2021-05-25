	/**
 * 
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class DBInteraction {

	private static Connection conn;
	private static Statement stat;
	
	public static void connect()
	{
		
		try {
			//chrgement du pilote
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bibliot";  
			//etablissement de la connection
			conn=DriverManager.getConnection(url, "root", "hajar");
			 
			//creation du statement
			stat=conn.createStatement();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void disconnect()
	{
		try {
			
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int Maj(String sql)
	{
		int nb=0;
		try {
			nb=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nb;
	}
	
	public static ResultSet select(String sql)
	{
		ResultSet rs=null;
		try {
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
