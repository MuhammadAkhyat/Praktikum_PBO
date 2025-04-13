package Posttest4;

public class LaporanKeuangan {
    protected int id;
    protected String tanggal;
    protected double pemasukan;
    protected double pengeluaran;

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

    public String getJenis() {
        return "Umum";
    }

    public double hitungSaldo() {
        return pemasukan - pengeluaran;
    }

    public double hitungSaldo(double tambahan) {
        return (pemasukan + tambahan) - pengeluaran;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Tanggal: " + tanggal +
                " | Pemasukan: " + pemasukan +
                " | Pengeluaran: " + pengeluaran +
                " | Jenis: " + getJenis();
    }
}
