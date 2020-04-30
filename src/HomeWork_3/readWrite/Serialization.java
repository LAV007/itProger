package HomeWork_3.readWrite;

import HomeWork_3.setPerson.Person;

import java.io.*;

public class Serialization {
    public static void doSerialization() {
        Person person = new Person();
        try {
            FileOutputStream fos = new FileOutputStream("person.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(person);

            oos.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
