package Posttest5;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemLaporanKeuangan {
    private static ArrayList<LaporanKeuangan> laporanList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu Sistem Laporan Keuangan Harian Indomaret:");
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
        System.out.print("Masukkan jumlah: ");
        double jumlah = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan keterangan: ");
        String keterangan = scanner.nextLine();

        LaporanKeuangan laporan = null;

        switch (jenis) {
            case 1 -> {
                System.out.print("Masukkan sumber: ");
                String sumber = scanner.nextLine();
                laporan = new LaporanPemasukan(idCounter++, tanggal, jumlah, keterangan, sumber);
            }
            case 2 -> {
                System.out.print("Masukkan kategori: ");
                String kategori = scanner.nextLine();
                laporan = new LaporanPengeluaran(idCounter++, tanggal, jumlah, keterangan, kategori);
            }
            case 3 -> {
                System.out.print("Masukkan jenis transaksi: ");
                String jenisTransaksi = scanner.nextLine();
                laporan = new LaporanCampuran(idCounter++, tanggal, jumlah, keterangan, jenisTransaksi);
            }
            default -> System.out.println("Jenis laporan tidak valid.");
        }

        if (laporan != null) {
            laporanList.add(laporan);
            System.out.println("Laporan berhasil ditambahkan.");
        }
    }

    private static void lihatLaporan() {
        if (laporanList.isEmpty()) {
            System.out.println("Belum ada laporan yang ditambahkan.");
        } else {
            for (LaporanKeuangan laporan : laporanList) {
                laporan.tampilkanDetail();
                System.out.println();
            }
        }
    }

    private static void editLaporan() {
        System.out.print("Masukkan ID laporan yang ingin diedit: ");
        int idEdit = scanner.nextInt();
        scanner.nextLine();

        for (LaporanKeuangan laporan : laporanList) {
            if (laporan.getId() == idEdit) {
                System.out.print("Masukkan tanggal baru: ");
                laporan.setTanggal(scanner.nextLine());
                System.out.print("Masukkan jumlah baru: ");
                laporan.setJumlah(scanner.nextDouble());
                scanner.nextLine();
                System.out.print("Masukkan keterangan baru: ");
                laporan.setKeterangan(scanner.nextLine());
                System.out.println("Laporan berhasil diedit.");
                return;
            }
        }
        System.out.println("Laporan dengan ID tersebut tidak ditemukan.");
    }

    private static void hapusLaporan() {
        System.out.print("Masukkan ID laporan yang ingin dihapus: ");
        int idHapus = scanner.nextInt();
        scanner.nextLine();

        for (LaporanKeuangan laporan : laporanList) {
            if (laporan.getId() == idHapus) {
                laporanList.remove(laporan);
                System.out.println("Laporan berhasil dihapus.");
                return;
            }
        }
        System.out.println("Laporan dengan ID tersebut tidak ditemukan.");
    }
}
