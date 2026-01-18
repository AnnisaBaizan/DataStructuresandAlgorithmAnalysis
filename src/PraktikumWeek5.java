import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Program Perbandingan Array dan ArrayList
 * Data Structures and Algorithm Analysis - Praktikum Week 5
 * Semua kelas digabung dalam 1 file
 */

// ==================== KELAS ARRAY OPERATIONS ====================
class ArrayOperations {

    /**
     * Traversal - Menampilkan isi array
     * Time Complexity: O(n)
     */
    public void traversal(int[] arr) {
        System.out.print("Array Traversal: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Linear Search - Pencarian nilai dalam array secara linear
     * Time Complexity: O(n)
     */
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary Search - Pencarian nilai dalam array yang sudah terurut
     * Time Complexity: O(log n)
     */
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Penyisipan nilai ke dalam array pada index tertentu
     * Time Complexity: O(n)
     */
    public int[] insert(int[] arr, int value, int index) {
        if (index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }

        int[] newArr = new int[arr.length + 1];

        // Salin elemen sebelum index
        System.arraycopy(arr, 0, newArr, 0, index);

        // Sisipkan nilai baru
        newArr[index] = value;

        // Salin elemen setelah index
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);

        return newArr;
    }

    /**
     * Penghapusan nilai dari array pada index tertentu
     * Time Complexity: O(n)
     */
    public int[] delete(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }

        int[] newArr = new int[arr.length - 1];

        // Salin elemen sebelum index
        System.arraycopy(arr, 0, newArr, 0, index);

        // Salin elemen setelah index
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);

        return newArr;
    }

    /**
     * Mengurutkan array menggunakan algoritma bubble sort
     * Time Complexity: O(n^2)
     */
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}

// ==================== KELAS ARRAYLIST OPERATIONS ====================
class ArrayListOperations {

    /**
     * Traversal - Menampilkan isi ArrayList
     * Time Complexity: O(n)
     */
    public void traversal(ArrayList<Integer> list) {
        System.out.print("ArrayList Traversal: [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    /**
     * Menambahkan elemen ke dalam ArrayList
     * Time Complexity: O(1) amortized
     */
    public void add(ArrayList<Integer> list, int value) {
        list.add(value);
    }

    /**
     * Menambahkan elemen pada index tertentu
     * Time Complexity: O(n)
     */
    public void insert(ArrayList<Integer> list, int value, int index) {
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }
        list.add(index, value);
    }

    /**
     * Menghapus elemen dari ArrayList berdasarkan index
     * Time Complexity: O(n)
     */
    public void deleteByIndex(ArrayList<Integer> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index tidak valid");
        }
        list.remove(index);
    }

    /**
     * Menghapus elemen dari ArrayList berdasarkan nilai
     * Time Complexity: O(n)
     */
    public boolean deleteByValue(ArrayList<Integer> list, int value) {
        return list.remove(Integer.valueOf(value));
    }

    /**
     * Linear Search - Pencarian elemen dalam ArrayList
     * Time Complexity: O(n)
     */
    public int linearSearch(ArrayList<Integer> list, int target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Binary Search - Pencarian elemen dalam ArrayList yang sudah terurut
     * Time Complexity: O(log n)
     */
    public int binarySearch(ArrayList<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) == target) {
                return mid;
            }

            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Mengurutkan elemen dalam ArrayList menggunakan Collections.sort()
     * Time Complexity: O(n log n)
     */
    public void sort(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    /**
     * Membersihkan semua elemen dalam ArrayList
     * Time Complexity: O(n)
     */
    public void clear(ArrayList<Integer> list) {
        list.clear();
    }
}

// ==================== KELAS COMPARISON ====================
class Comparison {

    private ArrayOperations arrayOps;
    private ArrayListOperations arrayListOps;

    public Comparison() {
        this.arrayOps = new ArrayOperations();
        this.arrayListOps = new ArrayListOperations();
    }

