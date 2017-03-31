package concurrency.base;

public class CircualSet {

	private int[] array;
	private int len;
	private int index = 0;
	public CircualSet(int size) {
		array = new int[size];
		len = size;
		for (int i = 0; i < array.length; i++) {
			array[i] = -1;
		}
	}
	
	public synchronized void add(int i) {
		
		array[index] = i;
		index = ++ index %len;
	}
	
	public synchronized boolean contains(int v) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == v) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
}
