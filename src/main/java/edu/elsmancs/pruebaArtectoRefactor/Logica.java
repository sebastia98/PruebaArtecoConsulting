package edu.elsmancs.pruebaArtectoRefactor;

public class Logica {
	private String loren = "";
	private String [] arrLoren = null;
	
	public Logica (String loren) {
		this.loren = loren.toLowerCase();
		this.generarLista();
	}
	
	public String[] getArr() {
		return arrLoren;
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
	
	private void generarLista() {
		StringBuilder texto = new StringBuilder();
		loren.chars().mapToObj(c -> (char)c).filter(c -> c != ',' && c != '.' && c != '\n' && c != ';' ).forEach(c -> texto.append(c));
		arrLoren = texto.toString().split(" ");
	}
}
