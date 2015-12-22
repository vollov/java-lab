package org.demo.oo;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class TestCakeScreen {
	private static final Logger logger = Logger.getLogger(TestCakeScreen.class);
	
	private CakeScreen cakeScreen;
	private ValueObject valueObject;
	
	@Before
    public void setUp() {
        cakeScreen = new CakeScreen();
        valueObject = new ValueObject();
        
        System.out.println("TestCakeScreen @Before - setUp");
    }
	
	@Test
	public void test_validateValueObject(){
		
		cakeScreen.validateValueObject(valueObject);
	}
	
}
