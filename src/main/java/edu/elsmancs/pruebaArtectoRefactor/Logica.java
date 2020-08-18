package edu.elsmancs.pruebaArtectoRefactor;

public class Logica {
	private String loren = "";
	
	public Logica (String loren) {
		this.loren = loren.toLowerCase();
	}
	
	public int contarPalabras() {
		return (int)this.loren.chars().filter(c -> c == ' ').count();
	}
	public int contarFrases() {
		return (int)this.loren.chars().filter(c -> c == '.').count();
	}
	
	public int contarParrafos() {
		return (int)this.loren.chars().filter(c -> c == '\n').count();
	}
}
