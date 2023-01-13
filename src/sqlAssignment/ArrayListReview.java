package sqlAssignment;


import java.text.DecimalFormat;
import java.util.ArrayList;

public class ArrayListReview {

	// both array lists and arrays are 0 based that means if we want 10 elements in
	// our array we are going from
	// position 0 to 9

	// a zero based array our GIVEN VALUES
	// positions 0 1 2 3 4 5 6 7 8 9
	// values    a b c d e f g h i j

	// for a 1 based array "toLoad"
	// positions 0 1 2 3 4 5 6 7 8 9 10
	// values      a b c d e f g h i j

	private static final String[] GIVEN_VALUES = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };

	public static void main(String [] args ) {
		// how do we load the GIVEN_VALUES into an array that is 1 based
		String[] toLoad = new String[11];
		
		// this for loop is going to initalize the array to have empty strings
		for (int i = 0 ; i < toLoad.length ; i++ ) {
			toLoad[i] = "";
		}
		
		// this was just a demonstration of how to shift everything by 1
		// how do we loop over the given values and load the array we just created
		for (int i = 0 ; i < GIVEN_VALUES.length ; i++ ) { 
			// we are basicaly shifting all of the elements from the given values to the right by 1
			toLoad[i+1] = GIVEN_VALUES[i];
		}
		
		// HOMEWORK - loop over the GIVEN_VALUES and create a String that is uppercase
		// HINT create a new string named result with value ""
		// loop over the given values and add the value at each position 
		// on the value at each position call the upper case function 
		// then add the upper case value to the result
		// this will be between 3 and 5 lines of code
		// print the final result
		String result = "";
		for ( int i = 0 ; i < GIVEN_VALUES.length ; i++ ) {
			String cap =  GIVEN_VALUES[i].toUpperCase();
			result = result + cap;
		}
		System.out.println(result);
			
		// HOMEWORK #2 - research and read about the difference between "" and null
		String empty = "";
		if ( empty.equals("") ) {
			System.out.println("This is an empty string");
		}
		if ( empty == null ) {
			// this code will not execute because empty is actually a string with characters in it
		}
		
		String snull = null;
		if ( snull == null ) {
			System.out.println("This is an null string");
		} else if ( snull.equals("") ) {
			// this code will not execute because empty actually a null value
		}
		
		
		
		// HOMEWORK #3 - create an array list and populate the ArrayList with all of the 
		// values in our toLoad[], however do not include the 0 position
		// do another loop to print the array list with each letter on the same line (out.print)
		ArrayList<String> list = new ArrayList<>();
		for ( int i = 1 ; i < toLoad.length ; i++ ) {
			list.add(toLoad[i]);
		}
		System.out.print("-->");
		for ( int i = 0 ; i < list.size() ; i++ ) {
			System.out.print(list.get(i));
		}
		System.out.print("\n");
		
		// HOMEWORK #4 - replace c, d, and e in our "toLoad" with "Z"
		// HINT - use a for loop with an index to check each position in the array and
		// replace the ones needed
		// bonus is to use the change value for this one too
		for ( int i = 0 ; i < toLoad.length ; i++ ) {
			if ( toLoad[i].equals("c") || toLoad[i].equals("d") || toLoad[i].equals("e") ) {
				toLoad[i] = "Z";
			}
		}
		// bonus implmentation
		for ( int i = 0 ; i < toLoad.length ; i++ ) {
			if ( toLoad[i].equals("c") || toLoad[i].equals("d") || toLoad[i].equals("e") ) {
				changeValue(toLoad,i,"Z");
			}
		}
		
		
		// HOMEWORK #4a - implement the changeValue function below. 
		changeValue(toLoad,3,"X");
		changeValue(toLoad,1,"X");
		changeValue(toLoad,0,"X");
		
		// HOMEWORK #5 - create a variable with the number 3.14159 and format this number to be 3.14
		// 1) can do this with a DecimalFormat 
		// 2) System.out.format
		
		// this is truncating
		// 3.14159 * 100 = 314.159
		// floor ( 314.159 ) = 314
		// 314 / 100 = 3.14
		double pi = 3.14159;
		System.out.format("the value rounded %.2f\n", pi); 
		
		String pattern = "#.##";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		System.out.format("the value rounded " + decimalFormat.format(pi)); 
		

		
		// ================= DAY 2 ==========================
		
		// Homework - create a new ArrayList and copy all of the values from "toLoad" into the array list
		// this is the same that we did in #3
		// then Loop over the array list and remove any element that has the value "Z"
		// the goal of this is to exercise removing an item from an ArrayList
		// final is to loop over array list and print value .. same as we did in #3
		ArrayList<String> noZs = new ArrayList<>();
		for (int i = 0; i < toLoad.length; i++) {
			if (toLoad[i] != null) {
				String value = toLoad[i];
				if ( ! value.equalsIgnoreCase("Z")) {
					noZs.add(toLoad[i]);
				}
			}
		}
		
		// IMPORTANT - noZs.size(), noZs.get(index), noZs.put(index, value)
		// array eq    toLoad.length, toLoad[index], toLoad[index] = value, toLoad
		
	}

	public static boolean changeValue(String[] toLoad, int index, String value) {
		// toLoad is our array of values
		// index is the position in the array to change
		// value is the string we want to change to.

		// if the value at index is a Z then print a message saying you can not update
		// it and return false and do not make any change;
		// if the index is less than 1 then print a message saying you can not update it
		// and return false and do not many any change;
		// otherwise set the value at index to the value passed in and return true
		if ( index < 1 ){ 
			System.out.println("cant do");
			return false;
		} else if ( toLoad[index] == null ) {
			System.out.println("cant do");
			return false;
		} else if ( toLoad[index].equals("Z") ) {
			System.out.println("cant do");
			return false;
		} else {
			toLoad[index] = value;
		}

		return true;
	}
	
	// This is how to extend an exception
	// based on the problem statement we have to implement the constructor with a string
	// and we simply call super(message) to set the message on the parent exception
	// this is a perfect example to memorize
	class SomeCustomException extends Exception {
		public SomeCustomException(String message) {
			super(message);
		}
	}

}