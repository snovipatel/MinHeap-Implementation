
public class TestMinHeap {

	public static void main(String[] args) {
		
		
		MinHeap<Integer> heap = new MinHeap<>();
		
		heap.add(5);
		heap.add(3); 
		heap.add(8); 
		heap.add(1); 
		heap.add(7); 
		
		while (heap.size() > 0) {
			System.out.println(heap.removeMin());
		}
		
		Integer[] arr = {9, 5, 7, 2, 8};
		heap = new MinHeap<>(arr);
		
		while (heap.size() > 0) {
			System.out.println(heap.removeMin());
		}
		
		//heapsort
		Integer[] arr2 = {15, 3, 21, 2, 16};
		heap = new MinHeap<>(arr2);
		
		Comparable[] sorted = heap.heapsort();
		for (Comparable n:sorted) {
			System.out.println(n);
		}
		
		//edge cases: empty and one elem
		MinHeap<Integer> empty = new MinHeap<>();
		System.out.println(empty.removeMin());
		
		MinHeap<Integer> oneElem = new MinHeap<>();
		oneElem.add(50);
		System.out.println(oneElem.removeMin());
		
		
		//Duplicates
		heap = new MinHeap<>();
		int[] dup = {6,33,15,11,11};
		
		for(int n : dup) {
			heap.add(n);
		}
		
		while (heap.size() > 0) {
			System.out.println(heap.removeMin());
		}
		
		//sorted and reverse sorted
		heap = new MinHeap<>(new Integer[] {1, 2, 3, 4, 5});
		while (heap.size() > 0) {
			System.out.println(heap.removeMin());
		}
		
		heap = new MinHeap<>(new Integer[] {5, 4, 3, 2, 1});
		while (heap.size() > 0) {
			System.out.println(heap.removeMin());
		}
			
	}

}
