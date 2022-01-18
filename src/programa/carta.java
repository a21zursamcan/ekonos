package programa;

public class carta {
	// Variables
	empresa empresa = null;
	String color1 = null;
	String color2 = null;

	carta(empresa empresa, String color1, String color2) {
		this.empresa = empresa;
		this.color1 = color1;
		this.color2 = color2;
	}
	
	public String toString() {
		return "["+empresa.nom+","+color1+","+color2+"]";
	}
}
