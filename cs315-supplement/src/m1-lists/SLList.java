package edu.erau.cs315;

public class SLList<Item> implements List<Item> {

	private class Node {
		Item info;
		Node next;		
	}

	private Node head;
	private Node tail;

	public SLList() {
		head = tail = null;
	}

	public Item getAt(int loc) {
		//Special case - empty list
		if ((head == null) || (loc < 0)) 
			return null;

		Node cur = head;
		for (int i=0; i < loc; i++) {
			if (cur.next == null) 
				return null;
			cur = cur.next;
		}
		return cur.info;
	}

	public Item deleteAt(int loc) {

		//Special case - empty list
		if ((head == null) || (loc < 0)) 
			return null;
		
		//Iterate to the node prior
		Node prevNode = null;
		Node cur = head;
		for (int i=0; i < loc; i++) {
			//If index is out of bounds, no delete.
			if (cur == null) 		
				return;
			prevNode = cur;
			cur = cur.next;
		}

		Item item = cur.info;	
		//Special case - last
		if ((cur == head) && (cur == tail)) { 
			head = tail = null;		
		}
		//Special Case - head
		else if (cur == head) { 
			head = head.next;			
		}
		//Special Case - tail
		else if (cur == tail) {
			tail = prevNode;
			tail.next = null;
		} 
		//Default case
		else {
			prevNode.next = cur.next;
		}
		return item;
	}


	public void addToHead(Item item) {
		Node newN = new Node();
		newN.next = head;
		newN.info = item;
		
		if (head == null) {
			head = tail = newN;
		} else {
			head = newN;
		}
	}

	public void addToTail(Item item) {
		Node newN = new Node();
		newN.info = item;
		newN.next = null;

		if (tail == null) {
			head = tail = newN;
		} else {
			tail.next = newN;
			tail = newN;
		}

	}

	public void addAt(int loc, Item item) {
		//Special case - add to empty list or head
		if ((loc <= 0) || (head == null)) {
			addToHead(item);
			return;
		}

		//Stops with cur at location - 1 or 
		// tail, whichever is reached first
		Node cur = head;
		for (int i=0; i < (loc-1); i++) {
			if (cur.next == null) break;
			cur = cur.next;
		}

		//Special case - add to tail
		if (cur == tail) { 
			addToTail(item);
			return;
		} 

		//Default case
		Node newN = new Node();
		newN.info = item;
		newN.next = cur.next;
		cur.next = newN;
	}

	public void printFwd() {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.info + " ");
			cur = cur.next;
		}
	}

	public void printRev() {
		printRev(head);
	}

	private void printRev(Node cur) {
		if (cur == null) {
			return;
		}
		else {
			printRev(cur.next);
			System.out.print(cur.info + " ");
		}		
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public static void main(String [] args) {
		ListTestClient.ListTest(new SLList<String>());
	}

}