import java.util.Scanner;

/**
 * Program Sistem Manajemen Antrian Restoran
 * Menggunakan Single Linked List dengan operasi Push dan Pop
 */

/*
 * ===========================
 * Class: Node
 * Representasi satu pelanggan dalam antrian
 * ===========================
 */
class Node {
    String namaPelanggan;  // Data: nama pelanggan
    int nomorAntrian;      // Data: nomor antrian
    Node next;             // Pointer ke node berikutnya

    // Konstruktor
    public Node(String namaPelanggan, int nomorAntrian) {
        this.namaPelanggan = namaPelanggan;
        this.nomorAntrian = nomorAntrian;
        this.next = null;
    }

    // Method untuk menampilkan informasi node
    @Override
    public String toString() {
        return "[" + nomorAntrian + "] " + namaPelanggan;
    }
}

/*
 * ===========================
 * Class: AntrianRestoran
 * Implementasi Single Linked List untuk sistem antrian
 * ===========================
 */
class AntrianRestoran {
    private Node head;           // Pointer ke node pertama (depan antrian)
    private Node tail;           // Pointer ke node terakhir (belakang antrian)
    private int jumlahPelanggan; // Jumlah pelanggan dalam antrian
    private int counterAntrian;  // Counter untuk nomor antrian

    // Konstruktor
    public AntrianRestoran() {
        this.head = null;
        this.tail = null;
        this.jumlahPelanggan = 0;
        this.counterAntrian = 0;
    }

    /**
     * Method isEmpty()
     * Mengecek apakah antrian kosong
     * @return true jika antrian kosong, false jika tidak
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Method getJumlahPelanggan()
     * Mengembalikan jumlah pelanggan dalam antrian
     * @return jumlah pelanggan
     */
    public int getJumlahPelanggan() {
        return jumlahPelanggan;
    }

    /**
     * Method push() - Menambahkan pelanggan ke antrian
     * Pelanggan baru ditambahkan di akhir antrian (FIFO)
     * Kompleksitas Waktu: O(1)
     *
     * @param namaPelanggan nama pelanggan yang akan ditambahkan
     */
    public void push(String namaPelanggan) {
        counterAntrian++;
        Node newNode = new Node(namaPelanggan, counterAntrian);

        if (isEmpty()) {
            // Jika antrian kosong, head dan tail menunjuk ke node baru
            head = newNode;
            tail = newNode;
        } else {
            // Jika antrian tidak kosong, tambahkan di belakang
            tail.next = newNode;
            tail = newNode;
        }

        jumlahPelanggan++;

        System.out.println("\n✓ Pelanggan berhasil ditambahkan!");
        System.out.println("  Nama    : " + namaPelanggan);
        System.out.println("  No. Antrian: " + counterAntrian);

        // Tampilkan antrian setelah operasi push
        display();
    }

    /**
     * Method pop() - Melayani dan menghapus pelanggan dari antrian
     * Pelanggan yang dilayani adalah yang paling depan (FIFO)
     * Kompleksitas Waktu: O(1)
     *
     * @return nama pelanggan yang dilayani, atau null jika antrian kosong
     */
    public String pop() {
        if (isEmpty()) {
            System.out.println("\n✗ Antrian kosong! Tidak ada pelanggan yang bisa dilayani.");
            return null;
        }

        // Simpan data pelanggan yang akan dilayani
        String namaDilayani = head.namaPelanggan;
        int nomorDilayani = head.nomorAntrian;

        // Pindahkan head ke node berikutnya
        head = head.next;
        jumlahPelanggan--;

        // Jika setelah pop antrian kosong, tail juga harus null
        if (head == null) {
            tail = null;
        }

        System.out.println("\n✓ Pelanggan sedang dilayani!");
        System.out.println("  Nama    : " + namaDilayani);
        System.out.println("  No. Antrian: " + nomorDilayani);

        // Tampilkan antrian setelah operasi pop
        display();

        return namaDilayani;
    }

