package edu.erau.cs315;

public class DLList<Item> implements List<Item> {

	private class Node {
		Item info;
		Node next;
		Node prev;
	}

	private Node head;
	private Node tail;

	public DLList() {
		head = tail = null;
	}

	public Item getAt(int loc) {
		Node cur = head;
		for (int i=0; i < loc; i++) {
			if (cur.next == null) 
				return null;
			cur = cur.next;
		}
		return cur.info;
	}


	public Item deleteAt(int loc) {

		//Iterate to the node prior
		Node cur = head;
		for (int i=0; i < loc; i++) {
			if (cur == null) //Special case - empty or out of bounds
				return;
			cur = cur.next;
		}
	
		Item item = cur.info;
		//Special case - last item
		if ((cur == head) && (cur == tail)) { 
			head = tail = null;
		}
		//Special case - head
		else if (cur == head) { 
			head = head.next;
			head.prev = null;
		}
		//Special case - tail
		else if (cur == tail) { 
			tail = tail.prev;
			tail.next = null;
		}
		//Default Case - reroute around deleted node, cur
		else {
			Node prevNode = cur.prev;
			Node nextNode = cur.next;				
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
		}				
		return item;
	}

	public void addToHead(Item item) {
		Node newN = new Node();
		newN.next = head; 
		newN.prev = null; 
		newN.info = item; 
		
		if (head == null) {
			head = tail = newN;
		} else {
			head.prev = newN;
			head = newN;
		}
	}

	public void addToTail(Item item) {
		Node newN = new Node();
		newN.info = item;
		newN.next = null;
		newN.prev = tail;

		if (tail == null) {
			head = tail = newN;
		} else {
			tail.next = newN;
			tail = newN;
		}

	}

	public void addAt(int loc, Item item) {
		if ((loc <= 0) || (head == null)) {
			addToHead(item);
			return;
		}

		//Stop at node just prior to target location
		// assume zero indexing.
		Node cur = head;
		for (int i=0; i < (loc-1); i++) {
			if (cur.next == null) break;
			cur = cur.next;
		}

		if (cur == tail) {
			addToTail(item);
		} else {
			Node newN = new Node();
			newN.info = item;
			newN.next = cur.next;
			newN.prev = cur;
			
			newN.prev.next = newN;
			newN.next.prev = newN;
		}
	}

	public void printFwd() {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.info + " ");
			cur = cur.next;
		}
	}

	public void printRev() {
		Node cur = tail;
		while (cur != null) {
			System.out.print(cur.info + " ");
			cur = cur.prev;
		}
	}
	
	public boolean isEmpty() {
		return (head == null);
	}


	public static void main(String [] args) {
		ListTestClient.ListTest(new DLList<String>());
	}
}