package org.demo.algorithm;

import java.util.List;

import org.junit.Test;

public class TestNextGreaterElement {

	NextGreaterElement nge = new NextGreaterElement();
	
	@Test
	public void testGroup1(){
		int[] candidate = new int[]{20,10,4,3,8,9,30};
		System.out.println("G1========");
		printResult(nge.compute(candidate));
	}
	
	@Test
	public void testOddNumbers(){
		int[] candidate = new int[]{2,1,13,8,5,78,26};
		System.out.println("G2========");
		printResult(nge.compute(candidate));
	}
	
	public void printResult(List<Integer> l){
		for(Integer x: l){
			System.out.print(x + ",");
		}
		System.out.println("");
		System.out.println("==========");
	}
}
