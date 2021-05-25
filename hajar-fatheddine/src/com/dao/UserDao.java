/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Livre;
import com.model.User;
import com.util.DBInteraction;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class UserDao implements IUser{

	@Override
	public int addUser(User u) {
		DBInteraction.connect();
		String sql="insert into User (login,password,role) values('"+u.getLog()+"','"+u.getPass()+"',"+"'etudiant')";
		int nb=DBInteraction.Maj(sql); 
		DBInteraction.disconnect();
		return nb;
	}
	
	@Override
	public int deleteUser(int id) {
		DBInteraction.connect();
		int nb=DBInteraction.Maj("delete from User where idu="+id);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public List<User> allUsers() {
		
		List<User>  Users=new ArrayList<User>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from User");
		try {
			while(rs.next())
			{
				User u=new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
				Users.add(u);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Users;
	}
	
	@Override
	public User authentification(String log, String pass) {
		User u=null;
		DBInteraction.connect();
		String sql="select * from User where login='"+log+"' and password='"+pass+"'";
		//System.out.println(sql);
		ResultSet rs = DBInteraction.select(sql);
		try {
			if(rs.next())
			{
				u=new User();
				u.setId(rs.getInt(1));
				u.setLog(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setRole(rs.getString(4));
			
				//ou
				//u=new User(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return u;
	}

}
