/**
 * 
 */
package com.util;

import com.dao.LivreDao;
import com.model.Livre;

import com.dao.UserDao;
import com.model.User;

/**
 * @author BEN LAHMAR EL HABIB
 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LivreDao lm=new LivreDao();
		Livre l=new Livre(1,"Mathfacile", 40,"prof-x","math",1);
				
		int nb=lm.addLivre(l);
		System.out.println(nb +" linges ajout�es");
		
		UserDao um=new UserDao();
		User u=new User(3,"ahmed","1234","etudiant");
				
		nb=um.addUser(u);
		System.out.println(nb +" linges ajout�es");
		
	}

}
