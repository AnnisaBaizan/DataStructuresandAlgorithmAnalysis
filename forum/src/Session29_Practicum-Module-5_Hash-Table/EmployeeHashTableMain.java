package Praktikum5;
import java.util.LinkedList;

class EmployeeHashTable {
    private LinkedList<Entry>[] table;
    private int size;

    static class Entry {
        int id;
        String name;

        Entry(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @SuppressWarnings("unchecked")
    EmployeeHashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int id) {
        return id % size;
    }

    void insert(int id, String name) {
        int index = hashFunction(id);
        table[index].add(new Entry(id, name));
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (Entry entry : table[i]) {
                System.out.print("(ID: " + entry.id + ", Nama: " + entry.name + ") -> ");
            }
            System.out.println("null");
        }
    }

    int getTotalEmployees() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            count += table[i].size();
        }
        return count;
    }

    void displayEmployeesAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index tidak valid!");
            return;
        }
        
        System.out.println("Karyawan di Index " + index + ":");
        if (table[index].isEmpty()) {
            System.out.println("  Tidak ada karyawan");
        } else {
            for (Entry entry : table[index]) {
                System.out.println("  - ID: " + entry.id + ", Nama: " + entry.name);
            }
        }
    }
}

public class EmployeeHashTableMain {
    public static void main(String[] args) {
        EmployeeHashTable employeeTable = new EmployeeHashTable(10);

        System.out.println("=== LATIHAN 2: Hash Table Karyawan ===\n");

        // Tambahkan beberapa data karyawan
        employeeTable.insert(101, "Budi Santoso");
        employeeTable.insert(102, "Dewi Lestari");
        employeeTable.insert(111, "Ahmad Rizki");
        employeeTable.insert(103, "Siti Nurhaliza");
        employeeTable.insert(121, "Eko Prasetyo");

        // Tampilkan data
        System.out.println("Data karyawan:");
        employeeTable.display();

        // Hitung total karyawan
        System.out.println("\n=== Total Karyawan ===");
        int total = employeeTable.getTotalEmployees();
        System.out.println("Total karyawan yang terdaftar: " + total);

        // Tampilkan karyawan di index tertentu
        System.out.println("\n=== Karyawan per Index ===");
        employeeTable.displayEmployeesAtIndex(1);
        employeeTable.displayEmployeesAtIndex(2);
        employeeTable.displayEmployeesAtIndex(3);
    }
}
