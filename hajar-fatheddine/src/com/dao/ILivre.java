/**
 * 
 */
package com.dao;

import java.util.List;

import com.model.Livre;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public interface ILivre {

	public int addLivre(Livre l);
	public int deleteLivre(int id); 
	public int reserveLivre(int id);
	public Livre findLivreById(int id);
	public int findIdCategorie(String categorie);
	public Livre findLivreByCategorie(String categorie);
	public List<Livre> allLivreByAuteur(String auteur);
	public List<Livre> allLivreByCategorie(String categorie);
	
}
