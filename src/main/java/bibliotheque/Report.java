package bibliotheque;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;



import org.apache.commons.io.IOUtils;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;




import sun.misc.BASE64Encoder;

public class Report {
	
	
	
	private   String Statut_Resultat ;
	private  String Message_Resultat;
	private  String id_Resultat;
	private  String id_Step;
	private  String id_sous_Step;
	
	private RapportXMLHtml Rapport=new RapportXMLHtml(); 
	
	
	
	public Report()   {
		Statut_Resultat = "Passed";
		Message_Resultat = "";
		id_Resultat = "0";
		id_Step = "0";
		id_sous_Step = "0";
	}
	
	public  String setCreateReport(String status, String id_Case) throws Exception {
		Rapport.Set_CreateReportXML("", "", id_Case);
		return (id_Resultat);
	}
	
	
	
	public  String setCreateStep(String id_execution, String step, String status, String Image) throws Exception {
		//step = 	ConvertElement(step);
		Rapport.AjouterStepXML(step);
		return (id_Step);
	}
	
	
	public  String setCreateSousStep(String id_execution, String step, String status, String Image) throws Exception {
		//step = 	ConvertElement(step);
		Rapport.AjouterSousStepXML(status,step, Image);
		return (id_sous_Step);
	}
	
	public  String setCreateSousStep(String id_execution, String step, String status) throws Exception {
		//step = 	ConvertElement(step);
		Rapport.AjouterSousStepXML(status,step);
		return (id_sous_Step);
	}
	
	public  void cloturerReport(String id_case) throws Exception {
		Rapport.Set_CloturerReportXML(id_case);
	}
	
	
	
	
	public  void setStatutResultatFailed() throws IOException {
		Statut_Resultat = "Failed";
	}
	
	public void setMessageResultat( String Message) throws IOException {
		String newLine = System.getProperty("line.separator");
		Message_Resultat = Message_Resultat + Message+ newLine;
		
	} 
	
	public  String getStatutResultat( ) throws IOException {
		if(Statut_Resultat == "Passed")
			return ("p");
		else
			return ("f");
	}
	
	public  String getMessageResultat() throws IOException {
		return (Message_Resultat);
	}
	
	
	public  String getIdResultat() throws IOException {
		return (id_Resultat);
	}
	
	
	
	public  String getIdStep() throws IOException {
		return (id_Step);
	}
	
	
	public static void createReport( String from, String to ) throws IOException {
		Path from2 = Paths.get(from);
    	OutputStream to2  = new FileOutputStream(to);
		Files.copy(from2, to2);
	}
	
	
	public static void replaceFileString(String old, String news, String fileDirectory) throws IOException {
	    FileInputStream fis = new FileInputStream(fileDirectory);
	    String content = IOUtils.toString(fis, Charset.defaultCharset());
	    content = content.replaceAll(old, news);
	    FileOutputStream fos = new FileOutputStream(fileDirectory);
	    IOUtils.write(content, new FileOutputStream(fileDirectory), Charset.defaultCharset());
	    fis.close();
	    fos.close();
	}
	
	
	public String sendPostCreateReport(String build_id, String testplan_id, String author_id, String status, String id_Case) throws Exception {
		return (id_Case);
 
	}
	
	public String sendPostUpdateReport(String id, String status, String Message) throws Exception {
		Message = ConvertElement(Message);
		return (Message);
	}
	
	public String sendPostCreateStep(String id_execution, String step, String status, String Image) throws Exception {
		Rapport.AjouterStepXML(step);
		return (step);
	}
	
	public String sendPostCreateSousStep(String id_execution, String step, String status, String Image) throws Exception {
		step = ConvertElement(step);
		
		
		return (step);
 
	}
	
	public void sendPost(String build_id, String testplan_id, String author_id, String status, String id_Case, String Message) throws Exception {
		 Message = ConvertElement(Message);
		
	}
	
	public void sendPostValidReport(String id) throws Exception {
	}
	
	public String ConvertElement(String Chaine)
	{
		
		Chaine = Chaine.replaceAll("'", "_");
		Chaine = Chaine.replaceAll("é", "e");
		Chaine = Chaine.replaceAll("è", "e");
		Chaine = Chaine.replaceAll("à", "a");
		Chaine = Chaine.replaceAll("\"", "*");
		Chaine = Chaine.replaceAll("ô", "o");
		Chaine = Chaine.replaceAll("â", "a");
		Chaine = Chaine.replaceAll("<", " INF ");
		Chaine = Chaine.replaceAll(">", " SUP ");
		return Chaine;
		
		
	}
	
	
	public  void InsertionResultatSosuStep (String Commentaire , String Statut ,  String Photo)throws Exception {
		if(Photo.equals("1"))
		{
			
			 String Path = new java.io.File( "." ).getCanonicalPath();
			Photo = ManipuleFile.getLatestFilefromDir(Path + "\\snapshots");
			String path  = ScreenShot.ImprimeEcrantRetour (Photo); 
			String id_Step = this.getIdStep();
			this.setCreateSousStep(id_Step,Statut,Commentaire,encodeToString(ImageIO.read(new File(path)), "png")  );
		}else
		{
			String id_Step = this.getIdStep();
			this.setCreateSousStep(id_Step,Statut,Commentaire,"" );
		}
	}
	
	
	
	
	
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
	
	
	//@SuppressWarnings("resource")
	@SuppressWarnings("unchecked")
	public HashMap<String, List<List<Object>>> sendPost_Json(String DateExecution) throws Exception {
		//URL url = new URL ("http://sgcib-sla-env:8181/sla/deal/GOB/loadAggregateData/40/31-07-2015");
		String userLogin = "all_admin";
		String userPwd = "all_admin";

		  // init http header
        final List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(acceptableMediaTypes);

        final String plainCreds = userLogin + ":" + userPwd;
        final byte[] plainCredsBytes = plainCreds.getBytes();
        final byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        final String base64Creds = new String(base64CredsBytes);
        headers.add("Authorization", "Basic " + base64Creds);
      
       
        DisableSSLCertificateCheckUtil.disableChecks();
       
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<Object> response = restTemplate.exchange("http://sgcib-sla-env:8181/sla/deal/GOB/loadAggregateData/"+DateExecution,
                HttpMethod.POST, new HttpEntity<Object>(headers), Object.class);
        final HashMap<String, List<List<Object>>> restResult = (HashMap<String, List<List<Object>>>) response.getBody();
        System.out.println(response.getBody().toString());
        
        
        
       // System.out.print(response.getBody().toString());
		return  (restResult) ;
	}
}
