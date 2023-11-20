package com;


import junit.framework.TestCase;

public class StringCalculatorTest extends TestCase {

    public void testEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }
//
    public void testSingleNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }
//
    public void testTwoNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }
//    
    public void testThreeNumbers() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }
//    
    public void testEscapeCharacters() {
    	assertEquals(10, StringCalculator.add("1,2,3\n,4"));
    }
////    
    public void testEscapeCharactersAtTheFront() {
    	assertEquals(10, StringCalculator.add("1,2,\n3,4"));
    }
//    
    public void testDifferentDelimiter() {
    	assertEquals(3, StringCalculator.add("//;\n1;2"));
    }
//    //Using try catch and fail to check for Exception
    public void testWithNegativeNumbers() {
    	try {
    		StringCalculator.add("-1,2");
    		fail("Expected IllegalArgumentException was not thrown.");
    	}catch(IllegalArgumentException e) {
    		assertEquals("Negatives not allowed: [-1]",e.getMessage());
    	}
    }
//    
    public void testWithMoreThanOneNegativeNumbers() {
    	try {
    		StringCalculator.add("2,-4,3,-5");
    		fail("Expected IllegalArgumentException was not thrown.");
    	}catch(IllegalArgumentException e) {
    		assertEquals("Negatives not allowed: [-4, -5]",e.getMessage());
    	}
    }
//    
    public void testWithBigNumbers() {
        assertEquals(2, StringCalculator.add("1000,2"));
    }
    
    public void testWithMultipleLengthDelimiter() {
      assertEquals(2, StringCalculator.add("//[;;]\n1;;2;;3"));
  }
    
    

    
}
