import java.util.Scanner;

/**
 * Kelas Barang merepresentasikan item dalam inventaris
 */
class Barang {
    String nama;
    int jumlahStok;
    double harga;

    // Constructor untuk inisialisasi objek
    public Barang(String nama, int jumlahStok, double harga) {
        this.nama = nama;
        this.jumlahStok = jumlahStok;
        this.harga = harga;
    }
}

/**
 * Program Inventaris Toko - Soal 2
 * Menambahkan fitur Update Stok dan Cari Barang
 */
public class InventarisToko {
    // Array inventaris dan jumlah barang sebagai variabel static
    static Barang[] inventaris = new Barang[10];
    static int jumlahBarang = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menambahkan 5 barang ke dalam array
        inventaris[0] = new Barang("Pensil", 50, 2000);
        inventaris[1] = new Barang("Buku Tulis", 30, 15000);
        inventaris[2] = new Barang("Penghapus", 20, 3000);
        inventaris[3] = new Barang("Penggaris", 25, 5000);
        inventaris[4] = new Barang("Pulpen", 40, 4000);
        jumlahBarang = 5;

        // Menampilkan inventaris awal
        System.out.println("==========================================");
        System.out.println("           INVENTARIS TOKO");
        System.out.println("==========================================");
        tampilkanInventaris();
        System.out.println("==========================================");

        System.out.println();

        // ===== FITUR UPDATE STOK =====
        System.out.print("Masukkan nama barang yang ingin diupdate: ");
        String namaUpdate = scanner.nextLine();
        System.out.print("Masukkan jumlah stok baru: ");
        int stokBaru = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        // Panggil method updateStok
        updateStok(namaUpdate, stokBaru);

        // Tampilkan inventaris setelah diupdate
        System.out.println("\n==========================================");
        System.out.println("       INVENTARIS SETELAH DIUPDATE");
        System.out.println("==========================================");
        tampilkanInventaris();
        System.out.println("==========================================");

        System.out.println();

        // ===== FITUR CARI BARANG =====
        System.out.print("Masukkan nama barang yang dicari: ");
        String namaCari = scanner.nextLine();

        // Panggil method cariBarang
        cariBarang(namaCari);

        scanner.close();
    }

    /**
     * Method untuk menampilkan semua barang dalam inventaris
     * Time Complexity: O(n) - harus iterasi semua elemen
     * Space Complexity: O(1) - tidak ada alokasi memori tambahan
     */
    public static void tampilkanInventaris() {
        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println((i + 1) + ". Nama: " + inventaris[i].nama +
                    ", Jumlah Stok: " + inventaris[i].jumlahStok +
                    ", Harga: Rp " + (int)inventaris[i].harga);
        }
    }

    /**
     * Method untuk mengupdate jumlah stok berdasarkan nama barang
     * Time Complexity: O(n) - worst case harus cek semua barang
     * Space Complexity: O(1) - tidak ada alokasi memori tambahan
     *
     * @param nama - nama barang yang akan diupdate
     * @param jumlahBaru - jumlah stok baru
     */
    public static void updateStok(String nama, int jumlahBaru) {
        for (int i = 0; i < jumlahBarang; i++) {
            if (inventaris[i].nama.equalsIgnoreCase(nama)) {
                int stokLama = inventaris[i].jumlahStok;
                inventaris[i].jumlahStok = jumlahBaru;
                System.out.println("\n>> Stok berhasil diupdate!");
                System.out.println(">> " + nama + ": " + stokLama + " -> " + jumlahBaru);
                return;
            }
        }
        // Jika tidak ditemukan
        System.out.println("\n>> Barang dengan nama '" + nama + "' tidak ditemukan.");
    }

    /**
     * Method untuk mencari barang berdasarkan nama dan menampilkan detailnya
     * Time Complexity: O(n) - linear search
     * Space Complexity: O(1) - tidak ada alokasi memori tambahan
     *
     * @param nama - nama barang yang dicari
     */
    public static void cariBarang(String nama) {
        System.out.println("\n==========================================");
        System.out.println("           HASIL PENCARIAN");
        System.out.println("==========================================");

        for (int i = 0; i < jumlahBarang; i++) {
            if (inventaris[i].nama.equalsIgnoreCase(nama)) {
                System.out.println("Barang ditemukan!");
                System.out.println("------------------------------------------");
                System.out.println("Nama       : " + inventaris[i].nama);
                System.out.println("Jumlah Stok: " + inventaris[i].jumlahStok);
                System.out.println("Harga      : Rp " + (int)inventaris[i].harga);
                System.out.println("==========================================");
                return;
            }
        }
        // Jika tidak ditemukan
        System.out.println("Barang dengan nama '" + nama + "' tidak ditemukan.");
        System.out.println("==========================================");
    }
}

