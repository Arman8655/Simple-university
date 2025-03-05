package uni;

import java.util.ArrayList;

public class Person {
    public int id;
    public static ArrayList<Person> personlist = new ArrayList<>();
    public String name;
    public String nationalID;
    public static int numberOfID = 0;


    public Person(String name, String nationalID) {

        this.name = name;
        this.nationalID = nationalID;
        personlist.add(this);
        this.id = numberOfID + 1;

    }

    public static Person findByID(int id) {
        for (Person person : personlist) {
            if (id == person.id) {
                return person;
            }
        }


            return null;
        
    }

    }


