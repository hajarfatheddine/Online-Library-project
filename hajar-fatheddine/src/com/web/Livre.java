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
import com.model.User;


/**
 * Servlet implementation class Livre
 */
@WebServlet({ "/Livre"  })
public class Livre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	LivreDao lm;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Livre() {
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
		User u=(User) ses.getAttribute("user");
		
		out.print("<h3>Bonjour : "+u.getLog()+"</h3>");
		out.print("<h1>Gestion de livres</h1>");
		
		out.print("<form action='serveL' method='post'> <table>");
		out.print("<tr><td>Titre:</td><td><input type='text' name='titre' required/></td></tr>");
		out.print("<tr><td>Quantite:</td><td><input type='number' name='quantite' required/></td></tr>");
		out.print("<tr><td>Auteur:</td><td><input type='text' name='auteur' required/></td></tr>");
		out.print("<tr><td>Categorie:</td><td><input type='text' name='categorie' required/>  math, physique, chimie, informatique</td></tr>");
		out.print("<tr><td><input type='submit' value='Ajouter' name='action'/><td/><td><input type='reset' value='Annuler' name='add'/></td></tr>");
		out.print("</table><form>");
		out.print("<hr/>");
		
		String categorie = (String) request.getAttribute("categorie");
				
		List<com.model.Livre> ls= lm.allLivreByCategorie(categorie);
				
		out.print("<table width='80%' bgcolor='gold' biorder='2px'>");
		
		out.print("<tbody>"); 
			out.print("<tr>");
			out.print("<td>ID</td>");
			out.print("<td>Titre</td>");
			out.print("<td>Quantite</td>");
			out.print("<td>Auteur</td>");
			out.print("<td>Categorie</td>");
			out.print("</tr>");
		out.print("</tbody>"); 
	
		out.print("<tbody>");
		for (com.model.Livre l : ls) {
			out.print("<tr>");
			out.print("<td>"+l.getId()+"</td>");
			out.print("<td>"+l.getTitre()+"</td>");
			out.print("<td>"+l.getQuantite()+"</td>");
			out.print("<td>"+l.getAuteur()+"</td>");
			out.print("<td>"+l.getCategorie()+"</td>");
			out.print("<td><a href='serveL?op=delete&id="+l.getId()+"'>delete</a></td>");
			out.print("</tr>");
		}
		out.print("</tbody>");
		out.print("</table");
	}

}
