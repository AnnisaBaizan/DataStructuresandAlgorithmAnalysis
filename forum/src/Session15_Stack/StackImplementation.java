package Session15_Stack;
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
// Stack Implementation using Array
// ========================================
class StackArray {
    private int[] stack;
    private int top;
    private int capacity;

    public StackArray(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    public void push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow! Tidak bisa push " + item);
            return;
        }
        stack[++top] = item;
        System.out.println(item + " berhasil di-push");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack kosong");
            return -1;
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return -1;
        }
        return stack[top];
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int getSize() {
        return top + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return;
        }
        System.out.print("Stack (Top -> Bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}

// ========================================
// Stack Implementation using Linked List
// ========================================
class StackLinkedList {
    private Node top;
    private int size;

    public StackLinkedList() {
        this.top = null;
        this.size = 0;
    }

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println(item + " berhasil di-push");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack kosong");
            return -1;
        }
        int item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack kosong!");
            return;
        }
        System.out.print("Stack (Top -> Bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// ========================================
// Main Class - Testing
// ========================================
public class StackImplementation {
    public static void main(String[] args) {

        // ========================================
        // TEST STACK USING ARRAY
        // ========================================
        System.out.println("========================================");
        System.out.println("     STACK IMPLEMENTATION USING ARRAY");
        System.out.println("========================================\n");

        StackArray stackArr = new StackArray(5);

        System.out.println("--- Test Push ---");
        stackArr.push(10);
        stackArr.push(20);
        stackArr.push(30);
        stackArr.push(40);
        stackArr.display();

        System.out.println("\nSize: " + stackArr.getSize());
        System.out.println("Top element: " + stackArr.peek());

        System.out.println("\n--- Test Pop ---");
        System.out.println("Pop: " + stackArr.pop());
        System.out.println("Pop: " + stackArr.pop());
        stackArr.display();

        System.out.println("\n--- Push lagi ---");
        stackArr.push(50);
        stackArr.push(60);
        stackArr.display();

        System.out.println("\n--- Test Stack Penuh ---");
        stackArr.push(70); // penuh
        stackArr.display();
        stackArr.push(80); // overflow

        System.out.println("\n--- Pop Semua ---");
        while (!stackArr.isEmpty()) {
            System.out.println("Pop: " + stackArr.pop());
        }
        stackArr.display();
        stackArr.pop(); // pop saat kosong


        // ========================================
        // TEST STACK USING LINKED LIST
        // ========================================
        System.out.println("\n\n===========================================");
        System.out.println("   STACK IMPLEMENTATION USING LINKED LIST");
        System.out.println("===========================================\n");

        StackLinkedList stackLL = new StackLinkedList();

        System.out.println("--- Test Push ---");
        stackLL.push(100);
        stackLL.push(200);
        stackLL.push(300);
        stackLL.push(400);
        stackLL.display();

        System.out.println("\nSize: " + stackLL.getSize());
        System.out.println("Top element: " + stackLL.peek());

        System.out.println("\n--- Test Pop ---");
        System.out.println("Pop: " + stackLL.pop());
        System.out.println("Pop: " + stackLL.pop());
        stackLL.display();

        System.out.println("\n--- Push lagi ---");
        stackLL.push(500);
        stackLL.push(600);
        stackLL.push(700);
        stackLL.display();

        System.out.println("\nSize: " + stackLL.getSize());

        System.out.println("\n--- Pop Semua ---");
        while (!stackLL.isEmpty()) {
            System.out.println("Pop: " + stackLL.pop());
        }
        stackLL.display();
        stackLL.pop(); // pop saat kosong

        System.out.println("\n--- Push Setelah Kosong ---");
        stackLL.push(999);
        stackLL.display();
    }
}