    /**
     * Method peek() - Melihat pelanggan di depan antrian tanpa menghapus
     * Kompleksitas Waktu: O(1)
     *
     * @return nama pelanggan di depan antrian
     */
    public String peek() {
        if (isEmpty()) {
            System.out.println("\n✗ Antrian kosong!");
            return null;
        }

        System.out.println("\n→ Pelanggan selanjutnya yang akan dilayani:");
        System.out.println("  Nama    : " + head.namaPelanggan);
        System.out.println("  No. Antrian: " + head.nomorAntrian);

        return head.namaPelanggan;
    }

    /**
     * Method display() - Menampilkan seluruh antrian
     * Kompleksitas Waktu: O(n)
     */
    public void display() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║       DAFTAR ANTRIAN PELANGGAN         ║");
        System.out.println("╠════════════════════════════════════════╣");

        if (isEmpty()) {
            System.out.println("║     ~ Antrian kosong ~                 ║");
        } else {
            System.out.println("║ Total pelanggan dalam antrian: " +
                    String.format("%-7d", jumlahPelanggan) + " ║");
            System.out.println("╠════════════════════════════════════════╣");

            Node current = head;
            int posisi = 1;

            while (current != null) {
                String status = (posisi == 1) ? " ← DEPAN" : "";
                System.out.printf("║ %d. [%03d] %-20s%s\n",
                        posisi, current.nomorAntrian,
                        current.namaPelanggan, status);
                current = current.next;
                posisi++;
            }
        }

        System.out.println("╚════════════════════════════════════════╝");
    }

    /**
     * Method displayVisualisasi() - Menampilkan visualisasi Linked List
     */
    public void displayVisualisasi() {
        System.out.println("\n=== VISUALISASI SINGLE LINKED LIST ===\n");

        if (isEmpty()) {
            System.out.println("head → null");
            System.out.println("tail → null");
            return;
        }

        System.out.print("head → ");
        Node current = head;

        while (current != null) {
            System.out.print("[" + current.namaPelanggan + "|");
            if (current.next != null) {
                System.out.print("•] → ");
            } else {
                System.out.print("null] → null");
            }
            current = current.next;
        }

        System.out.println();
        System.out.println("                                    ↑");
        System.out.println("                                   tail");
        System.out.println();
    }
}

/*
 * ===========================
 * Class: Main Program
 * Menu interaktif untuk sistem antrian restoran
 * ===========================
 */
public class SistemAntrianRestoran {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AntrianRestoran antrian = new AntrianRestoran();

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   SISTEM MANAJEMEN ANTRIAN RESTORAN    ║");
        System.out.println("║     Menggunakan Single Linked List     ║");
        System.out.println("╚════════════════════════════════════════╝");

        boolean running = true;

        while (running) {
            System.out.println("\n┌────────────── MENU ──────────────┐");
            System.out.println("│ 1. Tambah Pelanggan (Push)       │");
            System.out.println("│ 2. Layani Pelanggan (Pop)        │");
            System.out.println("│ 3. Lihat Pelanggan Selanjutnya   │");
            System.out.println("│ 4. Tampilkan Semua Antrian       │");
            System.out.println("│ 5. Visualisasi Linked List       │");
            System.out.println("│ 0. Keluar                        │");
            System.out.println("└──────────────────────────────────┘");
            System.out.print("Pilih menu: ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    // Push - Tambah pelanggan
                    System.out.print("\nMasukkan nama pelanggan: ");
                    String nama = scanner.nextLine().trim();
                    if (!nama.isEmpty()) {
                        antrian.push(nama);
                    } else {
                        System.out.println("✗ Nama tidak boleh kosong!");
                    }
                    break;

                case "2":
                    // Pop - Layani pelanggan
                    antrian.pop();
                    break;

                case "3":
                    // Peek - Lihat pelanggan selanjutnya
                    antrian.peek();
                    break;

                case "4":
                    // Display - Tampilkan semua antrian
                    antrian.display();
                    break;

                case "5":
                    // Visualisasi Linked List
                    antrian.displayVisualisasi();
                    break;

                case "0":
                    // Keluar
                    running = false;
                    System.out.println("\nTerima kasih telah menggunakan sistem antrian!");
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("\n✗ Pilihan tidak valid! Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}