package edu.erau.cs315;

public class ListTestClient {

	public static void ListTest(List l) {


		System.out.println("List Type:" + l.getClass());		

		//Is Empty - true expected
		System.out.println("Is Empty? " +  l.isEmpty());

		//Test Add to head and tail
		l.addToHead("3");
		l.addToHead("1");
		l.addToHead("0");
		l.addToTail("4");
		l.addToTail("5");

		//Test add at locations
		l.addAt(0,"|"); //Add to head index
		l.addAt(3,"2"); //Add to inner index
		l.addAt(7,"|"); //Add to tail index
		l.addAt(-100,"Start"); //Add out of bound front
		l.addAt(100,"END");    //Add out of bound back

		l.printFwd(); //Expected: START | 0 1 2 3 4 5 | END 
		System.out.println();

		l.printRev(); //Expected: END | 5 4 3 2 1 0 | START 
		System.out.println();
		
		System.out.println();

		//Test getAt method
		//Expected: START | 0 1 2 3 4 5 | END null
		for (int i=0; i < 11; i++) {
			System.out.print(l.getAt(i) + " ");			
		}
		System.out.println();
		System.out.println();
		

		//Test deletions
		l.deleteAt(9); //deletes value "End"
		l.deleteAt(0); //deletes value "Start"
		l.deleteAt(3); //deletes value 2
		l.printFwd(); //Expected: | 0 1 3 4 5 |
		System.out.println();
		l.printRev(); //Expected: | 5 4 3 1 0 |
		System.out.println();
		System.out.println();

		//Is Empty - false expected
		System.out.println("Is Empty? " +  l.isEmpty());
		System.out.println();
		System.out.println();

		//Clear list and make sure it is empty
		System.out.println("No Output after this point");
		System.out.println();
		while (!l.isEmpty()) {
			l.deleteAt(0);
		}
		l.printFwd(); // No output expected
		System.out.println();
		l.printRev(); // No output expected
		System.out.println();
	}

}