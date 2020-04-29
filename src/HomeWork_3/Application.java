package HomeWork_3;

import HomeWork_3.readWrite.GetPerson;
import HomeWork_3.readWrite.Serialization;

public class Application {

    public static void main(String[] args) {
        Serialization.doSerialization();
        GetPerson.getPerson();
    }

}
