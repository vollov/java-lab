package org.demo.algorithm;

/**
 * class to find second minimal number in an array. Without sorting an array.
 * 
 * Assumption: 
 * 1) no repeat numbers.
 * 2) array size bigger than 2
 * e.g. 
 * test 1: 2,1,13,8,5,78,26 -> 2
 * test 2: 2,1,13,8,5,26 -> 2
 */
public class SecondMinimal {

	public int f,s;
	
	/**
	 * initlize compare system
	 */
	public void init(int a, int b){
		// init
		f = a;
		s = b;
		
		if(f>s) {
			f = b;
			s = a;
		}
	}
	
	/**
	 * insert next candidate
	 * @param candidate
	 */
	public boolean compete(int[] candidate){

		int canadidateSize = candidate.length;
		
		if(canadidateSize < 2){
			System.out.println("Invalid Input: size at lease be 2 ");
            return false;
		}
		
		// if only two candidate, compete finised 
		if(canadidateSize == 2){
			init(candidate[0],candidate[1]);
			if(candidate[0] == candidate[1]){
				System.out.println("Invalid Input: tow numbers should not be same");
				return false;
			} else {
				return true;
			}
			//System.out.println("2nd minimal is: " + big(candidate[0], candidate[1]));
		}
		
		init(candidate[0],candidate[1]);
		
		for(int i=2; i < canadidateSize; i++){
			// first filter out duplicated min number
			if(candidate[i] == f){
				continue;
			}
			
			if(candidate[i] < s){
				s= candidate[i];
			}
			if(f > s) {
				s = f;
				f = candidate[i];
			}
		}
		return true;
	}
}
