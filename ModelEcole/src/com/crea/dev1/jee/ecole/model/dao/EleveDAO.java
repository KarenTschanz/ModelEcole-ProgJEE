package com.crea.dev1.jee.ecole.model.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import com.crea.dev1.jee.ecole.model.beans.Eleve;
import com.crea.dev1.jee.ecole.model.common.DBAction;


public class EleveDAO 
{
	/**
	 * Liste un �l�ve en particulier d'apr�s son identifiant pass� en param�tre de la fonction.
	 * @param num
	 * @return : retourne l'objet ElevTemp 
	 * @throws SQLException
	 */
	
	public static Eleve getEleveByNum(String num) throws SQLException 
	{
		Eleve elevTemp = new Eleve();
		String req = "SELECT * FROM eleve WHERE num = \'"+num+"\'";
		// Retourner l'objet ElevTemp
		DBAction.DBConnexion();
		//Execution de la requete
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			elevTemp.affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		//Retourner l'eleveTemp
		return elevTemp;
	}
	
	/**
	 * Selection d'Eleve(s) par le nom
	 * @param nom
	 * @return :un liste d'eleve  
	 */
	public static ArrayList<Eleve> getEleveByNom(String nom) throws SQLException 
	{
		//Cr�ation de ma liste d'�l�ve partageant la m�me chambre
		ArrayList<Eleve> listEleveNom = new ArrayList<Eleve>();
		// TO DO
		String req = "SELECT * FROM eleve WHERE nom = \'"+nom+"\'";
		
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			Eleve elevTemp = new Eleve();
			
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			
			listEleveNom.add(elevTemp);
		}
		
		for (int i = 0; i<listEleveNom.size(); i++) {
			listEleveNom.get(i).affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		// Retourner l'objet ElevTemp
		return listEleveNom;
	}
	
	/**
	 * Selection d'1 ou +sieurs Eleve par son num�ro de chambre
	 * @param no
	 * @return :un objet eleve
	 */
	public static ArrayList<Eleve> getEleveByNo(int no) throws SQLException 
	{ 
		//Cr�ation de ma liste d'�l�ve partageant la m�me chambre
		ArrayList<Eleve> listEleveNo = new ArrayList<Eleve>();
		
		String req = "SELECT * FROM eleve WHERE no = \'"+no+"\'";
		
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			Eleve elevTemp = new Eleve();
			
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			
			listEleveNo.add(elevTemp);
		}
		
		for (int i = 0; i<listEleveNo.size(); i++) {
			listEleveNo.get(i).affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		// Retourner l'objet ElevTemp
		return listEleveNo;
	}
	
	/**
	 * Delete Eleve par un num�ro
	 * @param num
	 * @return : 1 ou 0  (le nbr d'�tudiants supprim�s) sinon le (-) code d'erreur  
	 */
	public static int deleteEleveByNum(String num) {
		int result = -1;
		
		DBAction.DBConnexion();
		String req = "DELETE FROM eleve WHERE num = \'"+num+"\'";
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
	 * Met � jour de l'adresse d'un �l�ve par son num�ro
	 * @param num
	 * @return : 1 ou 0  (le nbr d'�tudiants mis � jour) sinon le (-) code d'erreur  
	 */
	public static int updAdresseEleveByNum(String num,String adresse) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE eleve SET adresse = '"+adresse+"'  WHERE num = \'"+num+"\'";
		
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
	 * Met � jour(Attribuer une chambre � 1 �l�ve) le n� de chambre � un �l�ve
	 * @param num
	 * @return : 1 ou 0  (le nbr d'�tudiants mis � jour) sinon le (-) code d'erreur  
	 */
	public static int updNoChambreEleveByNum(int no,String num) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "UPDATE eleve SET no = '"+no+"'  WHERE num = \'"+num+"\'";
		
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
	 * Ajouter un �l�ve
	 * @param String num, String nom, int age, String adresse
	 * @return : 1 ou 0  (le nbr d'�tudiants ajout�) sinon le (-) code d'erreur   
	 */
	public static int addEleve(String num,String nom, int age, String adresse) 
	{
		int result = -1;
		DBAction.DBConnexion();
		String req = "INSERT INTO eleve(num, no,nom,age,adresse)"+"VALUES ('"+num+"',NULL,'"+nom+"',"+age+", '"+adresse+"')";
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
	 * Renvoie une liste d'�l�ves en fonction de l'age.
	 * @param anneeNaissance : Date de naissance de(s) l'�l�ve(s)(l'ann�e)
	 * @return : 1 liste d'�l�ve ayant le m�me age. 
	 */
	public static ArrayList<Eleve> getListEleveByDateN(int anneeNaissance) throws SQLException
	{
		ArrayList<Eleve> listEleveAnneeNaissance = new ArrayList<Eleve>();
		int age = LocalDate.now().getYear() - anneeNaissance;
		
		String req = "SELECT * FROM eleve WHERE age = \'"+age+"\'";
		
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			Eleve elevTemp = new Eleve();
			
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			
			listEleveAnneeNaissance.add(elevTemp);
		}
		
		for (int i = 0; i<listEleveAnneeNaissance.size(); i++) {
			listEleveAnneeNaissance.get(i).affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return listEleveAnneeNaissance;
		
	}
	/**
	 * @param aucun
	 * @return : la liste de tous les �l�ves .
	 */
	public static ArrayList<Eleve> getAllEleve() throws SQLException 
	{
		
		ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		
		String req = "SELECT * FROM eleve ";
		
		DBAction.DBConnexion();
		
		DBAction.setRes(DBAction.getStm().executeQuery(req));
		
		while( DBAction.getRes().next() )
		{
			//Creation de l'objet
			Eleve elevTemp = new Eleve();
			
			elevTemp.setNum(DBAction.getRes().getString(1));
			elevTemp.setNo(DBAction.getRes().getInt(2));
			elevTemp.setNom(DBAction.getRes().getString(3));
			elevTemp.setAge(DBAction.getRes().getInt(4));
			elevTemp.setAdresse(DBAction.getRes().getString(5));
			
			listEleve.add(elevTemp);
		}
		
		for (int i = 0; i<listEleve.size(); i++) {
			listEleve.get(i).affiche();
		}
		
		//Fermeture de la connexion
		DBAction.DBClose();
		
		return listEleve;
	}
}