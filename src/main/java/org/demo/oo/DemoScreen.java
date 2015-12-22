package org.demo.oo;

import org.apache.log4j.Logger;

import java.util.List;

public abstract class DemoScreen extends Screen  {
	
	private static final Logger logger = Logger.getLogger(DemoScreen.class);
	
	public boolean isValidationRequired(){
		logger.info("DemoScreen.isValidationRequired()");
		return true;
	}
	
	public boolean isValidateOnLoad(){
		logger.info("DemoScreen.isValidateOnLoad()");
		return true;
	}
	
	/**
	 * Take a value object and fetch the validation rule codes
	 * @param value object
	 * @return a list of validation code
	 */
	public List<String> validateValueObject(ValueObject valueObject) {
		logger.info("DemoScreen.validateValueObject()");
		return null;
	}
}
