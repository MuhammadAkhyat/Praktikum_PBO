package Posttest2;

public class LaporanKeuangan {
    private int id;
    private String tanggal;
    private double pemasukan;
    private double pengeluaran;

    public LaporanKeuangan(int id, String tanggal, double pemasukan, double pengeluaran) {
        this.id = id;
        this.tanggal = tanggal;
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
    }

    public int getId() {
        return id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getPemasukan() {
        return pemasukan;
    }

    public void setPemasukan(double pemasukan) {
        this.pemasukan = pemasukan;
    }

    public double getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(double pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tanggal: " + tanggal + 
            " | Pemasukan: " + pemasukan + 
            " | Pengeluaran: " + pengeluaran;
    }
}
