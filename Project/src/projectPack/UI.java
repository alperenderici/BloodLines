package projectPack;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UI extends Person implements ActionListener {
    JFrame frame;
    JPanel firstPanel;
    JPanel secondPanel;
    JPanel thirdPanel;
    JPanel labelsPanel;//
    JPanel textfieldsPanel;
    JPanel firstControlPanel;
    JPanel secondControlPanel;
    Border border = BorderFactory.createLineBorder(Color.black);
    Border margin = new EmptyBorder(10, 10, 10, 10);//
    JButton buttonEkle;
    JButton buttonTemizle;
    JButton save;
    JLabel labelAd;
    JLabel labelSoyAd;
    JLabel labelDogumTarihi;
    JLabel labelCinsiyet;
    JLabel labelAkraba;
    public JTextField textFieldAd;
    public JTextField textFieldSoyad;
    public JTextField textFieldDogumTarihi;
    public JComboBox comboBoxCinsiyet;
    String[] cinsiyet = { "Kadın", "Erkek" };
    JComboBox comboBoxAkraba;
    String[] akraba = { "Ben", "Anne", "Baba", "Kardeş", "Eş", "Çocuk", "Büyükanne", "Büyükbaba", "Kuzen" };

    JTree jTree;
    DefaultMutableTreeNode root;
    DefaultMutableTreeNode grandParents;
    DefaultMutableTreeNode parents;
    DefaultMutableTreeNode spouse;
    DefaultMutableTreeNode children;
    DefaultMutableTreeNode broSis;

//    Person person = new Person();
//    Relation relation = new Relation();


    public UI() {
        firstPanel = new JPanel();
        firstPanel.setBorder(border);
        firstPanel.setBounds(0, 0, 1100, 800);
        firstPanel.setLayout(null);

        secondPanel = new JPanel();
        secondPanel.setBorder(border);
        secondPanel.setBounds(1100, 0, 430, 400);
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.LINE_AXIS));
        // secondPanel.setLayout(new GridLayout());

        secondControlPanel = new JPanel();
        secondControlPanel.setLayout(new GridLayout());

        thirdPanel = new JPanel();
        thirdPanel.setBorder(border);
        thirdPanel.setBounds(1100, 400, 430, 400);
        thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.PAGE_AXIS));

        firstControlPanel = new JPanel();
        firstControlPanel.setBounds(20, 20, 1100, 800);
        firstControlPanel.setLayout(new BoxLayout(firstControlPanel, BoxLayout.PAGE_AXIS));

        labelsPanel = new JPanel();
        // labelsPanel.setBounds(0,50,30,200);
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
        buttonEkle.setBounds(secondPanel.getX() + 50, secondPanel.getY() + 50, 30, 10);
        buttonEkle.addActionListener(this);

        buttonTemizle = new JButton("Temizle");
        buttonTemizle.setBounds(930, 690, 80, 30);
        buttonTemizle.addActionListener(this);

        save = new JButton("Save (.png)");
        save.setBounds(800, 690, 120, 30);
        save.addActionListener(this);

        root = new DefaultMutableTreeNode("Root");
        jTree = new JTree(root);
        jTree.setBounds(50, 50, 1000, 600);

        parents = new DefaultMutableTreeNode("Anne - Baba");
        grandParents = new DefaultMutableTreeNode("Büyükanne - Büyükbaba");
        spouse = new DefaultMutableTreeNode("Eş");
        children = new DefaultMutableTreeNode("Çocuklar");
        broSis = new DefaultMutableTreeNode("Kardeşler");

        root.add(parents);
        parents.add(grandParents);
        root.add(spouse);
        root.add(broSis);
        root.add(children);

        frame = new JFrame("BloodLines");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15))); // margin
        textfieldsPanel.add(textFieldAd);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        textfieldsPanel.add(textFieldSoyad);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        textfieldsPanel.add(textFieldDogumTarihi);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        textfieldsPanel.add(comboBoxCinsiyet);
        textfieldsPanel.add(Box.createRigidArea(new Dimension(0, 15)));

        labelsPanel.add(Box.createRigidArea(new Dimension(0, 15))); // margin
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
        firstPanel.add(jTree);

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

    public static void main(String[] args) {
        UI ui = new UI();
    }

    int personCounter = 0;
    int relationID = 0;
