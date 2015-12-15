package bibliotheque;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;

public class perserTab   extends SeleniumTest {    
	
	
    public  String[][] Get_TabHTML(String IdTab) {
        int a = Get_NBElementXpat(".//*[@id='"+IdTab+"']//tr");
        int b = Get_NBElementXpat("(.//*[@id='"+IdTab+"']//tr)[1]//th");
         System.out.println(a);
         System.out.println(b);
         String Xpat = "";
         String Txt = "";
         
         String[][] Tab5 = new String[a+1][b+1]; 
         for(int j=1;j<=b;j++)
         {
             Xpat = "((.//*[@id='"+IdTab+"']//tr)[1]//th)["+j+"]";
             Txt = find(By.xpath(Xpat)).driver().findElement(By.xpath(Xpat)).getText();
             Txt = Formatage_String(Txt);
             Tab5[1][j] = Txt;
         }
         
         for(int i=2;i<=a;i++)
         {
             for(int j=1;j<=b;j++)
             {
                 Xpat = "((.//*[@id='"+IdTab+"']//tr)["+i+"]//td)["+j+"]";
                 Txt = find(By.xpath(Xpat)).driver().findElement(By.xpath(Xpat)).getText();
                 Tab5[i][j] = Txt;
             }
         }
         
         for(int i=1;i<=a;i++)
         {
             for(int j=1;j<=b;j++)
             {
                 System.out.println(Tab5[i][j]);
             }
         }
         
         return (Tab5);
    }    

    
    
    
    
    
    public  int Get_NB_Ligne_TabHTML(String IdTab) {
        int a = Get_NBElementXpat(".//*[@id='"+IdTab+"']//tr");
         return (a);
    }
    
    public  int Get_NB_Col_TabHTML(String IdTab) {
        int b = Get_NBElementXpat( "(.//*[@id='"+IdTab+"']//tr)[1]//th");
         return (b);
    }
    
    
    public  int Get_NBElementXpat(String Xpat) {
        int xpathCount =  find(By.xpath(Xpat)).driver().findElements(By.xpath(Xpat)).size();
        return (xpathCount);
    } 
    
   
    
    public static String Formatage_String(String Txt) {
    	
    	if 	(Txt !=null)
    	{

    	 Txt = Txt.replace("E7", "");
         Txt = Txt.replace("E8", "");
    	
         Txt = Txt.replace(".", ":");
         
    	String[] parts = Txt.split(":");
    	if(parts.length==2)
    	{
    		String part2 = parts[1];
    		if(part2.length()==1)
    		{
    			Txt = Txt + "0";
    		}
    	}
    	
    	Txt = Txt.replace(":", "");
    	Txt = Txt.replace("�", "");
        Txt = Txt.replace("$","");
        Txt = Txt.replace(" ","");
        Txt = Txt.replace("�","");
        Txt = Txt.replace("⿿","");
        Txt = Txt.replace("'","");
       
        Txt = Txt.replace(".", "");
        Txt = Txt.replace("0,00", "0");
        Txt = Txt.replace(",", "");
        Txt = Txt.replace("&nbsp;", " ");
        Txt = Txt.replace("&gt", ">");
        Txt = Txt.replace("&lt", "<");
        
        Txt = Txt.replace("<", " inf ");
        Txt = Txt.replace(">", " sup ");
    	}
    	Txt=Txt+"";
    	return (Txt);
    	} 
    	
    
    
    
    
    
    
    
    public static String[][] SupprimerLigne(String[][] TabExel ,int numLignePr, int numLigneRt) {
    	for (int iEx =0; iEx<TabExel[numLigneRt].length; iEx++)
		{
			TabExel[numLigneRt][iEx]=TabExel[numLignePr][iEx];
		}
    	
        return (TabExel);
    } 
    
    
    
    public static String[][] SupprimerRows(String[][] TabExel ,int numColPr, int longueurTab) {
    	
    	
    	for (int iEx =numColPr; iEx<longueurTab-1; iEx++)
		{
    		
    		for(int jEx=1; jEx<(TabExel[1].length-1); jEx++)
			{
				System.out.println(TabExel[jEx][iEx]);
				System.out.println(TabExel[jEx][iEx+1]);
				TabExel[jEx][iEx]=TabExel[jEx][iEx +1];
				
				
				
			}
		}
    	
    	
        return (TabExel);
    }






	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	} 
    
    

}
