package com.crea.dev1.jee.ecole.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.crea.dev1.jee.ecole.model.beans.Eleve;
import com.crea.dev1.jee.ecole.model.beans.UV;
import com.crea.dev1.jee.ecole.model.common.DBAction;

public class UVDAO {
	
	/**
	 * Liste un code  en particulier d'après son identifiant passé en paramètre de la fonction.
	 * @param code
	 * @return : retourne l'objet ElevTemp 
	 * @throws SQLException
	 */
	
	public static UV getUvByCode(String code) throws SQLException 
	{
		UV uvTemp = new UV();
		String req = "SELECT * FROM uv WHERE code = \'"+code+"\'";
		// Retourner l'objet ElevTemp
		DBAction.DBConnexion();
		//Execution de la requete
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			uvTemp.setCode(DBAction.getRes().getString(1));
			uvTemp.setNbh(DBAction.getRes().getInt(2));
			uvTemp.setCoord(DBAction.getRes().getString(3));
			uvTemp.affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		//Retourner l'eleveTemp
		return uvTemp;
	}
	
	/**
	 * Selection uv (s) par le coord
	 * @param coord
	 * @return :un liste uv  
	 */
	
	public static ArrayList<UV> getUvByCoord(String coord) throws SQLException 
	{
		//Création de ma liste d'uv partageant la le même coord
		ArrayList<UV> listUvCoord = new ArrayList<UV>();
		// TO DO
		String req = "SELECT * FROM uv WHERE coord = \'"+coord+"\'";
		
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			UV uvTemp = new UV();
			
			//Creation de l'objet
			uvTemp.setCode(DBAction.getRes().getString(1));
			uvTemp.setNbh(DBAction.getRes().getInt(2));
			uvTemp.setCoord(DBAction.getRes().getString(3));
			
			listUvCoord.add(uvTemp);
		}
		
		for (int i = 0; i<listUvCoord.size(); i++) {
			listUvCoord.get(i).affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		// Retourner l'objet ElevTemp
		return listUvCoord;
	}
	
	/**
	 * Delete uv par un code
	 * @param code
	 * @return : 1 ou 0  (le nbr d'�tudiants supprim�s) sinon le (-) code d'erreur  
	 */
	
	public static int deleteUvByCode(String code) {
		int result = -1;
		
		DBAction.DBConnexion();
		String req = "DELETE FROM uv WHERE code = \'"+code+"\'";
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
	 * Met à jour de le nombre d'heure un uv par son code
	 * @param nbh code
	 * @return : 1 ou 0  (le nbr d'�tudiants mis � jour) sinon le (-) code d'erreur  
	 */
	
	public static int updNbhUvByCode(int nbh,String code) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE uv SET nbh = '"+nbh+"'  WHERE code = \'"+code+"\'";
		
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
	 * Ajouter un uv
	 * @param String code, int nbh, String coord
	 * @return : 1 ou 0  (le nbr d'�tudiants ajout�) sinon le (-) code d'erreur   
	 */
	public static int addUv(String code,int nbh, String coord) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "INSERT INTO uv(code, nbh ,coord)"+"VALUES ('"+code+"',0,'"+coord+"')";
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
	 * @return : la liste de tous les uv.
	 */
	public static ArrayList<UV> getAllUv() throws SQLException 
	{
		return null;

	}

}
