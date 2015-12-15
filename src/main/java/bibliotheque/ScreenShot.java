package bibliotheque;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.apache.commons.io.IOUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenShot {
	
	public static void ImprimeEcrant (WebDriver driver, String path) throws IOException
	{
		String Date_Str = FnctDate.GetDateString_yyyy_MM_dd_HH_mm_SS();
		Date_Str = Date_Str + ".jpg";
		path = path.replace(".jpg", Date_Str);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        ManipuleFile.copyFile (screenshot, new File(path));
        
	}
	
	
	public static String ImprimeEcrantRetour (String path) throws IOException
	{
		String Date_Str = FnctDate.GetDateString_yyyy_MM_dd_HH_mm_SS();
		Date_Str = Date_Str + ".jpg";
		path = path.replace(".jpg", Date_Str);
		//File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //ManipuleFile.copyFile (screenshot, new File(path));
        return (path);
	}
	
	public static String ImprimeEcrant_Base64 (WebDriver driver, String path_outPut, String path) throws IOException
	{
		String Date_Str = FnctDate.GetDateString_yyyy_MM_dd_HH_mm_SS();
		Date_Str = Date_Str + ".jpg";
		path_outPut = path_outPut.replace(".jpg", Date_Str);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        ManipuleFile.copyFile (screenshot, new File(path_outPut));
       
        File f = new File(path_outPut);
        byte[] ba = resize(f, 600, 600);
        IOUtils.write(ba, new FileOutputStream( new File(path_outPut) ) );
    	String F2 = Base64FileEncoder.Get_encodeFile(path_outPut,path) ;
        return (F2);
        
	}
	

public static byte[] resize(File file,
                            int maxWidth, int maxHeight) throws IOException{
    int scaledWidth = 0, scaledHeight = 0;

    BufferedImage img = ImageIO.read( file );

    scaledWidth = maxWidth;
    scaledHeight = (int) (img.getHeight() * ( (double) scaledWidth / img.getWidth() ));

    if (scaledHeight> maxHeight) {
        scaledHeight = maxHeight;
        scaledWidth= (int) (img.getWidth() * ( (double) scaledHeight/ img.getHeight() ));

        if (scaledWidth > maxWidth) {
            scaledWidth = maxWidth;
            scaledHeight = maxHeight;
        }
    }

    Image resized =  img.getScaledInstance( scaledWidth, scaledHeight, Image.SCALE_SMOOTH);

    BufferedImage buffered = new BufferedImage(scaledWidth, scaledHeight, Image.SCALE_REPLICATE);

    buffered.getGraphics().drawImage(resized, 0, 0 , null);

    String formatName = getFormatName( file ) ;

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    ImageIO.write(buffered,
            formatName,
            out);

    return out.toByteArray();
}


private static String getFormatName(ImageInputStream iis) {
    try { 

        // Find all image readers that recognize the image format
        Iterator<?> iter = ImageIO.getImageReaders(iis);
        if (!iter.hasNext()) {
            // No readers found
            return null;
        }

        // Use the first reader
        ImageReader reader = (ImageReader)iter.next();

        // Close stream
        iis.close();

        // Return the format name
        return reader.getFormatName();
    } catch (IOException e) {
    }

    return null;
}

private static String getFormatName(File file) throws IOException {
    return getFormatName( ImageIO.createImageInputStream(file) );
}
/*
private static String getFormatName(InputStream is) throws IOException {
    return getFormatName( ImageIO.createImageInputStream(is) );
}*/
	
	
	
	
	

}
