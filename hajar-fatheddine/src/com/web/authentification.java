package com.web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.model.User;

/**
 * Servlet implementation class authentification
 */
@WebServlet("/authentification")
public class authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao um;
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    //appelee juste apres l instanciation de la servlet
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		um=new UserDao(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String log=request.getParameter("log");
		String pass=request.getParameter("pass");
				
		//System.out.println(log);
		
		User u = um.authentification(log, pass);
		if(u!=null)
		{
			HttpSession ses = request.getSession(true);
			ses.setAttribute("user", u);
			
			if(u.getRole().equalsIgnoreCase("admin"))
			{
			
				response.sendRedirect("op-admin.jsp");
			} else
			{
			
				response.sendRedirect("op-user.jsp");
			}			
			
		} else
		{
			
			request.setAttribute("msg", "Login ou password incorrect");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
			//response.sendRedirect("index.jsp");
			//cette methode ne passe request et par suite le message msg
			
		}
	}

}
