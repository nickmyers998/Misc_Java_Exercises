import java.util.Scanner;

public class FibonacciObjects {

	//This program demonstrates array properties and Object intantiation through Fibonacci number calculation
	
	public long[] calculateF(int n) {		//calculates n Fibonacci numbers where n is the user's desired number
		
		long[] arr = new long[n];
		
		for (int i = 0; i < n; i++) {
			
			if (i == 0) {		// first required number for specified Fibonacci sequence
				arr[i] = 0;
			}
			else if (i == 1) {		// second required number for specified Fibonacci sequence
				arr[i] = 1;
			}
			else {
				arr[i] = arr[i-1] + arr[i-2];		// populates array with Fibonacci numbers based on first two numbers in sequence
			}
			
		}
		
		return arr;
	}
	
	public void displayF(long[] arr) {		// displays Fibonacci numbers to user
		System.out.println("The first " + arr.length + " Fibonacci numbers are:");
		for (long i: arr) {
			System.out.println(i);
		}
	}
	
	public int getN() {			// takes user's integer input 
		Scanner input = new Scanner(System.in);
		int rnnum = 0;
		
		while (true) {
			System.out.println("How many Fibonacci numbers would you like to calculate (Between 0 and 70)?: ");
			int n = input.nextInt();
			if (n < 0 || n > 70) {
				System.out.println("That is not a valid input, please try again.");
				continue;
			}
			else {
				rnnum = n;
				break;
			}
			
		}
		input.close();
		return rnnum;
	}

	public static void main(String[] args) {		// main method
		
		FibonacciObjects obj = new FibonacciObjects();
		int n = obj.getN();
		long[] arr = obj.calculateF(n);
		obj.displayF(arr);

	}

}
