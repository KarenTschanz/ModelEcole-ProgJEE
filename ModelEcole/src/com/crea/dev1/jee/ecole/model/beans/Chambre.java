package com.crea.dev1.jee.ecole.model.beans;

/**
 * 
 * @author Taha RIDENE
 * Classe Chambre
 */
public class Chambre 
{
	private int no;
	private String num;
	private float prix;
	
	public Chambre(int no, String num, float prix) 
	{
		//super();
		this.no = no;
		this.num = num;
		this.prix = prix;
	}
	
	public Chambre() 
	{
		this(0,"",0);
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	public void afficheChambre()
	{
		System.out.println("Numéro de chambre : ["+this.no+"] Numéro de l'elève: ["+this.num+"]  Prix de la chambre : ["+this.prix+"]  ");
	}
	
}
