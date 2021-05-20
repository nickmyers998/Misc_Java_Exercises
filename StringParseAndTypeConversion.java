import java.util.Scanner;

public class StringParseAndTypeConversion {
	
	
	//This program demonstrates string manipulation and type conversion by parsing through a user-given date, summing the digits, and producing a numerology prediction for the user. 

	
	public String getDate() {		// Gets user input and checks for properly formatted date, returns unpolished date string
		
		
		String invalid = "This is not a valid date, try again.";
		String dat = "";
		boolean done = false;
		while (!done) {
			boolean digitvalid = true;
			System.out.println("Please enter a date in the format 'MM / DD / YYYY'");
			Scanner input = new Scanner(System.in);		
			String date = input.nextLine();
			String datenums = ".";

			int formcheck = 0;
			if (date.length() > 14 || date.length() < 12) {
				System.out.println(invalid);
				continue;
			}
			
			for (int i = 0; i < date.length(); i++) {
				char d = date.charAt(i);
				if (d == ' ') {
					if (date.charAt(i+1) == '/') {
						if (date.charAt(i+2) == ' ') {
							formcheck++;
							i+=2;
							datenums = datenums.concat(".");
							continue;
						}
						else {
							break;
						}
					}
					else {
						break;
					}
				}
				
				if (Character.isDigit(d)) {
					datenums = datenums.concat(Character.toString(d));
				}
				else {
					System.out.println(invalid);
					digitvalid = false;
					break;
				}
				if (i == (date.length() - 1)) {
					done = true;
				}
			}
			
			if (formcheck != 2 && digitvalid == true) {
				System.out.println(invalid);
				done = false;
			}
			dat = datenums;
		}
		return dat;
	}
	
	
	public boolean checkValidDate(String date) {		// Bool method that formats date to be more usable, then checks whether the given date is possible
		
		int day = 0;
		int month = 0;
		int year = 0;
		int num = 0;
		int power = 0;
		
		for (int i = 0; i < date.length(); i++) {
			char d = date.charAt((date.length() - i - 1));
			if (d == '.') {
				num++;
				power = 0;
				continue;
			}
			else {
				int x = Character.getNumericValue(d);
				if (num == 0) {
					year += x*(Math.pow(10, power));
				}
				else if (num == 1) {
					day += x*(Math.pow(10, power));
				}
				else if (num == 2) {
					month += x*(Math.pow(10, power));
				}
				power++;
			}
		}
		
		if (month < 1 || month > 12) {
			return false;
		}
		if (day < 1 || day > 31) {
			return false;
		}
		if (year < 1500 || year > 3000) {
			return false;
		}
		if (day == 31) {
			if (month != 1 && month != 3 && month != 5 && month != 7 && month != 8 && month != 10 && month != 12) {
				return false;
			}
		}
		if (month == 2) {
			if (day > 29) {
				return false;
			}
			if (day == 29) {
				if (year % 4 != 0) {
					return false;
				}
				else {
					if (year % 100 == 0 && year % 400 != 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public int crunchDate(String nums) {		// Int method that sums the digits in the user's date
		
		int sum = 0;
		
		for (int i = 0; i < nums.length(); i++) {
			char d = nums.charAt(i);
			if (d == '.') {
				continue;
			}
			int x = Character.getNumericValue(d);
			sum+=x;
		}
		return (sum);
		
	}
	
	public void getPrediction(int num) {		// Void method that prints user's prediction to screen
		switch (num) {
			case 1:
				System.out.println("1: You will have good fortune with money.");
				break;
			case 2:
				System.out.println("2: You will have to keep a secret soon.");
				break;
			case 3:
				System.out.println("3: Do not trust strangers this week.");
				break;
			case 4:
				System.out.println("4: Help others to receive great rewards.");
				break;
			case 5:
				System.out.println("5: A new career path will open for you soon.");
				break;
			case 6:
				System.out.println("6: A valuable lesson will be learned soon.");
				break;
			case 7:
				System.out.println("7: You will find good friends in the coming weeks.");
				break;
			case 8:
				System.out.println("8: Embrace what is novel and you will find good luck.");
				break;
			case 9:
				System.out.println("9: An eye for detail will serve you well this month.");
				break;
		}
		return;
	}
	
	public static void main(String[] args) {		// Main method
		
		StringParseAndTypeConversion f1 = new StringParseAndTypeConversion();
		boolean done = false;
		String cdate = "";
		int num = 0;
		while (!done) {			// while loop that does not break until the user has entered a proper date
			String date = f1.getDate();
			boolean test = f1.checkValidDate(date);
			if (test == true) {
				done = true;
				cdate = date;
			}
			else {
				System.out.println("That is not a valid date, try again.");
			}
		}
		while (true) {			// while loop that does not break until the sum of the date digits is a single digit number
			int numerology = f1.crunchDate(cdate);
			if (numerology / 10 >= 1) {
				cdate = numerology + "";
				continue;
			}
			else {
				num = numerology;
				break;
			}
		}
		f1.getPrediction(num);
		
	}		// end main
	
}
