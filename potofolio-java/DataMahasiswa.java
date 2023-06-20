public class DataMahasiswa {
    // Struktur data untuk menyimpan data mahasiswa
    private static String[] namaMahasiswa = new String[100];
    private static int[] usiaMahasiswa = new int[100];
    private static char[] jenisKelaminMahasiswa = new char[100];
    private static double[] nilaiMahasiswa = new double[100];
    private static int jumlahMahasiswa = 0;
    public static void main(String[] args) {
        inputData();
        hitungRataRataNilai();
        tampilkanDataTerurut();
        cariMahasiswa("Asep");
        hapusMahasiswa("Euis");
        updateDataMahasiswa("Tatang");
        tampilkanLaporanStatistik();
    }
    // Method untuk menerima input data mahasiswa
    private static void inputData() {
        namaMahasiswa[jumlahMahasiswa] = "Asep";
        usiaMahasiswa[jumlahMahasiswa] = 20;
        jenisKelaminMahasiswa[jumlahMahasiswa] = 'L';
        nilaiMahasiswa[jumlahMahasiswa] = 85.5;
        jumlahMahasiswa++;
        namaMahasiswa[jumlahMahasiswa] = "Euis";
        usiaMahasiswa[jumlahMahasiswa] = 19;
        jenisKelaminMahasiswa[jumlahMahasiswa] = 'P';
        nilaiMahasiswa[jumlahMahasiswa] = 92.0;
        jumlahMahasiswa++;
        // Melakukan input data tambahan sesuai kebutuhan
        // ...
        System.out.println("Data mahasiswa berhasil diinput.");
    }
    // Method untuk menghitung rata-rata nilai mahasiswa dan menampilkannya
    private static void hitungRataRataNilai() {
        double totalNilai = 0;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            totalNilai += nilaiMahasiswa[i];
        }
        double rataRata = totalNilai / jumlahMahasiswa;
        System.out.println("Rata-rata nilai mahasiswa: " + rataRata);
    }
    // Method untuk menampilkan data mahasiswa terurut berdasarkan nilai tertinggi ke terendah
    private static void tampilkanDataTerurut() {
        // Menggunakan algoritma Bubble Sort untuk mengurutkan data
        for (int i = 0; i < jumlahMahasiswa - 1; i++) {
            for (int j = 0; j < jumlahMahasiswa - i - 1; j++) {
                if (nilaiMahasiswa[j] < nilaiMahasiswa[j + 1]) {
                    // Menukar posisi data jika nilai lebih kecil
                    String tempNama = namaMahasiswa[j];
                    namaMahasiswa[j] = namaMahasiswa[j + 1];
                    namaMahasiswa[j + 1] = tempNama;
                    int tempUsia = usiaMahasiswa[j];
                    usiaMahasiswa[j] = usiaMahasiswa[j + 1];
                    usiaMahasiswa[j + 1] = tempUsia;
                    char tempJenisKelamin = jenisKelaminMahasiswa[j];
                    jenisKelaminMahasiswa[j] = jenisKelaminMahasiswa[j + 1];
                    jenisKelaminMahasiswa[j + 1] = tempJenisKelamin;
                    double tempNilai = nilaiMahasiswa[j];
                    nilaiMahasiswa[j] = nilaiMahasiswa[j + 1];
                    nilaiMahasiswa[j + 1] = tempNilai;
                }
            }
        }
        System.out.println("Data mahasiswa terurut berdasarkan nilai:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Nama: " + namaMahasiswa[i] + ", Nilai: " + nilaiMahasiswa[i]);
        }
    }
    // Method untuk mencari mahasiswa berdasarkan nama
    private static void cariMahasiswa(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (namaMahasiswa[i].equals(nama)) {
                System.out.println("Mahasiswa ditemukan!");
                System.out.println("Nama: " + namaMahasiswa[i]);
                System.out.println("Usia: " + usiaMahasiswa[i]);
                System.out.println("Jenis Kelamin: " + jenisKelaminMahasiswa[i]);
                System.out.println("Nilai: " + nilaiMahasiswa[i]);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }
    // Method untuk menghapus data mahasiswa berdasarkan nama
    private static void hapusMahasiswa(String nama) {
        int indeks = -1;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (namaMahasiswa[i].equals(nama)) {
                indeks = i;
                break;
            }
        }
        if (indeks != -1) {
            for (int i = indeks; i < jumlahMahasiswa - 1; i++) {
                namaMahasiswa[i] = namaMahasiswa[i + 1];
                usiaMahasiswa[i] = usiaMahasiswa[i + 1];
                jenisKelaminMahasiswa[i] = jenisKelaminMahasiswa[i + 1];
                nilaiMahasiswa[i] = nilaiMahasiswa[i + 1];
            }
            jumlahMahasiswa--;
            System.out.println("Data mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }
    // Method untuk mengupdate data mahasiswa berdasarkan nama
    private static void updateDataMahasiswa(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            if (namaMahasiswa[i].equals(nama)) {
                usiaMahasiswa[i] = 21;
                nilaiMahasiswa[i] = 95.0;
                System.out.println("Data mahasiswa berhasil diupdate.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Mahasiswa tidak ditemukan.");
        }
    }
    // Method untuk menampilkan laporan statistik sederhana
    private static void tampilkanLaporanStatistik() {
        System.out.println("Jumlah total mahasiswa: " + jumlahMahasiswa);

        int totalUsia = 0;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            totalUsia += usiaMahasiswa[i];
        }
        double rataRataUsia = (double) totalUsia / jumlahMahasiswa;
        System.out.println("Rata-rata usia mahasiswa: " + rataRataUsia);
    }
}