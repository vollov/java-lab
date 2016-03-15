package org.demo.screen;

import java.util.List;

import org.apache.log4j.Logger;
import org.demo.oo.BaseScreen;
import org.demo.oo.ValueObject;

public class CornScreen extends BaseScreen {

	private static final Logger logger = Logger.getLogger(CornScreen.class);
	
	@Override
	public boolean validateScreenObject() {
		logger.info("CornScreen.validateScreenObject()");
		return false;
	}

	/**
	 * Take a value object and fetch the validation rule codes
	 * @param value object
	 * @return a list of validation code
	 */
	public List<String> validateValueObject(ValueObject valueObject) {
		logger.info("CornScreen.validateValueObject()");
		return null;
	}
	
	
}
