package lakuis;

import javax.swing.*;
import java.awt.*;

class PilihKendaraanFrame extends JFrame {
    public PilihKendaraanFrame() {
        setTitle("Pilih Kendaraan");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JButton motorButton = new JButton("Motor");
        JButton mobilButton = new JButton("Mobil");
        
        motorButton.addActionListener(e -> new DetailPenyewaanFrame("Motor", this));
        mobilButton.addActionListener(e -> new DetailPenyewaanFrame("Mobil", this));
        
        add(motorButton);
        add(mobilButton);
        
        setVisible(true);
    }
}
