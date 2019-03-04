package com.crea.dev1.jee.ecole.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;


import com.crea.dev1.jee.ecole.model.beans.Livre;
import com.crea.dev1.jee.ecole.model.common.DBAction;
import java.util.Date;

public class LivreDAO {
	
	/**
	* Liste les livres par cote
	* @param cote
	* @return : retourner l'objet chamTemp
	* @throws SQLException
	*/
	
	public static Livre getLivreByCote(String cote) throws SQLException
	{
		Livre livreTemp = new Livre();
		String req = "SELECT * FROM livre WHERE cote = \'"+cote+"\'";
		// Retourner l'objet ElevTemp
		DBAction.DBConnexion();
		//Execution de la requete
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			
			livreTemp.setCote(DBAction.getRes().getString(1));
			livreTemp.setNum(DBAction.getRes().getString(2));
			livreTemp.setTitre(DBAction.getRes().getString(3));
			livreTemp.setDatepret(DBAction.getRes().getDate(4));
			livreTemp.affiche();
		}
		//Fermeture de la connexion
		DBAction.DBClose();
		//Retourner l'eleveTemp
		return livreTemp;
	}
	
	
	/**
	 * Selection Livre par le titre
	 * @param titre
	 * @return :un liste livre  
	 */
	public static ArrayList<Livre> getLivreByTitre(String titre) throws SQLException 
	{
		//Cr�ation de ma liste d'�l�ve partageant la m�me chambre
		ArrayList<Livre> listLivreTitre = new ArrayList<Livre>();
		// TO DO
		String req = "SELECT * FROM livre WHERE titre = \'"+titre+"\'";
		
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			Livre livreTemp = new Livre();
			
			livreTemp.setCote(DBAction.getRes().getString(1));
			livreTemp.setNum(DBAction.getRes().getString(2));
			livreTemp.setTitre(DBAction.getRes().getString(3));
			livreTemp.setDatepret(DBAction.getRes().getDate(4));
			
			listLivreTitre.add(livreTemp);
		}
		
		for (int i = 0; i<listLivreTitre.size(); i++) {
			listLivreTitre.get(i).affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		// Retourner l'objet ElevTemp
		return listLivreTitre;
	}
	
	/**
	 * Delete Livre par la cote
	 * @param cote
	 * @return : 1 ou 0  (le nbr d'�tudiants supprim�s) sinon le (-) code d'erreur  
	 */
	public static int deleteLivreByCote(String cote) {
		int result = -1;
		
		DBAction.DBConnexion();
		String req = "DELETE FROM livre WHERE cote = \'"+cote+"\'";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requête executee");
		}catch (SQLException ex){
			result = ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		System.out.println("["+req+"] Suppression");
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		// TO DO

		return result;
	}
	
	/**
	 * Mettre à jour le num du livre par la cote
	 * @param cote
	 * @return : 1 ou 0  (le nbr de livre mis à jour) sinon le (-) code d'erreur  
	 */
	public static int updNumLivreByCote(String num,String cote) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE livre SET num = '"+num+"'  WHERE cote = \'"+cote+"\'";
		
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requête executee");
		}catch (SQLException ex){
			result = ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		System.out.println("["+req+"] Update");
		
		//Fermeture de la connexion
		DBAction.DBClose();

		return result;
	}
	
	/**
	 * Mettre à jour la date du livre par le tire
	 * @param titre
	 * @return : 1 ou 0  (le nbr de livre mis à jour) sinon le (-) code d'erreur  
	 */
	public static int updDateLivreByTitre(Date datepret,String titre) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE eleve SET date = '"+datepret+"'  WHERE titre = \'"+titre+"\'";
		
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requête executee");
		}catch (SQLException ex){
			result = ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		System.out.println("["+req+"] Update");
		
		//Fermeture de la connexion
		DBAction.DBClose();
		return result;
	}
	
	
	
	/**
	 * Ajouter un livre
	 * @param String cote, String num, String titre, Date datepret
	 * @return : 1 ou 0  (le nbr de livres ajouté) sinon le (-) code d'erreur   
	 */
	public static int addLivre(String cote,String num, String titre, Date datepret) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "INSERT INTO livre(cite, num,titre,datepret)"+"VALUES ('"+cote+"','"+num+"',"+titre+", null)";
		try {
			result = DBAction.getStm().executeUpdate(req);
			System.out.println("Requête executee");
		}catch (SQLException ex){
			result = ex.getErrorCode();
			System.out.println(ex.getMessage());
		}
		System.out.println("["+req+"] Update");
		
		//Fermeture de la connexion
		DBAction.DBClose();
		//TO DO		
		return result;
	}
	
	
	/**
	 * @param aucun
	 * @return : la liste de tous les livres
	 */
	public static ArrayList<Livre> getAllLivre() throws SQLException 
	{
		
		ArrayList<Livre> listLivre = new ArrayList<Livre>();
		
		String req = "SELECT * FROM livre ";
		
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			Livre livreTemp = new Livre();
			
			livreTemp.setCote(DBAction.getRes().getString(1));
			livreTemp.setNum(DBAction.getRes().getString(2));
			livreTemp.setTitre(DBAction.getRes().getString(3));
			livreTemp.setDatepret(DBAction.getRes().getDate(4));
			
			listLivre.add(livreTemp);
		}
		
		for (int i = 0; i<listLivre.size(); i++) {
			listLivre.get(i).affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return listLivre;
	}
}
