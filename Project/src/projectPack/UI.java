package projectPack;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UI extends Person implements ActionListener {
    JFrame frame;
    JPanel firstPanel;
    JPanel secondPanel;
    JPanel thirdPanel;
    JPanel labelsPanel;//
    JPanel textfieldsPanel;
    JPanel firstControlPanel;
    JPanel secondControlPanel;
    JButton buttonEkle;
    JButton buttonTemizle;
    JButton save;
    JLabel labelAd;
    JLabel labelSoyAd;
    JLabel labelDogumTarihi;
    JLabel labelCinsiyet;
    JLabel labelAkraba;
    JLabel labelHelp;
    JTextField textFieldAd;
    JTextField textFieldSoyad;
    JTextField textFieldDogumTarihi;
    JComboBox comboBoxCinsiyet;
    String[] cinsiyet = { "Kadın", "Erkek" };
    JComboBox comboBoxAkraba;
    String[] akraba = { "Ben", "Anne", "Baba", "Kardeş", "Eş", "Çocuk", "Anneanne", "Dede (anne tarafı)", "Babaanne", "Dede (baba tarafı)", "Kayınvalide", "Kayınpeder", "Teyze","Dayı","Hala","Amca" };
    URI uri;
    JTree jTree;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode grandParents;
    DefaultMutableTreeNode grandParents2;
    DefaultMutableTreeNode parents1;
    DefaultMutableTreeNode parents2;
    DefaultMutableTreeNode spouse;
    DefaultMutableTreeNode children;
    DefaultMutableTreeNode broSis;
    DefaultMutableTreeNode anneKardesleri;
    DefaultMutableTreeNode babaKardesleri;

    public UI() throws URISyntaxException {
        firstPanel = new JPanel();
        firstPanel.setBounds(0, 0, 1100, 800);
        firstPanel.setLayout(null);

        secondPanel = new JPanel();
        secondPanel.setBounds(1100, 0, 430, 400);
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.LINE_AXIS));

        secondControlPanel = new JPanel();
        secondControlPanel.setLayout(new GridLayout());

        thirdPanel = new JPanel();
        thirdPanel.setBounds(1100, 400, 430, 400);
        thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.PAGE_AXIS));

        firstControlPanel = new JPanel();

        labelsPanel = new JPanel();
        labelsPanel.setLayout(new BoxLayout(labelsPanel, BoxLayout.PAGE_AXIS));

        textfieldsPanel = new JPanel();
        textfieldsPanel.setLayout(new BoxLayout(textfieldsPanel, BoxLayout.PAGE_AXIS));

        labelAd = new JLabel();
        labelAd.setText("Ad: ");

        labelSoyAd = new JLabel();
        labelSoyAd.setText("Soyad: ");

        labelDogumTarihi = new JLabel();
        labelDogumTarihi.setText("Doğum Tarihi (dd/MM/yyyy): ");

        labelCinsiyet = new JLabel();
        labelCinsiyet.setText("Cinsiyet: ");

        try {
            uri = new URI("https://cntrktzr.github.io/website.github.io/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        labelHelp = new JLabel();
        labelHelp.setText("Yardım: " + uri);
        labelHelp.setBounds(10, 720, 310, 30);

        textFieldAd = new JTextField();
        textFieldAd.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldAd.getMinimumSize().height));

        textFieldSoyad = new JTextField();
        textFieldSoyad.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldSoyad.getMinimumSize().height));

        textFieldDogumTarihi = new JTextField();
        textFieldDogumTarihi
                .setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldDogumTarihi.getMinimumSize().height));

        comboBoxCinsiyet = new JComboBox(cinsiyet);
        comboBoxCinsiyet.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldDogumTarihi.getMinimumSize().height));
        comboBoxCinsiyet.addActionListener(this);

        labelAkraba = new JLabel("Akraba Ekle");

        comboBoxAkraba = new JComboBox(akraba);
        comboBoxAkraba.setMaximumSize(new Dimension(Integer.MAX_VALUE, textFieldDogumTarihi.getMinimumSize().height));
        comboBoxAkraba.addActionListener(this);

        buttonEkle = new JButton("Ekle");
        buttonEkle.setBounds(secondPanel.getX() + 50, secondPanel.getY() + 70, 30, 10);
        buttonEkle.addActionListener(this);

        buttonTemizle = new JButton("Temizle");
        buttonTemizle.setBounds(930, 690, 80, 30);
        buttonTemizle.addActionListener(this);


        save = new JButton("Kaydet (.png)");
        save.setBounds(800, 690, 120, 30);
        save.addActionListener(this);

        grandParents = new DefaultMutableTreeNode("Büyükanne - Büyükbaba");
        children = new DefaultMutableTreeNode("Çocuklar");
        broSis = new DefaultMutableTreeNode("Kardeşler");

        anneKardesleri = new DefaultMutableTreeNode("Kardeşleri");
        babaKardesleri = new DefaultMutableTreeNode("Kardeşleri");


        frame = new JFrame("BloodLines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        frame.setVisible(true);

        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 50))); // margin
        textfieldsPanel.add(textFieldAd);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        textfieldsPanel.add(textFieldSoyad);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        textfieldsPanel.add(textFieldDogumTarihi);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        textfieldsPanel.add(comboBoxCinsiyet);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        labelsPanel.add(Box.createRigidArea(new Dimension(0, 50))); // margin
        labelsPanel.add(labelAd);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 18)));
        labelsPanel.add(labelSoyAd);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 18)));
        labelsPanel.add(labelDogumTarihi);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 18)));
        labelsPanel.add(labelCinsiyet);
        labelsPanel.add(Box.createRigidArea(new Dimension(0, 18)));

        firstPanel.add(buttonTemizle);
        firstPanel.add(save);
        firstPanel.add(labelHelp);
        firstControlPanel.setBounds(50, 50, 1000, 600);


        secondControlPanel.add(labelsPanel);
        secondControlPanel.add(textfieldsPanel);
        secondPanel.add(secondControlPanel);
        secondPanel.add(buttonEkle);

        thirdPanel.add(labelAkraba);
        thirdPanel.add(comboBoxAkraba);

        frame.add(firstPanel);
        frame.add(secondPanel);
        frame.add(thirdPanel);

    }

    public static void main(String[] args) throws URISyntaxException {
        UI ui = new UI();

    }

    int personCounter = 0;
    int relationID = 0;
    String tempName;
    String tempSurname;
    String tempDogum;
    Date tempDateDogum;
    Boolean tempGender;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 0)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            root = new DefaultMutableTreeNode(tempName + " " + tempSurname);
            jTree = new JTree(root);
            jTree.setBounds(50, 50, 1000, 600);
            firstControlPanel.add(jTree);
            firstPanel.add(firstControlPanel);
            Relation tempRelation = new Relation();
            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            viewPersonInfo();
            personCounter++;
            tempRelation.id = personCounter;
        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 1)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            parents1 = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Anne)");
            root.add(parents1);
            Relation tempRelation = new Relation();
            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,false);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            motherFather(tempRelation,persons.get(0).id,tempRelation.spouse2);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.id));

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 2)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }

            parents2 = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Baba)");
            root.add(parents2);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,true);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            motherFather(tempRelation,persons.get(0).id,tempRelation.spouse2);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.id));

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 3)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            broSis = new DefaultMutableTreeNode(tempName + " " + tempSurname + " (Kardeş)");
            root.add(broSis);

            Relation tempRelation = new Relation();
            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            brotherAdder(tempRelation,tempRelation.relCounter,personCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).partner);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 4)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            spouse = new DefaultMutableTreeNode(tempName + " " + tempSurname + " (Eş)");
            root.add(spouse);

            Relation tempRelation = new Relation();

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            es(tempRelation,tempRelation.relCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).partner);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 5)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(spouse == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce eşinizi ekleyiniz!");
            }
            children = new DefaultMutableTreeNode(tempName + " " + tempSurname + " (Çocuk)");
            root.add(children);
            Relation tempRelation = new Relation();
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            childrenAdder(tempRelation,tempRelation.relCounter,personCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).children);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;
        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 6)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents1 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce annenizi ekleyiniz!");
            }

            grandParents = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Anneanne)");
            parents1.add(grandParents);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));

            grandParents();
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 7)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents1 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce annenizi ekleyiniz!");
            }
            grandParents = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Dede)");
            parents1.add(grandParents);

            Relation tempRelation = new Relation();
            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            //tempRelation.relCounter++;
            tempRelation.relCounter++;
            tempRelation.relationAdder(persons.get(personCounter-1),persons.get(personCounter)); // nine dede arası relation

            grandParents();
            viewPersonInfo();

            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;


        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 8)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents2 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce babanızı ekleyiniz!");
            }
            grandParents = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Babaanne)");
            parents2.add(grandParents);

            Relation tempRelation = new Relation();

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            tempRelation.relCounter++;
            tempRelation.relationAdder(persons.get(personCounter-1),persons.get(personCounter));

            grandParents();
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 9)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents2 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce babanızı ekleyiniz!");
            }
            grandParents = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Dede)");
            parents2.add(grandParents);

            Relation tempRelation = new Relation();

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            tempRelation.relCounter++;
            tempRelation.relationAdder(persons.get(personCounter-1),persons.get(personCounter)); // nine dede arası relation

            grandParents();
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 10)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }

            if(spouse == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce eşinizi ekleyiniz!");
            }

            grandParents2 = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Kayınvalide)");
            spouse.add(grandParents2);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));

            kayinPederValide(tempRelation, tempRelation.relCounter,personCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);


            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 11)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(spouse == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce eşinizi ekleyiniz!");
            }

            grandParents2 = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Kayınpeder)");
            spouse.add(grandParents2);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));

            kayinPederValide(tempRelation, tempRelation.relCounter,personCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 12)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents1 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce annenizi ekleyiniz!");
            }

            anneKardesleri = new DefaultMutableTreeNode("Kardeşi");
            parents1.add(anneKardesleri);

            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Teyze)");
            anneKardesleri.add(tempNode);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            dayiTeyze(tempRelation, tempRelation.relCounter,tempRelation.children.get(personCounter).id);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");
        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 13)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();

            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents1 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce annenizi ekleyiniz!");
            }

            anneKardesleri = new DefaultMutableTreeNode("Kardeşi");
            parents1.add(anneKardesleri);

            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Dayı)");
            anneKardesleri.add(tempNode);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));

            kayinPederValide(tempRelation, tempRelation.relCounter,personCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);


            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }
        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 14)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();

            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents2 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce babanızı ekleyiniz!");
            }

            babaKardesleri = new DefaultMutableTreeNode("Kardeşi");
            parents2.add(babaKardesleri);

            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Hala)");
            babaKardesleri.add(tempNode);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));

            amcaHala(tempRelation, tempRelation.relCounter,tempRelation.children.get(personCounter).id);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);


            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }
        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 15)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            try {
                tempDateDogum = stringToDate(tempDogum);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 0){
                tempGender = false;
            }
            if(comboBoxCinsiyet.getSelectedIndex() == 1){
                tempGender = true;
            }
            Relation tempRelation = new Relation();
            if(root == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce kendinizi ekleyiniz!");
            }
            if(parents2 == null){
                JOptionPane.showMessageDialog(null, "Lütfen ilk önce babanızı ekleyiniz!");
            }

            babaKardesleri = new DefaultMutableTreeNode("Kardeşi");
            parents2.add(babaKardesleri);

            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(tempName + " " + tempSurname +" (Amca)");
            babaKardesleri.add(tempNode);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));

            amcaHala(tempRelation, tempRelation.relCounter,tempRelation.children.get(personCounter).id);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);


            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

        }

        if (e.getSource() == comboBoxCinsiyet) {

        }

        if (e.getSource() == buttonTemizle) {
            firstControlPanel.removeAll();
            SwingUtilities.updateComponentTreeUI(firstControlPanel);
        }

        if(e.getSource() == save){
            try {
                captureScreen("BloodLines.png", firstControlPanel);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static Date stringToDate(String sDate1) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        return date1;
    }

    public void viewPersonInfo(){
        System.out.println("Adı: "+tempName);
        System.out.println("Soyadı: "+tempSurname);
        System.out.println("Doğum Tarihi: "+tempDogum);
        System.out.println("Cinsiyeti: "+tempGender);
        grandParents();

        System.out.println();
    }

    public static void captureScreen(String fileName, JPanel panel) throws Exception {
        Dimension screenSize = panel.getSize();
        Rectangle screenRectangle = new Rectangle(screenSize);
        Robot robot = new Robot();
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        ImageIO.write(image, "png", new File(fileName));
    }

}

