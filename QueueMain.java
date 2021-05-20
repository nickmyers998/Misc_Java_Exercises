import java.util.Scanner;

//This program is used in conjunction with QueueObj to demonstrate more concepts using Objects and methods

public class QueueMain {

	public static void main(String[] args) {
		
		int s = 20;
		QueueObj newobject = new QueueObj(8);			//create new Queue3503 object with initial capacity of 8
		for (int i = 0; i < s; i++) {
			System.out.println("Enter item " + (i+1));
			Scanner input = new Scanner(System.in);		//take user input 20x and stores input into elements queue
			int item = input.nextInt();
			newobject.enqueue(item);
		}
		
		System.out.print("Initial queue: ");
		for (int i = 0; i < s; i++) {
			System.out.print(newobject.getItem(i) + " ");
		}
		System.out.print("\n");
		
		for (int i = 1; i <= s; i++) {
			int k = newobject.dequeue();
			if (i % (5) == 0) {				//prints items along with after 5 elements have been removed from queue 
				System.out.print("After removing 5 elements: ");
				for (int j = 0; j < newobject.getSize(); j++) {
					System.out.print(newobject.getItem(j) + " ");
				}
				int queue_size = newobject.getSize();
				System.out.println("\nSize is " + queue_size);
				if (newobject.empty() == true) {
					break;
				}
				
			}
		}
		
	}

}
