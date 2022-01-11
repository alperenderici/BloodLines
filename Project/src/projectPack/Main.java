package projectPack;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Relation relation = new Relation();
        person.personAdder();// biz eklendik id=0
        person.personAdder();//kardes kisi eklendi id=1


        relation.relationAdder(person.persons.get(0),person.persons.get(1));// kardes rela

        person.brotherAdder(relation,0,1);


    }
}
