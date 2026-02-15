package UAS;

/**
 * Class untuk merepresentasikan setiap aksi yang dilakukan pengguna
 */
public class Aksi {
    private String deskripsiAksi;

    /**
     * Constructor
     * @param deskripsiAksi Deskripsi dari aksi yang dilakukan
     */
    public Aksi(String deskripsiAksi) {
        this.deskripsiAksi = deskripsiAksi;
    }

    /**
     * Getter untuk deskripsi aksi
     * @return Deskripsi aksi
     */
    public String getDeskripsiAksi() {
        return deskripsiAksi;
    }

    /**
     * Setter untuk deskripsi aksi
     * @param deskripsiAksi Deskripsi baru
     */
    public void setDeskripsiAksi(String deskripsiAksi) {
        this.deskripsiAksi = deskripsiAksi;
    }

    /**
     * Override toString untuk print yang mudah
     * @return String representation dari aksi
     */
    @Override
    public String toString() {
        return "Aksi: " + deskripsiAksi;
    }
}