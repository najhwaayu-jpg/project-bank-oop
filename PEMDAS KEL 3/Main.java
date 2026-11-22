
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
   

        Nasabah nasabah1 = new Nasabah("orang", "123456");
        Rekening rek1 = new Rekening("1001", nasabah1, 500000, "Bank ghofar");
        System.out.println("Rekening berhasil dibuka: " + rek1.getNoRekening());

        // cek PIN
        // System.out.println("PIN benar? " + rek1.cekPin("123456"));
        // System.out.println("PIN salah? " + rek1.cekPin("000000"));
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
        Scanner in = new Scanner(System.in);
        // rekening kedua untuk bahan uji coba transfer
        Nasabah nasabah2 = new Nasabah("Budi", "654321");
        Rekening rek2 = new Rekening("1002", nasabah2, 200000, "Bank ghofar");
        System.out.println("Rekening kedua berhasil dibuka: " + rek2.getNoRekening());

        int pilihan;
        do {
            System.out.println("\n=== MENU ATM BANK GHOFAR ===");
            System.out.println("1. Tarik Tunai");
            System.out.println("2. Setor Tunai"); //NO 3 (NEENA)
            System.out.println("3. Transfer ke Rek 1002"); //NO 4 (AFIF)
            System.out.println("4. Riwayat Transaksi");
            System.out.println("5. Ubah Saldo Minimum");
            System.out.println("0. Keluar");
            pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("Masukan nominal tarik: ");
                    double nomTarik = in.nextDouble();
                    in.nextLine();
                    System.out.println("Mmasukkan PIN: ");
                    String pinTarik = in.nextLine();
                    rek1.tarik(nomTarik, pinTarik);
                    break;
                case 2:
                    // BAGIAN NEENA (Setor Tunai);
                    System.out.println("Fitur setor tunai belum tersedia.");
                    break;

                case 3:
                    // BAGIAN AFIF (TRANSFER)
                    System.out.println("Fitur transfer belum tersedia");
                    break;
                case 4:
                    rek1.tampilkanRiwayat();
                    break;
                case 5:
                    System.out.println("Masukkan saldo minimum baru: ");
                    double minBaru = in.nextDouble();
                    in.nextLine();
                    rek1.setSaldoMinimum(minBaru);
                    break;
                case 0:
                    System.out.println("Terimakasih");
                    break;
                default:
                    System.out.println("Menu tidak valid");

            }
        } while (pilihan != 0);
        in.close();
    }
}
