package org.demo.fop;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.apache.fop.apps.FOPException;
import org.junit.Test;

public class TestXmlToPdfProcessor {
	
	//@Test
	public void employeePDF() throws FOPException, IOException, TransformerException{
		XmlToPdfProcessor.convertToPDF("employee.xml", "employee.xsl");
	}
	
	
	@Test
	public void eigPDF() throws FOPException, IOException, TransformerException{
		XmlToPdfProcessor.convertToPDF("GIOS-Q1002196-DT.xml", "Energie.Auto.xsl");
	}
}
