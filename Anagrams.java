package stringhandling;//created package as stringhandling

/**
 *Java program that finds all anagram sets from a list of words. 
 *Anagrams are those words in which there are same characters jumbled.
 */
import java.util.ArrayList;
                //import keyword is used to import built-in and user defined package into our java source file. So that our class can refer a class that is in another package by directly 
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams { //Creating class 
	public static void main(String[] args) { // main method 
		List<String> list = new ArrayList<String>(); //Creating list 
		
		//Add values in the list as mentioned the assignment 
		list.add("listen");
		list.add("pot");
		list.add("part");
		list.add("opt");
		list.add("trap");
		list.add("silent");
		list.add("top");
		list.add("this");
		list.add("hello");
		list.add("hits");
		list.add("what");
		list.add("shit");
		System.out.println(findAna(list)); //Printing the method output

	}

	/*
	 * Creating method findAna. Map is useful if you have to search, update or
	 * delete elements on the basis of key. Map<String(Key) ,
	 * List<String>(Value)> Words = Elements in the list or the list.
	 */
	private static Map<String, List<String>> findAna(List<String> words) {
		Map<String, List<String>> anagram = null; // Initializing Map interface

		if (words == null || words.size() == 0) { // Checks whether the list is empty of not.
													
			return null; //Return statement 
		}

		// HashMap is an implementation of Map Interface.
		// Initializing anagram.
		anagram = new HashMap<String, List<String>>();

		for (String word : words) { // Implementing for loop

			// Putting the list into the character array.
			// Trim() method eliminates white spaces.
			char[] charArray = word.trim().toCharArray();
			Arrays.sort(charArray); //Sorting the character array
			
			//Put that sorted character array into one string by creating object.
			String wordSort = String.valueOf(charArray); 
			
			/* 
			 * Implementing if else statement.
			 * if,
			 * anagram contains the key it will append the new word into the list
			 * else,
			 * it will create a new key
			 */
			if (anagram.containsKey(wordSort)) {
				List<String> newList = anagram.get(wordSort); //Creating list 
				newList.add(word); // Add value in the list 
				anagram.put(wordSort, newList); // Add the value into the hash map 
			} else {
				List<String> list = new ArrayList<String>(); //Creating a new list 
				list.add(word); //Add value in the new list 
				anagram.put(wordSort, list); //Add the value into the hash map 
			}
		}
		return anagram; //Return statement 
	}
}