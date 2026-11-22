
public class TransaksiBank {

    private String jenisTransaksi;
    private double nominal;
    private String keterangan;

    public TransaksiBank(String jenisTransaksi, double nominal, String keterangan) {
        this.jenisTransaksi = jenisTransaksi;
        this.nominal = nominal;
        this.keterangan = keterangan;
    }

    // getter dan setter
    public String getJenisTransaksi() {
        return jenisTransaksi;
    }

    public void setJenisTransaksi(String jenisTransaksi) {
        this.jenisTransaksi = jenisTransaksi;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void tampilkanInfo() {
        System.out.println(jenisTransaksi + " | Rp" + nominal + " | " + keterangan);
    }

}