    /**
     * Mengukur waktu eksekusi operasi traversal
     */
    public void compareTraversal(int size) {
        // Persiapan data
        int[] arr = new int[size];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr[i] = i;
            list.add(i);
        }

        // Ukur waktu Array
        long startTime = System.nanoTime();
        arrayOps.traversal(arr);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0;

        // Ukur waktu ArrayList
        startTime = System.nanoTime();
        arrayListOps.traversal(list);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("\n=== Perbandingan Waktu Traversal ===");
        System.out.printf("Waktu eksekusi traversal Array: %.6f ms\n", arrayTime);
        System.out.printf("Waktu eksekusi traversal ArrayList: %.6f ms\n", arrayListTime);
    }

    /**
     * Mengukur waktu eksekusi operasi pencarian
     */
    public void compareSearch(int size, int target) {
        // Persiapan data
        int[] arr = new int[size];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr[i] = i;
            list.add(i);
        }

        System.out.println("\n=== Perbandingan Waktu Pencarian (Linear Search) ===");

        // Linear Search pada Array
        long startTime = System.nanoTime();
        int arrIndex = arrayOps.linearSearch(arr, target);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0;

        System.out.printf("Pencarian %d dalam Array: ", target);
        if (arrIndex != -1) {
            System.out.printf("Ditemukan di indeks %d\n", arrIndex);
        } else {
            System.out.println("Tidak ditemukan");
        }
        System.out.printf("Waktu eksekusi: %.6f ms\n", arrayTime);

        // Linear Search pada ArrayList
        startTime = System.nanoTime();
        int listIndex = arrayListOps.linearSearch(list, target);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0;

