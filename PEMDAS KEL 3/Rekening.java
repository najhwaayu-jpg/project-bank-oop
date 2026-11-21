import java.util.ArrayList;

public class Rekening {
    private String noRekening;
    private Nasabah pemilik;
    private double saldo;
    private String namaBank;
    private double saldoMinimum = 50000;
    private double totalTarikHariIni = 0;
    private double batasTarikHarian = 5000000;
    private ArrayList<TransaksiBank> riwayat = new ArrayList<>();

    public Rekening(String noRekening, Nasabah pemilik, double saldoAwal, String namaBank) {
        this.noRekening = noRekening;
        this.pemilik = pemilik;
        this.saldo = saldoAwal;
        this.namaBank = namaBank;
    }

    public void tarik(double nominal, String inputPin) {
        if (!this.pemilik.cekPin(inputPin)) {
            System.out.println("Gagal: PIN salah!");
            return;
        }
        if (nominal <= 0) {
            System.out.println("Gagal: Nominal penarikan harus lebih dari 0");
            return;
        }
        if (this.totalTarikHariIni + nominal > this.batasTarikHarian) {
            System.out.println("Gagal: Melebihi batas penarikan harian (Maks: Rp" + this.batasTarikHarian + ")");
            return;
        }
        if (this.saldo - nominal < this.saldoMinimum) {
            System.out.println("Gagal: Saldo tidak mencukupi (Sisa saldo minimal Rp" + this.saldoMinimum + ")");
            return;
        }

        this.saldo -= nominal;
        this.totalTarikHariIni += nominal;
        this.riwayat.add(new TransaksiBank("Tarik Tunai", nominal, "Penarikan tunai berhasil"));
        System.out.println("Tarik tunai Rp" + nominal + " berhasil. Sisa saldo: Rp" + this.saldo);
    }

    public void tampilkanRiwayat() {
        System.out.println("=== RIWAYAT TRANSAKSI (" + this.noRekening + ") ===");
        if (this.riwayat.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (TransaksiBank t : this.riwayat) {
                t.tampilkanInfo();
            }
        }
    }


    public boolean cekPin(String inputPin) {
        return this.pemilik.cekPin(inputPin);
    }

    public String getNoRekening() {
        return noRekening;
    }

    public double getSaldoMinimum() {
        return saldoMinimum;
    }

    public void setSaldoMinimum(double saldoMinimum) {
        if (saldoMinimum < 0) {
            System.out.println("Gagal: Saldo minimum tidak boleh negatif");
            return;
        }
        this.saldoMinimum = saldoMinimum;
    }

    public boolean memenuhiSaldoMinimum(double nominal) {
        return (this.saldo - nominal) >= this.saldoMinimum;
    }

}

