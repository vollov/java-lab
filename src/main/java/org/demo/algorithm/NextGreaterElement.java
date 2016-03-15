package org.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement {

	public List<Integer> compute(int[] list){
		int next;
		List<Integer> r = new ArrayList<Integer>();
		
		for(int i=0; i < list.length; i++){
			//System.out.println("compute for " + list[i]);
			next = list[i];
			for(int j:list){
				//System.out.println("j="+j);
				
				// if next is not initialized, send next to a j which is greater than current item.
				if(next==list[i] && j > next){
					next =j;
				}
				
				if(j < next && j > list[i]){
					next = j;
				}
			}
			//System.out.println("next= " + next + ", list[i]=" + list[i]);
			if(next!=list[i]){
				r.add(next);
			}
		}
		return r;
	}
}
