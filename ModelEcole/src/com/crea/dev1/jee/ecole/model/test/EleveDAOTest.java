package com.crea.dev1.jee.ecole.model.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.crea.dev1.jee.ecole.model.beans.Chambre;
import com.crea.dev1.jee.ecole.model.beans.Eleve;
import com.crea.dev1.jee.ecole.model.dao.ChambreDAO;
import com.crea.dev1.jee.ecole.model.dao.EleveDAO;

class EleveDAOTest {

	@Test
	void testGetEleveByNum() throws SQLException {
		Eleve e_ref = new Eleve("AGUE001",0,"AGUE MAX", 40,"av de jjeune 13");
		Eleve e_res = new Eleve();
		e_res = EleveDAO.getEleveByNum("AGUE001");
		assertEquals(e_ref.getAdresse(),e_res.getAdresse());
		assertEquals(e_ref.getAge(),e_res.getAge());
		assertEquals(e_ref.getNo(),e_res.getNo());
		assertEquals(e_ref.getNom(),e_res.getNom());
		assertEquals(e_ref.getNum(),e_res.getNum());
	}

	@Test
	void testGetEleveByNom() {
		ArrayList<Eleve> lstref = new ArrayList<Eleve> ();
		ArrayList<Eleve> lstresult = new ArrayList<Eleve> ();
		
		Eleve e_ref1 = new Eleve("AGUE001",0,"AGUE MAX", 40,"av de jjeune 13");
		Eleve e_ref2 = new Eleve("AGUE004",0,"AGUE MAX", 42,"av de Verdin 13");

		lstref.add(e_ref1);
		lstref.add(e_ref2);
		
		try {
			lstresult = EleveDAO.getEleveByNom("AGUE MAX");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	void testGetEleveByNo() {
		
		ArrayList<Eleve> lstref = new ArrayList<Eleve> ();
		ArrayList<Eleve> lstresult = new ArrayList<Eleve> ();
		
		Eleve e_ref1 = new Eleve("KAMTO005",4,"KAMTO Diogène", 50 ,"54 Rue des Ebisoires 78300 Poissy");
		Eleve e_ref2 = new Eleve("LAURENCY004",6,"LAURENCY Patrick", 52 ,"79 Rue des Poules 75015 Paris");

		lstref.add(e_ref1);
		lstref.add(e_ref2);
		

		try {
			lstresult = EleveDAO.getEleveByNo(4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i= 0;i<lstref.size();i++) {
			assertEquals(lstref.get(i).getAdresse(),lstresult.get(i).getAdresse());
			assertEquals(lstref.get(i).getAge(),lstresult.get(i).getAge());
			assertEquals(lstref.get(i).getNo(),lstresult.get(i).getNo());
			assertEquals(lstref.get(i).getNom(),lstresult.get(i).getNom());
			assertEquals(lstref.get(i).getNum(),lstresult.get(i).getNum());
			
		}
	}

	@Test
	void testDeleteEleveByNum() {
		int delete =1;
		assertEquals(delete, EleveDAO.deleteEleveByNum("AGUE001"));
	}

	@Test
	void testUpdAdresseEleveByNum() {
		int update =1;
		assertEquals(update, EleveDAO.updAdresseEleveByNum("AGUE002", "av des petites fraises 13"));
	}

	@Test
	void testUpdNoChambreEleveByNum() {
		int update =1;
		assertEquals(update, EleveDAO.updNoChambreEleveByNum(4, "POL003"));
	}

	@Test
	void testAddEleve() {
		int insert =1;
		assertEquals(insert, EleveDAO.addEleve("AGUE002","AGUE MAX", 40,"av de jjeune 13"));
		assertEquals(insert, EleveDAO.addEleve("AGUE004","AGUE MAX", 42,"av de Verdin 13"));
	}

	@Test
	void testGetListEleveByDateN() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllEleve() throws SQLException {
		 ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
		 
		 Eleve e1 = new Eleve("AGUE001", 0, "AGUE MAX", 40, "18 Rue Labat 75018 Paris");//"AGUE001", 1, "AGUE MAX", 40, "18 Rue Labat 75018 Paris"
		 Eleve e2 = new Eleve("AGUE002", 0, "AGUE MAX", 42, "19 Rue Le Monde Paris");//"AGUE001", 1, "AGUE MAX", 40, "18 Rue Labat 75018 Paris"
		 Eleve e3 = new Eleve("KAMTO005", 0, "KAMTO Diogène", 50, "54 Rue des Ebisoires 78300 Poissy");
		 Eleve e4 = new Eleve("LAURENCY004", 0, "LAURENCY Patrick", 52, "79 Rue des Poules 75015 Paris");
		 Eleve e5 = new Eleve("TABIS003",0, "Ghislaine TABIS", 30, "12 Rue du louvre 75013 Paris");
		 Eleve e6 = new Eleve("TAHAE002", 0, "TAHAR RIDENE", 30, "12 Rue des Chantiers 78000 Versailles");
	
		 listEleve.add(e1);
		 listEleve.add(e2);
		 listEleve.add(e3);
		 listEleve.add(e4);
		 listEleve.add(e5);		
		 listEleve.add(e6);		
		 
		 for( int i =0; i < listEleve.size(); i++ )
		 {  
			 assertEquals(listEleve.get(i).getAdresse(),EleveDAO.getAllEleve().get(i).getAdresse());
			 assertEquals(listEleve.get(i).getNo(),EleveDAO.getAllEleve().get(i).getNo());
			 assertEquals(listEleve.get(i).getNom(),EleveDAO.getAllEleve().get(i).getNom());
			 assertEquals(listEleve.get(i).getNum(),EleveDAO.getAllEleve().get(i).getNum());
			 assertEquals(listEleve.get(i).getAge(),EleveDAO.getAllEleve().get(i).getAge());
		 }
		
	}

}
