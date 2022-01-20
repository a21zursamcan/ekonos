package programa;

import java.util.ArrayList;

public class empresa {
	//Variables
	String color;
	int marcadorDeCreixement;
	jugador president = null;
	String nom;
	ArrayList<jugador> accions = new ArrayList<jugador>();

	empresa(String nom, String color) {
		this.nom = nom;
		this.color = color;
	}

	public int numeroAccionsJugador(jugador jugador){
		int numero = 0;
		for(int x=0;x<accions.size();x++){
			if(accions.get(x)==jugador){
				numero++;
			}
		}
		return numero;
	}

	public int preuAccions(){

	}

	public String toString() {
		return this.nom + "<" + this.color + ">{" + marcadorDeCreixement + "}";
	}
}