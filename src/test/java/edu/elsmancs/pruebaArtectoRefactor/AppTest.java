package edu.elsmancs.pruebaArtectoRefactor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;






/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	@Test
    public void contarPalabrasTest() {
    	String texto = "Hola, como estás? \n"
    			     + "Yo estoy bien. Y tú? \n";
    	Logica logica = new Logica(texto);
    	assertTrue(8 == logica.contarPalabras());
    }
	
	@Test
    public void contarFrasesTest() {
    	String texto = "Hola amigo. \n"
    			     + "Esto es un; texto. \n"
    			     + "Debe, tener, 3 frases. \n";
    	Logica logica = new Logica(texto);
    	assertTrue(3 == logica.contarFrases());
    }
    
    @Test
    public void contarParrafosTest() {
    	String texto = "Hola amigo. \n"
    			     + "Arteco mola. \n"
    			     + "Esto es un; texto. \n"
    			     + "Debe, tener, 3 frases. \n";
    	Logica logica = new Logica(texto);
    	assertTrue(4 == logica.contarParrafos());
    }
    
    @Test
    public void generarListaTest() {
    	String texto = "Hola .amigo Arteco, mola; \n";
    	String [] arrTexto = {"hola", "amigo", "arteco", "mola"};
    	Logica logica = new Logica(texto);
    	assertArrayEquals(arrTexto, logica.getArr());
    }
    
    @Test
    public void ListaPalindromosTest() {
    	String texto = "Hola ala ele";
    	String [] arrTexto = {"ala", "ele"};
    	Logica logica = new Logica(texto);
    	assertArrayEquals(arrTexto, logica.listarPalindromos().toArray());
    }
    
    @Test
    public void contarRepetidasTest() {
    	String texto = "Amigo sdjn amigo uidnce wic hola diub hola idueb hola idcu y y y y ifuvb de de de de de de ucebi casa casa icei casa casa casa";
    	Map<String, Integer> tabla = new LinkedHashMap<String, Integer>();
    	tabla.put("de", 6); tabla.put("casa", 5); tabla.put("y", 4); 
    	tabla.put("hola", 3); tabla.put("amigo", 2);
    	Logica logica = new Logica(texto);
    	assertArrayEquals(tabla.keySet().toArray(), logica.contarRepetidas().keySet().toArray());
    	assertArrayEquals(tabla.values().toArray(), logica.contarRepetidas().values().toArray());
    }
    
    @Test
    public void contarTuplasRepetidasTest() {
    	String texto = "Amigo mio ddhs amigo mio diurb amigo mio dieb amigo mio ivb amigo mio iucb amigo mio, drub "
    			     + "casa blanca fhbe casa blanca ucdv casa blanca cjdv casa blanca ucdb casa blanca vf "
    			     + "hola hola dcibc hola hola iubdx hola hola sbw hola hola iucdb "
    			     + "toma toma dib toma toma iuxieu toma toma ciueb "
    			     + "sin blanca diub sin blanca.";
    	Map<String, Integer> tabla = new LinkedHashMap<String, Integer>();
    	tabla.put("amigo mio", 6); tabla.put("casa blanca", 5); tabla.put("hola hola", 4); 
    	tabla.put("toma toma", 3); tabla.put("sin blanca", 2);
    	Logica logica = new Logica(texto);
    	assertArrayEquals(tabla.keySet().toArray(), logica.contarTuplasRepetidas().keySet().toArray());
    	assertArrayEquals(tabla.values().toArray(), logica.contarTuplasRepetidas().values().toArray());
    }
}
