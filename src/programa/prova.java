package programa;

public class prova {
	static taulell t= new taulell();
	public static void main(String[] args) {
		t.jugadors.add(new jugador("jug1",1));
		t.jugadors.add(new jugador("jug2",2));
		t.jugadors.add(new jugador("jug3",3));
		t.jugadors.add(new jugador("jug4",4));
		t.jugadors.add(new jugador("jug5",5));
		t.jugadors.add(new jugador("jug6",6));
		
		jugador primerJugador=t.seleccionarPrimerJugador(1, null);
		System.out.println(primerJugador.nom);
		System.out.println("Nova ronda");
		primerJugador= t.seleccionarPrimerJugador(2, primerJugador);
		System.out.println(primerJugador.nom);
		System.out.println("Nova ronda");
		primerJugador= t.seleccionarPrimerJugador(3, primerJugador);
		System.out.println(primerJugador.nom);
		System.out.println("Nova ronda");
		primerJugador= t.seleccionarPrimerJugador(4, primerJugador);
		System.out.println(primerJugador.nom);
		System.out.println("Nova ronda");
		primerJugador= t.seleccionarPrimerJugador(5, primerJugador);
		System.out.println(primerJugador.nom);
		
	}

}
