package Posttest5;

public class LaporanPengeluaran extends LaporanKeuangan {
    private String kategori;

    public LaporanPengeluaran(int id, String tanggal, double jumlah, String keterangan, String kategori) {
        super(id, tanggal, jumlah, keterangan);
        this.kategori = kategori;
    }

    @Override
    public void tampilkanDetail() {
        header();
        System.out.println("ID Laporan   : " + id);
        System.out.println("Tanggal      : " + tanggal);
        System.out.println("Jumlah       : Rp" + jumlah);
        System.out.println("Keterangan   : " + keterangan);
        System.out.println("Kategori     : " + kategori);
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
