package org.demo.dom4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DomProcessor {

	public static final String PRINCIPAL_DRIVER = "PRINCIPAL";
	public static final String OCCASIONAL_DRIVER = "PRINCIPOD";
	public static final String NOT_RATED_DRIVER = "NOTRATED";
	
	
	public static InputStream getInputStream(String fileName) throws IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(fileName);
		return inputStream;
	}

	public static Document loadDom(String fileName) {
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			InputStream inputStream = getInputStream(fileName);
			doc = reader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	/**
	 * find the risks with occasional operator in
	 * DriverMeansOfTransportRelationship
	 * 
	 * @param document
	 * @return
	 */
	public static List<String> getRisksWithOccasionalOperator(Document document) {
		HashSet<String> riskIdSet = new HashSet<String>();

		Element ele = document.getRootElement();
		
		for (Iterator<Element> iter = ele.elementIterator(); iter.hasNext(); ) {
			Element element = iter.next();
//			System.out.println(element.getName());
//			System.out.println("###########################");
//			System.out.println(element.asXML());
		}
		
		
		
		
//		List<Node> nodeList = document.selectNodes("//DriverMeansOfTransportRelationship");
//		for (Node node : nodeList) {
//			if (node instanceof Element) {
//				String driverType = node.selectSingleNode("DriverTypeCd").getText();
//				if (DomProcessor.OCCASIONAL_DRIVER.equals(driverType)) {
//					String riskId = node.selectSingleNode("RiskId").getText();
//					riskIdSet.add(riskId);
//				}
//			}
//		}
//		List<String> riskIdList = new ArrayList<String>(riskIdSet);
		List<String> riskIdList = null;
		return riskIdList;
	}
	
	public static Element findElement(Element element, String name) {
		Element currentElement = null;
		for (Iterator<Element> iter = element.elementIterator(); iter.hasNext(); ) {
			currentElement = iter.next();
			String currentName = currentElement.getName();
			if (name.equalsIgnoreCase(currentName)){
				return currentElement;
			}
		}
		return currentElement;
	}
	
	public static Element findChildValue(Element element, String name, String value) {
		Element currentElement = null;
		for (Iterator<Element> iter = element.elementIterator(); iter.hasNext(); ) {
			currentElement = iter.next();
			String currentName = currentElement.getName();
			if (name.equalsIgnoreCase(currentName)){
				String v = currentElement.getText();
				if(v.equals(value)){
					return currentElement;
				}
			}
		}
		return currentElement;
	}
	
	
	public static Element getPolicyElement(Document document){
		Element rootElement = document.getRootElement();
		
		// <ReplyQuery>
		Element replyQueryElement = findElement(rootElement, "ReplyQuery");
		// <Policy>
		Element policyQueryElement = findElement(replyQueryElement, "Policy");
		
		return policyQueryElement;
	}
	
	public static Element getRiskElement(Element policyElement, String riskId){
		Element currentElement = null;
		Element riskElement = null;
		for (Iterator<Element> iter = policyElement.elementIterator(); iter.hasNext(); ) {
			currentElement = iter.next();
			String currentName = currentElement.getName();
			
			if ("Risk".equalsIgnoreCase(currentName)){
				System.out.println("XXXX" + currentName);
				
				return currentElement
//				riskElement = findChildValue(currentElement, "RiskId", riskId);
//				if(riskElement!= null){
//					return riskElement;
//				}
			}
		}
		return riskElement;
	}
}
