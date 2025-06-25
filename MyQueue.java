public class MyQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = size = 0;
        rear = capacity - 1;
    }

    public void enqueue(int item) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Dequeued: " + q.dequeue());
    }
}