//-----------------------------------------------------
// Title: Person class to keep each person's information.
// Author: Sencer Yücel
// Section: 02
// Assignment: 2
// Task: 1
//-----------------------------------------------------

public class Person implements Comparable {

    private String name, surname;
    private long id;

    Person(String name, String surname, long id){
        this.name = name;
        this.surname = surname;
        this.id = id;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }


    public String getName(){
        return name;
    }

    public String getSurname() {
        return surname;
    }
    public long getId(){
        return id;
    }
}
