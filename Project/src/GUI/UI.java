package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI implements ActionListener {
    JFrame frame;
    JPanel firstPanel;
    JPanel secondPanel;
    JPanel thirdPanel;
    JButton buttonEkle;
    JButton buttonTemizle;
    JButton buttonOlustur;
    JLabel labelAd;
    JLabel labelSoyAd;
    JLabel labelDogumTarihi;
    JLabel labelCinsiyet;
    JLabel labelAkraba;
    JTextField textFieldAd;
    JTextField textFieldSoyad;
    JTextField textFieldDogumTarihi;
    JComboBox comboBoxCinsiyet;
    String[] cinsiyet = {"Kadın","Erkek"};
    JComboBox comboBoxAkraba;
    String[] akraba = {"Anne","Baba","Kardeş","Amca","Teyze","Dayı","Hala","Eş"};
    Border border = BorderFactory.createLineBorder(Color.black);
    UI(){
        firstPanel = new JPanel();
        firstPanel.setBorder(border);
        firstPanel.setBounds(0, 0, 1100, 800);
        firstPanel.setLayout(null);

        secondPanel = new JPanel();
        secondPanel.setBorder(border);
        secondPanel.setBounds(1100, 0, 430, 400);
        secondPanel.setLayout(null);

        thirdPanel = new JPanel();
        thirdPanel.setBorder(border);
        thirdPanel.setBounds(1100, 400, 430, 400);
        thirdPanel.setLayout(null);

        labelAd = new JLabel();
        labelAd.setText("Ad: ");
        labelSoyAd = new JLabel();
        labelSoyAd.setText("Soyad: ");
        labelDogumTarihi = new JLabel();
        labelDogumTarihi.setText("Doğum Tarihi: ");
        labelCinsiyet = new JLabel();
        labelCinsiyet.setText("Cinsiyet: ");

        textFieldAd = new JTextField();
        textFieldAd.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldAd.getMinimumSize().height));

        textFieldSoyad = new JTextField();
        textFieldSoyad.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldSoyad.getMinimumSize().height));

        textFieldDogumTarihi = new JTextField();
        textFieldDogumTarihi.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldDogumTarihi.getMinimumSize().height));

        comboBoxCinsiyet = new JComboBox(cinsiyet);
        comboBoxCinsiyet.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldDogumTarihi.getMinimumSize().height));
        comboBoxCinsiyet.addActionListener(this);

        buttonEkle = new JButton("Ekle");
        buttonEkle.setBounds(secondPanel.getX() + 50,secondPanel.getY() + 50,30,10);
        buttonEkle.addActionListener(this);

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        frame.add(firstPanel);
        frame.add(secondPanel);
        frame.add(thirdPanel);
    }
    public static void main(String[] args) {
        UI ui = new UI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
