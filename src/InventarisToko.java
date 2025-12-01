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
 * Program Inventaris Toko - Soal 1
 * Menambahkan dan Menampilkan Inventaris
 */
public class InventarisToko {
    public static void main(String[] args) {
        // Deklarasi array untuk menyimpan daftar barang dengan kapasitas 10
        Barang[] inventaris = new Barang[10];

        // Menambahkan 5 barang ke dalam array
        inventaris[0] = new Barang("Pensil", 50, 2000);
        inventaris[1] = new Barang("Buku Tulis", 30, 15000);
        inventaris[2] = new Barang("Penghapus", 20, 3000);
        inventaris[3] = new Barang("Penggaris", 25, 5000);
        inventaris[4] = new Barang("Pulpen", 40, 4000);

        int jumlahBarang = 5; // Jumlah barang yang ada di inventaris

        // Menampilkan semua barang di inventaris
        System.out.println("==========================================");
        System.out.println("           INVENTARIS TOKO");
        System.out.println("==========================================");

        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println((i + 1) + ". Nama: " + inventaris[i].nama +
                    ", Jumlah Stok: " + inventaris[i].jumlahStok +
                    ", Harga: Rp " + (int)inventaris[i].harga);
        }

        System.out.println("==========================================");
        System.out.println("Total jenis barang: " + jumlahBarang);
        System.out.println("==========================================");
    }
}
