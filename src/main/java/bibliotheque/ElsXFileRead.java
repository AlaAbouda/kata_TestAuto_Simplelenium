package bibliotheque;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ElsXFileRead {
	
	  static void readXlsx(File inputFile) 
	  {
		  try 
		  {
	          @SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
	          XSSFSheet sheet = wb.getSheetAt(0);
	          Row row;
	          Cell cell;
	          Iterator<Row> rowIterator = sheet.iterator();
	          while (rowIterator.hasNext()) 
	          {
	        	  row = rowIterator.next();
	              Iterator<Cell> cellIterator = row.cellIterator();
	              while (cellIterator.hasNext()) 
	              {
	            	  cell = cellIterator.next();
	            	  switch (cell.getCellType()) 
	            	  {
		            	  	case Cell.CELL_TYPE_BOOLEAN:
		            	  		System.out.println(cell.getBooleanCellValue());
				                break;
				            case Cell.CELL_TYPE_NUMERIC:
				            	System.out.println(cell.getNumericCellValue());
				                break;
				            case Cell.CELL_TYPE_STRING:
				                System.out.println(cell.getStringCellValue());
				                break;
				            case Cell.CELL_TYPE_BLANK:
				                System.out.println(" ");
				                break;
				            default:
				                System.out.println(cell);
	
		              }
	               }
	          	}
		  }
		  catch (Exception e) 
		  {
		      System.err.println("Exception :" + e.getMessage());
		  }
	  }
	  
	  
	  public static int Get_NB_Rows(String inputFile ) throws IOException  {
		  	@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
          	XSSFSheet sheet = wb.getSheetAt(0);
          	Row row;
          	Cell cell;
          	Iterator<Row> rowIterator = sheet.iterator();
          
		    int Nb_Rows = 0;
		    while (rowIterator.hasNext()) 
	          {
	        	  row = rowIterator.next();
	              Iterator<Cell> cellIterator = row.cellIterator();
	              Nb_Rows = Nb_Rows +1;
	             
	          	}
		    return (Nb_Rows);
		  }
	  
	  public static int Get_NB_Columns(String inputFile ) throws IOException  {
		  @SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
        	XSSFSheet sheet = wb.getSheetAt(0);
        	Row row;
        	Cell cell;
        	Iterator<Row> rowIterator = sheet.iterator();
        
        	 int Nb_Columns = 0;
		    while (rowIterator.hasNext()) 
	          {
	        	  row = rowIterator.next();
	              Iterator<Cell> cellIterator = row.cellIterator();
	              Nb_Columns = 0;
	              while (cellIterator.hasNext()) 
	              {
	            	  Nb_Columns = Nb_Columns +1;
	            	  cell = cellIterator.next();
	               }
	          	}
		    return (Nb_Columns);
		  }
	  
	  
	  
	  public static String find_element_position(String inputFile,  int pos, int row_Pos ) throws IOException  {
		  @SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(inputFile));
        	XSSFSheet sheet = wb.getSheetAt(0);
        	Row row;
        	String val = "";
        	Cell cell;
        	Iterator<Row> rowIterator = sheet.iterator();
        	int Nb_Columns = 0;
        	int Nb_row = 0;
		    while (rowIterator.hasNext()) 
	          { 
		    	 row = rowIterator.next();
	             if(Nb_row==row_Pos)
	             {
			    	 Iterator<Cell> cellIterator = row.cellIterator();
		              Nb_Columns = 0;
		              while (cellIterator.hasNext()) 
		              {
		            	
		            	  cell = cellIterator.next();
		            	  if(Nb_Columns == pos)
		            	  {
			            	 
		            		  switch (cell.getCellType()) 
			            	  {
			            	  		case Cell.CELL_TYPE_BOOLEAN:
			            	  			val =  Boolean.toString(cell.getBooleanCellValue());
						                break;
						            case Cell.CELL_TYPE_NUMERIC:
						            	val = String.valueOf(cell.getNumericCellValue());
						                break;
						            case Cell.CELL_TYPE_STRING:
						                val = cell.getStringCellValue();
						                break;
						            default:
						            	val = "##";
				              }
		            	  }
		            	  Nb_Columns = Nb_Columns +1;
		               }
		              
	             }
	             Nb_row = Nb_row + 1;
	          	}
		    return (val);
		  }
	  
	  
	  
	  
	  

}
