package bibliotheque;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ParserTab {
	
	public static String[][] Get_Tab(WebDriver driver,String idTab, String idTR, int ligne, int col) {
		WebElement table_element = driver.findElement(By.id(idTab));
	    List<WebElement> tr_collection=table_element.findElements(By.xpath(idTR));
	
	    //System.out.println("NUMBER OF ROWS IN THIS TABLE = "+tr_collection.size());
	    int row_num,col_num;
	    row_num=1;
	    String[][] Tab = new String[ligne][col];
	    
	    
	    String text = "";
	    
	    for(WebElement trElement : tr_collection)
	    {
	        List<WebElement> td_collection=trElement.findElements(By.xpath("td"));
	        //System.out.println("NUMBER OF COLUMNS="+td_collection.size());
	        col_num=1;
	        for(WebElement tdElement : td_collection)
	        {
	           // System.out.println("row # "+row_num+", col # "+col_num+ "text="+tdElement.getText());
	            col_num++;
	            text = tdElement.getText();
	            Tab[row_num][col_num] = text.replace("0,00\n�", "0,00 �");
	        }
	        row_num++;
	    } 
	    return (Tab);
	}

    
    

}
