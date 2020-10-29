package com.revature;

import java.util.ArrayList;
import java.util.Random;

import com.revature.list.MyArrayList;

public class Driver {
	
	private static final int AMOUNT = 1000;

	public static void main(String[] args) {
		ArrayList<Integer> reglist = new ArrayList<>();
		MyArrayList mylist = new MyArrayList();

		Random r = new Random(System.currentTimeMillis());
		for(int i = 0; i < AMOUNT; i++) {
			int val = r.nextInt(AMOUNT);
			reglist.add(val);
			mylist.add(val);
		}
		
		long t1 = System.nanoTime();
		
		for(int i = 0; i < AMOUNT; i++) {
			reglist.set(i, AMOUNT % (2 * (i % 10) + 3));
		}
		
		for(int i = 0; i < AMOUNT; i++) {
			reglist.remove(0);
		}
		
		long t2 = System.nanoTime();
		
		long regTime = t2 - t1;
		
		
		t1 = System.nanoTime();
		
		for(int i = 0; i < AMOUNT; i++) {
			mylist.set(i, AMOUNT % (2 * (i % 10) + 3));
		}
		
		for(int i = 0; i < AMOUNT; i++) {
			mylist.remove(0);
		}
		
		t2 = System.nanoTime();
		
		long myTime = t2 - t1;
		
		System.out.println("It took ArrayList " + regTime + " ns to complete.");
		System.out.println("It took MyArrayList " + myTime + " ns to complete.");
		
		double ratio = (double) (myTime - regTime) / (double) regTime;
		
		System.out.printf("The original ArrayList is %.2f%% faster.%n", ratio * 100);
	}
}
