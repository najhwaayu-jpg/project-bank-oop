import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Inisialisasi rekening utama & rekening tujuan transfer
        Nasabah nasabah1 = new Nasabah("orang", "123456");
        Rekening rek1 = new Rekening("1001", nasabah1, 500000, "Bank ghofar");

        Nasabah nasabah2 = new Nasabah("Budi", "654321");
        Rekening rek2 = new Rekening("1002", nasabah2, 200000, "Bank ghofar");

        Transfer layananTransfer = new Transfer(1000000, 6500);

        System.out.println("=== SELAMAT DATANG DI BANK GHOFAR ===");
        System.out.println("Rekening Aktif : " + rek1.getNoRekening() + " (Saldo Awal: Rp" + rek1.getSaldo() + ")");
        System.out.println("Rekening Tujuan: " + rek2.getNoRekening() + " (a.n. Budi)");

        int pilihan;
        do {
            System.out.println("\n=== MENU ATM BANK GHOFAR ===");
            System.out.println("1. Tarik Tunai");
            System.out.println("2. Setor Tunai");
            System.out.println("3. Transfer ke Rek 1002");
            System.out.println("4. Riwayat Transaksi");
            System.out.println("5. Ubah Saldo Minimum");
            System.out.println("6. Cek Saldo");
            System.out.println("7. Potong Biaya Admin Bulanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = in.nextInt();
            in.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nominal tarik: ");
                    double nomTarik = in.nextDouble();
                    in.nextLine();
                    System.out.print("Masukkan PIN: ");
                    String pinTarik = in.nextLine();
                    rek1.tarik(nomTarik, pinTarik);
                    break;

                case 2:
                    System.out.print("Masukkan nominal setoran: ");
                    double nominalSetor = in.nextDouble();
                    in.nextLine();
                    rek1.setor(nominalSetor);
                    break;

                case 3:
                    System.out.print("Masukkan nominal transfer: ");
                    double nomTransfer = in.nextDouble();
                    in.nextLine();
                    System.out.print("Masukkan PIN: ");
                    String pinTransfer = in.nextLine();
                    layananTransfer.prosesTransfer(rek1, rek2, nomTransfer, pinTransfer);
                    break;

                case 4:
                    rek1.tampilkanRiwayat();
                    break;

                case 5:
                    System.out.print("Masukkan saldo minimum baru: ");
                    double minBaru = in.nextDouble();
                    in.nextLine();
                    rek1.setSaldoMinimum(minBaru);
                    break;

                case 6:
                    rek1.cekSaldo();
                    break;

                case 7:
                    rek1.potongAdminBulanan();
                    break;

                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan Bank Ghofar.");
                    break;

                default:
                    System.out.println("Menu tidak valid. Silakan pilih 0-7.");
            }
        } while (pilihan != 0);

        in.close();
    }
}