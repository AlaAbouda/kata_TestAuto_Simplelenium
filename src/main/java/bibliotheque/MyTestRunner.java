package bibliotheque;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;







import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



@SuppressWarnings("rawtypes")
public class MyTestRunner {
	
		public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException
		{
			//List testCases = new ArrayList();
			 List<Class<?>> testCases=new ArrayList<Class<?>>();
			 String Val = null;
        	 String Path = new java.io.File( "." ).getCanonicalPath();
			 String Tab2[] = ReadXML(Path + "/UsesCase/Conf.xml");
			 for(int i=0; i<Tab2.length; i++)
			{
				 Val = Tab2[i];
				 if(Val != null)
				 {
					 System.out.println(Val);
					 testCases.add(Class.forName(Val));
				 }
			}

			
			for (Class testCase : testCases)
	        {
	            runTestCase(testCase);
	        }
		}

	    private static void runTestCase(Class testCase)
	    {
	        Result result = JUnitCore.runClasses(testCase);
	        if(result.wasSuccessful()){
	        	System.out.println ("succes "+testCase.getName());
	        }else{
	        	System.out.println ("failure "+testCase.getName());
	        }
	        	
	        for (Failure failure : result.getFailures())
	        {
	        	System.out.println(failure.toString());
	        }
	    }
	    
	    
	    
	public static String[] ReadXML(String NameXML) throws ParserConfigurationException, SAXException, IOException {
		String[] Tab = new String[300];
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(NameXML));
		
		NodeList nodeList = document.getDocumentElement().getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node firstPersonNode = nodeList.item(i);
			
			if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){
				  
				 Element firstPersonElement = (Element)firstPersonNode;

                 //-------
                 NodeList firstNameList = firstPersonElement.getElementsByTagName("TestCase");
                 Element firstNameElement = (Element)firstNameList.item(0);
                 
                 NodeList textFNList = firstNameElement.getChildNodes();
                 Tab[i] =  textFNList.item(0).getNodeValue().trim();
                // System.out.println("First Name : " + i +
                //        ((Node)textFNList.item(0)).getNodeValue().trim());
			}
		}
		return (Tab);
	}
}