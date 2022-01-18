package programa;

import java.util.ArrayList;

public class casella {

	int numero;
	ArrayList<Integer> conexionsNumeriques = new ArrayList<Integer>();
	ArrayList<casella> conexions = new ArrayList<casella>();
	boolean buida = true;

	public casella(int... j) {
		this.numero = j[0];
		for (int x = 1; x < j.length; x++) {
			conexionsNumeriques.add(j[x]);
		}
	}

	public String toString() {
		String sortida = "Casella numero " + numero + " amb conexions amb ";
		for (int x = 0; x < conexions.size(); x++) {
			if (x == conexions.size() - 1) {
				sortida = sortida + " y ";
			} else {
				if (x == 0) {

				} else {
					sortida = sortida + ", ";
				}
			}
			sortida = sortida + conexions.get(x).numero;

		}
		return sortida;
	}

}
