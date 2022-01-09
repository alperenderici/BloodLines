package projectPack;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Relation relation = new Relation();

        System.out.println("Kişi ekleme hoş geldiniz.");
        person.personAdder();//ilk kisi eklendi

        person.personAdder();//es
        person.personAdder();//baba
        person.personAdder();//annem

        person.personAdder();//cocuk

        relation.relationAdder(person.persons.get(0),person.persons.get(1));
        relation.relationAdder(person.persons.get(2),person.persons.get(3));

        person.childrenAdder(relation,0,4);//cocuk id
        person.childrenAdder(relation,1,0);//bizim baba cocuk

        person.persons.get(4).grandParents();
        person.torun(relation,0,0);
        person.persons.get(2).viewPersonInfo();//dedeinfo
        person.persons.get(4).viewPersonInfo();//cocuk info


    }
}
