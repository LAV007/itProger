package HomeWork_3.setPerson;

import java.io.Serializable;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class Person implements Serializable {

    private String name;
    private String login;
    private String age;
    private String hobby;
    private String hobby2;
    private String hobby3;

    public Person () {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        this.name = in.nextLine();
        System.out.print("Введите логин: ");
        this.login = in.nextLine();
        System.out.print("Введите возраст: ");
        this.age = in.nextLine();
        System.out.print("Введите первое хобби: ");
        this.hobby = in.nextLine();
        System.out.print("Введите второе хобби: ");
        this.hobby2 = in.nextLine();
        System.out.print("Введите третье хобби: ");
        this.hobby3 = in.nextLine();
    }

    public String sj(){
        StringJoiner strJ = new StringJoiner(" " + "\n" + "\n");
        strJ.add(hobby);
        strJ.add(hobby2);
        strJ.add(hobby3);
        return strJ.toString();

    }

    @Override
    public String toString() {
        return "Пользователь: " + name + " с логином: " + login + '.' + " Его возраст: " + age  + '.' +  " Все хобби:  \n" + "\n" + sj();
    }
}