class Person {
    int personCounter = 0;
    int id;
    Relation parents;
    String name;
    String surname;
    Date birthday;
    Boolean gender;

    ArrayList<Person> persons = new ArrayList<Person>();

    public Person() {
        name = "bos";
        surname = "bos";
        birthday = new Date(0, 0, 0, 0, 0, 0);
        gender = null;
    }

    public void personAdder(Relation relation,String name, String surname, Date birthday, Boolean gender) {
        persons.add(new Person(relation,name,surname,birthday,gender));
    }

    public void childrenAdder(Relation relation, int relationID, int personID) {
        relation.relations.get(relationID).children.add(persons.get(personID));
        persons.get(personID).parents = relation.relations.get(relationID);
    }

    public void brotherAdder(Relation relation, int relationID, int relationdakiSpouseID) {//spouse idye bastiriyo bunu bir daha islememiz gerekebilir.
        try {
            relation.brother.add(relation.relations.get(relationID).spouse1);
            relation.brother.add(relation.relations.get(relationID).spouse2);
            if (relation.relations.get(relationID).spouse1.birthday.after(relation.relations.get(relationID).spouse2.birthday)) {
                if (relation.relations.get(relationID).spouse2.gender) {
                    System.out.println("Abi adı: " + relation.brother.get(relationdakiSpouseID).name);
                } else {
                    System.out.println("Abla adı: " + relation.brother.get(relationdakiSpouseID).name);
                }
            } else {
                System.out.println("Kardeş adı: " + relation.brother.get(relationdakiSpouseID).name);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void motherFather(Relation relation,int childRel,Person person) {

        try {
            if (person.gender) {
                Relation tempR = new Relation();
                tempR.relationAdder(person, person.parents.spouse2);
                relation.relations.get(childRel).mother.add(tempR.spouse2);
                relation.relations.get(childRel).father.add(tempR.spouse1);
                parents.father = tempR.relations.get(childRel).father;
                parents.mother = tempR.relations.get(childRel).mother;
                System.out.println("Baba adi: " + relation.relations.get(childRel).father.get(tempR.id).name+ "\nAnne adı: " +relation.relations.get(childRel).mother.get(tempR.id).name);
            } else {
                Relation tempR = new Relation();
                tempR.relationAdder(person.parents.spouse1, person);
                relation.relations.get(childRel).mother.add(tempR.spouse1);
                relation.relations.get(childRel).father.add(tempR.spouse2);
                parents.father = tempR.relations.get(childRel).father;
                parents.mother = tempR.relations.get(childRel).mother;
                System.out.println("Baba adi: " + relation.relations.get(childRel).father.get(tempR.id).name+ "\nAnne adı: " +relation.relations.get(childRel).mother.get(tempR.id).name);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void kayinPederValide(Relation relation, int relationID, int personID) {
        try {
            if (persons.get(personID).parents.spouse1.gender) {
                System.out.println("Kayınpeder: " + persons.get(personID).parents.spouse1.name);
                System.out.println("Kayınvalide: " + persons.get(personID).parents.spouse2.name);
            } else if (persons.get(personID).parents.spouse2.gender) {
                System.out.println("Kayınpeder: " + persons.get(personID).parents.spouse2.name);
                System.out.println("Kayınvalide: " + persons.get(personID).parents.spouse1.name);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void amcaHala(Relation relation, int relationID, int childrenID) {
        try {
            if (relation.relations.get(relationID).children.get(childrenID).gender) {
                System.out.println("Amca: " + relation.relations.get(relationID).children.get(childrenID).name);
            } else {
                System.out.println("Hala: " + relation.relations.get(relationID).children.get(childrenID).name);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void dayiTeyze(Relation relation, int relationID, int childrenID) {
        try {
            if (relation.relations.get(relationID).children.get(childrenID).gender) {
                System.out.println("Dayı: " + relation.relations.get(relationID).children.get(childrenID).name);
            } else {
                System.out.println("Teyze: " + relation.relations.get(relationID).children.get(childrenID).name);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void es(Relation relation, int relationID) {
        try {
            if (relation.relations.get(relationID).spouse1.gender)
                System.out.println("Es/ Kocam: " + relation.relations.get(relationID).spouse2.name);
            else {
                System.out.println("Es/ Karıcığım: " + relation.relations.get(relationID).spouse1.name);
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void grandParents() {
        try {

            if (parents.spouse1.parents.spouse1.gender)
                System.out.println("Dede adı: " + parents.spouse1.parents.spouse1.name + "\nBabaanne adı: " + parents.spouse1.parents.spouse2.name);
            else
                System.out.println("Dede adı: " + parents.spouse1.parents.spouse2.name + "\nBabaanne adı: " + parents.spouse1.parents.spouse1.name);
            if (parents.spouse2.parents.spouse1.gender)
                System.out.println("Dede adı: " + parents.spouse2.parents.spouse1.name + "\nAnneanne adı: " + parents.spouse2.parents.spouse2.name);
            else
                System.out.println("Dede adı: " + parents.spouse2.parents.spouse2.name + "\nAnneanne adı: " + parents.spouse2.parents.spouse1.name);
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void kuzen(Relation relation, int relationID, int personId, int cousinID) {
        try {

            if (persons.get(personId).id == relation.relations.get(relationID).children.get(cousinID).id) {
                System.out.println("Kuzen: " + persons.get(personId).name);
            } else {
                System.out.println("Kuzen yok");
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }
    public void torun(Relation relation, int dederelationID, int babarelationID, int childrenID, int torunID){
        try {
            if (relation.relations.get(dederelationID).children.get(childrenID).id == relation.relations.get(babarelationID).spouse1.id){
                if (!relation.relations.get(babarelationID).children.isEmpty()){
                    System.out.println("Torun: "+relation.relations.get(babarelationID).children.get(torunID).name);
                }
                else {
                    System.out.println("Torun yok!");
                }
            }
            else if (relation.relations.get(dederelationID).children.get(childrenID).id == relation.relations.get(babarelationID).spouse2.id){
                if (!relation.relations.get(babarelationID).children.isEmpty()){
                    System.out.println("Torun: "+relation.relations.get(babarelationID).children.get(torunID).name);
                }
                else {
                    System.out.println("Torun yok!");
                }
            }
        }catch (NullPointerException e){
            e.getMessage();
        }
    }


    public Person(Relation parents, String name, String surname, Date birthday, Boolean gender){
        this.parents = parents;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        id = personCounter;
        personCounter++;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Relation getParents() {
        return parents;
    }

    public void setParents(Relation parents) {
        this.parents = parents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}

