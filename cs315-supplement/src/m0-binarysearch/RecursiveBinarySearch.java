//Author: Richard S. Stansbury 
// Building upon BinarySearch.java implemented by Sedgewick and Wayne for the textbook
//  Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley 
//     Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu

package edu.princeton.cs.algs4;

import java.util.Arrays;

public class RecursiveBinarySearch {


	private RecursiveBinarySearch() {}

	//Kickoff method for recursive algorithm
    // - Implements the same API as BinarySearch
    // - returns the results of a call to the recursive case with lo=0 and hi=length-1
    public static int indexOf(int[] a, int key) {
    	return indexOf(a, key, 0, (a.length-1));
    }


    //Recursive implementation of the binary search algorithm. Set to private since only accessible
    // through the public indexOf method, which kicks off the search.
    private static int indexOf(int[] a, int key, int lo, int hi) {
    	if (lo > hi)  
    		return -1; //Base case - key not found 
    	else {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
     			return indexOf(a, key, lo, (mid-1)); //Progress - Recurse Left	
            }
            else if (key > a[mid]) {
				return indexOf(a, key, (mid+1), hi); //Progress - Recurse Right  		
            }
            else
            	return mid; //Base Case - key == a[mid]
    	}
    }

    //The author changed the example from the book and no longer uses rank.  
    //Rank is still included for backward compatibility. I am including it 
    //here to maintain the same API as the previous example.
    @Deprecated
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }


    /**
     * This snippet is directly from Sedgewick and Wayne.
     *
     * Reads in a sequence of integers from the whitelist file, specified as
     * a command-line argument; reads in integers from standard input;
     * prints to standard output those integers that do <em>not</em> appear in the file.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();

        // sort the array
        Arrays.sort(whitelist);

        // read integer key from standard input; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (RecursiveBinarySearch.indexOf(whitelist, key) == -1)
                StdOut.println(key);
        }
    }
	
}