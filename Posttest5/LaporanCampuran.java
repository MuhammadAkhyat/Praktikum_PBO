package Posttest5;

public final class LaporanCampuran extends LaporanKeuangan { 
    private String jenisTransaksi;

    public LaporanCampuran(int id, String tanggal, double jumlah, String keterangan, String jenisTransaksi) {
        super(id, tanggal, jumlah, keterangan);
        this.jenisTransaksi = jenisTransaksi;
    }

    @Override
    public void tampilkanDetail() {
        header();
        System.out.println("ID Laporan       : " + id);
        System.out.println("Tanggal          : " + tanggal);
        System.out.println("Jumlah           : Rp" + jumlah);
        System.out.println("Keterangan       : " + keterangan);
        System.out.println("Jenis Transaksi  : " + jenisTransaksi);
    }

    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }
}
