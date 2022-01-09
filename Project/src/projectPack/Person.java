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
    ArrayList<Person> brother;

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

    public void brotherAdder(Relation relation, int relationID, int personID,int secondID){//TODO BURADA SIKINTI VAR!!!!!!!
        try {
            relation.brother.add(relation.relations.get(relationID).children.get(personID));//TODO BURADA SIKINTI VAR!!!!!!!
            relation.brother.add(relation.relations.get(relationID).children.get(secondID));
            System.out.println("Kardeş: "+relation.brother.get(personID).name);
        }catch (NullPointerException e){
            e.getMessage();
        }
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
        try {
        if (persons.get(personID).parents.spouse1.gender){
            System.out.println("Kayınpeder: "+persons.get(personID).parents.spouse1.name);
            System.out.println("Kayınvalide: "+persons.get(personID).parents.spouse2.name);
        }else if (persons.get(personID).parents.spouse2.gender){
            System.out.println("Kayınpeder: "+persons.get(personID).parents.spouse2.name);
            System.out.println("Kayınvalide: "+persons.get(personID).parents.spouse1.name);
        }
        }catch (NullPointerException e){
            e.getMessage();
        }
    }

    public void amcaHala(Relation relation, int relationID, int personID, int childrenID){
        try {
            if (relation.relations.get(relationID).children.get(childrenID).gender){
                System.out.println("Amca: "+relation.relations.get(relationID).children.get(childrenID).name);
            }else {
                System.out.println("Hala: "+relation.relations.get(relationID).children.get(childrenID).name);
            }
        }catch (NullPointerException e){
            e.getMessage();
        }
    }

    public void dayiTeyze(Relation relation, int relationID, int personID, int childrenID){
        try {
            if (relation.relations.get(relationID).children.get(childrenID).gender){
                System.out.println("Dayı: "+relation.relations.get(relationID).children.get(childrenID).name);
            }else {
                System.out.println("Teyze: "+relation.relations.get(relationID).children.get(childrenID).name);
            }
        }catch (NullPointerException e){
            e.getMessage();
        }
    }

    public void es(Relation relation, int relationID){
        try {
            if (relation.relations.get(relationID).spouse1.gender)
            System.out.println("Es/ Kocam: "+relation.relations.get(relationID).spouse2.name);
            else {
                System.out.println("Es/ Karıcığım: "+relation.relations.get(relationID).spouse1.name);
            }
        }catch (NullPointerException e){
            e.getMessage();
        }
    }


    public void grandParents(){
        try {

        if (parents.spouse1.parents.spouse1.gender) System.out.println("Dede adı: "+parents.spouse1.parents.spouse1.name+"\nBabaanne adı: "+parents.spouse1.parents.spouse2.name);
        else System.out.println("Dede adı: "+parents.spouse1.parents.spouse2.name+"\nBabaanne adı: "+parents.spouse1.parents.spouse1.name);
        if (parents.spouse2.parents.spouse1.gender) System.out.println("Dede adı: "+parents.spouse2.parents.spouse1.name+"\nAnneanne adı: "+parents.spouse2.parents.spouse2.name);
        else System.out.println("Dede adı: "+parents.spouse2.parents.spouse2.name+"\nAnneanne adı: "+parents.spouse2.parents.spouse1.name);
        }catch (NullPointerException e){
            e.getMessage();
        }
    }

    public void kuzen(Relation relation, int relationID,int personId, int childrenID){
        try {
            if (!persons.get(personId).brother.isEmpty() && !relation.relations.get(relationID).children.isEmpty()){
                System.out.println("Kuzen: "+relation.relations.get(relationID).children.get(childrenID).name);
            }else
            {
                System.out.println("Kuzen yok!");
            }

        }catch (NullPointerException e){
            e.getMessage();
        }
    }

    public void torun(Relation relation, int relationID, int personID){
        try {
            System.out.println("Torun: "+relation.relations.get(relationID).children.get(personID).name);//havada kalmis gibi
        }catch (NullPointerException e){
            e.getMessage();
        }
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


