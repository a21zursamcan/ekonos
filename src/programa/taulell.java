package programa;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import interficie.interficie;

public class taulell {

	// Hi ha 36 caselles

	// Variables
	interficie i;
	Scanner sc = new Scanner(System.in);
	ArrayList<empresa> empreses = new ArrayList<empresa>();
	ArrayList<carta> baralla = new ArrayList<carta>();
	ArrayList<jugador> jugadors = new ArrayList<jugador>();
	ArrayList<casella> caselles = new ArrayList<casella>();

	public void generarCartes() {
		// Alfa
		this.novaCarta("Alfa", "blauFort", "groc");
		this.novaCarta("Alfa", "blauFort", "blau");
		this.novaCarta("Alfa", "blauFort", "verd");
		this.novaCarta("Alfa", "verd", "groc");
		this.novaCarta("Alfa", "blau", "groc");
		this.novaCarta("Alfa", "verd", "blau");
		// Delta
		this.novaCarta("Delta", "blau", "rosa");
		this.novaCarta("Delta", "blau", "vermell");
		this.novaCarta("Delta", "groc", "rosa");
		this.novaCarta("Delta", "rosa", "vermell");
		this.novaCarta("Delta", "groc", "vermell");
		this.novaCarta("Delta", "groc", "blau");
		// Beta
		this.novaCarta("Beta", "groc", "rosa");
		this.novaCarta("Beta", "verd", "blau");
		this.novaCarta("Beta", "groc", "blau");
		this.novaCarta("Beta", "blau", "rosa");
		this.novaCarta("Beta", "verd", "rosa");
		this.novaCarta("Beta", "verd", "groc");
		// Gamma
		this.novaCarta("Gamma", "blauFort", "verd");
		this.novaCarta("Gamma", "rosa", "verd");
		this.novaCarta("Gamma", "vermell", "blauFort");
		this.novaCarta("Gamma", "rosa", "vermell");
		this.novaCarta("Gamma", "vermell", "verd");
		this.novaCarta("Gamma", "blauFort", "rosa");
		// Omega
		this.novaCarta("Omega", "blau", "verd");
		this.novaCarta("Omega", "verd", "groc");
		this.novaCarta("Omega", "vermell", "verd");
		this.novaCarta("Omega", "vermell", "groc");
		this.novaCarta("Omega", "vermell", "blauFort");
		this.novaCarta("Omega", "blauFort", "groc");
		// Epsilon
		this.novaCarta("Epsilon", "blau", "rosa");
		this.novaCarta("Epsilon", "blau", "vermell");
		this.novaCarta("Epsilon", "rosa", "vermell");
		this.novaCarta("Epsilon", "rosa", "blauFort");
		this.novaCarta("Epsilon", "vermell", "blauFort");
		this.novaCarta("Epsilon", "blau", "blauFort");
	}

	public void generarEmpreses() {
		empreses.add(new empresa("Alfa", "vermell"));
		empreses.add(new empresa("Delta", "verd"));
		empreses.add(new empresa("Beta", "blauFort"));
		empreses.add(new empresa("Gamma", "blau"));
		empreses.add(new empresa("Omega", "rosa"));
		empreses.add(new empresa("Epsilon", "groc"));
	}

	public void novaCarta(String empresa, String color1, String color2) {
		int numEmpresa = -1;
		// Busquem una empresa coincident
		for (int x = 0; x < empreses.size(); x++) {
			if (empresa.equals(empreses.get(x).nom)) {
				numEmpresa = x;
			}
		}
		// Creem la carta
		baralla.add(new carta(empreses.get(numEmpresa), color1, color2));
	}

	public String mostraEmpreses() {
		String sortida = "";
		// Imprimir Empreses
		sortida = sortida + "\n--Empreses--\n";
		for (int x = 0; x < empreses.size(); x++) {
			sortida = sortida + (x + ".-" + empreses.get(x).toString() + "\n");
		}
		return sortida;
	}

