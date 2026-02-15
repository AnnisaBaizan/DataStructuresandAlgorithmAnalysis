package UAS;

import java.util.Stack;

/**
 * Class untuk mengelola sistem Undo menggunakan Stack
 */
public class ManajerUndo {
    private Stack<Aksi> stackAksi;

    // Constructor
    public ManajerUndo() {
        this.stackAksi = new Stack<>();
    }

    /**
     * Menambahkan aksi baru yang dilakukan pengguna
     * @param aksi Aksi yang akan ditambahkan
     */
    public void tambahAksi(Aksi aksi) {
        stackAksi.push(aksi);
        System.out.println("✓ Aksi ditambahkan: " + aksi.getDeskripsiAksi());
    }

    /**
     * Membatalkan aksi terakhir (Undo)
     * @return Aksi yang dibatalkan
     * @throws Exception jika tidak ada aksi yang bisa dibatalkan
     */
    public Aksi batalkanAksi() throws Exception {
        if (apakahKosong()) {
            throw new Exception("❌ Tidak ada aksi yang bisa dibatalkan!");
        }

        Aksi aksiBatal = stackAksi.pop();
        System.out.println("↶ Undo: " + aksiBatal.getDeskripsiAksi());
        return aksiBatal;
    }

    /**
     * Melihat aksi terakhir tanpa menghapusnya
     * @return Aksi terakhir
     * @throws Exception jika stack kosong
     */
    public Aksi lihatAksiTerakhir() throws Exception {
        if (apakahKosong()) {
            throw new Exception("❌ Tidak ada aksi dalam riwayat!");
        }

        return stackAksi.peek();
    }

    /**
     * Mengecek apakah tidak ada aksi yang bisa dibatalkan
     * @return true jika kosong, false jika ada aksi
     */
    public boolean apakahKosong() {
        return stackAksi.isEmpty();
    }

    /**
     * Mendapatkan jumlah aksi dalam stack
     * @return Jumlah aksi
     */
    public int jumlahAksi() {
        return stackAksi.size();
    }

    /**
     * Menampilkan semua aksi dalam stack (untuk debugging)
     */
    public void tampilkanSemuaAksi() {
        if (apakahKosong()) {
            System.out.println("Stack kosong - tidak ada aksi.");
            return;
        }

        System.out.println("\n=== Riwayat Aksi (dari terbaru) ===");
        int index = stackAksi.size();
        for (Aksi aksi : stackAksi) {
            System.out.println(index + ". " + aksi.getDeskripsiAksi());
            index--;
        }
        System.out.println("===================================\n");
    }
}