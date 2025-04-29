package Posttest6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemLaporanKeuangan {
    private static final ArrayList<LaporanKeuangan> laporanList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
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

            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka. Silakan coba lagi.");
                scanner.nextLine(); // reset buffer
            }
        }
    }

    private static void tambahLaporan() {
        try {
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
                    LaporanPemasukan pem = new LaporanPemasukan(idCounter++, tanggal, jumlah, keterangan, sumber);
                    if (pem.validasiJumlah(jumlah) && pem.validasiTanggal(tanggal)) {
                        laporan = pem;
                    } else {
                        System.out.println("Data tidak valid. Tanggal atau jumlah salah.");
                        return;
                    }
                }
                case 2 -> {
                    System.out.print("Masukkan kategori: ");
                    String kategori = scanner.nextLine();
                    LaporanPengeluaran peng = new LaporanPengeluaran(idCounter++, tanggal, jumlah, keterangan, kategori);
                    if (peng.validasiJumlah(jumlah) && peng.validasiTanggal(tanggal)) {
                        laporan = peng;
                    } else {
                        System.out.println("Data tidak valid. Tanggal atau jumlah salah.");
                        return;
                    }
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
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Silakan coba lagi.");
            scanner.nextLine();
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
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }

    private static void hapusLaporan() {
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }
}
