package bibliotheque;

import net.codestory.simplelenium.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;


public class ElementSelenium  extends SeleniumTest{

	
	private static boolean isElementPresent(WebDriver driver,By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
	
	
	public static  void Set_Txt(WebDriver driver, String Path_Txt, String Valeur) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	if(!Valeur.equals("")){
	            		driver.findElement(By.xpath(Path_Txt)).clear();
	            		driver.findElement(By.xpath(Path_Txt)).sendKeys(Valeur);
	            	}
	            	if(Valeur.equals("vide")){
	            		driver.findElement(By.xpath(Path_Txt)).clear();
	            	}
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	

	
	
	
	public static  void Set_File(WebDriver driver, String Path_Txt, String Valeur) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	if(!Valeur.equals("")){
	            		WebElement element = driver.findElement(By.xpath(Path_Txt));
	        			element.click();
	        			uploadFile("path to the file");
	        			Thread.sleep(2000);
	            	}
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	public void Set_File( String Path_Txt, String Valeur) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
            	VerifElement Verification = new VerifElement();
	            if (Verification.IsTestElementPresent_True(Path_Txt)){ 
	            	if(!Valeur.equals("")){
	            		find(Path_Txt).click();
	        			uploadFile("path to the file");
	            	}
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	public static  void Set_Cmb_Value(WebDriver driver, String Path_Txt, String Valeur) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	if(!Valeur.equals("")){
	            		WebElement ComboBox = driver.findElement(By.xpath(Path_Txt));
	        			Select Cmb_ComboBox = new Select(ComboBox);
	        			Cmb_ComboBox.selectByValue(Valeur);
	        			Thread.sleep(1000L);
	            	}
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	public static  void Set_Cmb_Text(WebDriver driver, String Path_Txt, String Valeur) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	if(!Valeur.equals("")){
	            		WebElement ComboBox = driver.findElement(By.xpath(Path_Txt));
	        			Select Cmb_ComboBox = new Select(ComboBox);
	        			Cmb_ComboBox.selectByVisibleText(Valeur);
	        			Thread.sleep(1000L);
	            	}
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	
	public static  void Set_Cmb_Index(WebDriver driver, String Path_Txt, int Valeur) throws InterruptedException
	{
		
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	if(Valeur != 0)
	        		{
	        			WebElement ComboBox = driver.findElement(By.xpath(Path_Txt));
	        			Select Cmb_ComboBox = new Select(ComboBox);
	        			Cmb_ComboBox.selectByIndex(Valeur);
	        			Thread.sleep(1000L);
	        		}
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	
	
	
	public static  void Set_Cmb_Value_Null(WebDriver driver, String Path_Txt) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	WebElement ComboBox = driver.findElement(By.xpath(Path_Txt));
	        		Select Cmb_ComboBox = new Select(ComboBox);
	        		Cmb_ComboBox.selectByValue("");
	        		Thread.sleep(1000L);
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	public static  void Set_Cmb_Text_Null(WebDriver driver, String Path_Txt) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	WebElement ComboBox = driver.findElement(By.xpath(Path_Txt));
	        		Select Cmb_ComboBox = new Select(ComboBox);
	        		Cmb_ComboBox.selectByVisibleText("");
	        		Thread.sleep(1000L);
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	
	public static  void Set_Cmb_Index_Null(WebDriver driver, String Path_Txt) throws InterruptedException
	{
		
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){
	        		WebElement ComboBox = driver.findElement(By.xpath(Path_Txt));
	        		Select Cmb_ComboBox = new Select(ComboBox);
	        		Cmb_ComboBox.selectByIndex(0);
	        		Thread.sleep(1000L);
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	
	
	
	
	
	public static  void ClickBtn(WebDriver driver, String Path_Txt) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 10) {System.out.println("erreur Element : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	driver.findElement(By.xpath(Path_Txt)).click();
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	
	public static  void ClickBtnFacultatif(WebDriver driver, String Path_Txt) throws InterruptedException
	{
		for (int second = 0;; second++) {
            if (second >= 5) {System.out.println("Warning : " + Path_Txt);break;}
            try { 
	            if (isElementPresent(driver, By.xpath(Path_Txt))){ 
	            	driver.findElement(By.xpath(Path_Txt)).click();
	            	 Thread.sleep(2000);
	            	break; 
	            }
            } catch (Exception e) {}
            Thread.sleep(1000);
         }
	}
	
	
	
	
	
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }


	@Override
	protected String getDefaultBaseUrl() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
