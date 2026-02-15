package Session15_2Queue;
// ========================================
// Circular Queue Implementation using Array
// ========================================
class CircularQueue {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Circular Queue Overflow! Tidak bisa menambah " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
        System.out.println(item + " berhasil di-enqueue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue Underflow! Queue kosong");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return -1;
        }
        return queue[front];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return;
        }
        System.out.print("Circular Queue: Front -> ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println("<- Rear");
    }
}

// ========================================
// Priority Queue Implementation using Array
// (Higher value = higher priority)
// ========================================
class PriorityQueue {
    private int[] queue;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Priority Queue Overflow! Tidak bisa menambah " + item);
            return;
        }

        int i;
        for (i = size - 1; i >= 0 && queue[i] < item; i--) {
            queue[i + 1] = queue[i];
        }
        queue[i + 1] = item;
        size++;

        System.out.println(item + " berhasil di-enqueue (priority)");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Priority Queue Underflow! Queue kosong");
            return -1;
        }
        return queue[--size];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return -1;
        }
        return queue[size - 1];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return;
        }
        System.out.print("Priority Queue (High -> Low): ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

// ========================================
// Main Class - Testing
// ========================================
public class CircularAndPriorityQueueImplementation {
    public static void main(String[] args) {

        // ========================================
        // TEST CIRCULAR QUEUE
        // ========================================
        System.out.println("========================================");
        System.out.println("       CIRCULAR QUEUE IMPLEMENTATION");
        System.out.println("========================================\n");

        CircularQueue cq = new CircularQueue(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.display();

        System.out.println("\nDequeue: " + cq.dequeue());
        System.out.println("Dequeue: " + cq.dequeue());
        cq.display();

        System.out.println("\nEnqueue lagi (memanfaatkan slot kosong)");
        cq.enqueue(50);
        cq.enqueue(60);
        cq.display();

        System.out.println("\nFront element: " + cq.peek());
        System.out.println("Size: " + cq.getSize());

        // ========================================
        // TEST PRIORITY QUEUE
        // ========================================
        System.out.println("\n\n========================================");
        System.out.println("       PRIORITY QUEUE IMPLEMENTATION");
        System.out.println("========================================\n");

        PriorityQueue pq = new PriorityQueue(5);

        pq.enqueue(30);
        pq.enqueue(10);
        pq.enqueue(50);
        pq.enqueue(20);
        pq.display();

        System.out.println("\nDequeue (priority tertinggi): " + pq.dequeue());
        pq.display();

        System.out.println("\nPeek (priority tertinggi): " + pq.peek());
        System.out.println("Size: " + pq.getSize());

        System.out.println("\nDequeue Semua:");
        while (!pq.isEmpty()) {
            System.out.println("Dequeue: " + pq.dequeue());
        }
        pq.display();
    }
}
