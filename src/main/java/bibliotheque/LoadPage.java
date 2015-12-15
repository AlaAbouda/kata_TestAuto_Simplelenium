package bibliotheque;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoadPage {
	
	public static WebDriver OpenUrl(String URL, String Browser, String Path) throws IOException{
		
		WebDriver driver = null;
		if(Browser.equals("GC"))
		{
			driver = google(URL,Path) ;
		}else if(Browser.equals("ie"))
		{
			driver = ie(URL,Path) ;
		}else
		{
			driver = firefoxe(URL) ;
		}
		
		driver.manage().window().maximize();
		
		return driver; 
	}
	

	
	
public static WebDriver firefoxe(String URL) throws IOException{
		
	
	FirefoxProfile prof=new FirefoxProfile();
		
		prof.setPreference("browser.download.dir", "C:\\Save");
		prof.setPreference("browser.download.folderList", 2);
		prof.setPreference("browser.helperApps.neverAsk.saveToDisk", 
		    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"//MIME types Of MS Excel File.
		    + "application/pdf;" //MIME types Of PDF File.
		    + "application/vnd.openxmlformats-officedocument.wordprocessingml.document;" //MIME types Of MS doc File.
		    + "text/plain;" //MIME types Of text File.
		    + "text/csv"); //MIME types Of CSV File.
		prof.setPreference( "browser.download.manager.showWhenStarting", false );
		prof.setPreference( "pdfjs.disabled", true );
		
		
		prof.setPreference("webdriver.load.strategy", "unstable");
		prof.setAssumeUntrustedCertificateIssuer(false);
		
		WebDriver driver = new FirefoxDriver(prof);
		driver.get(URL);
		
		return driver; 
	}


public static WebDriver google(String URL, String Path) throws IOException{
	
	//Google chrome
	System.setProperty("webdriver.chrome.driver", Path+"\\Lib\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get(URL);
	
	return driver; 
}


public static WebDriver ie(String URL, String Path) throws IOException{
	
	//Internet Explorer
	System.setProperty("webdriver.ie.driver", Path+"\\Lib\\IEDriverServer.exe");
//	WebDriver driver = new InternetExplorerDriver();
	WebDriver driver = new ChromeDriver();
	driver.get(URL);
	
	return driver; 
}

}
