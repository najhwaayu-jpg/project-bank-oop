public class Main {
    public static void main(String[] args) {
   
        Nasabah nasabah1 = new Nasabah("orang", "123456");
        Rekening rek1 = new Rekening("1001", nasabah1, 500000, "Bank ghofar");
        System.out.println("Rekening berhasil dibuka: " + rek1.getNoRekening());

        // cek PIN
        System.out.println("PIN benar? " + rek1.cekPin("123456"));
        System.out.println("PIN salah? " + rek1.cekPin("000000"));

        // saldo minimum
        System.out.println("Saldo minimum: Rp" + rek1.getSaldoMinimum());
        rek1.tarik(460000, "123456"); // sisa 40.000 < 50.000, harus gagal

       // Setor tunai
       System.out.println("Setor Tunai:");
       rek1.setor(100000);

    // Cek saldo
    System.out.println("Cek Saldo:");
    rek1.cekSaldo();

    // Biaya admin bulanan
    System.out.println("Biaya Admin Bulanan:");
    rek1.potongAdminBulanan();

    // Riwayat transaksi
    System.out.println("Riwayat Transaksi:");
    rek1.tampilkanRiwayat();
    }
}