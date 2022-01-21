package programa;

import java.util.ArrayList;

public class empresa {
	//Variables
	String color;
	int marcadorDeCreixement;
	jugador president = null;
	String nom;
	static ArrayList<jugador> accions = new ArrayList<jugador>();

	empresa(String nom, String color) {
		this.nom = nom;
		this.color = color;
	}

	public boolean primeraAccioxPresident (jugador jugadorActual){
		if (accions.get(0)==jugadorActual){
			return true;
		}
		return false;
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

	public boolean comprovaPresident(jugador jugadorActual){
		if (jugadorActual.accions<this.numeroAccionsJugador(president)) {
			return false;
		}
		else if (jugadorActual.accions>this.numeroAccionsJugador(president)){
			return true;
		}
		else {
			return false;
		}
	}

	public int valorVenta(){
		return this.accions.size();
	}

	public int valorCompra(){
		return this.accions.size()+1;
	}

	public String toString() {
		return this.nom + "<" + this.color + ">{" + marcadorDeCreixement + "}";
	}
}