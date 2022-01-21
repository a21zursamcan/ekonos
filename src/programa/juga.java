package programa;

import java.util.Collections;

import interficie.interficie;

public class juga {
	//Variables
	static taulell t= new taulell();
	static interficie i= new interficie(t);
	static int ronda=0;
	static int numeroRondas=0;
	static jugador primerJugador=null;
	static int cartesPerTorn;

	public static void main(String[] args) {
		//Generar Empreses
		t.generarEmpreses();
		//Generar Cartes
		t.generarCartes();
		//Genera Caselles
		t.generaCaselles();
		//Registra jugadors
		i.registre();
		//Seleccionem el numero de rondes que hi haur�n
		numeroRondas=t.seleccionaNumeroRondes();
		//Seleccionem les cartes que es repartiran per torn
		cartesPerTorn=t.seleccionaCartesPerTorn();
		//Iniciem el joc
		inici();

		
	}
	
	public static void inici() {
		for(int ronda=1;ronda<=numeroRondas;ronda++) {
			i.imprimeix("Ronda " + ronda);
			//Generem les cartes
			t.generarCartes();
			//Remenem les cartes
			Collections.shuffle(t.baralla);
			//Seleccionem el jugador que iniciar� el torn
			primerJugador=t.seleccionarPrimerJugador(ronda,primerJugador);
			//Una vegada seleccionat el jugador inciem els torns, comen�ant amb el primerJugador seleccionat
			jugador jugadorActiu=primerJugador;
			for(int x=0;x<cartesPerTorn;x++) {
				for(int y=0; y<t.jugadors.size();y++) {
					if(x==0) {
						//Si es la primera jugada del jugador en aquest torn
						//El jugador agafa les cartes
						jugadorActiu.ma=t.agafaCartes(cartesPerTorn);
						//Se li dona les u.m.
						jugadorActiu.unitatMonetaria=t.cobrament(jugadorActiu);
					}
					i.tornJugador(jugadorActiu);
					i.imprimeix("----------FASE DE VENTA DE ACCIONS------------");
					t.vendreAcions(jugadorActiu);
					i.imprimeix("----------FASE DE COMPRA DE ACCIONS------------");
					t.compraAccions(jugadorActiu);
					try {
						jugadorActiu=t.jugadors.get(jugadorActiu.id);
					} catch (IndexOutOfBoundsException e) {
						jugadorActiu=t.jugadors.get(0);
					}
				}
			}
			
		}
	}

}
