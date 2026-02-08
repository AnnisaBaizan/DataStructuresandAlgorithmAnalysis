package Praktikum5;
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        System.out.println("=== PRAKTIK: Java HashMap (Built-in) ===\n");
        
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Menambahkan elemen ke HashMap
        System.out.println("Menambahkan elemen...");
        hashMap.put(1, "Alice");
        hashMap.put(11, "Bob");
        hashMap.put(21, "Charlie");

        // Menampilkan elemen
        System.out.println("\nIsi HashMap:");
        System.out.println(hashMap);

        // Mencari elemen
        System.out.println("\n=== Search ===");
        System.out.println("Search key 11: " + hashMap.get(11));
        System.out.println("Search key 1: " + hashMap.get(1));

        // Update elemen
        System.out.println("\n=== Update ===");
        hashMap.put(11, "Bobby");
        System.out.println("After updating key 11: " + hashMap);

        // Menghapus elemen
        System.out.println("\n=== Delete ===");
        hashMap.remove(11);
        System.out.println("After deleting 11: " + hashMap);

        // Menampilkan ukuran
        System.out.println("\nTotal elemen: " + hashMap.size());
    }
}
