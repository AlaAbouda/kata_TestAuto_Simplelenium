package bibliotheque;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;
import sun.misc.BASE64Encoder;


public class VerifElement  extends SeleniumTest{
	
	private static final String Msg_Confirm_DeleteDeal = "Delete Deal Date";
	private static final String Msg_Err_AddNewAggregate = "The Aggregate Id is mandatory. "
			                                               + "The First Coordinate is mandatory."
			                                               + "The Second Coordinate is mandatory."
                                                           + "The Measure is mandatory.";
	private static final String Msg_Confirm_DeleteAggregate = "Delete selected aggregate";
	private static final String Msg_Confirm_DeleteAggregateRef = "Delete selected aggregate reference";
	private static final String Msg_Confirm_DeleteBucket = "Delete selected bucket";
	private static final String Msg_ID_Not_Found = "No matching records found";
	private static final String Msg_No_Data_available = "No data available in table";
	
	

	 public static String encodeToString(BufferedImage image, String type) {
	        String imageString = null;
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();

	        try {
	            ImageIO.write(image, type, bos);
	            byte[] imageBytes = bos.toByteArray();

	            BASE64Encoder encoder = new BASE64Encoder();
	            imageString = encoder.encode(imageBytes);

	            bos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return imageString;
	    }
	
	
	public  boolean IsTestElementPresent_True( String element)
	{   takeSnapshot();
		int xpathCount =   find(By.xpath(element)).driver().findElements(By.xpath(element)).size();
	    if(xpathCount<=0)
	    	return false;
	    else
	        return true;
	}

	public  boolean IsTestElementPresentByIDClass( String element)
	{
	    try
	    {
	    	find(element).should().exist();
	        return true;
	    }
	    catch  (Exception e) 
	    {
	        return false;
	    }
	}
	
	
	public  boolean IsIDElementContainText(String element,String Text)
	{  try
	    { 
		   // int xpathCount =   find(By.xpath(element)).driver().findElements(By.xpath(element)).size();
	    	find(element).should().contain(Text);
	        return true;
	    }
	    catch  (Exception e) 
	    {
	        return false;
	    }
	}
	
	public  boolean IsPathElementContainText(String element,String Text)
	{  try
	    {  
		    takeSnapshot();
			@SuppressWarnings("unused")
			int xpathCount =   find(By.xpath(element)).driver().findElements(By.xpath(element)).size();
			String resultat = find(By.xpath(element)).driver().findElement(By.xpath(element)).getText();
			if( resultat.equals(Text))
	    	 return true;
			else 
			 return false;	
	    }
	    catch  (Exception e) 
	    {
	        return false;
	    }
	}
	public  String Get_Text_Element(String element,String Text)
	{  try
	    {  
		    takeSnapshot();
			@SuppressWarnings("unused")
			int xpathCount =   find(By.xpath(element)).driver().findElements(By.xpath(element)).size();
			String resultat = find(By.xpath(element)).driver().findElement(By.xpath(element)).getText();
			
	    	return resultat;}
	    catch  (Exception e) 
	    {
	        return null;
	    }
	}
	public  boolean VerifierMessage_Existe(String TypeMessage) throws InterruptedException {
		String Message = Get_Message(TypeMessage);
		Message = Message.replace("�", " ");
		boolean ValidConnexion = this.IsTestElementPresent_True(Get_Path_Lbl_Message(Message));
		return (ValidConnexion);	
	}
	
    public static String Get_Message(String TypeMessage) {
		String Message = "";
		switch (TypeMessage) 
		{   
		    case "Msg_Err_AddNewAggregate":        Message = Msg_Err_AddNewAggregate;
                    break;
		    
	        default: Message = TypeMessage;
	                break;
	    }
		return (Message);	
	}
	
	public   String Get_Path_Lbl_Message(String Message)
	{
			return ".//*[contains(text(),'"+Message+"')]";
	}
	
	
	public  void Insertion_Resultat_SosuStep (String Commentaire , String Statut ,  Report Rapport, String Photo)throws Exception {
		 String Path = new java.io.File( "." ).getCanonicalPath();
		if(Photo.equals("1"))
		{
			Photo = ManipuleFile.getLatestFilefromDir(Path + "\\snapshots");
			String path  = ScreenShot.ImprimeEcrantRetour (Photo); 
			String id_Step = Rapport.getIdStep();
			Rapport.setCreateSousStep(id_Step,Statut,Commentaire,encodeToString(ImageIO.read(new File(path)), "png")  );
		}else
		{
			String id_Step = Rapport.getIdStep();
			Rapport.setCreateSousStep(id_Step,Statut,Commentaire,"" );
		}
	}
	
	
	public  void ValidResultat_obtenu_attendu(boolean Resultat_Obtenu, boolean Resultat_Attendu,Report Rapport, String  Desc_Stape)  
			throws Exception {
		 String Path = new java.io.File( "." ).getCanonicalPath();
		String Message = "";
		Desc_Stape = Get_Message(Desc_Stape);
		String id_Step = Rapport.getIdStep();
		
		if(Resultat_Attendu==false){Message = "";}
		String Mes = "         - ''"+Message+"'' "+Desc_Stape;
		
		String Photo = ManipuleFile.getLatestFilefromDir(Path + "\\snapshots");
		String path  = ScreenShot.ImprimeEcrantRetour (Photo); 
		
		if(Resultat_Obtenu==Resultat_Attendu)
		{
			Rapport.setMessageResultat("         - "+Message+" "+Desc_Stape+" ==> passed");
			Rapport.setCreateSousStep(id_Step,"p",Mes,encodeToString(ImageIO.read(new File(path)), "png") );
			
			
		}else
		{
		
			Rapport.setMessageResultat("         - "+Message+" "+Desc_Stape+" ==> Echec*************************");
			Rapport.setStatutResultatFailed();
			Rapport.setCreateSousStep(id_Step,"f",Mes,encodeToString(ImageIO.read(new File(path)), "png") );
		}
	}
	
	
	
	public  void ValidResultat_obtenu_attendu_Light(boolean Resultat_Obtenu, boolean Resultat_Attendu,Report Rapport, String  Desc_Stape)  
			throws Exception {
		 String Path = new java.io.File( "." ).getCanonicalPath();
		String Message = "";
		Desc_Stape = Get_Message(Desc_Stape);
		String id_Step = Rapport.getIdStep();
		
		if(Resultat_Attendu==false){Message = "";}
		String Mes = "         - ''"+Message+"'' "+Desc_Stape;
		
		String Photo = ManipuleFile.getLatestFilefromDir(Path + "\\snapshots");
		String path  = ScreenShot.ImprimeEcrantRetour (Photo); 
		
		if(Resultat_Obtenu==Resultat_Attendu)
		{
			Rapport.setMessageResultat("         - "+Message+" "+Desc_Stape+" ==> passed");
			Rapport.setCreateSousStep(id_Step,"p",Mes,encodeToString(ImageIO.read(new File(path)), "png") );
			
			
		}else
		{
		
			Rapport.setMessageResultat("         - "+Message+" "+Desc_Stape+" ==> Echec*************************");
			Rapport.setStatutResultatFailed();
			Rapport.setCreateSousStep(id_Step,"f","" );
		}
	}
	
	
	
	
	
	
	public  void ValidResultat_attendu(boolean Resultat_Obtenu, boolean Resultat_Attendu,Report Rapport, String  Desc_Stape)  
			throws Exception {
		String Message = "";
		String id_Step = Rapport.getIdStep();
		 String Path = new java.io.File( "." ).getCanonicalPath();
		
		if(Resultat_Attendu==false){Message = "";}
		String Mes = "         - "+Message+" "+Desc_Stape;
		
		String Photo = ManipuleFile.getLatestFilefromDir(Path + "\\snapshots");
		String path  = ScreenShot.ImprimeEcrantRetour (Photo); 
		
		if(Resultat_Obtenu==Resultat_Attendu)
		{
			Rapport.setMessageResultat("         - "+Message+" "+Desc_Stape+" ==> passed");
			Rapport.setCreateSousStep(id_Step,"p",Mes,encodeToString(ImageIO.read(new File(path)), "png") );
			
			
		}else
		{
		
			Rapport.setMessageResultat("         - "+Message+" "+Desc_Stape+" ==> Echec*************************");
			Rapport.setStatutResultatFailed();
			Rapport.setCreateSousStep(id_Step,"f",Mes,encodeToString(ImageIO.read(new File(path)), "png") );
		}
	}
	public  void InsertResultat(boolean Resultat_Obtenu, boolean Resultat_Attendu,Report Rapport, String Texte)  throws Exception 
	{
	
		String Message = ""+ Texte;
		String id_Step = Rapport.getIdStep();
		String Mes = Message;
		if(Resultat_Obtenu==Resultat_Attendu)
		{
			Rapport.setMessageResultat("         - "+Message+" ==> passed");
			Rapport.setCreateSousStep(id_Step,"p",Mes,"" );
		}else
		{
			Rapport.setMessageResultat("         - "+Message + " ==> Echec*************************");
			Rapport.setStatutResultatFailed();
			Mes = Message ;
			Rapport.setCreateSousStep(id_Step,"f",Mes,"" );
		}
	}
	
	public  void InsertResultat( 	String ValResultat_Attendu,
			String ValResultat_Obenue,
			Report Rapport)  throws Exception 
	{
	
		String Message = ""+ ValResultat_Attendu;
		String id_Step = Rapport.getIdStep();
		String Mes = Message;
		if(ValResultat_Attendu.equals(ValResultat_Obenue))
		{
			Rapport.setMessageResultat("         - "+Message+" ==> passed");
			Rapport.setCreateSousStep(id_Step,"p",Mes,"" );
		}else
		{
			Rapport.setMessageResultat("         - "+Message + ". Resultat Obtenue "+ ValResultat_Obenue +" ==> Echec*************************");
			Rapport.setStatutResultatFailed();
			Mes = Message + "''. Resultat Obtenue "+ ValResultat_Obenue ;
			Rapport.setCreateSousStep(id_Step,"f",Mes,"" );
		}
	}
	
	
	



	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}
