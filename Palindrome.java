package assignPackage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

// This file instantiates a class with methods for file read and write operations to check for words which are palindromes


public class Palindrome {
	
	public File infile;
	public FileWriter outfile;
	public Scanner obj = null;

	public Palindrome(String filename){		//constructor that takes filename as input
		
		infile = new File(filename);		//creates File object
		try {
			outfile = new FileWriter("Output.txt");		//creates FileWriter object 
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			obj = new Scanner(infile);		//creates Scanner object to read file
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getLine(){		//method to read data from file

		char[] arr = null;
		while (obj.hasNextLine()) {			//loops through all lines in file
			String rawdata = obj.nextLine();
			String data = removeSpaces(rawdata);		//calls removeSpaces to remove spaces and whitespace in word
			PrintWriter test = new PrintWriter(outfile);
			arr = data.toCharArray();		//converts data string to character array
			checkPalindrome(arr, test);		//calls checkPalindrome method to test for palindrome
		}
		try {
			outfile.close();		//closes FileWriter object
		} catch (IOException e) {
			e.printStackTrace();
		}
		obj.close();		//closes Scanner object
	}
	
	public void checkPalindrome(char[] arr, PrintWriter test) {
		char[] pal = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {		//loop to fill empty character array with the reversed characters of given array
			pal[arr.length - i - 1] = arr[i];
		}
		String orig = new String(arr);
		String pall = new String(pal);
		if (pall.equals(orig)) {		//checks if word and its reverse are the same
			test.println("Yes, palindrome");		//writes to file
		}
		else {
			test.println("No, " + pall);		//writes to file
		}
	}
	
	public String removeSpaces(String word) {
		String finword = "";
		for (int i = 0; i < word.length(); i++) {		//loops through characters in word
			if (word.charAt(i) == ' ') {
				continue;		//skips all spaces
			}
			else {
				String x = String.valueOf(word.charAt(i));		//creates a string of character
				finword = finword.concat(x);		//adds character to string finword
			}
		}
		return finword;		//returns original word without spaces or whitespace
	}
}