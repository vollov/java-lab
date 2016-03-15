package org.demo.dom4j;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.Before;
import org.junit.Test;

public class TestDomProcessor {
	private Document giosDom;
	
	/**
	 * Load the test DOM
	 * @throws Exception
	 */
	@Before
    public void setUp() throws Exception {
		giosDom = DomProcessor.loadDom("seed/GIOS-Q1002222-DT.xml");
    }
	
	@Test
	public void getRisksWithOccasionalOperator(){
		List<String> idList = DomProcessor.getRisksWithOccasionalOperator(giosDom);
		
		int expectedRiskSize = 1;
		int actualRiskSize = idList.size();
		assertEquals(expectedRiskSize, actualRiskSize);
		
		String expectedRiskId = "2";
		String actualRiskId = idList.get(0);
		assertEquals(expectedRiskId, actualRiskId);
	}

//	@Test
//	public void getPolicyElement(){
//		Element element = DomProcessor.getPolicyElement(giosDom);
//		System.out.println(element.getName());
//		System.out.println("###########################");
//		System.out.println(element.asXML());
//	}
//	
	@Test
	public void getRiskElement(){
		Element policyElement = DomProcessor.getPolicyElement(giosDom);
		Element riskElement = DomProcessor.getRiskElement(policyElement, "2");
		System.out.println(riskElement.getName());
		System.out.println("###########################");
		System.out.println(riskElement.asXML());
	}
}
