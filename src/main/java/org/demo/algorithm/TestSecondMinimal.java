package org.demo.algorithm;

import org.junit.Test;

public class TestSecondMinimal {
	
	SecondMinimal  sm = new SecondMinimal();
	
	@Test
	public void testOddNumbers(){
		int[] candidate =  new int[]{2,1,13,8,5,78,26};
		if(sm.compete(candidate)){
			System.out.println("odd second min is " + sm.s);
		}
	}
	
	@Test
	public void testEvenNumbers(){
		int[] candidate =  new int[]{13,2,1,8,5,26};
		if(sm.compete(candidate)){
			System.out.println("even second min is " + sm.s);
		}
	}
	
	@Test
	public void testTwoNumbers(){
		int[] candidate =  new int[]{5,26};
		if(sm.compete(candidate)){
			System.out.println("two second min is " + sm.s);
		}
	}
	
	@Test
	public void testInvalidTwoNumbers(){
		int[] candidate =  new int[]{5,5};
		if(sm.compete(candidate)){
			System.out.println("two second min is " + sm.s);
		}
	}
	
	@Test
	public void testDuplicateNumbers(){
		int[] candidate =  new int[]{2,1,1,13,8,5,13,78,26};
		if(sm.compete(candidate)){
			System.out.println("duplicate second min is " + sm.s);
		}
	}
	
	@Test
	public void testOneNumbers(){
		int[] candidate =  new int[]{2};
		if(sm.compete(candidate)) {
			System.out.println("invalid second min is " + sm.s);
		}
	}
	
	@Test
	public void testNumbers(){
		//10
		int[] candidate =  new int[]{12, 13, 1, 10, 34, 1};
		if(sm.compete(candidate)) {
			System.out.println("other second min is " + sm.s);
		}
	}
}
