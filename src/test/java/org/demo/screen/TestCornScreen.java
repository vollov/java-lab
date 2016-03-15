package org.demo.screen;

import org.apache.log4j.Logger;
import org.demo.oo.CakeScreen;
import org.junit.Before;
import org.junit.Test;

public class TestCornScreen {
	private static final Logger logger = Logger.getLogger(TestCornScreen.class);
	
	private CornScreen cornScreen;
	private CakeScreen cakeScreen;
	
	@Before
    public void setUp() {
		cornScreen = new CornScreen();
		cakeScreen = new CakeScreen();
        System.out.println("TestCakeScreen @Before - setUp");
    }

	@Test
	public void test_show(){
	//	cakeScreen.show();
	}
}
