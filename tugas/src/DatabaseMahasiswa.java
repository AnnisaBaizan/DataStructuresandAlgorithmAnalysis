import java.util.Scanner;

class Node {
    String nim;
    String nama;
    String jurusan;
    Node next;

    public Node(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.next = null;
    }
}

class StudentLinkedList {
    private Node head;
    private int size;
    private final int MAX_SIZE = 5;

    public StudentLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method push data mahasiswa
    public void push(String nim, String nama, String jurusan) {
        // Validasi jumlah data maksimal 5
        if (size >= MAX_SIZE) {
            System.out.println("Error: Database penuh! Maksimal 5 data.");
            return;
        }

        // Validasi NIM maksimal 10 angka
        if (nim.length() > 10 || !nim.matches("\\d+")) {
            System.out.println("Error: NIM harus angka dan maksimal 10 digit!");
            return;
        }

        // Validasi nama maksimal 30 karakter
        if (nama.length() > 30) {
            System.out.println("Error: Nama maksimal 30 karakter!");
            return;
        }

        // Validasi jurusan maksimal 50 karakter
        if (jurusan.length() > 50) {
            System.out.println("Error: Jurusan maksimal 50 karakter!");
            return;
        }

        // Tambahkan node baru
        Node newNode = new Node(nim, nama, jurusan);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        size++;
        System.out.println("Data mahasiswa berhasil ditambahkan!");
    }

    // Method menampilkan data dengan sorting berdasarkan NIM
    public void display() {
        if (head == null) {
            System.out.println("Database kosong!");
            return;
        }

        // Copy data ke array untuk sorting
        Node[] nodes = new Node[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            nodes[index++] = current;
            current = current.next;
        }

        // Bubble sort berdasarkan NIM
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (nodes[j].nim.compareTo(nodes[j + 1].nim) > 0) {
                    Node temp = nodes[j];
                    nodes[j] = nodes[j + 1];
                    nodes[j + 1] = temp;
                }
            }
        }

        // Tampilkan data terurut
        System.out.println("\n========================================");
        System.out.println("DAFTAR MAHASISWA (Sorted by NIM)");
        System.out.println("========================================");
        System.out.printf("%-12s %-20s %-20s%n", "NIM", "NAMA", "JURUSAN");
        System.out.println("----------------------------------------");

        for (int i = 0; i < size; i++) {
            System.out.printf("%-12s %-20s %-20s%n",
                    nodes[i].nim, nodes[i].nama, nodes[i].jurusan);
        }
        System.out.println("========================================");
        System.out.println("Total: " + size + " mahasiswa");
    }

    // Method pop semua data
    public void popAll() {
        if (head == null) {
            System.out.println("Database sudah kosong!");
            return;
        }

        head = null;
        size = 0;
        System.out.println("Semua data berhasil dihapus!");
    }
}

public class DatabaseMahasiswa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList database = new StudentLinkedList();

        while (true) {
            System.out.println("\n=== DATABASE MAHASISWA ===");
            System.out.println("1. Push data mahasiswa");
            System.out.println("2. Tampilkan semua data");
            System.out.println("3. Pop semua data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (pilihan) {
                case 1:
                    System.out.print("NIM: ");
                    String nim = scanner.nextLine();
                    System.out.print("Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Jurusan: ");
                    String jurusan = scanner.nextLine();
                    database.push(nim, nama, jurusan);
                    break;

                case 2:
                    database.display();
                    break;

                case 3:
                    database.popAll();
                    break;

                case 4:
                    System.out.println("Terima kasih!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}