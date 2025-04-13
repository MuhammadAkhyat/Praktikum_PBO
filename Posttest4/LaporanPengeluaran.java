package Posttest4;

public class LaporanPengeluaran extends LaporanKeuangan {
    public LaporanPengeluaran(int id, String tanggal, double pengeluaran) {
        super(id, tanggal, 0, pengeluaran);
    }

    @Override
    public String getJenis() {
        return "Pengeluaran";
    }
}
