package com.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LivreDao;
import com.model.Livre;

/**
 * Servlet implementation class serveL
 */
@WebServlet("/serveParAut")
public class serveParAut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LivreDao lm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serveParAut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		lm=new LivreDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		lm.reserveLivre(id);
		response.sendRedirect("ParAut");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//recuperation du formulaire
		String auteur=request.getParameter("auteur");
				
		//retourner
		request.setAttribute("auteur", auteur);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("ParAut");
		dispatcher.forward(request, response);
		
	}

}
