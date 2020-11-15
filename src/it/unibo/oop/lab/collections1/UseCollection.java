package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int START_NUMBER = 1_000;
	private static final int LAST_NUMBER = 1_999;
	private static final int NEW_ELEMENTS = 1_000_00;
	private static final int TO_MS = 1_000_000;
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	
    	var arrayList = new ArrayList<Integer>();
    	
    	for(int i = START_NUMBER; i <= LAST_NUMBER; i++) {
    		arrayList.add(i);
    	}
    	
    	var linkedList = new LinkedList<Integer>(arrayList);
    	
    	int temporaryVar = arrayList.get(0);
    	arrayList.set(0, arrayList.get(arrayList.size() - 1));
    	arrayList.set(arrayList.size() - 1, temporaryVar);
    	
    	for(Integer i: arrayList) {
    		System.out.println(i);
    	}
    	
    	long time = System.nanoTime();
    	Random rd = new Random();
    	
    	for(int i = 0; i < NEW_ELEMENTS; i++) {
    		arrayList.add(0, rd.nextInt());
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Measurement of ArrayList: " + time/TO_MS + "ms");
    	
    	time = System.nanoTime();
    	
    	for(int i = 0; i < NEW_ELEMENTS; i++) {
    		linkedList.add(0, rd.nextInt());
    	}
    	
    	time = System.nanoTime() - time;
    	
    	System.out.println("Measurement of LinkedList: " + time/TO_MS + "ms");
    	
    	long time2 = System.nanoTime();
    	time = System.nanoTime();
    	
    	for(int i = 0; i < START_NUMBER; i++) {
    		System.out.println(arrayList.get(arrayList.size()/2));
    	}
    	
    	time = System.nanoTime() - time; 
    	
    	for(int i = 0; i < START_NUMBER; i++) {
    		System.out.println(linkedList.get(linkedList.size()/2));
    	}
    	
    	time2 = System.nanoTime() - time2;
    	
    	
    	System.out.println("Reading Measurement of ArrayList: " + time +
    						"\nReading Measurement of LinkedList: " + time);
    	
    	Map<String, Double> map = new HashMap<>();
    	
    	map.put("Africa", 1110635000.0);
    	map.put("Americas", 972005000.0);
    	map.put("Asia", 4298723000.0);
    	map.put("Europe", 742452000.0);
    	map.put("Oceania", 38304000.0);
    	map.put("Antartica", 0.0);
    	
    	double sum = 0;
    	for(final Double d: map.values()) {
    		sum += d;
    	}
    	
    	System.out.println("The population is about: " + sum);
    }
}
