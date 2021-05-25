/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Livre;
import com.model.User;

/**
 * @author BEN LAHMAR EL HABIB
 */
public interface IUser {

	public int addUser(User u);
	public int deleteUser(int id); 
	public List<User> allUsers();
	public User authentification(String log,String pass);
	
}
