public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return (2 * i) + 1; }
    private int right(int i) { return (2 * i) + 2; }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap full");
            return;
        }
        heap[size] = key;
        int current = size++;
        while (current > 0 && heap[current] < heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMin() {
        if (size <= 0) return -1;
        if (size == 1) return heap[--size];

        int root = heap[0];
        heap[0] = heap[--size];
        heapify(0);
        return root;
    }

    private void heapify(int i) {
        int smallest = i;
        int l = left(i);
        int r = right(i);

        if (l < size && heap[l] < heap[smallest]) smallest = l;
        if (r < size && heap[r] < heap[smallest]) smallest = r;

        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(10);
        h.insert(3);
        h.insert(2);
        h.insert(1);
        System.out.println("Min: " + h.extractMin());
    }
}