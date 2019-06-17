package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String acronym = new String();
		acronym = phrase.substring(0, 1); //gives acronym the first letter of the inputted string
		for (int i = 0; i < phrase.length(); i++) {
			if (phrase.charAt(i) == ' ' || phrase.charAt(i) == '-') { 
				acronym = acronym + phrase.substring(i + 1, i + 2);
			} //this loop iterates through the input and checks if there is a space or a '-' at the current index
			// and then if there is a space or a '-', then the acronym string will add the next letter in the string to the acronym

		}
		acronym = acronym.toUpperCase();
		System.out.println("The acronym for: " + phrase + " is " + acronym);
		return acronym;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		//create a counter for each point value that can be obtained in scrabble
		int onepointcounter = 0;
		int twopointcounter = 0;
		int threepointcounter = 0;
		int fourpointcounter = 0;
		int fivepointcounter = 0;
		int eightpointcounter = 0;
		int tenpointcounter = 0;
		int finalvalue = 0;
		String lowercasestring = string.toLowerCase();
		
		//use a for loop to iterate through string, increment appropriate counter depending on what the character is at that current value of i
		for (int i = 0; i < string.length(); i++) {
			if (lowercasestring.charAt(i) == 'a' || lowercasestring.charAt(i) == 'e' || lowercasestring.charAt(i) == 'i'
					|| lowercasestring.charAt(i) == 'o' || lowercasestring.charAt(i) == 'u'
					|| lowercasestring.charAt(i) == 'l' || lowercasestring.charAt(i) == 'n'
					|| lowercasestring.charAt(i) == 'r' || lowercasestring.charAt(i) == 's'
					|| lowercasestring.charAt(i) == 't') {
				onepointcounter++;
			} else if (lowercasestring.charAt(i) == 'd' || lowercasestring.charAt(i) == 'g') {
				twopointcounter++;
			} else if (lowercasestring.charAt(i) == 'b' || lowercasestring.charAt(i) == 'c'
					|| lowercasestring.charAt(i) == 'm' || lowercasestring.charAt(i) == 'p') {
				threepointcounter++;
			} else if (lowercasestring.charAt(i) == 'f' || lowercasestring.charAt(i) == 'h'
					|| lowercasestring.charAt(i) == 'v' || lowercasestring.charAt(i) == 'w'
					|| lowercasestring.charAt(i) == 'y') {
				fourpointcounter++;
			} else if (lowercasestring.charAt(i) == 'k') {
				fivepointcounter++;
			} else if (lowercasestring.charAt(i) == 'j' || lowercasestring.charAt(i) == 'x') {
				eightpointcounter++;
			} else if (lowercasestring.charAt(i) == 'q' || lowercasestring.charAt(i) == 'z') {
				tenpointcounter++;
			}
		}
		//calculate finalvalue
		finalvalue = (1 * onepointcounter) + (2 * twopointcounter) + (3 * threepointcounter) + (4 * fourpointcounter)
				+ (5 * fivepointcounter) + (8 * eightpointcounter) + (10 * tenpointcounter);
		System.out.println("Scrabble Score for word " + string + " is: " + finalvalue);
		return finalvalue;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration

		
		System.out.println("Inputted phone number: " + string);
		String str;
		//clean out all spaces in the inputted string
		str = string.replaceAll("\\s", "");

		//convert the string into an array of characters, and then create an ArrayList that holds the values of that array
		char[] array = str.toCharArray();
		List<Character> list = new ArrayList<>();

		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		//iterate through the list, and if the character is not a digit, remove it from the list
		for (int i = 0; i < list.size(); i++) {
			if (Character.isDigit(list.get(i)) == false) {
				list.remove(i);
				//if the character is a special character, throw an IllegalArgumentException
				if ((Character.isLetter(list.get(i)) == true) || (list.get(i) == '!') || (list.get(i) == '@')
						|| (list.get(i) == '%') || (list.get(i) == ':')) {
					System.err.println("Invalid characters");
					throw new IllegalArgumentException();

				}
			}
		}
		//use StringBuilder to create a string out of the ArrayList of characters after appropriate elements have been removed
		StringBuilder sb = new StringBuilder();
		for (Character c : list) {
			sb.append(c);
		}
		String finalstr = sb.toString();
		//throw an exception if there are more than 10 digits in a phone number
		if (finalstr.length() > 10) {
			System.err.println("Too many digits");
			throw new IllegalArgumentException();
		} else {

			System.out.println("Cleaned up phone number: " + finalstr);
			return finalstr;
		}
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		// TODO Write an implementation for this method declaration

		Map<String, Integer> map = new HashMap<>();
		//create a list
		List<String> list = new ArrayList<>();
		//create a string array split at either spaces, commas, or a new line 
		String[] array = string.split(" |,|\n");
		//initialize list with values of the String array formed by splitting the input string
		for (int i = 0; i < array.length; i++) {

			list.add(array[i]);
		}
		//use an enhanced for loop to iterate through the list, and check that the current s is not blank, 
		// and then if the map already has that string, then the count for that string increments, 
		//and if its not already in the map, put it in the map as a new entry
		for (String s : list) {
			if (s.equals("") == false) {
				if (map.containsKey(s)) {
					map.put(s, map.get(s) + 1);
				} else {
					map.put(s, 1);
				}
			}
		}
		System.out.println(string);
		System.out.println("Word Count: " + map);
		return map;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			int key = 0;
			int beginning = 0;
			int end = sortedList.size();
			//this block of code will run when the inputted type of T is a an Integer
			if (t instanceof Integer) {
				key = (Integer) t;
				while (beginning <= end) {
					int middle = beginning + (end - beginning) / 2; //find middle position of list
					if (sortedList.get(middle).equals(key)) { //if the middle position is where the "key" variable is located, then that is the index we are looking for
						System.out.println("The element you want to search for: " + key); 
						System.out.println("is located at index: " + middle);
						return middle;
					}
					if ((Integer) sortedList.get(middle) < key) { //if the condition above fails, then this condition will check if the "key" value is smaller or larger than the middle value
						beginning = middle + 1; //if the middle element of the list is less than the key value, then the new beginning of the array is the upper half of the list

					} else { //if the middle element is greater than the key, then the new array would end at the element one before the middle
						end = middle - 1;
					}
				}
				return -1;

			} else 
				//this next block is the same concept as the block above but it will be used if the input type is String
			{
				String s = (String) t;
				key = Integer.parseInt(s);
				System.out.println(key);
				while (beginning <= end) {
					int middle = beginning + (end - beginning) / 2;
					if (Integer.parseInt((String) sortedList.get(middle)) == (key)) {
						System.out.println("The element you want to search for: " + key);
						System.out.println("is located at index: " + middle);
						return middle;
					}
					if ((Integer.parseInt((String) sortedList.get(middle)) < key)) {
						beginning = middle + 1;

					} else {
						end = middle - 1;
					}
				}
				return -1;

			}

		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		boolean isArmstrong = false;
		int total = 0;
		int numLength = Integer.toString(input).length();
		for (char c : Integer.toString(input).toCharArray()) {
			int digit = c - '0'; // converts unicode character type of numbers to integer type
			total += (int) Math.pow(digit, numLength);

		}
		if (total == input) {
			isArmstrong = true;

		}
		System.out.println("Input number: " + input);
		System.out.println("After completing Armstrong computation: " + total);
		System.out.println("Is this an armstrong number? " + isArmstrong);
		return isArmstrong;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		long copy = l;
		List<Long> primes = new ArrayList<>(); //use an ArrayList because you dont know how many prime factors there will be
		
		for (int i = 2; i <= l; i++) { //iterate from 2(the first prime number) up to the number of interest
			while (l % i == 0) { //every time a factor of l appears, add that factor to the list of primes
				primes.add((long) i);
				l = l / i; //once a factor has been found, the original number is divided by that factor, then the factors of the new value of l are searched for
			}
		}
		System.out.println("The prime factors for " + copy + " are:");
		System.out.println(primes);

		return primes;
	}

	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			String alphabet = "abcdefghijklmnopqrstuvwxyz"; //a string to reference characters from the original alphabet before encoding
			String reversed = "zyxwvutsrqponmlkjihgfedcba";//a string to reference the corresponding characters for the cipher 
			String encoded = "";
			System.out.println("decoded string: " + string);
			string = string.toLowerCase();
			string = string.replaceAll("\\s", "").replaceAll("\\.", "").replaceAll("\\,", ""); //splice out any spaces or punctuation

			for (int i = 0; i < string.length(); i++) {
				if (Character.isDigit(string.charAt(i)) == false) { //make sure the character in question isnt a digit (numbers arent ciphered)

					char codechar = string.charAt(i); //create a character to represent the character at the current iteration
					int x = alphabet.indexOf(codechar); //create an integer that will carry the index of the character that needs to be coded
					char c = reversed.charAt(x);//create a new character that will represent the coded character
					encoded = encoded + c;//add coded character to a new string
				} else {
					encoded = encoded + string.charAt(i); //if the character in question is a number, then just add that number to the encoded string
				}

			}
			
			List<Character> encodedlist = new ArrayList<>(); //create a list of characters of the encoded string
			for (int i = 0; i < encoded.length(); i++) {
				encodedlist.add(encoded.charAt(i));
			}
			int a = 5;
			while (a < encodedlist.size()) { //add space after every 5 characters in the coded string
				encodedlist.add(a, ' ');
				a = a + 6;
			}
			StringBuilder sb = new StringBuilder(); //use string builder to recreate the encoded string
			for (Character c : encodedlist) {
				sb.append(c);
			}

			System.out.println("encoded string: " + sb.toString()); //use toString() to convert sb to a String
			return sb.toString();
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			String alphabet = "abcdefghijklmnopqrstuvwxyz"; //a string to reference alphabet characters
			String reversed = "zyxwvutsrqponmlkjihgfedcba";// a string to reference alphabet characters in reverse (ciphered)
			String decoded = "";
			System.out.println("encoded string: " + string);
			string = string.toLowerCase();
			string = string.replaceAll("\\s", "").replaceAll("\\.", "").replaceAll("\\,", ""); //remove any spaces or punctuation
			for (int i = 0; i < string.length(); i++) {
				if (Character.isDigit(string.charAt(i)) == false) { //produce a decoded string the same way as we did in the encode method, just now we are looking to the reversed alphabet first to figure out which character from the normal alphabet the character corresponds to

					char decodechar = string.charAt(i);
					int x = reversed.indexOf(decodechar);
					char c = alphabet.charAt(x);
					decoded = decoded + c;
				} else {
					decoded = decoded + string.charAt(i);
				}

			}
			System.out.println("decoded string: " + decoded);
			return decoded;
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration

		String add = "plus";
		String subtract = "minus";
		String multiply = "multiplied";
		String divide = "divided";
		int sum = 0;
		int difference = 0;
		int product = 0;
		int quotient = 0;

		System.out.println(string);
		string = string.replaceAll("\\?", "");

		String[] words = string.split(" "); //create a string array of the words in the inputted string
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(add)) {
				sum = (Integer.parseInt(words[i - 1]) + Integer.parseInt(words[i + 1])); // the numbers that need to be manipulated are directly before and after the keyword
				System.out.println(sum);
				return sum;
			}
			if (words[i].equals(subtract)) {
				difference = (Integer.parseInt(words[i - 1]) - Integer.parseInt(words[i + 1])); //use parseInt to convert string to int
				System.out.println(difference);
				return difference;
			}
			if (words[i].equals(multiply)) {
				product = (Integer.parseInt(words[i - 1]) * Integer.parseInt(words[i + 2])); //multiply and divide require you to check the element 2 after the keyword because the input says "multiplied by"
				System.out.println(product);
				return product;
			}
			if (words[i].equals(divide)) {
				quotient = (Integer.parseInt(words[i - 1]) / Integer.parseInt(words[i + 2]));
				System.out.println(quotient);
				return quotient;
			}

		}
		return 0;

	}

}
