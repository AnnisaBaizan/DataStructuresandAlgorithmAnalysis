class DoublyLinkedList {
    // Inner class DoublyNode untuk Doubly Linked List
    class DoublyNode {
        int data;
        DoublyNode next, prev;

        DoublyNode(int data) {
            this.data = data;
            this.next = this.prev = null;
        }
    }
    DoublyNode head;

    void insert(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void display() {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // SOLUSI: Implementasi metode untuk menghapus node dengan nilai tertentu
    void deleteByValue(int value) {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }

        DoublyNode temp = head;

        // Traverse untuk mencari node dengan nilai tertentu
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Nilai tidak ditemukan");
            return;
        }

        // Jika node yang dihapus bukan head
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            // Jika node yang dihapus adalah head
            head = temp.next;
        }

        // Jika node yang dihapus bukan node terakhir
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }
}

public class DoublyLinkedListExercise {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);

        dll.display();
        dll.deleteByValue(30);  // Menghapus node dengan nilai 30
        dll.display();
    }
}