	public String toString() {
		String sortida;
		// Imprimir Jugadors
		sortida = "\n--Jugadors--\n";
		for (int x = 0; x < jugadors.size(); x++) {
			sortida = sortida + jugadors.get(x).id + ".-" + jugadors.get(x).nom + "\n";
		}
		// Imprimir Empreses
		sortida = sortida + "\n--Empreses--\n";
		for (int x = 0; x < empreses.size(); x++) {
			sortida = sortida + (x + ".-" + empreses.get(x).nom + "\n");
		}
		// Jugadors

		// Imprimir Baralla Completa
		sortida = sortida + "\n--Baralla--\n";
		for (int x = 0; x < baralla.size(); x++) {
			sortida = sortida + (baralla.get(x).toString());
			if (x != (baralla.size() - 1)) {
				sortida = sortida + "\n";
			}
		}

		// Imprimir caselles
		sortida = sortida + "\n\n--Caselles--\n";
		for (int x = 0; x < caselles.size(); x++) {
			sortida = sortida + caselles.get(x).toString() + "\n";
		}
		return sortida;
	}

	public void introdueixJugadors(interficie i) {

		this.i = i;
		boolean mesJugadors = true;
		int numeroJugador = this.jugadors.size();
		while (mesJugadors) {
			numeroJugador++;
			String jugador = sc.nextLine();
			if (jugador.equals("")) {
				// Si el usuari no vol introduir mes jugadors
				numeroJugador--;
				mesJugadors = false;
			} else {
				jugadors.add(new jugador(jugador, numeroJugador));

				i.imprimeix(jugador + "-->Jugador " + numeroJugador);
				if (numeroJugador == 6) {
					// Si s'ha arribat al numero maxim de jugadors
					mesJugadors = false;
				}
			}

		}
		// Comprobem si el numero de usuaris es minim 3
		if (numeroJugador < 3) {
			i.imprimeixErr("El numero de jugadors ha de ser minim 3");
			introdueixJugadors(i);
		}

	}

	public void generaCaselles() {
		// Casella(numeroCasella, conexio1, conexio2, conexio3, ...)
		this.novaCasella(1, 2, 8);
		this.novaCasella(2, 1, 3, 8);
		this.novaCasella(3, 2, 4, 10);
		this.novaCasella(4, 3, 5, 10);
		this.novaCasella(5, 4, 6, 11);
		this.novaCasella(6, 5, 7, 11);
		this.novaCasella(7, 6, 11, 17);
		this.novaCasella(8, 1, 2, 12);
		this.novaCasella(9, 10, 12, 13, 14);
		this.novaCasella(10, 3, 4, 9, 15);
		this.novaCasella(11, 5, 6, 7, 16);
		this.novaCasella(12, 8, 9, 18);
		this.novaCasella(13, 9, 14, 18, 19);
		this.novaCasella(14, 9, 13, 15, 20);
		this.novaCasella(15, 10, 14, 16, 21);
		this.novaCasella(16, 11, 15, 17, 21);
		this.novaCasella(17, 7, 16, 24);
		this.novaCasella(18, 12, 13, 26, 27);
		this.novaCasella(19, 13, 20, 27, 28);
		this.novaCasella(20, 14, 19, 21, 22);
		this.novaCasella(21, 15, 16, 20, 22);
		this.novaCasella(22, 20, 21, 23, 29);
		this.novaCasella(23, 22, 24, 30);
		this.novaCasella(24, 17, 23, 30, 31);
		this.novaCasella(25, 26, 32, 33);
		this.novaCasella(26, 18, 25, 27, 34);
		this.novaCasella(27, 18, 19, 26, 28);
		this.novaCasella(28, 19, 27, 29, 34, 35);
		this.novaCasella(29, 22, 28, 35);
		this.novaCasella(30, 23, 24, 35, 36);
		this.novaCasella(31, 24, 36);
		this.novaCasella(32, 25, 33);
		this.novaCasella(33, 25, 32, 34);
		this.novaCasella(34, 26, 28, 33);
		this.novaCasella(35, 28, 29, 30, 36);
		this.novaCasella(36, 30, 31, 35);
		// Una vegada que s'ha creat cada casella afegim cada casella com objecte
		this.tradueirConexions();
	}

