package edu.erau.cs315;

public class ListStack<Item> {
	int count;
	SLList<Item> list;

	public ListStack() {
		list = new SLList<Item>();
		count = 0;
	}

	public void push(Item item) {
		list.addToHead(item);
		count++;
	}

	public Item pop() {
		Item item = list.deleteAt(0);
		if (item != null) 
			count--;
		return item;
	}

	public Item top() {
		return list.getAt(0);
	}

	public Item peak() {
		return top();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public int size() {
		return count;
	}


	public static void main(String [] args) {
		ListStack s = new ListStack<String>();
		s.push("A");
		s.push("B");
		s.push("C");

		System.out.println(s.top() + " " + s.size());

		while (!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}

}