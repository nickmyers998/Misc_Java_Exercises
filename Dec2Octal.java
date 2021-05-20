import java.util.Scanner;

//This program converts a decimal number provided by the user into its octal equivalent

public class Dec2Octal {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int intnum = 0;
		int maxinput = 2097151;
		boolean done = false;
		int place = 0;
		int eightpower = 1;
		int pnum = 0;
		int x = 1;
		int remainder;
		
		System.out.println("Please enter a positive integer less than or equal to " + maxinput + " to convert to octant numeral");
		intnum = input.nextInt();
		if (intnum > maxinput) {		// tests for input over maximum value allowed
			System.out.println("UNABLE TO CONVERT.");
			return;
		}
		else if (intnum <0) {			// tests for negative integer input
			System.out.println("UNABLE TO CONVERT.");
			return;
		}

		System.out.print("Your integer number " + intnum + " is ");			// displays portion of output message before computation
		
		while (!done) {				// gets the maximum power of 8 that the input divides into
			x = 0;
			x = intnum / eightpower;
			if (x >= 1) {
				place++;
				eightpower *= 8;
				
			}
			else {
				done = true;
				place--;
			}
		}
		
		int zeros = 7-(place+1);			// variable 'zeros' stores how many prefix zeros will be added to make output 7 digits long
		
		while (true) {
			if (zeros > 0) {
			System.out.print(0);			// outputs zeros using while loop
			}
			else {
			break;
			}
			zeros--;
		}
		
		while (place >=0) {				// outputs sequence of octal digits by successive Euclidean division, power of 8 decreases incrementally
			
			int a = 1;
			done = false;
			pnum = 0;
		
			while (!done) {
				remainder = intnum;
				remainder -= ((Math.pow(8, place)) * a);
				if (remainder >=0) {
					pnum++;
					a++;
				}
				else {
					done = true;	
				}
			}
		
			System.out.print(pnum);				// outputs octal digit
			int b = a-1;
			intnum -= ((Math.pow(8, place)) * b);
			place--;
			
		}
		
		System.out.print(" in octal.");			// end of main function after final digit is displayed and user message is complete
		
	}
	
}
