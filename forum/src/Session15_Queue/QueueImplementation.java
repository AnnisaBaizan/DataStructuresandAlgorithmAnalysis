package Session15_Queue;

// ========================================
// Node class untuk Linked List
// ========================================
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// ========================================
// Queue Implementation using Array
// ========================================
class QueueArray {
    private int[] queue;
    private int front, rear, size, capacity;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow! Tidak bisa menambah " + item);
            return;
        }
        rear++;
        queue[rear] = item;
        size++;
        System.out.println(item + " berhasil di-enqueue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue kosong");
            return -1;
        }

        int item = queue[front];

        // Shift elemen ke kiri
        for (int i = 0; i < rear; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
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
        System.out.print("Queue: Front -> ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("<- Rear");
    }
}

// ========================================
// Queue Implementation using Linked List
// ========================================
class QueueLinkedList {
    private Node front, rear;
    private int size;

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);

        if (rear == null) {
            front = rear = newNode;
            size++;
            System.out.println(item + " berhasil di-enqueue");
            return;
        }

        rear.next = newNode;
        rear = newNode;
        size++;
        System.out.println(item + " berhasil di-enqueue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue kosong");
            return -1;
        }

        int item = front.data;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue kosong!");
            return;
        }

        System.out.print("Queue: Front -> ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("<- Rear");
    }
}

// ========================================
// Main Class - Testing
// ========================================
public class QueueImplementation {
    public static void main(String[] args) {

        // ========================================
        // TEST QUEUE USING ARRAY
        // ========================================
        System.out.println("========================================");
        System.out.println("    QUEUE IMPLEMENTATION USING ARRAY");
        System.out.println("========================================\n");

        QueueArray queueArr = new QueueArray(5);

        System.out.println("--- Test Enqueue ---");
        queueArr.enqueue(10);
        queueArr.enqueue(20);
        queueArr.enqueue(30);
        queueArr.enqueue(40);
        queueArr.display();

        System.out.println("\nSize: " + queueArr.getSize());
        System.out.println("Front element: " + queueArr.peek());

        System.out.println("\n--- Test Dequeue ---");
        System.out.println("Dequeue: " + queueArr.dequeue());
        System.out.println("Dequeue: " + queueArr.dequeue());
        queueArr.display();

        System.out.println("\n--- Enqueue lagi ---");
        queueArr.enqueue(50);
        queueArr.enqueue(60);
        queueArr.display();

        System.out.println("\n--- Test Queue Penuh ---");
        queueArr.enqueue(70);
        queueArr.display();
        queueArr.enqueue(80); // Gagal karena penuh

        System.out.println("\n--- Dequeue Semua ---");
        while (!queueArr.isEmpty()) {
            System.out.println("Dequeue: " + queueArr.dequeue());
        }
        queueArr.display();
        queueArr.dequeue(); // Coba dequeue saat kosong


        // ========================================
        // TEST QUEUE USING LINKED LIST
        // ========================================
        System.out.println("\n\n===========================================");
        System.out.println("  QUEUE IMPLEMENTATION USING LINKED LIST");
        System.out.println("===========================================\n");

        QueueLinkedList queueLL = new QueueLinkedList();

        System.out.println("--- Test Enqueue ---");
        queueLL.enqueue(100);
        queueLL.enqueue(200);
        queueLL.enqueue(300);
        queueLL.enqueue(400);
        queueLL.display();

        System.out.println("\nSize: " + queueLL.getSize());
        System.out.println("Front element: " + queueLL.peek());

        System.out.println("\n--- Test Dequeue ---");
        System.out.println("Dequeue: " + queueLL.dequeue());
        System.out.println("Dequeue: " + queueLL.dequeue());
        queueLL.display();

        System.out.println("\n--- Enqueue lagi ---");
        queueLL.enqueue(500);
        queueLL.enqueue(600);
        queueLL.enqueue(700);
        queueLL.display();

        System.out.println("\nSize: " + queueLL.getSize());

        System.out.println("\n--- Dequeue Semua ---");
        while (!queueLL.isEmpty()) {
            System.out.println("Dequeue: " + queueLL.dequeue());
        }
        queueLL.display();
        queueLL.dequeue(); // Coba dequeue saat kosong

        System.out.println("\n--- Enqueue Setelah Kosong ---");
        queueLL.enqueue(999);
        queueLL.display();


        // ========================================
        // PERBANDINGAN
        // ========================================
        System.out.println("\n\n========================================");
        System.out.println("           PERBANDINGAN");
        System.out.println("========================================");
        System.out.println("| Aspek          | Array           | Linked List     |");
        System.out.println("|----------------|-----------------|-----------------|");
        System.out.println("| Memory         | Fixed size      | Dynamic size    |");
        System.out.println("| Overflow       | Bisa terjadi    | Tidak ada       |");
        System.out.println("| Implementation | Lebih sederhana | Lebih kompleks  |");
        System.out.println("| Access Speed   | Lebih cepat     | Lebih lambat    |");
        System.out.println("| Resizing       | Sulit           | Mudah           |");
        System.out.println("========================================\n");
    }
}