//    int id;
    //Relation parents;

    //ArrayList<Person> persons = new ArrayList<Person>();
    String tempName;
    String tempSurname;
    String tempDogum;
    Date tempDateDogum;
    Boolean tempGender;
    //Person person;

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(e.getSource() == buttonEkle){
            personCounter++;
        }
        if(e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() != 0)){
            relationID++;
        }*/

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 0)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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


            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText());
            // root = new DefaultMutableTreeNode(tempNode);

            // Changing the text of the root value
            DefaultTreeModel model = (DefaultTreeModel) jTree.getModel();
            root = (DefaultMutableTreeNode) model.getRoot();
            root.setUserObject(textFieldAd.getText() + " " + textFieldSoyad.getText() + "(Kendisi)");
            model.nodeChanged(root);

            //person.persons.add(new Person(tempRelation,tempName,tempSurname,tempDateDogum,tempGender));



//            try
//            {
//                Thread.sleep(3000);
//            } catch (InterruptedException ie) {}

            //person.personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            //int counter =0;
            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            //System.out.println(persons.get(personCounter).name);
            viewPersonInfo();
            //counter++;

            personCounter++;
            //tempRelation.id++;
            tempRelation.id = personCounter;

            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");


        }


        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 1)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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

            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Annesi)");

            parents.add(tempNode);


            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,false);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            motherFather();
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).mother);

            personCounter++;
            //tempRelation.id++;
            tempRelation.relCounter++;

            tempRelation.id = personCounter;

            System.out.println(personCounter);
            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");



        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 2)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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

            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Babası)");
            parents.add(tempNode);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,true);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            motherFather();
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).father);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

            //System.out.println(personCounter);
            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");


        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 3)) { //DAHA YAPILMADI
            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Kardeşi)");
            broSis.add(tempNode);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            System.out.println(textFieldAd.getText());
            System.out.println(textFieldSoyad.getText());
            System.out.println(textFieldDogumTarihi.getText());
        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 4)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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
            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Eşi)");
            spouse.add(tempNode);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            es(tempRelation,tempRelation.relCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).partner);

            //personCounter++;
            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");

//            System.out.println(textFieldAd.getText());
//            System.out.println(textFieldSoyad.getText());
//            System.out.println(textFieldDogumTarihi.getText());
        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 5)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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
            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Çocuğu)");
            children.add(tempNode);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            childrenAdder(tempRelation,tempRelation.relCounter,personCounter);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).children);



//            System.out.println(textFieldAd.getText());
//            System.out.println(textFieldSoyad.getText());
//            System.out.println(textFieldDogumTarihi.getText());

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

            //System.out.println(personCounter);
            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");
        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 6)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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
            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Büyükanne)");
            grandParents.add(tempNode);

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

            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");


