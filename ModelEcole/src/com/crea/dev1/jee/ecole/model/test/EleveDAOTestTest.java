package com.crea.dev1.jee.ecole.model.test;

import java.sql.SQLException;

import com.crea.dev1.jee.ecole.model.dao.EleveDAO;

public class EleveDAOTestTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			EleveDAO.getEleveByNum("TAHAE002");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			EleveDAO.getEleveByNom("AGUE MAX");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			EleveDAO.getEleveByNo(4);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
//		EleveDAO.deleteEleveByNum("TABIS003");
		EleveDAO.updAdresseEleveByNum("AGUE001", "Ma petite adresse 2");
		EleveDAO.updNoChambreEleveByNum( 6, "LAURENCY004");
		
		EleveDAO.addEleve("POL008", "Claude Laugeau", 50, "62 rue Madame 72900");
		try {
			EleveDAO.getListEleveByDateN(1969);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// AFFicher toute la liste des élèves
		try {
			EleveDAO.getAllEleve();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
