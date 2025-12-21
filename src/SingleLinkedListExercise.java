class LinkedList {
    // Inner class Node untuk Single Linked List
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // SOLUSI: Implementasi metode untuk mencari nilai maksimum
    void findMax() {
        if (head == null) {
            System.out.println("Linked List kosong");
            return;
        }

        int max = head.data;
        int position = 0, currentPosition = 0;
        Node temp = head;

        while (temp != null) {
            if (temp.data > max) {
                max = temp.data;
                position = currentPosition;
            }
            currentPosition++;
            temp = temp.next;
        }

        System.out.println("Nilai maksimum: " + max + " ditemukan di posisi: " + position);
    }
}

public class SingleLinkedListExercise {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(15);
        list.insert(30);

        list.display();
        list.findMax();  // Memanggil metode findMax()
    }
}