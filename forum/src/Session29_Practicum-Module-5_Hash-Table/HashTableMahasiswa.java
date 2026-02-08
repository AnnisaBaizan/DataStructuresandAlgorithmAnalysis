package Praktikum5;
import java.util.LinkedList;

class HashTableMahasiswa_Class {
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
    HashTableMahasiswa_Class(int size) {
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

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("(NIM: " + entry.key + ", Nama: " + entry.value + ") -> ");
            }
            System.out.println("null");
        }
    }

    void update(int key, String newValue) {
        int index = hashFunction(key);
        for (Entry entry : table[index]) {
            if (entry.key == key) {
                entry.value = newValue;
                System.out.println("Data NIM " + key + " berhasil diupdate.");
                return;
            }
        }
        System.out.println("NIM " + key + " tidak ditemukan.");
    }

    void delete(int key) {
        int index = hashFunction(key);
        boolean removed = table[index].removeIf(entry -> entry.key == key);
        if (removed) {
            System.out.println("Data NIM " + key + " berhasil dihapus.");
        } else {
            System.out.println("NIM " + key + " tidak ditemukan.");
        }
    }
}

public class HashTableMahasiswa {
    public static void main(String[] args) {
        HashTableMahasiswa_Class hashTable = new HashTableMahasiswa_Class(10);

        System.out.println("=== LATIHAN 1: Hash Table Mahasiswa ===\n");

        // Tambahkan beberapa data mahasiswa
        hashTable.insert(20231001, "John Doe");
        hashTable.insert(20231002, "Jane Smith");
        hashTable.insert(20231011, "Alice Johnson");
        hashTable.insert(20231012, "Bob Williams");

        // Tampilkan data sebelum update dan delete
        System.out.println("Sebelum update dan delete:");
        hashTable.display();

        // Test update
        System.out.println("\n=== Testing Update ===");
        hashTable.update(20231002, "Jane Anderson");
        hashTable.update(20231099, "Non Existent"); // Test NIM yang tidak ada

        System.out.println("\nSetelah update:");
        hashTable.display();

        // Test delete
        System.out.println("\n=== Testing Delete ===");
        hashTable.delete(20231011);
        hashTable.delete(20231099); // Test NIM yang tidak ada

        System.out.println("\nSetelah delete:");
        hashTable.display();
    }
}
