package projectPack;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Relation relation = new Relation();
        person.personAdder();// biz eklendik id=0
        person.personAdder();//es kisi eklendi id=1

        person.personAdder();//babam kisi eklendi id=2
        person.personAdder();//annem kisi eklendi id=3

        person.personAdder();//cocuk kisi eklendi id=4

        person.personAdder();//yenge kisi eklendi id=5
        person.personAdder();//kardes/amca kisi eklendi id=6
        person.personAdder();//kuzen kisi eklendi id=7

        relation.relationAdder(person.persons.get(0),person.persons.get(1));//biz esim
        relation.relationAdder(person.persons.get(2),person.persons.get(3));//anne baba rel

        relation.relationAdder(person.persons.get(6),person.persons.get(5));//yenge kardes rel

        person.childrenAdder(relation,0,4);//cocuk bizim
        person.childrenAdder(relation,1,0);//biz anne-baba eklend
        person.childrenAdder(relation,1,6);//amca eklend
        person.childrenAdder(relation,2,7);//kuzen amca yenge eklend

        relation.relationAdder(person.persons.get(2),person.persons.get(6)); // babamizla kardesi amcamizin relationi

        person.brotherAdder(relation,3,2);//su 2 spouse2 yani amcamiz (babamizin kardesi)


        person.kuzen(relation,2,2,7);






    }
}
