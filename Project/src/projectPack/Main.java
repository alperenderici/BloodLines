package projectPack;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Relation relation = new Relation();

        System.out.println("Kişi ekleme hoş geldiniz.");
        person.personAdder();//ilk kisi eklendi

        person.personAdder();//es kisi eklendi id=1

        person.personAdder();//babam kisi eklendi id=2
        person.personAdder();//annem kisi eklendi id=3

        person.personAdder();//cocuk kisi eklendi id=4

        person.personAdder();//yenge kisi eklendi id=5
        person.personAdder();//kardes kisi eklendi id=6
        person.personAdder();//kuzen kisi eklendi id=7

        relation.relationAdder(person.persons.get(0),person.persons.get(1));//biz esim
        relation.relationAdder(person.persons.get(2),person.persons.get(3));//anne baba rel

        relation.relationAdder(person.persons.get(6),person.persons.get(5));//yenge kardes rel

        person.childrenAdder(relation,0,4);//cocuk bizim
        person.childrenAdder(relation,1,0);//biz anne-baba eklend
        person.childrenAdder(relation,1,6);//amca eklend
        person.childrenAdder(relation,2,7);//kuzen amca yenge eklend

        person.brotherAdder(relation,1,0,6);


        person.kuzen(relation,2,2,7);





    }
}
