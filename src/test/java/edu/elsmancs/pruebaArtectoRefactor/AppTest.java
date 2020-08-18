package edu.elsmancs.pruebaArtectoRefactor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.elsmancs.ArtecoRefactorizado.Logica;



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
}
