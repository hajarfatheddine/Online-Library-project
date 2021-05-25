/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Livre;
import com.util.DBInteraction;

/**
 * @author BEN LAHMAR EL HABIB
 *
 */
public class LivreDao implements ILivre {

	@Override
	public int addLivre(Livre l) {
		
		DBInteraction.connect();
		String sql="insert into Livre (titre,quantite,auteur,categorie,idc) values('"+l.getTitre()+"',"+l.getQuantite()+",'"+l.getAuteur()+"','"+l.getCategorie()+"',"+l.getIdc()+")";		
		int nb=DBInteraction.Maj(sql);
		return nb; 
	}
	
	@Override
	public int deleteLivre(int id) {
		DBInteraction.connect(); 
		int nb=DBInteraction.Maj("delete from Livre where idl="+id);
		DBInteraction.disconnect();
		return nb;
	}
	
	@Override
	public int reserveLivre(int id) {
		DBInteraction.connect();
		Livre l=findLivreById(id);
		int q=l.getQuantite()-1;
		int nb=DBInteraction.Maj("update Livre set quantite = '"+Integer.toString(q)+"' where idl="+id);
		DBInteraction.disconnect();
		return nb;
		
	}

	@Override
	public Livre findLivreById(int id) {
		Livre l=null;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from Livre where idl="+id);
		try {
			if(rs.next())
			{
				l=new Livre(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public Livre findLivreByCategorie(String categorie) {
		Livre l=null;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from Livre where categorie="+"'"+categorie+"'");
		try {
			if(rs.next())
			{
				l=new Livre(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public int findIdCategorie(String categorie) {
		int i=0;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select idc from Livre where categorie="+"'"+categorie+"'");
		try {
			if(rs.next())
			{
				i= rs.getInt(1);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	@Override
	public List<Livre> allLivreByCategorie(String categorie) {
		
		List<Livre>  Livres=new ArrayList<Livre>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from Livre where categorie = "+"'"+categorie+"'");
		try {
			while(rs.next())
			{
				Livre l=new Livre(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6));
				Livres.add(l);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Livres;
	}

	@Override
	public List<Livre> allLivreByAuteur(String auteur) {
		
		List<Livre>  Livres=new ArrayList<Livre>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.select("select * from Livre where auteur = "+"'"+auteur+"'");
		try {
			while(rs.next())
			{
				Livre l=new Livre(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6));
				Livres.add(l);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Livres;
	}

}
