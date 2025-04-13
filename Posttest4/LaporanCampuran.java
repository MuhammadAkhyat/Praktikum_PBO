package Posttest4;

public class LaporanCampuran extends LaporanKeuangan {
    public LaporanCampuran(int id, String tanggal, double pemasukan, double pengeluaran) {
        super(id, tanggal, pemasukan, pengeluaran);
    }

    @Override
    public String getJenis() {
        return "Campuran";
    }
}
