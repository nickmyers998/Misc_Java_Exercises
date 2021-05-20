import java.util.Random;
import java.util.ArrayList;

//This program demonstrates pseudo-random number generation and Object instantiation with functions to find the most popular birthday in a randomly generated set.


public class RandomInts {

	public static void main(String[] args) {
		
		Arena test = new Arena(12000);
		test.fillRandom();
		test.findMin();
		test.findMax();	
	}
}


class Arena{
	
	int num;
	
	Arena(int arena){
		num = arena;
	}

	int[] birthdays = new int[365];
	
	public void fillRandom() {
		
		for (int i = 0; i < num; i++) {
			
			Random day = new Random();
			int k = day.nextInt(365);
			birthdays[k] = birthdays[k] + 1;
		}
	}
	
	public void findMax() {
		
		ArrayList<Integer> max = new ArrayList<Integer>();
		int x = 0;
		int maxnum = 0;
		max.add(0);
		
		for (int i = 0; i < birthdays.length; i++) {
			if (birthdays[i] > maxnum) {
				max.clear();
				x = 0;
				max.add(0);
				max.set(0, i+1);
				maxnum = birthdays[i];
			}
			else if (birthdays[i] == maxnum) {
				x++;
				max.add(0);
				max.set(x, i+1);
			}
		}
		
		System.out.printf("\nThe following days have %d people: \n", maxnum);
		
		for (int i: max) {
			System.out.print(i + " ");
		}
	}
	
	public void findMin() {
		ArrayList<Integer> min = new ArrayList<Integer>();
		int x = 0;
		int minnum = num;
		min.add(minnum);
		
		for (int i = 0; i < birthdays.length; i++) {
			if (birthdays[i] < minnum) {
				x = 0;
				min.clear();
				min.add(0);
				min.set(0, i+1);
				minnum = birthdays[i];
			}
			else if (birthdays[i] == minnum) {
				x++;
				min.add(0);
				min.set(x, i+1);
			}
		}
		
		System.out.printf("\nThe following days have %d people: \n", minnum);
		
		for (int i: min) {
			System.out.print(i + " ");
		}
	}
	
}