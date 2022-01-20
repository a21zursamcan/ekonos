package programa;

import java.util.ArrayList;

import interficie.interficie;

public class jugador {

//Variables 
	public ArrayList<carta> ma = new ArrayList<carta>();
	public String nom;
	public int id;
	public casella posicio=null;
	public boolean viu=true;
	public boolean patada=false;
	public interficie i;
	public int unitatMonetaria=0;
	public int accions=18;
	public boolean teAccions=false;

	jugador(String nom, int id) {
		this.nom = nom;
		this.id=id;
	}

	public String getMa() {
		String resposta = "";
		for(int x=0;x<this.ma.size();x++) {
			resposta=resposta+x+".-"+ma.get(x).toString()+"\n";
		}
		return resposta;
	}
	
}