	public void novaCasella(int... c) {
		if (c.length == 3) {
			caselles.add(new casella(c[0], c[1], c[2]));
		}
		if (c.length == 4) {
			caselles.add(new casella(c[0], c[1], c[2], c[3]));
		}
		if (c.length == 5) {
			caselles.add(new casella(c[0], c[1], c[2], c[3], c[4]));
		}
		if (c.length == 6) {
			caselles.add(new casella(c[0], c[1], c[2], c[3], c[4], c[5]));
		}

	}

	public void tradueirConexions() {
		for (int x = 0; x < caselles.size(); x++) {
			for (int y = 0; y < caselles.get(x).conexionsNumeriques.size(); y++) {
				caselles.get(x).conexions.add(caselles.get(caselles.get(x).conexionsNumeriques.get(y) - 1));
			}
		}
	}

	public jugador seleccionarPrimerJugador(int ronda, jugador anteriorPrimerJugador) {
		if (ronda == 1) {
			// Si es la primera ronda seleccionem un jugador aleatori
			int numeroAleatori = (int) Math.round(Math.random() * (jugadors.size() - 1));

			return jugadors.get((int) numeroAleatori);
		} else {
			// Si no es el primer torn
			int nouJugador = anteriorPrimerJugador.id;
			// Comprobem que no ha arribat al ultim jugador
			if (nouJugador == jugadors.size()) {
				// Si hem arribat a l'ultim jugador li tocara al primer jugador
				return jugadors.get(0);
			} else {
				// Si no hem arribat a l'ultim jugador li tocara al seg�ent
				return jugadors.get(nouJugador);
			}
		}
	}

	public int seleccionaNumeroRondes() {
		if (jugadors.size() == 6) {
			return 2;
		}
		if (jugadors.size() == 5 || jugadors.size() == 4) {
			return 3;
		}
		if (jugadors.size() == 3) {
			return 4;
		}
		return 0;
	}

	public int seleccionaCartesPerTorn() {
		if (jugadors.size() == 6 || jugadors.size() == 4 || jugadors.size() == 3) {
			return 6;
		}
		if (jugadors.size() == 5) {
			return 5;
		}
		return 0;
	}

	public ArrayList<carta> agafaCartes(int numeroCartes) {
		ArrayList<carta> ma = new ArrayList<carta>();
		for (int x = 0; x < numeroCartes; x++) {
			// Afegim l'ultima carta a la ma del jugador y la eliminem de la baralla
			ma.add(baralla.get(baralla.size() - 1));
			baralla.remove(baralla.size() - 1);
		}
		return ma;
	}

	public void seleccionaCarta(jugador jugador) {
		try {
			int numeroCarta = Integer.parseInt(sc.nextLine());
			carta carta = jugador.ma.get(numeroCarta);
			jugador.ma.remove(numeroCarta);
			empresa empresa = this.tradueixColorEmpresa(carta.color1);
			empresa.marcadorDeCreixement++;
			this.comprobaCasella(empresa);
			empresa = this.tradueixColorEmpresa(carta.color2);
			empresa.marcadorDeCreixement++;
			this.comprobaCasella(empresa);
			this.mostraEmpreses();
		}catch(InputMismatchException e){
			i.imprimeixErr("Valor introduit incorrecte!");
			this.seleccionaCarta(jugador);
		}catch(IndexOutOfBoundsException e){
			i.imprimeixErr("Numero introduit incorrecte!");
			this.seleccionaCarta(jugador);
		}catch (IllegalArgumentException e){
			i.imprimeixErr("Valor introduit incorrecte!");
			this.seleccionaCarta(jugador);
		}
	}

