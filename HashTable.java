package a7conkin;

/**
 * Easton Conkin
 * CS3410
 * Spring 2024
 * Assignment 7
 */

public class HashTable {
	private double loadFactorThreshold;
	private int size;
	private int[] hashTable;
	
	public int getLength() {
		return hashTable.length;
	}
	
	public HashTable(int size, double loadFactorThreshold) {
		hashTable = new int[size];
		this.loadFactorThreshold = loadFactorThreshold;
	}
	
	public void delete(int index) {
		if (index >= 0 && index <= hashTable.length && size > 0) {
			hashTable[index] = 0;
			size--;
		}
	}
	
	public double getLoadFactor() {
		return loadFactorThreshold;
	}
	
	// Comments added because this part is what gave me the most trouble, hopefully it explains the process well
	public void insert(int number) {
	    // Check if the hash table needs to be resized based on the load factor threshold
	    if (size == (int)(hashTable.length * loadFactorThreshold)) {
	        // Create a new array that is double the size of the current hash table
	        int[] temp = new int[hashTable.length * 2];
	        
	        // Rehash all existing elements in the hash table into the new array
	        for (int i = 0; i < hashTable.length; i++) {
	            // Only rehash non-zero elements (i.e., actual stored values)
	            if (hashTable[i] != 0) {
	                // Calculate the new index for the current element
	                int j = hashTable[i] % temp.length;
	                // Resolve collisions using linear probing
	                while (temp[j] != 0) {
	                    j = (j + 1) % temp.length;
	                }
	                // Place the element in the new index
	                temp[j] = hashTable[i];
	            }
	        }
	        // Update the reference to the hash table to the new resized array
	        hashTable = temp;
	    }

	    // (No table resizing needed) Calculate the index for the new element
	    int i = number % hashTable.length;
	    // Resolve collisions using linear probing
	    while (hashTable[i] != 0) {
	        i = (i + 1) % hashTable.length;
	    }
	    // Insert the new element into the calculated index
	    hashTable[i] = number;
	    // Increment the size of the hash table
	    size++;
	}

	
	
	public void printTable() {
		System.out.print("[");
		for (int i = 0; i < hashTable.length; i++) {
			if (i == hashTable.length - 1) {
				System.out.print(hashTable[i]);
			}
			else {
				System.out.print(hashTable[i] + ", ");
			}
		}
		System.out.println("]");
	}
}
