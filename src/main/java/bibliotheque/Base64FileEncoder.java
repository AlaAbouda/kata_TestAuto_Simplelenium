// Sample program to encode a binary file into a Base64 text file.
// Author: Christian d'Heureuse (www.source-code.biz)
package bibliotheque;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base64FileEncoder {



public static void encodeFile (String inputFileName, String outputFileName) throws IOException {
   BufferedInputStream in = null;
   BufferedWriter out = null;
   try {
      in = new BufferedInputStream(new FileInputStream(inputFileName));
      out = new BufferedWriter(new FileWriter(outputFileName));
      encodeStream(in, out);
      out.flush(); }
    finally {
      if (in != null) in.close();
      if (out != null) out.close(); }}

public static String Get_encodeFile (String inputFileName, String outputFileName) throws IOException {
	
	outputFileName = outputFileName + "\\Decode2015_07_07_09_16_93.txt";
	encodeFile(inputFileName, outputFileName); 
	String chaine = "";
	try{
		
		InputStream ips=new FileInputStream(outputFileName); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne;
		while ((ligne=br.readLine())!=null){
			//System.out.println(ligne);
			chaine+=ligne+"\n";
		}
		
		br.close(); 
	}		
	catch (Exception e){
		System.out.println(e.toString());
	}
	
	return (chaine);	   


}


private static void encodeStream (InputStream in, BufferedWriter out) throws IOException {
   int lineLength = 72;
   byte[] buf = new byte[lineLength/4*3];
   while (true) {
      int len = in.read(buf);
      if (len <= 0) break;
      out.write(Base64Coder.encode(buf, 0, len));
      out.newLine(); }}

} // end class Base64FileEncoder
