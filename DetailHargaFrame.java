package lakuis;

/**
 *
 * @author L E N O V O
 */
import javax.swing.*;
import java.awt.*;

class DetailHargaFrame extends JFrame {
    public DetailHargaFrame(String nama, String telepon, Kendaraan kendaraan, int jumlahHari, int totalHarga, JFrame parent) {
        parent.setVisible(false);
        setTitle("Detail dan Total Harga");
        setSize(400, 250);
        setLayout(new GridLayout(5, 1));
        
        JLabel detailLabel = new JLabel("Nama: " + nama + "\nNomor Telepon: " + telepon + "\nKendaraan: " + kendaraan.getNama() + "\nHarga per Hari: Rp" + kendaraan.getHargaPerHari() + "\nTotal Harga: Rp" + totalHarga);
        add(detailLabel);
        
        JButton selesaiButton = new JButton("Selesai");
        selesaiButton.addActionListener(e -> System.exit(0));
        add(selesaiButton);
        
        setVisible(true);
    }
}
