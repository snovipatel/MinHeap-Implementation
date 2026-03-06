
public class MinHeap<T extends Comparable<? super T>>{

	private T[] internal;
	private int size; // recall that internal.length might be > the number of elements in the MinHeap
	
	public MinHeap(){
	
		this.internal =(T[]) new Comparable[10];
		this.size = 0;
	}

	/** 
	 * @param arr 
	 *
	 * Iteratively add the elements of arr to this MinHeap.
	 * Note that the elements of arr may not be in an order
	 * that respects the Heap property.
	 */
	public MinHeap(T[] arr){
		// TODO
		
		internal = (T[]) new Comparable[arr.length * 2];
		size = 0;
		
		for(T elem : arr) {
			add(elem);
		}
	}
	
	/**
	 * @param elem: The element to insert into the MinHeap, resizing
	 *				this.internal if necessary.
	 */ 
	public void add(T elem){
		
		if (size == internal.length) {
			
			T[] newArr = (T[]) new Comparable[internal.length * 2];
			
			for (int i = 0; i < size; i++) {
				newArr[i] = internal[i];
			}
			internal = newArr;
		}
		
		internal[size] = elem;
		
		int i = size;
		int parent = (i - 1) / 2;
		
		while (i > 0 && internal[i].compareTo(internal[parent]) < 0) {
			T temp = internal[i];
			internal[i] = internal[parent];
			internal[parent] = temp;
			
			i = parent;
			parent = (i - 1) / 2;
		}
		
		size++;

	}
	
	
	/**
	 * @return T The element at the top of the MinHeap, which 
	 *			 is also the minimum element present.
	 * 
	 */ 
	public T removeMin(){
		
		if (size == 0) {
			return null;
		}
		
		T min = internal[0];
		internal[0] = internal[size - 1];
		size--;
		
		int i = 0;
		while (true) {
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			int smallest = i;
			
			if (left < size && internal[left].compareTo(internal[smallest]) < 0) {
				smallest = left;
			}
			
			if (right < size && internal[right].compareTo(internal[smallest]) < 0) {
				smallest = right;
			}
			
			if(smallest == i) {
				break;
			}
			
			T temp = internal[i];
			internal[i] = internal[smallest];
			internal[smallest] = temp;
			
			i = smallest;
			
		}
		
		return min;
	}
	
	
	/**
	 * @return int The number of elements in the MinHeap
	 */ 
	public int size(){
		return size;
	}
	
	
	/**
	 * @return T[] A sorted array from the elements of this MinHeap
	 *			   
	 */	 
	 public T[] heapsort(){
		 
		 MinHeap<T> copy = new MinHeap<>();
		 copy.internal = (T[]) new Comparable[internal.length];
		 copy.size = size;
		 
		 for(int i = 0; i < size; i++) {
			 copy.internal[i] = internal[i];
		 }
		 
		 T[] sorted = (T[]) new Comparable[size];
		 
		 for (int i = 0; i < sorted.length; i++) 
		 {
			 sorted[i] = copy.removeMin();
		 }
		 
		 return sorted;
	 }
	
}