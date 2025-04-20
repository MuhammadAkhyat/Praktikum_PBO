package Posttest5;

public abstract class LaporanKeuangan {
    protected final int id; 
    protected String tanggal;
    protected double jumlah;
    protected String keterangan;

    public LaporanKeuangan(int id, String tanggal, double jumlah, String keterangan) {
        this.id = id;
        this.tanggal = tanggal;
        this.jumlah = jumlah;
        this.keterangan = keterangan;
    }

    public abstract void tampilkanDetail(); 

    public final void header() { 
        System.out.println("====== DETAIL LAPORAN ======");
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

    public double getJumlah() {
        return jumlah;
    }

    public void setJumlah(double jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
