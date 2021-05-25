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
@WebServlet("/serveL")
public class serveL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       LivreDao lm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serveL() {
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
		lm.deleteLivre(id);
		response.sendRedirect("Livre");
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//recuperation du formulaire
		String titre=request.getParameter("titre");
		int quantite= Integer.parseInt(request.getParameter("quantite"));
		String auteur=request.getParameter("auteur");
		String categorie=request.getParameter("categorie");
				
		request.setAttribute("categorie", categorie);
		
		int idc = lm.findIdCategorie(categorie);
								
		Livre l=new Livre(0, titre, quantite, auteur,categorie,idc);
		lm.addLivre(l);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("Livre");
		dispatcher.forward(request, response);
		
	}

}
