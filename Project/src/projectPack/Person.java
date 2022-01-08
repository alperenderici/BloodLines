package projectPack;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    static int personCounter = 0;
    int id;
    Relation parents;
    String name;
    String surname;
    String birthday;
    Boolean gender;

    ArrayList<Person> persons = new ArrayList<Person>();

    Scanner scanner = new Scanner(System.in);

    public Person(){
        name = "bos";
        surname = "bos";
        birthday = "bos";
        gender = null;
    }

    public void personAdder(){
        //TODO agacta ekleme yapilacak kisi bulunamamakta kontrolu (ilk kisi icin)
        System.out.println("Kisi bilgilerini giriniz");
        Relation tempRelation = new Relation();
        System.out.println("Ad: ");
        String tempName = scanner.nextLine();
        System.out.println("Soyad: ");
        String tempSurname = scanner.nextLine();
        System.out.println("Doğum tarihi: ");
        String tempBirthday = scanner.nextLine();
        System.out.println("Cinsiyet(E/K): ");
        String inputForGender = scanner.nextLine();
        Boolean tempGender;
        if (inputForGender.equals("E")||inputForGender.equals("e")){
            tempGender = true;
        }
        else if (inputForGender.equals("K")||inputForGender.equals("k")){
            tempGender = false;
        }else {
            tempGender = null;
        }

        persons.add(new Person(tempRelation,tempName,tempSurname,tempBirthday,tempGender));
    }

    public Person(projectPack.Relation parents, String name, String surname, String birthday, Boolean gender){
        this.parents = parents;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.gender = gender;
        id = personCounter;
        personCounter++;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }


}
