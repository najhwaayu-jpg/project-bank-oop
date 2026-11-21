public class Nasabah {
    private String nama;
    private String pin;

    public Nasabah(String nama, String pin) {
        this.nama = nama;
        this.pin = pin;
    }

    public boolean cekPin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public String getNama() {
        return nama;
    }
}