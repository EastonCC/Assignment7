package a7conkin;

import java.util.Scanner;

/**
 * Easton Conkin
 * CS3410
 * Spring 2024
 * Assignment 7
 */

class a7conkin {
	static Scanner input = new Scanner(System.in);
	static HashTable hashTable = null;

	public static void main(String[] args) {
		int size = 0;
		double threshold = 0;
		System.out.println("What is the initial size of your hash table? ");
		size = input.nextInt();
		if (size < 0) { System.out.println("Size is non-positive, it has been set to 1 by default."); size = 1;}
		System.out.println("What is the load threshold of your hash table? (enter a decimal between 0 and 1) ");
		threshold = input.nextDouble();
		if (threshold > 1 || threshold <= 0) { System.out.println("Threshold is out of bounds, it has been set to 0.8 by default."); threshold = 0.8;}
		hashTable = new HashTable(size, threshold);

		hashTablePrompt();

	}

	public static void hashTablePrompt() {
		int choice = 0;
		System.out.print("Type a number corresponding to a command to control your hash table.\n" 
		+ "1. Insert\n"
		+ "2. Delete\n" 
		+ "3. Get current load factor threshold\n" 
		+ "4. Print hash table\n" 
		+ "5. Quit\n");
		choice = input.nextInt();
		switch (choice) {
		case 1: {
			insertCommand();
		}
		case 2: {
			deleteCommand();
		}
		case 3: {
			loadFactorCommand();
		}
		case 4: {
			printCommand();
		}
		case 5: {
			quitCommand();
		}
		default:
			quitCommand();
		}
	}
	
	private static void insertCommand() {
		System.out.println("Number to insert: ");
		int numberToInsert = input.nextInt();
		hashTable.insert(numberToInsert);
		hashTablePrompt();

	}

	private static void deleteCommand() {
		System.out.println("Index to delete: ");
		int numberToDelete = input.nextInt();
		hashTable.delete(numberToDelete);
		hashTablePrompt();

	}
	
	private static void loadFactorCommand() {
		System.out.println(hashTable.getLoadFactor());
		hashTablePrompt();

	}
	
	private static void printCommand() {
		hashTable.printTable();
		hashTablePrompt();

	}
	
	private static void quitCommand() {
		System.exit(0);
	}
	
}
