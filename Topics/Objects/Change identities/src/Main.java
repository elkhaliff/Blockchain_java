
class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        Person person = new Person();
        person.name = p1.name;
        person.age = p1.age;
        p1.name = p2.name;
        p1.age = p2.age;
        p2.name = person.name;
        p2.age = person.age;
    }
}