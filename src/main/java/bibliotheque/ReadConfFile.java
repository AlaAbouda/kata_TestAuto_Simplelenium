package bibliotheque;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadConfFile {

	public final static String GlobalsURL="hhttp://localhost:8081/";
	public final static String GlobalsBrowser="FIREFOX";
	public final static String GlobalsLangue="Fr";
	
	
	
	public static String[] Get_Info(String param_server) {
    	String[] Info = new String[] {GlobalsURL, GlobalsBrowser};
    	String IN = null;
    	
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try 
        { 
        	final DocumentBuilder builder = factory.newDocumentBuilder();
            final Document document= builder.parse(new File("Conf.xml"));
            final Element racine = document.getDocumentElement();
	        final NodeList racineNoeuds = racine.getChildNodes();
	        final int nbRacineNoeuds = racineNoeuds.getLength();
	        for (int i = 0; i<nbRacineNoeuds; i++) 
	        {

	        	if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) 
	        	{
	        		final Element personne = (Element) racineNoeuds.item(i);
	        		IN = personne.getAttribute("param_server");
	        		if(IN.equals(param_server))
		            {
			            final Element URL = (Element) personne.getElementsByTagName("URL").item(0);
			            final Element Browser = (Element) personne.getElementsByTagName("Browser").item(0);
			            
			            Info[0] =  URL.getTextContent();
			            Info[1] =  Browser.getTextContent();
			            
		            }
	        	} 
	        } 
	        

        }
        catch (final ParserConfigurationException e) {
            e.printStackTrace();
        }

        catch (final SAXException e) {
            e.printStackTrace();
        }

        catch (final IOException e) {
            e.printStackTrace();
        } 
        return (Info);
    }
	
	
	
	
	
	
}
