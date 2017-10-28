//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Scanner;
//
//class Solution {
//	HashSet<String> set = new HashSet<>(); 
//    public int solution(int N) {
//    	int count = 0, transform;
//    	String number;
//    	rearranging(String.valueOf(N), "");
//    	for (String s:set) {
////    		System.out.println(s);
//    		transform = Integer.parseInt(s);
//    		number = String.valueOf(transform);
//    		if (number.length()==s.length()) {
//    			count++;
//    		}
//    	}
//    	return count;
//    	
//    }
//    public void rearranging(String s, String generate) {
////    	System.out.println(s+' '+generate);
//    	if (s.length()==0) {
//    		set.add(generate);
//    	}
//    	else {
//    		for(int i=0;i<s.length();i++) {
//    			rearranging(s.substring(0, i).concat(s.substring(i+1,s.length())), generate.concat(s.substring(i,i+1)));
//    		}
//    	}
//    }
//}
//
//public class SameNumber {
//	public static void main(String args[]) {
//		Solution s = new Solution();
//		System.out.println(s.solution(99999));
//	}
//	
//}
