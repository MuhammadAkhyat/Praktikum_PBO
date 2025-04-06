package Posttest3;

import java.util.ArrayList;
import java.util.Scanner;

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
                case 1 -> tambahLaporan();
                case 2 -> lihatLaporan();
                case 3 -> editLaporan();
                case 4 -> hapusLaporan();
                case 5 -> {
                    System.out.println("Terima kasih! Keluar dari program.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static void tambahLaporan() {
        System.out.println("\nJenis Laporan:");
        System.out.println("1. Pemasukan");
        System.out.println("2. Pengeluaran");
        System.out.println("3. Campuran");
        System.out.print("Pilih jenis laporan: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan tanggal laporan (YYYY-MM-DD): ");
        String tanggal = scanner.nextLine();

        switch (jenis) {
            case 1 -> {
                System.out.print("Masukkan jumlah pemasukan: ");
                double pemasukan = scanner.nextDouble();
                scanner.nextLine();
                laporanList.add(new LaporanPemasukan(idCounter++, tanggal, pemasukan));
            }
            case 2 -> {
                System.out.print("Masukkan jumlah pengeluaran: ");
                double pengeluaran = scanner.nextDouble();
                scanner.nextLine();
                laporanList.add(new LaporanPengeluaran(idCounter++, tanggal, pengeluaran));
            }
            case 3 -> {
                System.out.print("Masukkan jumlah pemasukan: ");
                double pemasukan = scanner.nextDouble();
                System.out.print("Masukkan jumlah pengeluaran: ");
                double pengeluaran = scanner.nextDouble();
                scanner.nextLine();
                laporanList.add(new LaporanCampuran(idCounter++, tanggal, pemasukan, pengeluaran));
            }
            default -> System.out.println("Jenis laporan tidak valid.");
        }

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
            if (laporan.getId() == id) {
                System.out.print("Masukkan tanggal baru: ");
                laporan.setTanggal(scanner.nextLine());

                if (laporan instanceof LaporanPemasukan) {
                    System.out.print("Masukkan pemasukan baru: ");
                    laporan.setPemasukan(scanner.nextDouble());
                    laporan.setPengeluaran(0);
                } else if (laporan instanceof LaporanPengeluaran) {
                    System.out.print("Masukkan pengeluaran baru: ");
                    laporan.setPengeluaran(scanner.nextDouble());
                    laporan.setPemasukan(0);
                } else {
                    System.out.print("Masukkan pemasukan baru: ");
                    laporan.setPemasukan(scanner.nextDouble());
                    System.out.print("Masukkan pengeluaran baru: ");
                    laporan.setPengeluaran(scanner.nextDouble());
                }

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
            if (laporanList.get(i).getId() == id) {
                laporanList.remove(i);
                System.out.println("Laporan berhasil dihapus!");
                return;
            }
        }

        System.out.println("Laporan tidak ditemukan.");
    }
}