	public void comprobaCasella(empresa empresa) {
		if (empresa.marcadorDeCreixement == 4) {
			this.marcador4(empresa);
		} else {
			if (empresa.marcadorDeCreixement == 6) {
				this.marcador6(empresa);
			}
		}
	}

	public void marcador4(empresa empresa) {
		//Funcio al arribar al marcador de creixement numero 4
		System.out.println("Marcador de Creixement 4");
	}

	public void marcador6(empresa empresa) {
		//Funcio al arribar al marcador de creixement numero 6
		empresa.marcadorDeCreixement = 0;
		System.out.println("Marcador de Creixement 6");
	}

	public empresa tradueixColorEmpresa(String color) {
		for (int x = 0; x < empreses.size(); x++) {
			if (empreses.get(x).color.equals(color)) {
				return empreses.get(x);
			}
		}
		i.imprimeixErr("Empresa de color " + color + " no trobada");
		return null;
	}

	public int cobrament(jugador jugador) {
		//Crea un nou valor
		int total = jugador.unitatMonetaria;
		if (jugadors.size() == 6 || jugadors.size() == 4 || jugadors.size() == 3) {
			//Suma el numero de unitats monetaries al total
			total = total + 12;
			return total;
		} else {
			if (jugadors.size() == 5) {
				total = total + 10;
				return total;
			}
			return 0;
		}
	}


	public void mostraAccionsEmpreses() {
		for (int x = 0; x < empreses.size(); x++) {
			String linea = null;
			linea = (x + ".-" + empreses.get(x).nom + ": ");
			for (int y = 0; y < jugadors.size(); y++) {
				linea = linea + jugadors.get(y).nom+"<"+empreses.get(x).numeroAccionsJugador(jugadors.get(y))+">";
				if (y != jugadors.size() - 1) {
					linea = linea + ", ";
				}
			}
			i.imprimeix(linea);
		}

	}


	public void compraAccions(jugador jugador) {
		if(jugador.accions>0){
			String resposta1;
			String resposta2;
			int xSeleccio;
			boolean cofirmaCompra = false;
			i.imprimeix("Vols compra alguna acció? tens "+jugador.unitatMonetaria+" U.M");
			resposta1 = sc.nextLine();
			if (resposta1.equalsIgnoreCase("si")) {
				//Aqui es te que veure les accions disponibles a comprar
				this.mostraAccionsEmpreses();
				//Es selecciona una accio
				i.imprimeix("Selecciona l'empresa en la que vols invertir l'accio (escriu el numero de la llista): ");
				xSeleccio = Integer.parseInt(sc.nextLine());
				empresa empresaActual=empreses.get(xSeleccio);
				//Captura excepcio de numero (encara no fet)
				i.imprimeix("Has seleccionat l'empresa: " +empresaActual.nom);
				//Aqui es dira el preu de l'accio
				i.imprimeix("El preu d'aquesta Acció es " + empresaActual.valorCompra()+" et quedarà "+(jugador.unitatMonetaria-empresaActual.valorCompra()));
				//Es verifica si l'usuari vol comprar l'accio
				i.imprimeix("Vols comprar aquesta acció?");
				resposta2 = sc.nextLine();
				if (resposta2.equalsIgnoreCase("si")) {
					jugador.unitatMonetaria=jugador.unitatMonetaria-empresaActual.valorCompra();
					i.imprimeix("Has comprat aquesta acció! et queden "+);
					//Si no hi ha cap president en la empresa
					if(empresaActual.president==null){
						//Fem al jugador actual president
						empresaActual.president=jugador;
						i.imprimeix("Felicitats! Ets el nou president d'aquesta empresa, ja que ets la primera persona en adquirir una acció");
					}else{
						//Si hi ha un president comprobem si el jugador te mes accions que el president
						if(empresaActual.numeroAccionsJugador(jugador)>empresaActual.numeroAccionsJugador(empresaActual.president)){
							empresaActual.president=jugador;
							i.imprimeix("Felicitats! Ets el nou president d'aquesta empresa, ja que t'acabas de convertir en el mayor accionista!");
						}
					}
					empresaActual.accions.add(jugador);
					jugador.accions--;
				}
//				Torna a començar (l'hem comentat ja que a la pagina web fica que solament pots fer un cop aquesta opció)
//				this.compraAccions(jugador);
			}else{
				if(resposta1.equalsIgnoreCase("no")){
					i.imprimeix("No has comprat cap accio");
				}else{
					i.imprimeixErr("Valor introduir incorrecte");
					this.compraAccions(jugador);
				}
			}
		}else{
			i.imprimeix("No tens accions disponibles, tens que vendre alguna");
		}
	}

