package HomeWork_3.readWrite;

import HomeWork_3.setPerson.Person;

import java.io.*;

public class GetPerson {
    public static void getPerson() {
        try {
            FileInputStream fis = new FileInputStream("person.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person readObj = (Person) ois.readObject();

            System.out.println(readObj);

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
