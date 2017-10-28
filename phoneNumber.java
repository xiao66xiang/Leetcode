import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Solution {
    public int solution(String s) {
    	String[] parts = s.split("\n");
    	String time, phone, maxPhone = "999-999-999";
    	int hour, minute, second, result = 0, len, totalMinute, max = -1, money;
    	HashMap<String, Integer>bill = new HashMap<>();
    	HashMap<String, Integer>cost = new HashMap<>();
    	for (int i=0;i<parts.length;i++) {
    		time = parts[i].split(",")[0];
    		phone = parts[i].split(",")[1];
    		hour = Integer.parseInt(time.split(":")[0]);
    		minute = Integer.parseInt(time.split(":")[1]);
    		second = Integer.parseInt(time.split(":")[2]);
    		System.out.println(second);
    		len = hour*3600+minute*60+second;
    		if (len<300) {
    			money = 3*len;
    		}else {
    			totalMinute = hour*60+minute;
    			if (second>0) {
    				totalMinute++;
    			}
    			money = totalMinute*150;
    		}
    		if (bill.get(phone)==null) {bill.put(phone, len); cost.put(phone, money);}
    		else {
    			int last = bill.get(phone); 
    			bill.put(phone, len+last); 
    			int lastCost = cost.get(phone); 
    			cost.put(phone, lastCost+result);
    			}   		
    	}
    	for (String phn: bill.keySet()) {
    		if (bill.get(phn)>max || bill.get(phn)==max && phn.compareTo(maxPhone)<0) {
    			max = bill.get(phn);
    			maxPhone = phn;
    		}
    	}
    	for (String phn: cost.keySet()) {
    		System.out.println(phn+' '+bill.get(phn));
    		if (!phn.equals(maxPhone)) {
    			
    			result+=cost.get(phn);}
    	}
    	return result;    
    }
}

public class phoneNumber {
	public static void main(String args[]) {
//		Solution s = new Solution();
		char c = 'b';
		String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int []a = new int[]{1,2};
		System.out.println(c-'a');
		//System.out.println(s.solution("00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090"));
	}
	
}
