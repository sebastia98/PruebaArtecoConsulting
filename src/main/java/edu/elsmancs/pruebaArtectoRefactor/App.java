package edu.elsmancs.pruebaArtectoRefactor;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String loren = "";
        Document doc = Jsoup.connect("https://es.lipsum.com/feed/html").get();
        Element content = doc.getElementById("lipsum");
        for (Element p : content.getElementsByTag("p")) {
        	loren += p.text() + " \n";
        }
        
        Logica logica = new Logica(loren);
        System.out.println(loren);
        System.out.print(logica);
    }
}
