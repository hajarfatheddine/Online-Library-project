/**
 * 
 */
package com.model;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Livre {

	int id;
	String titre;
	int quantite;
	String auteur;
	String categorie;
	int idc;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}
	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public int getIdc() {
		return idc;
	}
	
	public void setIdc(int idc) {
		this.idc = idc;
	}
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livre(int id, String titre, int quantite, String auteur, String categorie, int idc) {
		super();
		this.id = id;
		this.titre = titre;
		this.quantite = quantite;
		this.auteur = auteur;
		this.categorie =categorie;
		this.idc = idc;
	}
	
	
}
