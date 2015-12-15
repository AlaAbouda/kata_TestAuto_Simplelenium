package bibliotheque;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class CsvFileHelper {
 
 
 
	public static String[][] run( int ligne, int col) throws InterruptedException, IOException {
 
	String csvFile = "C:/TestAuto/ByblosAutoTest/Data/Table.cvs";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
	String[][] Tab = new String[ligne][col];
	 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		int i = 1;
		while ((line = br.readLine()) != null) {
			String[] country = line.split(cvsSplitBy);
			Tab[i][1] =country[0];
			Tab[i][2] =country[1];
			Tab[i][3] =country[2];
			Tab[i][4] =country[3];
			Tab[i][5] =country[4];
			Tab[i][6] =country[5];
			Tab[i][7] =country[6];
			i++;
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	return (Tab);
  }
 
}