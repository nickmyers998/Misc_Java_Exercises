import java.util.ArrayList;

//This file contains the Queue class and its methods

public class QueueObj {

	private int size;
	private ArrayList<Integer> elements = new ArrayList<Integer>();
	
	public QueueObj(int capacity) {		//constructor to initialize size variable and integer arraylist
		this.size = 0;
		this.elements = new ArrayList<Integer>(capacity);
	}
	
	
	public void enqueue(int v) {		//places item into new position at end of arraylist
		elements.add(elements.size(), v);
		size++;
	}
	
	public int dequeue() {			//removes item from first position in arraylist
		int removed_int = elements.get(0);
		elements.remove(0);
		size--;
		return removed_int;
	}
	
	public boolean empty() {		//checks if arraylist is empty
		if (elements.isEmpty() == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getSize() {		//returns size of arraylist
		return size;
	}
	
	public int getItem(int index) {		//retrieves item at given index from private arraylist
		int x = elements.get(index);
		return x;
	}
	
}
