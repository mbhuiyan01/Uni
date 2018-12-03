import java.util.Arrays;

public class Heap {

    private int heapSize;
    private int[] heap;

    Heap(int[] array){
        this.heapSize = array.length;
        this.heap = array;
        buildMaxHeap();
    }

    Heap(int[] array, int heapSize){
        this.heapSize = heapSize;
        this.heap = array;
        buildMaxHeap();
    }

    private void buildMaxHeap(){
        for (int i = heapSize / 2 - 1; i >= 0; i--){
            maxHeapify(i);
        }
    }

    private void maxHeapify(int i){
        int l = left(i);
        int r = right(i);

        int largest = i;

        if (l < this.heapSize && this.heap[l] > this.heap[largest]){
            largest = l;
        }
        if (r < this.heapSize && this.heap[r] > this.heap[largest]){
            largest = r;
        }

        //System.out.printf("i: %d, l: %d r: %d largest: %d  %s\n", i, l, r, largest,Arrays.toString(this.heap));
        if (largest != i){
            swap(i, largest);
            maxHeapify(largest);
        }

    }

    private void increaseKey(int i, int p) throws IllegalArgumentException{
        if (p < this.heap[i]){
            throw new IllegalArgumentException("prio. too small.");
        }

        this.heap[i] = p;
        while (i > 0 && this.heap[parent(i)] < this.heap[i]){
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void insert(int p) throws IllegalArgumentException{
        if (this.heapSize + 1 > this.heap.length){
            throw new IllegalArgumentException("length of array too small.");
        }
        this.heapSize++;
        if (this.heapSize > this.heap.length){
            System.out.println("error");
        }
        this.heap[this.heapSize - 1] = -1 * Integer.MAX_VALUE;
        increaseKey(this.heapSize - 1, p);
    }

    private int extractMax() throws IllegalArgumentException{
        if (this.heapSize < 1){
            throw new IllegalArgumentException("Heap underflow");
        }
        int max = this.heap[0];
        this.heap[0] = this.heap[this.heapSize-1];
        this.heapSize--;

        maxHeapify(0);

        return max;
    }

    private int findMax(){
        return this.heap[0];
    }

    private void printHeap(){
        System.out.println(Arrays.toString(this.heap));
    }

    private int left(int i){
        return (i * 2 + 1);
    }

    private int right(int i){
        return (i * 2 + 2);
    }

    private int parent(int i){
        return i / 2;
    }

    private void swap(int i, int j){
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    public static void main(String[] args) {
        int[] A = {1, 10, 2, 7, 8, 4, 3, 9, 5, 6};

        Heap heap = new Heap(A);
        heap.printHeap();
    }
}
