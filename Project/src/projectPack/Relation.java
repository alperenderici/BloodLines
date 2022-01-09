package projectPack;

import java.util.ArrayList;

public class Relation {
    Person spouse1;
    Person spouse2;
    static int relCounter = 1;
    int id;

    ArrayList<Relation> relations = new ArrayList<Relation>();
    ArrayList<Person> children = new ArrayList<Person>();
    ArrayList<Person> father = new ArrayList<Person>();
    ArrayList<Person> mother = new ArrayList<Person>();
    ArrayList<Person> partner = new ArrayList<Person>();
    ArrayList<Person> brother = new ArrayList<Person>();

    public Relation(){

    }

    public void relationAdder(Person person1, Person person2){
        relations.add(new Relation(person1,person2));
    }


    public Relation(Person spouse1, Person spouse2) {
        this.spouse1 = spouse1;
        this.spouse2 = spouse2;
        id = relCounter;
        relCounter++;
    }
}
