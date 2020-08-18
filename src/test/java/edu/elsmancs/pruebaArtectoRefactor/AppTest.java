package edu.elsmancs.pruebaArtectoRefactor;

import static org.junit.Assert.assertTrue;

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
}
