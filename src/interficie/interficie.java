package interficie;

import programa.jugador;
import programa.taulell;

public class interficie {
	
	taulell t;
	
	public interficie(taulell t){
		this.t=t;
	}
	
	public void registre() {
		// Imprimim el titol
		this.imprimeix("--REGISTRE--");
		// Demanem els jugadors
		this.imprimeix("Introdueix els jugadors, deixa el espai en blanc per no introduir mes");
		t.introdueixJugadors(this);
	}
	
	public void imprimeix(String missatge) {
		System.out.println(missatge);
	}
	
	public void imprimeixErr(String missatge) {
		System.err.println(missatge);
	}
	
	public void tornJugador(jugador jugador) {
		this.imprimeix("Torn de "+jugador.nom);
		this.imprimeix("Quina carta vols fer servir?");
		this.imprimeix(t.mostraEmpreses());
		this.imprimeix(jugador.getMa());
		
		t.seleccionaCarta(jugador);
	}
}
