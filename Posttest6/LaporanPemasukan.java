package Posttest6;

public class LaporanPemasukan extends LaporanKeuangan implements ValidasiInput {
    private String sumber;

    public LaporanPemasukan(int id, String tanggal, double jumlah, String keterangan, String sumber) {
        super(id, tanggal, jumlah, keterangan);
        this.sumber = sumber;
    }

    @Override
    public void tampilkanDetail() {
        header();
        System.out.println("ID Laporan   : " + id);
        System.out.println("Tanggal      : " + tanggal);
        System.out.println("Jumlah       : Rp" + jumlah);
        System.out.println("Keterangan   : " + keterangan);
        System.out.println("Sumber       : " + sumber);
    }

    public String getSumber() { return sumber; }
    public void setSumber(String sumber) { this.sumber = sumber; }

    @Override
    public boolean validasiJumlah(double jumlah) {
        return jumlah > 0;
    }

    @Override
    public boolean validasiTanggal(String tanggal) {
        return tanggal.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}
