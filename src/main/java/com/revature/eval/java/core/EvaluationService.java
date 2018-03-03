package com.revature.eval.java.core;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluationService {

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {
		
		// Create array that is the same length as the string
		int stringLength = string.length();
		String forwardString = string;
		String backwardString = "";
		
		for(int i = 0; i < stringLength; i++){
			backwardString = backwardString + forwardString.charAt(stringLength -1 - i);
		}
		return backwardString;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// Preparing the phrase
			String s = phrase;
			String secondString = "";
			
			s = s.replace("-"," ");
			
			String[] sArray = s.split(" ");
			
		// Characters
			char[] charArray = new char[sArray.length];
			
			for (int i = 0; i < sArray.length; i++){
				charArray[i] = sArray[i].charAt(0);
			}
			for (int i = 0; i < charArray.length; i++){
				secondString = secondString + charArray[i];
			}
			
		// Finishing Touches
			secondString = secondString.toUpperCase();
		return secondString;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			
			double avg = (getSideOne() + getSideTwo() + getSideThree())/3;
			if (avg == getSideOne() && avg == getSideTwo() && avg == getSideThree())
			{
				return true;
			}
			return false;
		}

		public boolean isIsosceles() {
			if (getSideOne() == getSideTwo() && getSideOne() != getSideThree()){
				return true;
			}
			if (getSideTwo() == getSideThree() && getSideTwo() != getSideOne()){
				return true;
			}
			if (getSideThree() == getSideOne() && getSideThree() != getSideTwo()){
				return true;
			}
			return false;
		}

		public boolean isScalene() {
			if (getSideOne() != getSideTwo() && getSideOne() != getSideThree() && getSideTwo() != getSideThree()){
				return true;
			}
			return false;
		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
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
		string = string.toUpperCase();
		
		// Initializing variables
		int total = 0; 
		int points = 0;
		char [] cArray = new char[string.length()];
		
		for (int i = 0; i < string.length(); i++){
			cArray[i] = string.charAt(i);
		}
		
		for(int i = 0; i < cArray.length ; i++){

			switch (cArray[i]){
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
			case 'L':
			case 'N':
			case 'R':
			case 'S':
			case 'T':
				points = 1;
				break;
			case 'D':
			case 'G':
				points = 2;
				break;
			case 'B':
			case 'C':
			case 'M':
			case 'P':
				points = 3;
				break;
			case 'F':
			case 'H':
			case 'V':
			case 'W':
			case 'Y':
				points = 4;
				break;
			case 'K':
				points = 5;
				break;
			case 'J':
			case 'X':
				points = 8;
				break;
			case 'Q':
			case 'Z':
				points = 10;
				break;
			}
			total = total + points;
		}
		return total;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
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
		String str = string;
		
		str = str.replaceAll("[^0-9]","");
		str = str.replaceAll(" ", "");
		if (str.length() == 10){
			return str;	
		}
		else{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		// String Prep
		string = string.replaceAll("\n", "");
		string = string.replaceAll("[^a-zA-Z]", " ");

		String[] stringArray = string.split(" "); 
		
		/** Put String in Hashmap
		* HashMaps accept one null key and any amount of null values. Are not synchronized.
		*/
		
		HashMap<String, Integer> h = new HashMap<String, Integer>();
		
		for(String i:stringArray){
			if(!h.containsKey(i)){
				h.put(i, 1);
			} else {
				h.put(i, h.get(i) + 1);
		}
		}
		return h;
	}

	/**
	 * 7. Implement a binary search algorithm.
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

			return 0;
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
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */

	public String Conversion (String str){
		// Special Cases
		if (str.startsWith("th")){
			str = str.substring(2) + "thay ";
			return str;
		}
		if (str.startsWith("sch")){
			str = str.substring(3) + "schay ";
			return str;					
		}
		if (str.startsWith("qu")){
			str = str.substring(2) + "quay ";
			return str;
		}
		
		// Normal Cases
		char c = str.charAt(0);
		switch (c){
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			str = str + "ay ";
			break;
		case 'b':
		case 'c':
		case 'd':
		case 'f':
		case 'g':
		case 'h':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			str = str.substring(1) + c + "ay "; 
			break;
		}
		return str;
	}
	public String toPigLatin(String string) {
		/** 
		 * If string has a space then split the words into a String Array,
		 * otherwise make an array of one and place string in there.
		*/
		
		if (string.contains(" ")){
			String[] stringArray = string.split(" ");
			String str = "";
			// Convert strings
			for (int i = 0; i < stringArray.length; i++){
				stringArray[i] = Conversion(stringArray[i]);
				str = str + stringArray[i];
				
			}
			// remove last space
			str = str.substring(0, str.length()-1);
			return str;
			
		} else {
			String[] stringArray = {string};
			String str = "";
			str = Conversion(stringArray[0]);
			
			// remove last space
			str = str.substring(0, str.length()-1);
			return str;
		}

	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
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
	public double ArmstrongNumber(int input){
		String num = Integer.toString(input);
		double[] doubleArray = new double[num.length()];
		double total = 0;
		
		// Split up the numbers
		for(int i = 0; i < num.length(); i++){
			doubleArray[i] = Character.getNumericValue(num.charAt(i));
		}
		
		// Raising each space to how many digits the number it has.
		for(int i = 0; i < num.length(); i++){
			doubleArray[i] = Math.pow(doubleArray[i], num.length());
			total = total + doubleArray[i];
		}
		return total;
	}
	public boolean isArmstrongNumber(int input) {
		double total = ArmstrongNumber(input);
		
		if (input == total){
			return true;
		}
		return false;
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	
	public List<Integer> calculatePrimeFactorsOf(long l) {
		int num = (int) l;
		List<Integer> intList = new ArrayList<>();
		
		// Make it so that i isn't an even number.
		
		while(num % 2 == 0){
			intList.add(2);
			num = num/2;
		}
		
		// Starting at 3, skip even iterations of i.
		// i can't be larger than the square root of n.
		for (int i = 3; i <= Math.sqrt(num); i += 2){
			while (num % i == 0){				
			intList.add(i);
			num = num / i;
			}
		}
		
		if (num > 2){
			intList.add(num);
		}
		return intList;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	
	static class RotationalCipher {
		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		public String rotate(String string) {
			String s = "";

			for(int i = 0; i < string.length(); i++){

				if (Character.isLetter(string.charAt(i))){
					char c = (char)(string.charAt(i) + key);

					if (c > 'z'){
						s += (char)(string.charAt(i) - (26 - key));
					} else {
						s += (char)(string.charAt(i) + key);
					}
				} else {
					s += (char)(string.charAt(i));
				}
			}
			return s;
		}
	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	
	public static boolean isPrimeNumber(int j){
		if (j%2 == 0 && j != 2) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(j); i+=2){

			if (j % i == 0){
				return false;
			}
		}
		return true;
	}
	public int calculateNthPrime(int i) {
		List<Integer> l = new ArrayList<>();
		if (i > 0){
			for (int j = 2; j < 200000; j++){
				if (isPrimeNumber(j)){
					l.add(j);
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		int x = l.get(i-1);
		return x;
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
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

	
	public static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		
		static String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
		static String cipher = "zyxwvutsrqponmlkjihgfedcba0123456789"; 
		
		public static String encode(String string) {
			// Prepare the strings
			string = string.toLowerCase();
			string = string.replaceAll("[^a-z0-9]", "");
			char[] cArray = string.toCharArray();
			
			String[] cipherStringArray = new String[(string.length()/5) + 1];
			String cipheredString = "";
			String s = "";
			
			for (int i = 0; i < cArray.length; i++){
				int x = alphabet.indexOf(cArray[i]);
				cArray[i] = cipher.charAt(x);
			}
			
			for (char c : cArray){
				cipheredString += c;
			}
			
			if (string.length() < 5){
				return cipheredString;
			} 
				for (int i = 0; i < (string.length()/5) + 1; i++){
					if (cipheredString.length() >= 5){
						cipherStringArray[i] = cipheredString.substring(0, 5);
						cipheredString = cipheredString.substring(5,cipheredString.length());
						cipherStringArray[i] = cipherStringArray[i] + " ";
						continue;
					}
					
					cipherStringArray[i] = cipheredString;
				}
				
				for (String st : cipherStringArray){
					s += st;
				}
			s = s.trim();
			return s;
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			string = string.replaceAll(" ", "");
			char[] cArray = string.toCharArray();
			String s = "";
			
			for (int i = 0; i < string.length(); i++){
				int x = cipher.indexOf(cArray[i]);
				cArray[i] = alphabet.charAt(x);
			}
			
			for (char c: cArray){
				s += c;
			}
			return s;
		}
	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {
		string = string.replaceAll("-", "");
		char[] cArray = string.toCharArray();
		int[] iArray = new int[cArray.length];
		int total = 0;
		for (int i = 0; i < cArray.length; i++){
			if (i==9 && cArray[i] == 'X'){
				iArray[i] = 10;
			}
			iArray[i] = cArray[i];
			
		}
		for(int i = 0; i < iArray.length ; i++){
			int value = iArray[i];
			int position = 10 - i;

			total += (value*position);
			}		
		if (total % 11 == 0){
			return true;
		}
		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		Set<Character> lettersRemaining = new HashSet<>();
		
		for (char ch = 'a'; ch <='z'; ch++){
			lettersRemaining.add(ch);
		}
		
		string = string.toLowerCase();
		
		for (int i = 0; i < string.length(); i++){
			lettersRemaining.remove(string.charAt(i));
		}
		
		if (lettersRemaining.size() == 0){
			return true;
		}
		return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param given
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal given) {
		
		return null;
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		// TODO Write an implementation for this method declaration
		return 0;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		// TODO Write an implementation for this method declaration
		return false;
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
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
	
	public boolean isNumber (String str){
		str = str.toUpperCase();
		switch(str.charAt(0)){
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
			return false;
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case '-':
			return true;

		}
		return false;
	}
	public int solveWordProblem(String string) {
		
		// Initializing Variables and Arrays
		String[] stringSplit = string.split(" ");
		int total = 0;
		int[] numArray = new int[2];
		int num1 = 0;
		int num2 = 0;
		// Try add to an array
		for (int i = 0; i < string.length(); i++)
		{
			if (isNumber(stringSplit[i]) == true){
				if (num1 != 0){
					num1 = Integer.parseInt(stringSplit[i]);
				} else {
					num2 = Integer.parseInt(stringSplit[i]);
				}
			} else {
				continue;
			}
			
		}
		if(string.contains("plus")){
			total = num1 + num2;
		}
		if(string.contains("minus")){
			total = num1 - num2;
		}
		if(string.contains("divided")){
			total = num1 / num2;
		}
		if(string.contains("multiplied")){
			total = num1 * num2;
		}
		return total;
	}

}