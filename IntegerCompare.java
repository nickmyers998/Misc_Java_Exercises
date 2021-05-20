
//This is a simple program demonstrating Java I/O, basic syntax, and logical expressions
//Program asks the user for two integers, then gives the user the appropriate magnitude comparisons between the integers


import java.util.Scanner;

public class IntegerCompare {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int number1, number2;
		
		System.out.println("Enter first integer: ");
		number1 = input.nextInt();
		
		System.out.println("Enter second integer: ");
		number2 = input.nextInt();
		
		if (number1==number2) {
			System.out.printf("%d == %d\n", number1, number2);
		}
		
		if (number1!=number2) {
			System.out.printf("%d != %d\n", number1, number2);
		}

		if (number1>number2) {
			System.out.printf("%d > %d\n", number1, number2);
		}
		
		if (number1<number2) {
			System.out.printf("%d < %d\n", number1, number2);
		}
		
		if (number1>=number2) {
			System.out.printf("%d >= %d\n", number1, number2);
		}
		
		if (number1<=number2) {
			System.out.printf("%d <= %d\n", number1, number2);
		}
	}

}
