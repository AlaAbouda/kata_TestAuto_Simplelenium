package bibliotheque;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NBElement {
	
	public static int Get_NBElementXpat(WebDriver driver,String Xpat) {
		int xpathCount = driver.findElements(By.xpath(Xpat)).size();
        return (xpathCount);
	}	    

	
	
}
