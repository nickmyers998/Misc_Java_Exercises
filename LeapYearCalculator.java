import java.util.Scanner;


//This program demonstrates nested if-else expressions and functions by determining if a user-given year is a leap year


public class LeapYearCalculator {
	
	
	public void check_leapyear(int K) {
			
			Scanner yinput = new Scanner(System.in);
			int x = K;
			
			
			while (x != 0) {
				System.out.println("\nWhat is a year between 1500 and 2019 that you would like to check?: ");
				int year = yinput.nextInt();
				if (year < 1500 || year > 2019) {
					System.out.println("That is not a valid year, please enter a year between 1500 and 2019.");
					continue;
				}
				else {
					if (year % 4 != 0) {
						System.out.println("No, " + year + " is not a leap year.");
					}
					else {
						if (year % 100 == 0) {
							if (year % 400 == 0) {
								System.out.println("Yes! " + year + " is a leap year.");
							}
							else {
								System.out.println("No, " + year + " is not a leap year.");
							}
						}
						else {
							System.out.println("Yes! " + year + " is a leap year.");
						}
					}
					x--;
				}
			}
			
			yinput.close();
			return;
			
		}
		
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("\nHow many years would you like to check?: ");
		int K = input.nextInt();
		LeapYearCalculator cly = new LeapYearCalculator();
		cly.check_leapyear(K);
		input.close();
		
	}
}
