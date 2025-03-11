package lakuis;

/**
 *
 * @author L E N O V O
 */

abstract class Kendaraan {
    protected String nama;
    protected int hargaPerHari;

    public Kendaraan(String nama, int harga) {
        this.nama = nama;
        this.hargaPerHari = harga;
    }

    public String getNama() {
        return nama;
    }

    public int getHargaPerHari() {
        return hargaPerHari;
    }

    public abstract String getJenis();
}

class Motor extends Kendaraan {
    public Motor(String nama, int harga) {
        super(nama, harga);
    }
    @Override
    public String getJenis() {
        return "Motor";
    }
}

class Mobil extends Kendaraan {
    public Mobil(String nama, int harga) {
        super(nama, harga);
    }
    @Override
    public String getJenis() {
        return "Mobil";
    }
}
