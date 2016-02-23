package org.demo.fop;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOURIResolver;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.DocumentSource;
import org.dom4j.io.SAXReader;

/**
 * class to convert pdf to
 * 
 * @author DTZ
 *
 */
public class XmlToPdfProcessor {

	public static InputStream getInputStream(String fileName) throws IOException {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream inputStream = classloader.getResourceAsStream(fileName);
		System.out.println(getURI(fileName));
		return inputStream;
	}

	@SuppressWarnings("static-access")
	public static String getURI(String fileName) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getSystemResource(fileName);
		return url.toString();
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
	 * Method that will convert the given XML to PDF
	 * 
	 * @throws IOException
	 * @throws FOPException
	 * @throws TransformerException
	 */
	public static void convertToPDF(String xml, String xsl) throws IOException, FOPException, TransformerException {

		//StreamSource xslSource = new StreamSource(getInputStream(xsl));

		// the XML file which provides the input
		Document document = loadDom(xml);
		DocumentSource xmlSource = new DocumentSource(document);

		// create an instance of fop factory
		FopFactory fopFactory = FopFactory.newInstance();
		// a user agent is needed for transformation
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		// Setup output
		OutputStream out;
		out = new java.io.FileOutputStream("employee.pdf");

		try {
			// Construct fop with desired output format
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

			// Setup XSLT
			TransformerFactory factory = TransformerFactory.newInstance();
			
			URIResolver uriResolver = new ClasspathResourceURIResolver();
			Source xsltSrc = uriResolver.resolve(xsl, null);
//			
			
			Transformer transformer = factory.newTransformer(xsltSrc);
			transformer.setURIResolver(uriResolver);

			// Resulting SAX events (the generated FO) must be piped through to
			// FOP
			Result res = new SAXResult(fop.getDefaultHandler());

			// Start XSLT transformation and FOP processing
			// That's where the XML is first transformed to XSL-FO and then
			// PDF is created
			transformer.transform(xmlSource, res);
		} finally {
			out.close();
		}
	}
}

class ClasspathResourceURIResolver implements URIResolver {

	public Source resolve(String href, String base) throws TransformerException {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public Source resolve(String href, String base) throws TransformerException {
//		//return new StreamSource(Thread.currentThread().getContextClassLoader().getResourceAsStream(href));
//		
//		StreamSource xslSource= null;
//		try {
//			ClassLoader cl = this.getClass().getClassLoader();
//			InputStream in = cl.getResourceAsStream(href);
//			xslSource = new StreamSource(in);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		xslSource.setSystemId(href);
//		return xslSource;
////	    
////	    
////	    InputSource xslInputSource = new InputSource(in);
////	    Document xslDoc = dBuilder.parse(xslInputSource);
////	    DOMSource xslDomSource = new DOMSource(xslDoc);
////	    xslDomSource.setSystemId(href);
////	    return xslDomSource;
//	}
}