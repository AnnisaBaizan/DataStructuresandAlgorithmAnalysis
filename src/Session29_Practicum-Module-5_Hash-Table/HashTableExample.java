package Praktikum5;
import java.util.LinkedList;

class HashTable {
    private LinkedList<Entry>[] table;
    private int size;

    static class Entry {
        int key;
        String value;

        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    void insert(int key, String value) {
        int index = hashFunction(key);
        table[index].add(new Entry(key, value));
    }

    String search(int key) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("(Key: " + entry.key + ", Value: " + entry.value + ") -> ");
            }
            System.out.println("null");
        }
    }

    void delete(int key) {
        int index = hashFunction(key);
        table[index].removeIf(entry -> entry.key == key);
    }

    void update(int key, String newValue) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = newValue;
                return;
            }
        }
        System.out.println("Key " + key + " tidak ditemukan.");
    }
}

public class HashTableExample {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        System.out.println("=== PRAKTIK 1: Insert dan Display ===");
        hashTable.insert(1, "Alice");
        hashTable.insert(11, "Bob");
        hashTable.insert(21, "Charlie");
        hashTable.display();

        System.out.println("\n=== PRAKTIK 2: Search ===");
        System.out.println("Search key 11: " + hashTable.search(11));
        System.out.println("Search key 1: " + hashTable.search(1));

        System.out.println("\n=== PRAKTIK 3: Update ===");
        hashTable.update(11, "Bobby");
        hashTable.display();

        System.out.println("\n=== PRAKTIK 4: Delete ===");
        hashTable.delete(11);
        hashTable.display();
    }
}