        System.out.printf("Pencarian %d dalam ArrayList: ", target);
        if (listIndex != -1) {
            System.out.printf("Ditemukan di indeks %d\n", listIndex);
        } else {
            System.out.println("Tidak ditemukan");
        }
        System.out.printf("Waktu eksekusi: %.6f ms\n", arrayListTime);
    }

    /**
     * Mengukur waktu eksekusi operasi penyisipan
     */
    public void compareInsertion(int size, int value, int index) {
        // Persiapan data
        int[] arr = new int[size];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr[i] = i * 10;
            list.add(i * 10);
        }

        System.out.println("\n=== Perbandingan Waktu Penyisipan ===");

        // Penyisipan pada Array
        long startTime = System.nanoTime();
        int[] newArr = arrayOps.insert(arr, value, index);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0;

        System.out.print("Array setelah penyisipan elemen " + value + ": ");
        if (newArr.length <= 10) {
            System.out.println(Arrays.toString(newArr));
        } else {
            System.out.println("[" + newArr[0] + ", " + newArr[1] + ", ... " +
                    newArr[newArr.length-2] + ", " + newArr[newArr.length-1] + "]");
        }
        System.out.printf("Waktu eksekusi: %.6f ms\n", arrayTime);

        // Penyisipan pada ArrayList
        startTime = System.nanoTime();
        arrayListOps.insert(list, value, index);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0;

        System.out.print("ArrayList setelah penyisipan elemen " + value + ": ");
        if (list.size() <= 10) {
            System.out.println(list);
        } else {
            System.out.println("[" + list.get(0) + ", " + list.get(1) + ", ... " +
                    list.get(list.size()-2) + ", " + list.get(list.size()-1) + "]");
        }
        System.out.printf("Waktu eksekusi: %.6f ms\n", arrayListTime);
    }

    /**
     * Mengukur waktu eksekusi operasi penghapusan
     */
    public void compareDeletion(int size, int index) {
        // Persiapan data
        int[] arr = new int[size];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            arr[i] = i * 10;
            list.add(i * 10);
        }

        System.out.println("\n=== Perbandingan Waktu Penghapusan ===");

        // Penghapusan pada Array
        long startTime = System.nanoTime();
        int[] newArr = arrayOps.delete(arr, index);
        long endTime = System.nanoTime();
        double arrayTime = (endTime - startTime) / 1_000_000.0;

        System.out.print("Array setelah penghapusan elemen di indeks " + index + ": ");
        if (newArr.length <= 10) {
            System.out.println(Arrays.toString(newArr));
        } else {
            System.out.println("[" + newArr[0] + ", " + newArr[1] + ", ... " +
                    newArr[newArr.length-2] + ", " + newArr[newArr.length-1] + "]");
        }
        System.out.printf("Waktu eksekusi: %.6f ms\n", arrayTime);

        // Penghapusan pada ArrayList
        startTime = System.nanoTime();
        arrayListOps.deleteByIndex(list, index);
        endTime = System.nanoTime();
        double arrayListTime = (endTime - startTime) / 1_000_000.0;

        System.out.print("ArrayList setelah penghapusan elemen di indeks " + index + ": ");
        if (list.size() <= 10) {
            System.out.println(list);
        } else {
            System.out.println("[" + list.get(0) + ", " + list.get(1) + ", ... " +
                    list.get(list.size()-2) + ", " + list.get(list.size()-1) + "]");
        }
        System.out.printf("Waktu eksekusi: %.6f ms\n", arrayListTime);
    }

    /**
     * Membuat tabel perbandingan komprehensif
     */
    public void generateComparisonTable(int[] sizes) {
        System.out.println("\n" + "=".replace(80));
        System.out.println("TABEL PERBANDINGAN KINERJA ARRAY VS ARRAYLIST");
        System.out.println("=".replace(80));
        System.out.printf("%-20s | %-15s | %-15s | %-20s\n",
                "Operasi", "Array (ms)", "ArrayList (ms)", "Ukuran Data");
        System.out.println("-".replace(80));

        for (int size : sizes) {
            // Test Traversal
            int[] arr = new int[size];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arr[i] = i;
                list.add(i);
            }

            long start = System.nanoTime();
            for (int i = 0; i < arr.length; i++) { int x = arr[i]; }
            long end = System.nanoTime();
            double arrTraversal = (end - start) / 1_000_000.0;

            start = System.nanoTime();
            for (int i = 0; i < list.size(); i++) { int x = list.get(i); }
            end = System.nanoTime();
            double listTraversal = (end - start) / 1_000_000.0;

            System.out.printf("%-20s | %15.6f | %15.6f | %20d\n",
                    "Traversal", arrTraversal, listTraversal, size);

            // Test Search
            int target = size / 2;
            start = System.nanoTime();
            arrayOps.linearSearch(arr, target);
            end = System.nanoTime();
            double arrSearch = (end - start) / 1_000_000.0;

            start = System.nanoTime();
            arrayListOps.linearSearch(list, target);
            end = System.nanoTime();
            double listSearch = (end - start) / 1_000_000.0;

            System.out.printf("%-20s | %15.6f | %15.6f | %20d\n",
                    "Linear Search", arrSearch, listSearch, size);

            // Test Insertion
            start = System.nanoTime();
            arr = arrayOps.insert(arr, 999, size/2);
            end = System.nanoTime();
            double arrInsert = (end - start) / 1_000_000.0;

            start = System.nanoTime();
            arrayListOps.insert(list, 999, size/2);
            end = System.nanoTime();
            double listInsert = (end - start) / 1_000_000.0;

            System.out.printf("%-20s | %15.6f | %15.6f | %20d\n",
                    "Insertion", arrInsert, listInsert, size);

            System.out.println("-".replace(80));
        }
    }
}

// ==================== KELAS MAIN ====================
public class PraktikumWeek5 {

