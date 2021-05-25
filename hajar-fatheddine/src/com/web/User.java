package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.dao.LivreDao;
import com.dao.UserDao;

/**
 * Servlet implementation class Livre
 */
@WebServlet({ "/User"  })
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao um;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		um=new UserDao();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		
		HttpSession ses = request.getSession(false);
		com.model.User u=(com.model.User) ses.getAttribute("user");
		
		out.print("<h3>Bonjour : "+u.getLog()+"</h3>");
		out.print("<h1>Gestion des utilisateurs</h1>");
		
		out.print("<form action='serveU' method='post'> <table>");
		out.print("<tr><td>Login:</td><td><input type='text' name='login' required/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='passsword' name='password' required/></td></tr>");
		out.print("<tr><td>Role:</td><td><input type='text' name='role' required/></td></tr>");
		out.print("<tr><td><input type='submit' value='Ajouter' name='action'/><td/><td><input type='reset' value='Annuler' name='add'/></td></tr>");
		out.print("</table><form>");
		out.print("<hr/>");
		
		List<com.model.User> us = um.allUsers();
		out.print("<table width='80%' bgcolor='gold' biorder='2px'>");
				
		out.print("<tbody>"); 
			out.print("<tr>");
			out.print("<td>ID</td>");
			out.print("<td>Login</td>");
			out.print("<td>Password</td>");
			out.print("<td>Role</td>");	
			out.print("</tr>");
		out.print("</tbody>"); 
		out.print("<tbody>");
			
		for (com.model.User u2 : us) {
			out.print("<tr>");
			out.print("<td>"+u2.getId()+"</td>");
			out.print("<td>"+u2.getLog()+"</td>");
			out.print("<td>"+u2.getPass()+"</td>");
			out.print("<td>"+u2.getRole()+"</td>");
			out.print("<td><a href='serveU?op=delete&id="+u2.getId()+"'>delete</a></td>");
			out.print("</tr>");
		}
		out.print("</tbody>");
		out.print("</table");
	}

}
