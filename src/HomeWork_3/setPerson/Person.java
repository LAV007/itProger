package HomeWork_3.setPerson;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {

    private String name;
    private String login;
    private String age;
    private String hobby;

    public Person () {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = in.nextLine();
        System.out.print("Введите логин: ");
        this.login = in.nextLine();
        System.out.print("Введите возраст: ");
        this.age = in.nextLine();
        System.out.print("Введите все хобби хоббои через запятую: ");
        this.hobby = in.nextLine();
    }

    public String str(){
        String[] hobb = hobby.split(",");

        return hobb[0].toString() + "\n" + "\n" +
               hobb[1].toString() + "\n" + "\n" +
               hobb[2].toString();
    }

    @Override
    public String toString() {
        return "User: " + name + " with login: " + login + '.' + " Has name: " + age  + '.' +  " All hobbies:  \n" + "\n" + str();
    }
}
