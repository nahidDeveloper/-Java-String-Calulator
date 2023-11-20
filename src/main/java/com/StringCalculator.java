package com;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class StringCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "1,2,3\n,4";
		String[] numArry = test.split(",");

		System.out.println(Arrays.toString(numArry));
		System.out.println("Length of array:"+numArry.length);
		//		System.out.println(numArry[3]);
		//		int  a = Integer.parseInt("3");
		//		System.out.println(a);
		//		int b =Integer.parseInt("3\n"); //Cant work whit whitespace
		//		System.out.println(b);

		//Question 4 test case
		//		String d = "//;\n1;2";
		//		String spaceTest = "//123456";
		//		int index = spaceTest.indexOf("//");
		//		System.out.println(index);
		//		
		//		String qqq = "//;\n1;2";
		//		System.out.println(qqq);
		//		String delimter = listDelimiters(qqq);
		//		System.out.println(delimter);

		String rr ="";
		if(!rr.isEmpty()) {
			int num = Integer.parseInt(rr);
		}

	}

	public static String listDelimiters(String numbers) {
		int checkNewDelimiter = numbers.indexOf("//"); //Will return minus 1 if not there
		//		System.out.println("Do we enter this method:"+numbers);
		List<String> delimiterStr = new ArrayList<String>();
		if(checkNewDelimiter>=0) {
			System.out.println("We enter if statement");
			int delimiterEnd = numbers.indexOf("\n");
			String delimiter = numbers.substring(2, delimiterEnd);
			System.out.println("Length of idenfitied str Length"+delimiter.length());
			return delimiter;
		}
		return "";
	}
	
	
	public static int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		} else {
			String delimiters = listDelimiters(numbers);
			String pattern ="";
			if(!delimiters.isEmpty()) {
				pattern = ",|"+listDelimiters(numbers);
			}else {
				pattern =",";
			}
			//        	String pattern =",|"+listDelimiters(numbers);
			if(numbers.indexOf("//")>=0) {
				numbers = numbers.substring(2);
			}


//			System.out.println("This is "+pattern);
			String[] numberArray = numbers.split(pattern);
//			System.out.println("Length of Array now"+numberArray.length);

			System.out.println(Arrays.toString(numberArray));
			int sum = 0;
			//Need to use ArrayList to add negative numbers
			List<Integer> negatives = new ArrayList<Integer>();
			for (int i=0;i<numberArray.length;i++) {
				if(!numberArray[i].isEmpty()) { //Avoids empty Strings
					if(Integer.parseInt(numberArray[i].trim())>0&&Integer.parseInt(numberArray[i].trim())<1000) {
						sum += Integer.parseInt(numberArray[i].trim());//Ignore \n
					}else {
						if(Integer.parseInt(numberArray[i].trim())!=1000) {
						negatives.add(Integer.parseInt(numberArray[i].trim()));
						}
					}
				}
			}
			//Need to check if list of Negatives is empty
			if(!negatives.isEmpty()) {
				 throw new IllegalArgumentException("Negatives not allowed: " + negatives);
			}
			return sum;
		}
	}

}