//            System.out.println(textFieldAd.getText());
//            System.out.println(textFieldSoyad.getText());
//            System.out.println(textFieldDogumTarihi.getText());
        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 7)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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
            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Büyükbaba)");
            grandParents.add(tempNode);

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            //tempRelation.relCounter++;
            tempRelation.relCounter++;
            tempRelation.relationAdder(persons.get(personCounter-1),persons.get(personCounter)); // nine dede arası relation


            grandParents();
            viewPersonInfo();
            //System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).spouse2);

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;



            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");



        }

        if (e.getSource() == buttonEkle && (comboBoxAkraba.getSelectedIndex() == 8)) {
            tempName = textFieldAd.getText();
            tempSurname = textFieldSoyad.getText();
            tempDogum = textFieldDogumTarihi.getText();
            //tempGender = comboBoxCinsiyet.getSelectedItem().toString();
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
            DefaultMutableTreeNode tempNode = new DefaultMutableTreeNode(
                    textFieldAd.getText() + " " + textFieldSoyad.getText() + " (Kuzen)");
            children.add(tempNode);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add

            personAdder(tempRelation,tempName,tempSurname,tempDateDogum,tempGender);
            SwingUtilities.updateComponentTreeUI(firstPanel); // reload the firstPanel after every person add
            tempRelation.relationAdder(persons.get(0),persons.get(personCounter));
            kuzen(tempRelation,tempRelation.relCounter,personCounter,tempRelation.relations.get(relationID).children.get(personCounter).id);
            viewPersonInfo();
            System.out.println(tempRelation.relations.get(tempRelation.relCounter));
            System.out.println(tempRelation.relations.get(tempRelation.relCounter).children);



//            System.out.println(textFieldAd.getText());
//            System.out.println(textFieldSoyad.getText());
//            System.out.println(textFieldDogumTarihi.getText());

            personCounter++;
            tempRelation.relCounter++;
            tempRelation.id = personCounter;

            //System.out.println(personCounter);
            System.out.println(tempRelation.id);
            System.out.println(tempRelation.relCounter);
            System.out.println("------------");
        }



        if (e.getSource() == comboBoxCinsiyet) {

        }

        if (e.getSource() == buttonTemizle) {
            firstControlPanel.removeAll();
            SwingUtilities.updateComponentTreeUI(firstControlPanel);
        }

        if(e.getSource() == save){
            try {
                captureScreen("blood.png", jTree);
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
        motherFather();
        grandParents();

        System.out.println();
    }

    public static void printScreen(JTree jtree) throws AWTException {
        BufferedImage bufImage = new BufferedImage(jtree.getSize().width, jtree.getSize().height,BufferedImage.TYPE_INT_RGB);
        jtree.paint(bufImage.createGraphics());
        File imageFile = new File("C:\\Users\\Gizem\\IdeaProjects\\untitled4\\out");
        try{
            imageFile.createNewFile();
            ImageIO.write(bufImage, "jpeg", imageFile);
        }catch(Exception ex){
        }
    }

    public static void captureScreen(String fileName, JTree jtree) throws Exception {
        Dimension screenSize = jtree.getSize();
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

    Scanner scanner = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);

    //projectPack.UI ui = new projectPack.UI();

    public Person() {
        name = "bos";
        surname = "bos";
        birthday = new Date(0, 0, 0, 0, 0, 0);
        gender = null;
    }

//    public Person(Relation tempRelation, String tempName, String tempSurname, Date date2, Boolean inputForGender) {
//    }



    public void personAdder(Relation relation,String name, String surname, Date birthday, Boolean gender){
        persons.add(new Person(relation,name,surname,birthday,gender));
        //viewPersonInfo();
    }

    public void childrenAdder(Relation relation, int relationID, int personID) {
        relation.relations.get(relationID).children.add(persons.get(personID));
        persons.get(personID).parents = relation.relations.get(relationID);
    }

//    public void brotherAdder(Relation relation, int relationID, int relationdakiSpouseID) {//spouse idye bastiriyo bunu bir daha islememiz gerekebilir.
//        try {
//            relation.brother.add(relation.relations.get(relationID).spouse1);
//            relation.brother.add(relation.relations.get(relationID).spouse2);
//            if (relation.relations.get(relationID).spouse1.birthday.after(relation.relations.get(relationID).spouse2.birthday)) {
//                if (relation.relations.get(relationID).spouse2.gender) {
//                    System.out.println("Abi adı: " + relation.brother.get(relationdakiSpouseID).name);
//                } else {
//                    System.out.println("Abla adı: " + relation.brother.get(relationdakiSpouseID).name);
//                }
//            } else {
//                System.out.println("Kardeş adı: " + relation.brother.get(relationdakiSpouseID).name);
//            }
//        } catch (NullPointerException e) {
//            e.getMessage();
//        }
//    }

    public void motherFather() {
        gender = true;
        try {
            if (gender) {
                parents.father.add(parents.spouse1);

                parents.mother.add(parents.spouse2);
                System.out.println("Baba adı: " + parents.spouse1.name + "\nAnne adı: " + parents.spouse2.name);
            } else if (!gender) { //parents.spouse2.gender
                parents.father.add(parents.spouse2);
                parents.mother.add(parents.spouse1);
                System.out.println("Baba adı: " + parents.spouse2.name + "\nAnne adı: " + parents.spouse1.name);
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

    public void amcaHala(Relation relation, int relationID, int personID, int childrenID) {
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

    public void dayiTeyze(Relation relation, int relationID, int personID, int childrenID) {
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

//    public void showPersons(Person person){
//        for (int i=0; i<persons.size();i++){
//            person.viewPersonInfo();
//        }
//    }

//    public void viewPersonInfo(){
//        System.out.println("Adı: "+name);
//        System.out.println("Soyadı: "+surname);
//        System.out.println("Doğum Tarihi: "+birthday);
//        System.out.println("Cinsiyeti: "+gender);
//        motherFather();
//        grandParents();
//
//        System.out.println();
//
//    }

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

