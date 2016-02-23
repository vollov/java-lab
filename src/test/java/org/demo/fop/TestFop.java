package org.demo.fop;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.apache.fop.pdf.PDFEncryptionParams;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * fop -xml persons.xml -xsl hello.xsl -pdf hello.pdf
 * http://netjs.blogspot.in/2015/07/how-to-create-pdf-from-xml-using-apache-fop.html
 * @author DTZ
 *
 */
public class TestFop {
	
	//@Test
	public void test_fop_by_eig() throws Exception{
		
		Document doc = loadDomFromFile("hello.xml");
		
		FopFactory fopFactory = FopFactory.newInstance();
		Properties sysProperties = System.getProperties(); 
		sysProperties.put("javax.xml.transform.TransformerFactory", "org.apache.xalan.processor.TransformerFactoryImpl");
		
		TransformerFactory tFactory = TransformerFactory.newInstance();
		DocumentSource src = new DocumentSource( doc );
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
	    
	    FOUserAgent userAgent = fopFactory.newFOUserAgent();
	    PDFEncryptionParams parms = new PDFEncryptionParams();
	    parms.setAllowEditContent(false);
	    parms.setAllowEditAnnotations(false);
	    //parms.setAllowFillInForms(false);
	    parms.setAllowCopyContent(false);
	    //parms.setAllowAssembleDocument(false);
	    parms.setOwnerPassword(generateRandomOwnerPassword());
	    userAgent.getRendererOptions().put("encryption-params", parms);
	    
	    Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, userAgent,out);
	    
	    
	}
	
	
	/**
	 * This is a unit testing method only.
	 * 
	 * @return Document object
	 */
	public Document loadDomFromFile(String fileName){
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			InputStream inputStream = new FileInputStream(fileName);
			doc = reader.read(inputStream);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return doc;
	}
	
	private String generateRandomOwnerPassword()
	{
		Random rng = new Random();
		int length = 19;
		String characters = "PasswordSeed";
		
		char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }

	    return new String(text);
	}
	
	//@Test
	public void test_fop_by_demo() throws Exception{
		// Step 1: Construct a FopFactory
		// (reuse if you plan to render multiple documents!)
		FopFactory fopFactory = FopFactory.newInstance();

		// Step 2: Set up output stream.
		// Note: Using BufferedOutputStream for performance reasons (helpful with FileOutputStreams).
		OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("C:/Temp/myfile.pdf")));

		try {
		    // Step 3: Construct fop with desired output format
		    Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

		    // Step 4: Setup JAXP using identity transformer
		    TransformerFactory factory = TransformerFactory.newInstance();
		    Transformer transformer = factory.newTransformer(); // identity transformer add xlst here

		    // Step 5: Setup input and output for XSLT transformation
		    // Setup input stream
		    //Source src = new StreamSource(new File("C:/Temp/myfile.fo"));
		    Document doc = null;
		    SAXReader reader = new SAXReader();
		    
//			doc = reader.read(new StringReader(giosXMLString));
			
		    DocumentSource src = new DocumentSource( doc );
		    
		    // Resulting SAX events (the generated FO) must be piped through to FOP
		    Result res = new SAXResult(fop.getDefaultHandler());

		    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		    // Step 6: Start XSLT transformation and FOP processing
		    transformer.transform(src, res);

		} finally {
		    //Clean-up
		    out.close();
		}
	}
}
