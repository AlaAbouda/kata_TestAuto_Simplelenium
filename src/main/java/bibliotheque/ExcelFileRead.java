package bibliotheque;
import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelFileRead {
	

	  public static String[][] read(String inputFile, int nb1, int nb2 ) throws IOException  {
		String[][] Tab = new String[nb1][nb2];
	    File inputWorkbook = new File(inputFile);
	    Workbook w;
	    try {
	      w = Workbook.getWorkbook(inputWorkbook);
	      Sheet sheet = w.getSheet(0);
		@SuppressWarnings("unused")
		int n = sheet.getColumns();
		@SuppressWarnings("unused")
		int m = sheet.getRows();
	      for (int j = 0; j < sheet.getColumns(); j++) {
	        for (int i = 0; i < sheet.getRows(); i++) {
	          Cell cell = sheet.getCell(j, i);
	          Tab[i][j] = cell.getContents();
	        }
	      }
	    } catch (BiffException e) {
	      e.printStackTrace();
	    }
		return Tab;
	  }
	  
	  public static String[][] read(String inputFile, String SheetName, int nb1, int nb2 ) throws IOException  {
			String[][] Tab = new String[nb1][nb2];
		    File inputWorkbook = new File(inputFile);
		    Workbook w;
		    try {
		      w = Workbook.getWorkbook(inputWorkbook);
		      Sheet sheet = w.getSheet(SheetName);
			  int n = sheet.getColumns();
			  int m = sheet.getRows();
		      for (int j = 0; j < sheet.getColumns(); j++) {
		        for (int i = 0; i < sheet.getRows(); i++) {
		          Cell cell = sheet.getCell(j, i);
		          Tab[i][j] = cell.getContents();
		        }
		      }
		    } catch (BiffException e) {
		      e.printStackTrace();
		    }
			return Tab;
		  }
	  
	  public static int Get_NB_Rows(String inputFile ) throws IOException  {
			File inputWorkbook = new File(inputFile);
		    Workbook w;
		    int Nb_Rows = 0;
		    try {
		      w = Workbook.getWorkbook(inputWorkbook);
		      Sheet sheet = w.getSheet(0);
		      Nb_Rows = sheet.getRows();
		     
		    } catch (BiffException e) {
		      e.printStackTrace();
		    }
		    return (Nb_Rows);
		  }
	  
	  public static int Get_NB_Columns(String inputFile ) throws IOException  {
			File inputWorkbook = new File(inputFile);
		    Workbook w;
		    int Nb_Columns = 0;
		    try {
		      w = Workbook.getWorkbook(inputWorkbook);
		      Sheet sheet = w.getSheet(0);
		      Nb_Columns = sheet.getColumns();
		     
		    } catch (BiffException e) {
		      e.printStackTrace();
		    }
		    return (Nb_Columns);
		  }
	  
	  public static String find_element_position(String inputFile,  int pos, int row ) throws IOException  {
			File inputWorkbook = new File(inputFile);
			String val = "";
		    Workbook w;
		    try {
		      w = Workbook.getWorkbook(inputWorkbook);
		      Sheet sheet = w.getSheet(0);
		      Cell cell = sheet.getCell(pos, row);
		      val = cell.getContents();
		    } catch (BiffException e) {
		      e.printStackTrace();
		    }
			return val;
		  }
	  
	  

}