    public static void main(String[] args) {
        // Inisialisasi objek
        ArrayOperations arrayOps = new ArrayOperations();
        ArrayListOperations arrayListOps = new ArrayListOperations();
        Comparison comparison = new Comparison();

        System.out.println("=".repeat(80));
        System.out.println("PROGRAM PERBANDINGAN ARRAY VS ARRAYLIST");
        System.out.println("Data Structures and Algorithm Analysis - Praktikum Week 5");
        System.out.println("=".repeat(80));

        // ========== DEMONSTRASI OPERASI DASAR ==========
        System.out.println("\n### BAGIAN 1: DEMONSTRASI OPERASI DASAR ###\n");

        // 1. Inisialisasi data
        int[] array = {10, 20, 30, 40, 50};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        // 2. Traversal
        System.out.println("--- Operasi Traversal ---");
        arrayOps.traversal(array);
        arrayListOps.traversal(arrayList);

        // 3. Pencarian
        System.out.println("\n--- Operasi Pencarian ---");
        int searchValue = 30;
        int arrayIndex = arrayOps.linearSearch(array, searchValue);
        int arrayListIndex = arrayListOps.linearSearch(arrayList, searchValue);

        System.out.printf("Pencarian %d dalam Array: ", searchValue);
        if (arrayIndex != -1) {
            System.out.printf("Ditemukan di indeks %d\n", arrayIndex);
        } else {
            System.out.println("Tidak ditemukan");
        }

        System.out.printf("Pencarian %d dalam ArrayList: ", searchValue);
        if (arrayListIndex != -1) {
            System.out.printf("Ditemukan di indeks %d\n", arrayListIndex);
        } else {
            System.out.println("Tidak ditemukan");
        }

        // 4. Penyisipan
        System.out.println("\n--- Operasi Penyisipan ---");
        int insertValue = 25;
        int insertIndex = 2;

        System.out.println("Array sebelum penyisipan: " + Arrays.toString(array));
        array = arrayOps.insert(array, insertValue, insertIndex);
        System.out.println("Array setelah penyisipan elemen " + insertValue +
                " di indeks " + insertIndex + ": " + Arrays.toString(array));

        System.out.println("\nArrayList sebelum penyisipan: " + arrayList);
        arrayListOps.insert(arrayList, insertValue, insertIndex);
        System.out.println("ArrayList setelah penyisipan elemen " + insertValue +
                " di indeks " + insertIndex + ": " + arrayList);

        // 5. Penghapusan
        System.out.println("\n--- Operasi Penghapusan ---");
        int deleteIndex = 3;

        System.out.println("Array sebelum penghapusan: " + Arrays.toString(array));
        array = arrayOps.delete(array, deleteIndex);
        System.out.println("Array setelah penghapusan elemen di indeks " + deleteIndex +
                ": " + Arrays.toString(array));

        System.out.println("\nArrayList sebelum penghapusan: " + arrayList);
        arrayListOps.deleteByIndex(arrayList, deleteIndex);
        System.out.println("ArrayList setelah penghapusan elemen di indeks " + deleteIndex +
                ": " + arrayList);

        // 6. Binary Search (pada data terurut)
        System.out.println("\n--- Binary Search (pada data terurut) ---");
        int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        ArrayList<Integer> sortedList = new ArrayList<>(
                Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90));

        int binarySearchValue = 50;
        int arrBinaryIndex = arrayOps.binarySearch(sortedArray, binarySearchValue);
        int listBinaryIndex = arrayListOps.binarySearch(sortedList, binarySearchValue);

        System.out.printf("Binary Search %d dalam Array: Ditemukan di indeks %d\n",
                binarySearchValue, arrBinaryIndex);
        System.out.printf("Binary Search %d dalam ArrayList: Ditemukan di indeks %d\n",
                binarySearchValue, listBinaryIndex);

        // ========== PERBANDINGAN KINERJA ==========
        System.out.println("\n\n### BAGIAN 2: PERBANDINGAN KINERJA ###\n");

        // Test dengan data kecil
        System.out.println(">>> Test dengan ukuran data kecil (10 elemen) <<<");
        comparison.compareTraversal(10);
        comparison.compareSearch(10, 5);
        comparison.compareInsertion(10, 25, 5);
        comparison.compareDeletion(10, 5);

