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

    public void childrenAdder(Relation relation, int relationID, int personID){
        relation.relations.get(relationID).children.add(persons.get(personID));
        persons.get(personID).parents = relation.relations.get(relationID);

    }
    public void motherFather(){
        try {

        if (parents.spouse1.gender){
            parents.father.add(parents.spouse1);
            parents.mother.add(parents.spouse2);
            System.out.println("Baba adı: " + parents.spouse1.name + "\nAnne adı: " + parents.spouse2.name);
        }else if (parents.spouse2.gender){
            parents.father.add(parents.spouse2);
            parents.mother.add(parents.spouse1);
            System.out.println("Baba adı: " + parents.spouse2.name + "\nAnne adı: " + parents.spouse1.name);
        }
        }catch (NullPointerException e){
            e.getMessage();
        }
    }

    public void kayinPederValide(Relation relation, int relationID, int personID){

        if (persons.get(personID).parents.spouse1.gender){
            System.out.println("Kayınpeder: "+persons.get(personID).parents.spouse1.name);
        }
    }



    public void grandParents(){
        if (parents.spouse1.parents.spouse1.gender) System.out.println("Dede adı: "+parents.spouse1.parents.spouse1.name+"\nBabaanne adı: "+parents.spouse1.parents.spouse2.name);
        else System.out.println("Dede adı: "+parents.spouse1.parents.spouse2.name+"\nBabaanne adı: "+parents.spouse1.parents.spouse1.name);
        if (parents.spouse2.parents.spouse1.gender) System.out.println("Dede adı: "+parents.spouse2.parents.spouse1.name+"\nAnneanne adı: "+parents.spouse2.parents.spouse2.name);
        else System.out.println("Dede adı: "+parents.spouse2.parents.spouse2.name+"\nAnneanne adı: "+parents.spouse2.parents.spouse1.name);
    }

    public void showPersons(Person person){
        for (int i=0; i<person.persons.size();i++){
            person.viewPersonInfo();
        }
    }

    public void viewPersonInfo(){
        System.out.println("Adı: "+name);
        System.out.println("Soyadı: "+surname);
        System.out.println("Doğum Tarihi: "+birthday);
        System.out.println("Cinsiyeti: "+gender);
        motherFather();
        grandParents();
        System.out.println();

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


