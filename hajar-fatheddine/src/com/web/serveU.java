package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class serveL
 */
@WebServlet("/serveU")
public class serveU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao um;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serveU() {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		um.deleteUser(id);
		response.sendRedirect("User");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
			
		User u=new User(0,login, password, role);
		um.addUser(u);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("User");
		dispatcher.forward(request, response);
		
	}

}
