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
    
    public void setor(double nominal) {
    if (nominal <= 0) {
        System.out.println("Gagal: Nominal setoran harus lebih dari 0");
        return;
    }
    this.saldo += nominal;
    this.riwayat.add(new TransaksiBank("Setor Tunai", nominal, "Setoran berhasil"));
    System.out.println("Setor tunai berhasil.");
    System.out.println("Saldo sekarang: Rp" + this.saldo);
    }

    public void cekSaldo() {
    System.out.println("Nomor Rekening: " + this.noRekening);
    System.out.println("Saldo Anda: Rp" + this.saldo);
    }


    public void potongAdminBulanan() {
    double biayaAdmin = 8000;
    if (this.saldo < biayaAdmin) {
        System.out.println("Gagal: Saldo tidak mencukupi untuk membayar biaya admin.");
        return;
    }
    this.saldo -= biayaAdmin;
    this.riwayat.add(new TransaksiBank("Biaya Admin Bulanan", biayaAdmin, "Pemotongan admin berhasil"));
    System.out.println("Biaya admin Rp" + biayaAdmin + " berhasil dipotong.");
    System.out.println("Sisa saldo: Rp" + this.saldo);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldoBaru) {
        if (saldoBaru < 0) {
            System.out.println("Gagal: Saldo tidak boleh negatif.");
            return;
        }
        this.saldo = saldoBaru;
    }

    public String getNamaBank() {
        return this.namaBank;
    }

    public void tambahRiwayat(TransaksiBank transaksi) {
        this.riwayat.add(transaksi);
    }


}

