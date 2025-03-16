package Posttest1;
import java.util.ArrayList;
import java.util.Scanner;

class LaporanKeuangan {
    int id;
    String tanggal;
    double pemasukan;
    double pengeluaran;

    public LaporanKeuangan(int id, String tanggal, double pemasukan, double pengeluaran) {
        this.id = id;
        this.tanggal = tanggal;
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tanggal: " + tanggal + " | Pemasukan: " + pemasukan + " | Pengeluaran: " + pengeluaran;
    }
}

public class SistemLaporanKeuangan {
    private static ArrayList<LaporanKeuangan> laporanList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu Sistem Laporan Keuangan Harian Indomaret");
            System.out.println("1. Tambah Laporan");
            System.out.println("2. Lihat Laporan");
            System.out.println("3. Edit Laporan");
            System.out.println("4. Hapus Laporan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    tambahLaporan();
                    break;
                case 2:
                    lihatLaporan();
                    break;
                case 3:
                    editLaporan();
                    break;
                case 4:
                    hapusLaporan();
                    break;
                case 5:
                    System.out.println("Terima kasih! Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahLaporan() {
        System.out.print("Masukkan tanggal laporan (YYYY-MM-DD): ");
        String tanggal = scanner.nextLine();
        System.out.print("Masukkan pemasukan: ");
        double pemasukan = scanner.nextDouble();
        System.out.print("Masukkan pengeluaran: ");
        double pengeluaran = scanner.nextDouble();
        scanner.nextLine();

        laporanList.add(new LaporanKeuangan(idCounter++, tanggal, pemasukan, pengeluaran));
        System.out.println("Laporan berhasil ditambahkan!");
    }

    private static void lihatLaporan() {
        if (laporanList.isEmpty()) {
            System.out.println("Belum ada laporan keuangan.");
            return;
        }
        System.out.println("\nDaftar Laporan Keuangan:");
        for (LaporanKeuangan laporan : laporanList) {
            System.out.println(laporan);
        }
    }

    private static void editLaporan() {
        System.out.print("Masukkan ID laporan yang akan diedit: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (LaporanKeuangan laporan : laporanList) {
            if (laporan.id == id) {
                System.out.print("Masukkan tanggal baru: ");
                laporan.tanggal = scanner.nextLine();
                System.out.print("Masukkan pemasukan baru: ");
                laporan.pemasukan = scanner.nextDouble();
                System.out.print("Masukkan pengeluaran baru: ");
                laporan.pengeluaran = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Laporan berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Laporan tidak ditemukan.");
    }

    private static void hapusLaporan() {
        System.out.print("Masukkan ID laporan yang akan dihapus: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < laporanList.size(); i++) {
            if (laporanList.get(i).id == id) {
                laporanList.remove(i);
                System.out.println("Laporan berhasil dihapus!");
                return;
            }
        }
        System.out.println("Laporan tidak ditemukan.");
    }
}