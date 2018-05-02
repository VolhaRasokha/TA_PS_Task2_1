package by.epam.ta.ps.task2_1.service.read;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.epam.ta.ps.task2_1.entity.Candy;
import by.epam.ta.ps.task2_1.entity.Sweets;

public class ReadFromXml implements Readable {

	@Override
	public List<Sweets> read() throws ParserConfigurationException, SAXException, IOException {
		List<Sweets> readResult = new ArrayList<Sweets>();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	   
	    File xmlFile = new File("SweetsFromXML.xml");
		Document doc = db.parse(xmlFile);
	    
	    NodeList nodeList = doc.getElementsByTagName("candy");
	    
	    for (int i = 0; i < nodeList.getLength(); i++){
	    	Candy myCandy = new Candy();
	    	Node node = nodeList.item(i);
	        System.out.println();
	        if (Node.ELEMENT_NODE == node.getNodeType()) {
	            Element element = (Element) node;
	           
	            myCandy.setSweetName(element
	                    .getElementsByTagName("sweetsName").item(0)
	                    .getTextContent());

	            myCandy.setWeight(Double.parseDouble(element.getElementsByTagName("sweetsWeight").item(0)
	                    .getTextContent()));
	            
	            myCandy.setCount(Integer.parseInt(element.getElementsByTagName("sweetsCount").item(0)
	                    .getTextContent()));

	            myCandy.setManufacturer(element.getElementsByTagName("sweetsManufacturer").item(0)
	                    .getTextContent());

	            myCandy.setCandyType(element.getElementsByTagName("sweetsCandyType").item(0)
	                    .getTextContent());
	            
	            readResult.add(myCandy);
	        }
	    }

		return readResult;
	}
	
	

}
