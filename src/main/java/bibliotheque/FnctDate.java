package bibliotheque;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FnctDate {
	
	
	public static String GetDateString_yyyy_MM_dd_HH_mm_SS() throws IOException{
		//Date
		DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		return reportDate; 
	}
	
	public static String GetDateStringNum_yyyy_MM_dd_HH_mm_SS() throws IOException{
		//Date
		String reportDate = GetDateString_yyyy_MM_dd_HH_mm_SS();
		reportDate = reportDate.replace("0", "A");
		reportDate = reportDate.replace("1", "B");
		reportDate = reportDate.replace("2", "C");
		reportDate = reportDate.replace("3", "D");
		reportDate = reportDate.replace("4", "E");
		reportDate = reportDate.replace("5", "F");
		reportDate = reportDate.replace("6", "G");
		reportDate = reportDate.replace("7", "H");
		reportDate = reportDate.replace("8", "I");
		reportDate = reportDate.replace("9", "J");
		reportDate = reportDate.replace("_", "K");
		return reportDate; 
	}
	
	
	
	
}
