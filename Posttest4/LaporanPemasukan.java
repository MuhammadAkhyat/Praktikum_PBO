package Posttest4;

public class LaporanPemasukan extends LaporanKeuangan {
    public LaporanPemasukan(int id, String tanggal, double pemasukan) {
        super(id, tanggal, pemasukan, 0);
    }

    @Override
    public String getJenis() {
        return "Pemasukan";
    }
}
