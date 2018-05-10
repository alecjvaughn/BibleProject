import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class Parser {

	public static void main(String[] args) {
		
		try {
			File inputFile = new File("/Users/ry5923un/Developer/Projects/my_projects/BibleProject/assets/bible.xml");
			File outFile = new File("/Users/ry5923un/Developer/Projects/my_projects/BibleProject/assets/bible copy.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
	        NodeList books = doc.getElementsByTagName("book");
	        for (int i = 0; i < books.getLength(); i++) {
	        		Element book = (Element) books.item(i);
	        		NodeList chapters = book.getElementsByTagName("chapter");
	            String temp = book.getAttributes().getNamedItem("chapters").getNodeValue();
	            int count = Integer.parseInt(temp);
	            for(int j = 0; j < count; j++) {
	            		Element chapter = (Element) chapters.item(j);
	            		chapter.setAttribute("num", "" + (j+1));
	            }
	        }
	        // write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(outFile);
			transformer.transform(source, result);

			System.out.println("Done");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
