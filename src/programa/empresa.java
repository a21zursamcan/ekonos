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

	public int numeroAccionsJugador(jugador jugador) {
		int numero = 0;
		for (int x = 0; x < accions.size(); x++) {
			if (accions.get(x) == jugador) {
				numero++;
			}
		}
		return numero;
	}

	public void eliminaUltimaAccio(jugador jugador){
		//Busquem l'ultima accio del jugador
		int posicioAccio=0;
		for(int x=0; x<accions.size();x++){
			if(accions.get(x)==jugador){
				posicioAccio=x;
			}
		}
		//Una vegada que sabem quina és l'última acció del jugador l'eliminem
		accions.remove(posicioAccio);
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