package bibliotheque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class RapportXMLHtml {
	private int id;
	private String EtatStep;
	private String EtatFinal;
	private String newLine = System.getProperty("line.separator");
	
	
	private  String Message_Resultat;
	
	
	
	public RapportXMLHtml()   {
		Message_Resultat = "";
		EtatFinal = "p";
		id = 0;
	}
	
	
	public  void Set_CreateReportXML(String build_id, String test_plan_id, String id_case ) throws Exception {
		
		SimpleDateFormat date_execution = null;
		Date aujourdhui = new Date();
		date_execution = new SimpleDateFormat("dd-MM-yyyy");
		
		SimpleDateFormat heure_debut = null;
		heure_debut = new SimpleDateFormat("hh:mm:ss");
		
		Message_Resultat =	"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + newLine ;
		Message_Resultat =	Message_Resultat + "<Rapport>" + newLine ;
		Message_Resultat =	Message_Resultat + "<build_id>"+build_id+"</build_id>" + newLine ;
		Message_Resultat =	Message_Resultat + "<test_plan_id>"+test_plan_id+"</test_plan_id>" + newLine ;
		Message_Resultat =	Message_Resultat + "<id_case>"+id_case+"</id_case>" + newLine ;
		Message_Resultat =	Message_Resultat + "<date_execution>"+date_execution.format(aujourdhui)+"</date_execution>" + newLine ;
		Message_Resultat =	Message_Resultat + "<heure_debut>"+heure_debut.format(aujourdhui)+"</heure_debut>" + newLine ;
		
	}
		
		
	public   void AjouterStepXML(String Commentaire) throws Exception {
		
		if(id!=0)
		 {
			Message_Resultat =	Message_Resultat +  "<EtatStep>"+EtatStep+"</EtatStep>" + newLine ;
			Message_Resultat =	Message_Resultat + "</Step>" + newLine ;
		 }
		SimpleDateFormat date_execution = null;
		Date aujourdhui = new Date();
		date_execution = new SimpleDateFormat("dd-MM-yyyy");
			
		SimpleDateFormat heure_debut = null;
		heure_debut = new SimpleDateFormat("hh:mm:ss");
		id = 1;
		
		Message_Resultat =	Message_Resultat + " <Step>" + newLine ;
		Message_Resultat =	Message_Resultat + " <Commentaire>"+Commentaire+"</Commentaire>" + newLine ;
		Message_Resultat =	Message_Resultat + "<date_executionStep>"+date_execution.format(aujourdhui)+"</date_executionStep>" + newLine ;
		Message_Resultat =	Message_Resultat + "<heure_debutStep>"+heure_debut.format(aujourdhui)+"</heure_debutStep>" + newLine ;
		EtatStep = "p";
	}	
	
	
	
	public   void AjouterSousStepXML(String SousStep, String Etat, String Image) throws Exception {
		SimpleDateFormat date_execution = null;
		Date aujourdhui = new Date();
		date_execution = new SimpleDateFormat("dd-MM-yyyy");
			
		SimpleDateFormat heure_debut = null;
		heure_debut = new SimpleDateFormat("hh:mm:ss");
		
		  Message_Resultat =	Message_Resultat + " <Steps>" + newLine ;
		  Message_Resultat =	Message_Resultat + " <SousStep>"+SousStep+"</SousStep>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<Etat>"+Etat+"</Etat>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<Image>"+Image+"</Image>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<DateExec>"+date_execution.format(aujourdhui)+"</DateExec>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<HeureExec>"+heure_debut.format(aujourdhui)+"</HeureExec>" + newLine ;
		  Message_Resultat =	Message_Resultat + "</Steps>" + newLine ;
		  
		  
		  if(Etat.equals("f"))
		  {
			  EtatStep = "f";
			  EtatFinal = "f";
		  }
		}	
	
	public   void AjouterSousStepXML(String SousStep, String Etat) throws Exception {
		SimpleDateFormat date_execution = null;
		Date aujourdhui = new Date();
		date_execution = new SimpleDateFormat("dd-MM-yyyy");
			
		SimpleDateFormat heure_debut = null;
		heure_debut = new SimpleDateFormat("hh:mm:ss");
		
		  Message_Resultat =	Message_Resultat + " <Steps>" + newLine ;
		  Message_Resultat =	Message_Resultat + " <SousStep>"+SousStep+"</SousStep>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<Etat>"+Etat+"</Etat>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<DateExec>"+date_execution.format(aujourdhui)+"</DateExec>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<HeureExec>"+heure_debut.format(aujourdhui)+"</HeureExec>" + newLine ;
		  Message_Resultat =	Message_Resultat + "</Steps>" + newLine ;
		  
		  
		  if(Etat.equals("f"))
		  {
			  EtatStep = "f";
			  EtatFinal = "f";
		  }
		}	
	
	public   void Set_CloturerReportXML(String id_case) throws Exception {
		String resultatHtml = "";
		String resultatHTML2 = "";
		 String Path = new java.io.File( "." ).getCanonicalPath();
		SimpleDateFormat date_execution = null;
		Date aujourdhui = new Date();
		date_execution = new SimpleDateFormat("dd-MM-yyyy");
			
		SimpleDateFormat heure_debut = null;
		heure_debut = new SimpleDateFormat("hh:mm:ss");
		
		
		SimpleDateFormat nameFile = null;
		nameFile = new SimpleDateFormat("yyy_mm_dd_hh_mm_ss");
		
		String Ext = nameFile.format(aujourdhui);
		
		String NameXML = "xml/" + id_case + "_" + Ext + ".xml";
		String NameHTML =  "xml/" + id_case + "_" + Ext + ".html";
		String NameTxt = "Tmp.txt";
		
		  Message_Resultat =	Message_Resultat +  "<EtatStep>"+EtatStep+"</EtatStep>" + newLine ;
		  Message_Resultat =	Message_Resultat + "</Step>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<resultat>"+EtatFinal+"</resultat>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<date_fin>"+date_execution.format(aujourdhui)+"</date_fin>" + newLine ;
		  Message_Resultat =	Message_Resultat + "<heure_fin>"+heure_debut.format(aujourdhui)+"</heure_fin>" + newLine ;
		  Message_Resultat =	Message_Resultat + "</Rapport>" + newLine ;
		  
		  //File f = new File (NameXML);
		  Writer f = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(NameXML), "UTF-8"));
		  f.write (Message_Resultat);
		  f.close();
		  
		 String Message_Resultat_xml = "";
		  
		  final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		  final DocumentBuilder builder = factory.newDocumentBuilder();
          final Document document= builder.parse(new File(NameXML));
          final Element racine = document.getDocumentElement();
          
          	final Element Rapport = racine;
          
          	final Element build_id = (Element) Rapport.getElementsByTagName("build_id").item(0);
	        final Element test_plan_id = (Element) Rapport.getElementsByTagName("test_plan_id").item(0);
	        final Element id_case2 = (Element) Rapport.getElementsByTagName("id_case").item(0);
	        final Element date_execution2 = (Element) Rapport.getElementsByTagName("date_execution").item(0);
	        final Element heure_debut2 = (Element) Rapport.getElementsByTagName("heure_debut").item(0);
	        final Element resultat = (Element) Rapport.getElementsByTagName("resultat").item(0);
	        final Element heure_fin = (Element) Rapport.getElementsByTagName("heure_fin").item(0);
	       // final Element date_fin = (Element) Rapport.getElementsByTagName("date_fin").item(0);
	        
	        
	       // System.out.println(date_fin.getTextContent());
	        
	        
	        
	        
	    	  
	    	  Message_Resultat_xml =	Message_Resultat_xml +  "<body>" + newLine ;
	    	  Message_Resultat_xml =	Message_Resultat_xml +  "<div class='log'>" + newLine ;
	    	  Message_Resultat_xml =	Message_Resultat_xml +  "<div class='s'>" + newLine ;
	    	  
	    	  Message_Resultat_xml =	Message_Resultat_xml +  "<div class='test-name'>" + newLine ;
	    	  
	    	  Message_Resultat_xml =	Message_Resultat_xml + id_case2.getTextContent() + " - " + 
								    	  build_id.getTextContent() + " - " + 
								    	  test_plan_id.getTextContent() + " - <strong>" +
								    	  resultat.getTextContent() + "</strong> - Date Debut : <strong>" +
								    	  date_execution2.getTextContent()  + "</strong> - Heure Debut : <strong>" +
								    	  heure_debut2.getTextContent() + "</strong> - Heure Fin : <strong>" +
								    	  heure_fin.getTextContent() + "</strong> </div> " + newLine ;
				
				Message_Resultat_xml =	Message_Resultat_xml +  "<div class='total-time'> DUREE TOTALE: </div>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "<div class='ui-background'>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "<div class='transparent'> </div>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "<a class='button'>Close</a>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;

				Message_Resultat_xml =	Message_Resultat_xml +  "<div class='gs'>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "<div id='tcs' class='g'>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;
								
				Message_Resultat_xml =	Message_Resultat_xml +  "<input id='totaltime' type='hidden' value='<!-- Total_Time -->'/>"+ newLine;
				Message_Resultat_xml =	Message_Resultat_xml +  "<div class='g'>	"+ newLine;
	        
	        
		    
		    
	        final NodeList racineNoeuds = racine.getElementsByTagName("Step");
	        final int nbRacineNoeuds = racineNoeuds.getLength();
	        for (int i = 0; i<nbRacineNoeuds; i++) 
	        {
	        	if(racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) 
	        	{
	        		final Element Step = (Element) racineNoeuds.item(i);
	        		
	        		final Element Commentaire = (Element) Step.getElementsByTagName("Commentaire").item(0);
	    	       // final Element date_executionStep = (Element) Step.getElementsByTagName("date_executionStep").item(0);
	    	        final Element heure_debutStep = (Element) Step.getElementsByTagName("heure_debutStep").item(0);
	    	        final Element EtatStep = (Element) Step.getElementsByTagName("EtatStep").item(0);
	    	        
	    	        
	    	       // System.out.println(date_executionStep.getTextContent());
	    	        
	    	       if(EtatStep.getTextContent().equals("f"))
	    	       {
	    	    	   resultatHtml = "failed";
	    	       }else{
	    	    	   resultatHtml = "passed";
	    	       }
					
					Message_Resultat_xml =	Message_Resultat_xml +  "<div class='g'>"+ newLine;
					Message_Resultat_xml =	Message_Resultat_xml +  "<div class='g-h " + resultatHtml + "'>"+Commentaire.getTextContent()+"<span name='time' class='right'>"+heure_debutStep.getTextContent()+"</span></div>"+ newLine;
					Message_Resultat_xml =	Message_Resultat_xml +  "<div class='g-c'>"+ newLine;
					
	    	        final NodeList racineNoeudsSteps = Step.getElementsByTagName("Steps");
	    	        final int nbRacineNoeudsStep = racineNoeudsSteps.getLength();
	    	        for (int j = 0; j<nbRacineNoeudsStep; j++) 
	    	        {
	    	        	if(racineNoeudsSteps.item(j).getNodeType() == Node.ELEMENT_NODE) 
	    	        	{
	    	        		final Element Steps = (Element) racineNoeudsSteps.item(j);
	    	        		
	    	        		final Element SousStep = (Element) Steps.getElementsByTagName("SousStep").item(0);
	    	    	        final Element Etat = (Element) Steps.getElementsByTagName("Etat").item(0);
	    	    	        final Element Image = (Element) Steps.getElementsByTagName("Image").item(0);
	    	    	        //final Element DateExec = (Element) Steps.getElementsByTagName("DateExec").item(0);
	    	    	        //final Element HeureExec = (Element) Steps.getElementsByTagName("HeureExec").item(0);
	    	    	        
	    	    	       // System.out.println(SousStep.getTextContent());
	    	    	       // System.out.println(DateExec.getTextContent());
	    	    	       // System.out.println(HeureExec.getTextContent());
	    	    	        
	    	    	        if(Etat.getTextContent().equals("p"))
	    	    	        {
	    	    	        	resultatHTML2 = "passed";
	    	    	        }else{
	    	    	        	resultatHTML2 = "fail";
	    	    	        }
							
							 Message_Resultat_xml =	Message_Resultat_xml +  "<div class='m "+resultatHTML2+"'>" + newLine;
							
							 if(Image.getTextContent().length()>250)
								 Message_Resultat_xml =	Message_Resultat_xml +  "<img class='screenshot' src='data:image/png;base64,"+Image.getTextContent()+"' />" + newLine;
							 
							 
							 Message_Resultat_xml =	Message_Resultat_xml +  SousStep.getTextContent() + newLine;
							 Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;
							
	    	        	}
	    	        }
		        }
	        	Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;
	        	Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;
	        } 
	        Message_Resultat_xml =	Message_Resultat_xml +  "</div>"+ newLine;
	        Message_Resultat_xml =	Message_Resultat_xml +  "</body>"+ newLine;
	        Message_Resultat_xml =	Message_Resultat_xml +  "</html>"+ newLine;
	        
	        File f2 = new File (NameTxt);
	        FileReader fr = new FileReader (f2);
	        BufferedReader br = new BufferedReader (fr);
	     
	       
		    String line = br.readLine();
		    String tmp = "";
		    while (line != null)
		    {
		      line = br.readLine();
		       tmp = tmp + line + newLine;
		    }
		    br.close();
		    fr.close();
		    tmp = tmp + Message_Resultat_xml;
	        
		    
		    Writer f3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(NameHTML), "UTF-8"));
			  f3.write (tmp);
			  f3.close();
		    
		 
		}
	
	
}

