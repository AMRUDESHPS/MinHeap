import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinHeap {
	List<Integer> heap = new ArrayList<>();
	public MinHeap() {
		
	}
	
	public MinHeap(List<Integer> array) {
		buildHeap(array);
	}
	
	private void buildHeap(List<Integer> array) {
		heap = array;
		for(int i = parent(heap.size() - 1); i >= 0; i-- ) {
			shiftDown(i);
		}
		
	}
	
	private void shiftDown(int currentIdx) {
		int endIdx = heap.size() - 1;
		int leftIdx = leftChild(currentIdx);
		while(leftIdx <= endIdx) {
			int rightIdx = rightChild(currentIdx);
			int idxToShift;
			if(rightIdx <= endIdx && heap.get(rightIdx) < heap.get(leftIdx)) {
				idxToShift = rightIdx;
			} else {
				idxToShift = leftIdx;
			}
			if(heap.get(currentIdx) > heap.get(idxToShift)) {
				Collections.swap(heap, currentIdx, idxToShift);
				currentIdx = idxToShift;
				leftIdx = leftChild(currentIdx);
			}
		}
	}
	
	private void shiftUp(int currentIdx) {
		int parentIdx = parent(currentIdx);
		
		while(currentIdx > 0 && heap.get(parentIdx) > heap.get(currentIdx)) {
			Collections.swap(heap, currentIdx, parentIdx);
			currentIdx = parentIdx;
			parentIdx = parent(currentIdx);
		}
	}
	
	public int peek() {
		return heap.get(0);
	}
	
	public void remove() {
		 
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		shiftDown(0);
	}
	
	public void insert(int value) {
		heap.add(value);
		shiftUp(heap.size() - 1);
	}
	
	private int parent(int i) {
		return (i-1) / 2;
	}
	
	private int leftChild(int i) {
		return (2*i) + 1;
	}
	
	private int rightChild(int i) {
		return (2*i) + 2;
	}
	
	public void display() {
		for(int i = 0; i < heap.size(); i++) {
			System.out.println(heap.get(i));
		}
	}
	
	public static void main(String[] args) {
		List<Integer> array = new ArrayList<>(Arrays.asList(8, 1, 5));
		MinHeap heap = new MinHeap(array);
		heap.insert(2);
		heap.insert(10);
		heap.display();
		heap.remove();
		heap.display();
		System.out.println(heap.peek());

	}
}
