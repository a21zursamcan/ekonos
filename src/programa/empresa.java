package programa;

import java.util.ArrayList;

public class empresa {
	//Variables
	String color;
	int marcadorDeCreixement;
	jugador president=null;
	String nom;
	ArrayList<jugador> accions =new ArrayList<jugador>();
	
	empresa(String nom, String color){
		this.nom=nom;
		this.color=color;
	}
	public String toString() {
		return this.nom+"<"+this.color+">{"+marcadorDeCreixement+"}";
	}
}