        // Test dengan data sedang
        System.out.println("\n\n>>> Test dengan ukuran data sedang (100 elemen) <<<");
        comparison.compareSearch(100, 50);
        comparison.compareInsertion(100, 999, 50);
        comparison.compareDeletion(100, 50);

        // Test dengan data besar
        System.out.println("\n\n>>> Test dengan ukuran data besar (1000 elemen) <<<");
        comparison.compareSearch(1000, 500);
        comparison.compareInsertion(1000, 999, 500);
        comparison.compareDeletion(1000, 500);

        // Tabel perbandingan komprehensif
        int[] testSizes = {100, 500, 1000, 5000};
        comparison.generateComparisonTable(testSizes);

        // ========== DEMONSTRASI SORTING ==========
        System.out.println("\n\n### BAGIAN 3: DEMONSTRASI SORTING ###\n");

        int[] unsortedArray = {64, 34, 25, 12, 22, 11, 90};
        ArrayList<Integer> unsortedList = new ArrayList<>(
                Arrays.asList(64, 34, 25, 12, 22, 11, 90));

        System.out.println("Array sebelum sorting: " + Arrays.toString(unsortedArray));
        long startTime = System.nanoTime();
        arrayOps.sort(unsortedArray);
        long endTime = System.nanoTime();
        double arraySortTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("Array setelah sorting: " + Arrays.toString(unsortedArray));
        System.out.printf("Waktu eksekusi sorting Array: %.6f ms\n", arraySortTime);

        System.out.println("\nArrayList sebelum sorting: " + unsortedList);
        startTime = System.nanoTime();
        arrayListOps.sort(unsortedList);
        endTime = System.nanoTime();
        double arrayListSortTime = (endTime - startTime) / 1_000_000.0;
        System.out.println("ArrayList setelah sorting: " + unsortedList);
        System.out.printf("Waktu eksekusi sorting ArrayList: %.6f ms\n", arrayListSortTime);

        // ========== KESIMPULAN ==========
        System.out.println("\n\n" + "=".repeat(80));
        System.out.println("KESIMPULAN");
        System.out.println("=".repeat(80));
        System.out.println("\nKELEBIHAN ARRAY:");
        System.out.println("1. Akses elemen lebih cepat karena menggunakan memory yang kontinu");
        System.out.println("2. Penggunaan memory lebih efisien (tidak ada overhead object)");
        System.out.println("3. Cocok untuk data dengan ukuran tetap");
        System.out.println("4. Performa lebih baik untuk operasi akses langsung");

        System.out.println("\nKEKURANGAN ARRAY:");
        System.out.println("1. Ukuran tetap (fixed size), tidak bisa berubah setelah inisialisasi");
        System.out.println("2. Operasi penyisipan dan penghapusan memerlukan array baru");
        System.out.println("3. Kurang fleksibel untuk manipulasi data dinamis");

        System.out.println("\nKELEBIHAN ARRAYLIST:");
        System.out.println("1. Ukuran dinamis, bisa bertambah/berkurang secara otomatis");
        System.out.println("2. Memiliki banyak method built-in untuk manipulasi data");
        System.out.println("3. Lebih mudah digunakan dan lebih fleksibel");
        System.out.println("4. Operasi penyisipan dan penghapusan lebih mudah");

        System.out.println("\nKEKURANGAN ARRAYLIST:");
        System.out.println("1. Overhead memory karena menggunakan object wrapper");
        System.out.println("2. Sedikit lebih lambat dibanding Array untuk akses elemen");
        System.out.println("3. Hanya bisa menyimpan objek, tidak bisa primitive types");

        System.out.println("\n" + "=".repeat(80));
        System.out.println("Program selesai dijalankan!");
        System.out.println("=".repeat(80));
    }
}