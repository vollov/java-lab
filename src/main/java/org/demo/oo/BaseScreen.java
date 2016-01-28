package org.demo.oo;

import org.apache.log4j.Logger;

import java.util.List;

public abstract class BaseScreen extends Screen  {
	
	private static final Logger logger = Logger.getLogger(BaseScreen.class);
	
	public boolean isValidationRequired(){
		logger.info("BaseScreen.isValidationRequired()");
		return true;
	}
	
	public boolean isValidateOnLoad(){
		logger.info("BaseScreen.isValidateOnLoad()");
		return true;
	}
	
	/**
	 * Take a value object and fetch the validation rule codes
	 * @param value object
	 * @return a list of validation code
	 */
	public List<String> validateValueObject(ValueObject valueObject) {
		logger.info("BaseScreen.validateValueObject()");
		return null;
	}

	protected void show(){
		logger.info("BaseScreen.show()");
	}
}
