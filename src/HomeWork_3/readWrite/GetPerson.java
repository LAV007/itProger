package HomeWork_3.readWrite;

import HomeWork_3.setPerson.Person;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class GetPerson {
    public static void getPerson() {
        try {
            FileInputStream fis = new FileInputStream("person.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Person readObject = (Person) ois.readObject();

            System.out.println(readObject);

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
