package UAS;
/**
 * Class Main untuk mendemonstrasikan sistem Undo
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   SISTEM UNDO - EDITOR TEKS SEDERHANA");
        System.out.println("==============================================\n");

        // Inisialisasi ManajerUndo
        ManajerUndo manajer = new ManajerUndo();

        try {
            // Simulasi: User mengetik beberapa kata
            System.out.println("--- User melakukan beberapa aksi ---\n");

            manajer.tambahAksi(new Aksi("Mengetik 'Halo'"));
            manajer.tambahAksi(new Aksi("Mengetik 'Dunia'"));
            manajer.tambahAksi(new Aksi("Memformat teks menjadi Bold"));
            manajer.tambahAksi(new Aksi("Menambah baris baru"));
            manajer.tambahAksi(new Aksi("Mengetik 'Selamat pagi'"));

            // Tampilkan riwayat
            manajer.tampilkanSemuaAksi();

            // Lihat aksi terakhir tanpa undo
            System.out.println("--- Melihat aksi terakhir ---");
            Aksi terakhir = manajer.lihatAksiTerakhir();
            System.out.println("👁 Aksi terakhir: " + terakhir.getDeskripsiAksi());
            System.out.println("Jumlah aksi: " + manajer.jumlahAksi() + "\n");

            // Simulasi: User melakukan Undo beberapa kali
            System.out.println("--- User melakukan Undo 3 kali ---\n");

            manajer.batalkanAksi(); // Undo: Mengetik 'Selamat pagi'
            manajer.batalkanAksi(); // Undo: Menambah baris baru
            manajer.batalkanAksi(); // Undo: Memformat teks Bold

            // Tampilkan riwayat setelah undo
            manajer.tampilkanSemuaAksi();

            // User melakukan aksi baru setelah undo
            System.out.println("--- User melakukan aksi baru ---\n");
            manajer.tambahAksi(new Aksi("Mengetik 'Indonesia'"));
            manajer.tambahAksi(new Aksi("Menyimpan dokumen"));

            manajer.tampilkanSemuaAksi();

            // Undo semua aksi yang tersisa
            System.out.println("--- Undo semua aksi yang tersisa ---\n");

            while (!manajer.apakahKosong()) {
                manajer.batalkanAksi();
            }

            System.out.println("\nStatus stack: " +
                    (manajer.apakahKosong() ? "Kosong ✓" : "Masih ada aksi"));

            // Coba undo lagi (seharusnya error)
            System.out.println("\n--- Mencoba undo saat stack kosong ---");
            manajer.batalkanAksi(); // Akan throw exception

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n==============================================");
        System.out.println("         DEMONSTRASI SELESAI");
        System.out.println("==============================================");
    }
}