package lakuis;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class DetailPenyewaanFrame extends JFrame {
    private JTextField namaField, teleponField, hariField;
    private List<Kendaraan> daftarKendaraan;
    private Kendaraan kendaraanTerpilih;
    private JFrame parent;
    
    public DetailPenyewaanFrame(String jenis, JFrame parent) {
        this.parent = parent;
        parent.setVisible(false);
        setTitle("Detail Penyewaan");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2));
        
        daftarKendaraan = new ArrayList<>();
        if (jenis.equals("Motor")) {
            daftarKendaraan.add(new Motor("Honda Beat", 50000));
            daftarKendaraan.add(new Motor("Yamaha NMAX", 80000));
            daftarKendaraan.add(new Motor("Suzuki Satria", 60000));
        } else {
            daftarKendaraan.add(new Mobil("Toyota Avanza", 300000));
            daftarKendaraan.add(new Mobil("Honda Jazz", 350000));
            daftarKendaraan.add(new Mobil("Suzuki Ertiga", 320000));
        }
        
        add(new JLabel("Nama Penyewa: "));
        namaField = new JTextField();
        add(namaField);
        
        add(new JLabel("Nomor Telepon: "));
        teleponField = new JTextField();
        add(teleponField);
        
        add(new JLabel("Pilih Kendaraan: "));
        ButtonGroup group = new ButtonGroup();
        JPanel radioPanel = new JPanel(new GridLayout(3, 1));
        
        for (Kendaraan k : daftarKendaraan) {
            JRadioButton radio = new JRadioButton(k.getNama() + " - Rp" + k.getHargaPerHari());
            radio.addActionListener(e -> kendaraanTerpilih = k);
            radioPanel.add(radio);
            group.add(radio);
        }
        add(radioPanel);
        
        add(new JLabel("Jumlah Hari: "));
        hariField = new JTextField();
        add(hariField);
        
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(e -> simpanData());
        add(simpanButton);
        
        setVisible(true);
    }
    
    private void simpanData() {
        try {
            String nama = namaField.getText();
            String telepon = teleponField.getText();
            int jumlahHari = Integer.parseInt(hariField.getText());
            
            if (nama.isEmpty() || telepon.isEmpty() || kendaraanTerpilih == null) {
                JOptionPane.showMessageDialog(this, "Harap isi semua data!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            int totalHarga = jumlahHari * kendaraanTerpilih.getHargaPerHari();
            new DetailHargaFrame(nama, telepon, kendaraanTerpilih, jumlahHari, totalHarga, this);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah hari yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}