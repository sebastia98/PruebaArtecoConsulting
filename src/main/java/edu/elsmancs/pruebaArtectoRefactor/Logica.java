package edu.elsmancs.pruebaArtectoRefactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Logica {
	private String loren = "";
	private String [] arrLoren = null;
	
	public Logica (String loren) {
		this.loren = loren.toLowerCase();
		this.generarLista();
	}
	
	public String toString() {
		return "Este texto tiene " + this.contarPalabras() + " palabras, " + this.contarFrases() + " frases y " + this.contarParrafos()  + " párrafos.\n"
			 + "Este texto tiene " + this.listarPalindromos().size() + " palíndromas y son estas: " + this.listarPalindromos() + "\n"
			 + "Estas son sus palabras más usadas: " + this.contarRepetidas() + "\n"
			 + "Estas son sus tuplas (de dos palabras) más usadas: " + this.contarTuplasRepetidas();
	}
	
	public String[] getArr() {
		return arrLoren;
	}
	/*
	 * Métodos para contar palabras, frases y párrafos. En todos transformo el String en un Stream de chars 
	 * y filtro los elementos que más me convienen para contarlos.
	 */
	public int contarPalabras() {
		return (int)this.loren.chars().filter(c -> c == ' ').count();
	}
	public int contarFrases() {
		return (int)this.loren.chars().filter(c -> c == '.').count();
	}
	
	public int contarParrafos() {
		return (int)this.loren.chars().filter(c -> c == '\n').count();
	}
	/*
	 * Método que genera una lista de Strings. Filtro todo aquello que no sean signos de puntuación excepto espacios. 
	 * Hago uso de la Clase StringBuilder que me permite añadir los chars más cómodamente. Luego lo paso a String y 
	 * creo un String[] con el método split.
	 */
	private void generarLista() {
		StringBuilder texto = new StringBuilder();
		loren.chars().mapToObj(c -> (char)c).filter(c -> c != ',' && c != '.' && c != '\n' && c != ';' ).forEach(c -> texto.append(c));
		arrLoren = texto.toString().split(" ");
	}
	/*
	 * Itero cada palabra de la lista y la convierto en StringBuilder, ya que con su método reverse me permite 
	 * comprobar si es igual a su forma original.
	 */
	public ArrayList<String> listarPalindromos() {
		ArrayList<String> listaPal = new ArrayList<String>();
		for (String w : arrLoren) {
			StringBuilder palabra = new StringBuilder(w);
			if (palabra.reverse().toString().equals(w)) {listaPal.add(w);}
		}
		return listaPal;
	}
	/*
	 * Se le pasa un Object[] y devuelve un mapa ordenado de los cinco elementos mas repetidos de ese array.
	 */
	private Map<String, Integer> generarMapa(Object [] arr) {
		
		Map<String, Integer> tabla = new HashMap<String, Integer>();
		/*
		 * Itero cada Objeto del array que le paso y la filtro para poder contarla, 
		 * después añado el Objeto casteado a String y su cantidad en un Mapa en caso de que este no lo contenga.
		 */
		for (Object palabra : arr) {
			int suma = (int)Stream.of(arr).filter(w -> w.equals(palabra)).count();
			if (!tabla.containsKey(palabra)) tabla.put((String) palabra, suma);
		}
		/*
		 * Luego lo ordeno en función del valor de las entradas del mapa, devolviendo solo 5 entradas y 
		 * coleccionadas en un LinkedHashMap.
		 */
		return tabla.entrySet().stream()
							   .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(5)
							   .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}
	/*
	 * Método que genera Strings de dos palabras de forma ordenada y secuencial 
	 * con todas las palabras de arrLoren.
	 */
	private ArrayList<String> generarTuplas() {
		ArrayList<String> listaTuplas = new ArrayList<String>();
		for (int i = 0; i < arrLoren.length; i++) {
			String tupla = "";
			try {
				tupla = arrLoren[i] + " " + arrLoren[i + 1];
				listaTuplas.add(tupla);
			} catch (Exception e) {}
		}
		return listaTuplas;
	}
	/*
	 * Estos métodos "cuentan" las palabras y las tuplas llamando al método generarMapa y pasándole por 
	 * parámetro la estructura de datos que necesite para realizar su función.
	 */
	public Map<String, Integer> contarRepetidas(){
		return generarMapa(arrLoren);
	}
	
	public Map<String, Integer> contarTuplasRepetidas(){
		return generarMapa(generarTuplas().toArray());
	}
}
