package org.demo.oo;

import java.util.List;

import org.apache.log4j.Logger;

public abstract class Screen {
	
	private static final Logger logger = Logger.getLogger(Screen.class);
	
	public boolean isValidationRequired() {
		logger.info("Screen.isValidationRequired()");
		return false;
	}

	public boolean isValidateOnLoad() {
		logger.info("Screen.isValidateOnLoad()");
		return false;
	}
	
	/**
	 * Take a value object and fetch the validation rule codes
	 * @param value object
	 * @return a list of validation code
	 */
	public List<String> validateValueObject(ValueObject valueObject) {
		logger.info("Screen.validateValueObject()");
		return null;
	}
		
	public abstract boolean validateScreenObject();
}
