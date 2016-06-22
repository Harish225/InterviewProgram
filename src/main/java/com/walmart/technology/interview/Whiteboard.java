package com.walmart.technology.interview;


import java.util.HashMap;
import java.util.Map;

/**
 * @author NKHarish
 *	This class was created to program the Interview Question.
 *  Question: Given Month Number (1-12) & Day (Sunday thru Saturday) as Input to the method 
 *  		  and return the No.of times the day appeared in the month.
 *  Assumptions: Jan 1st - Friday and every month consists of 30 days.
 */
public class Whiteboard {
	
	/**
	 * This method takes month(1-12) and dayInput (Sunday - Saturday) as inputs.
	 * @param month
	 * @param dayInput
	 * Returns Integer value which represents the number of times the day was present in the Input Month.  
	 */
	public int returnNoOfDays(int month, String dayInput){
		
		int monthFirstDayFlag; //Used to hold the Key for the First Day of the given month.      
		Map<Integer,String> dayMap= new HashMap<Integer,String>();
		dayMap.put(1, "Saturday");
		dayMap.put(2, "Sunday");
		dayMap.put(3, "Monday");
		dayMap.put(4, "Tuesday");
		dayMap.put(5, "Wednesday");
		dayMap.put(6, "Thursday");
		dayMap.put(0, "Friday");
		monthFirstDayFlag= (((month-1)* 30)+1) % 7; //Calculates the key for the First Day of the Month.
		if(month==1){ 
			//As Jan 1st is Friday we can directly check whether input day is Saturday or Sunday so that it occurs five times in the month  
			if(dayInput.equals(dayMap.get(1))||dayInput.equals(dayMap.get(2)))
				return 5;
			else 
				return 4;
		}else{
			//As every month has (4*7+2) days, we find the key for the First Day of the month and check if the inputDay equals to either of the 
			//value of the corresponding 2 sequential keys.
			if(dayInput.equals(dayMap.get(monthFirstDayFlag+1))||dayInput.equals(dayMap.get(monthFirstDayFlag+2)))
				return 5;
			else 
				return 4;
		}
	}
	public static void main(String args[]){
		Whiteboard myInterviewProgram = new Whiteboard();
		//Passing February and Wednesday as Inputs.
		System.out.println("No Of Times present: "+myInterviewProgram.returnNoOfDays(2, "Wednesday")); 
	}
}
