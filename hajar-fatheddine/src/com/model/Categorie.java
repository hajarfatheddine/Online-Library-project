/**
 * 
 */
package com.model;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class Categorie {
int id;
String titre;


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


public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}




public Categorie() {
	super();
	// TODO Auto-generated constructor stub
}

public Categorie(int id, String titre) {
	super();
	this.id = id;
	this.titre = titre;

}


}
