
public class TransaksiBank {

    public String jenisTransaksi;
    public double nominal;
    public String keterangan;

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

    public void setNominal() {
        this.nominal = nominal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan() {
        this.keterangan = keterangan;
    }

    public void tampilkanInfo() {
        System.out.println(jenisTransaksi + " | Rp" + nominal + " | " + keterangan);
    }

}
