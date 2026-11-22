public class Transfer {
    private double batasGratis;
    private double biayaAdminAntarBank;

    //Constructor
    public Transfer(double batasGratis, double biayaAdminAntarBank) {
        this.batasGratis = batasGratis;
        this.biayaAdminAntarBank = biayaAdminAntarBank;
    }

    public double getBatasGratis() {
        return batasGratis;
    }

    public void setBatasGratis(double batasGratis) {
        if (batasGratis >= 0) {
            this.batasGratis = batasGratis;
        }
    }

    public double getBiayaAdminAntarBank() {
        return biayaAdminAntarBank;
    }

    public void setBiayaAdminAntarBank(double biayaAdminAntarBank) {
        if (biayaAdminAntarBank >= 0) {
            this.biayaAdminAntarBank = biayaAdminAntarBank;
        }
    }

    public void prosesTransfer(Rekening pengirim, Rekening penerima, double nominal, String inputPin) {
        if (!pengirim.cekPin(inputPin)) {
            System.out.println("Gagal: PIN salah!");
            return;
        }
        if (nominal <= 0) {
            System.out.println("Gagal: Nominal transfer harus lebih dari 0.");
            return;
        }
        if (pengirim.getNoRekening().equals(penerima.getNoRekening())) {
            System.out.println("Gagal: Tidak dapat mentransfer ke rekening sendiri.");
            return;
        }

        // Cek biaya admin (beda bank atau di atas batas tertentu)
        double biayaAdmin = 0;
        if (!pengirim.getNamaBank().equalsIgnoreCase(penerima.getNamaBank()) || nominal > this.batasGratis) {
            biayaAdmin = this.biayaAdminAntarBank;
        }

        double totalPotongan = nominal + biayaAdmin;

        if (!pengirim.memenuhiSaldoMinimum(totalPotongan)) {
            System.out.println("Gagal: Saldo tidak mencukupi (Total: Rp" + totalPotongan + ", Sisa minimal Rp" + pengirim.getSaldoMinimum() + ")");
            return;
        }

        //transfer
        pengirim.setSaldo(pengirim.getSaldo() - totalPotongan);
        penerima.setSaldo(penerima.getSaldo() + nominal);

        //catat ke riwayat kedua rekening
        String ket = "Transfer ke Rek " + penerima.getNoRekening() + " (" + penerima.getNamaBank() + ")";
        if (biayaAdmin > 0) {
            ket += " [Admin: Rp" + biayaAdmin + "]";
        }
        pengirim.tambahRiwayat(new TransaksiBank("Transfer Keluar", totalPotongan, ket));
        penerima.tambahRiwayat(new TransaksiBank("Transfer Masuk", nominal, "Transfer dari Rek " + pengirim.getNoRekening()));

        System.out.println("Transfer Rp" + nominal + " ke " + penerima.getNoRekening() + " berhasil!");
        if (biayaAdmin > 0) {
            System.out.println("Biaya admin transfer: Rp" + biayaAdmin);
        }
        System.out.println("Sisa saldo Anda: Rp" + pengirim.getSaldo());
    }
}