	public void vendreAcions(jugador jugador) {
		String resposta, siFinal;
		int xSeleccio;
		if (jugador.accions==18) {
			i.imprimeix("No tens cap acció");
		} else {
			i.imprimeix("Vols vendre alguna acció? Tens disponibles aquestes Unitats Monetaries:"+jugador.unitatMonetaria+" U.M");
			resposta = sc.nextLine();
			if (resposta.equalsIgnoreCase("si")) {
				i.imprimeix("Tens disponibles aquestes Unitats Monetaries: " + jugador.unitatMonetaria);
				this.mostraAccionsEmpreses();
				i.imprimeix("Selecciona de quina empresa vols vendre accions ");
				xSeleccio = Integer.parseInt(sc.nextLine());
				empresa empresaActual=empreses.get(xSeleccio);
				i.imprimeix("Has seleccionat l'empresa: " + empresaActual.nom);
				i.imprimeix("Aquesta acció te un valor actual de: "+empresaActual.valorVenta());
				i.imprimeix("Vols vendre aquesta acció finalment?");
				siFinal = sc.nextLine();
				if (siFinal.equalsIgnoreCase("si")) {
					jugador.unitatMonetaria=jugador.unitatMonetaria+empresaActual.valorVenta();
					empresaActual.eliminaUltimaAccio(jugador);
					jugador.accions++;
					if(empresaActual.president==jugador){
						//Llista amb els posibles substituts per president
						ArrayList<jugador> posiblesPresidents = new ArrayList<jugador>();
						//Si el jugador és el president actual de la empresa
						for(int i = 0; i<jugadors.size();i++){
							if(jugadors.get(i)==jugador){
								//Si es el mateix jugador no es comproba res
							}else{
								if(empresaActual.numeroAccionsJugador(jugadors.get(i))>empresaActual.numeroAccionsJugador(empresaActual.president)){
									posiblesPresidents.add(jugadors.get(i));
								}
							}
						}
						if(posiblesPresidents.size()>1){
							i.imprimeix("Aquests jugadors tenen mes accions que tu a causa de la venta que has fet");
							for(int x=0; x<posiblesPresidents.size(); x++){
								i.imprimeix(x+".-"+posiblesPresidents.get(x).nom);
							}
							i.imprimeix("Selecciona un d'aquests per ser el teu substitut en la presidència: ");
							int nouPresident=Integer.parseInt(sc.nextLine());
							empresaActual.president=posiblesPresidents.get(nouPresident);
							i.imprimeix("Felicitats! "+empresaActual.president.nom+", s'ha convertit en el nou president");
						}else if(posiblesPresidents.size()==1){
							empresaActual.president=posiblesPresidents.get(0);
							i.imprimeixErr(empresaActual.president.nom+" s'ha convertit en el nou president per que es el mayor accionista");
						}
					}
				}
				else{
					i.imprimeix("Venta de la acció: CANCELADA!");
				}
//				Torna a començar (l'hem comentat ja que a la pagina web fica que solament pots fer un cop aquesta opció)
//				this.vendreAccions(jugador);
			}
			else System.out.println("----------------------------");
		}

	}
}