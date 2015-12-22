package org.demo.oo;

import java.util.List;

import org.apache.log4j.Logger;

public class CakeScreen extends DemoScreen {

	private static final Logger logger = Logger.getLogger(CakeScreen.class);
	
	@Override
	public boolean validateScreenObject() {
		logger.info("CakeScreen.validateScreenObject()");
		return false;
	}

	/**
	 * Take a value object and fetch the validation rule codes
	 * @param value object
	 * @return a list of validation code
	 */
	public List<String> validateValueObject(ValueObject valueObject) {
		logger.info("CakeScreen.validateValueObject()");
		return null;
	}
}
