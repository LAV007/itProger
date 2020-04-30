package HomeWork_3.rightAnswer;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Создаем объект для получения данных
        Scanner in = new Scanner(System.in);

        // Получаем имя
        System.out.print("Введите имя: ");
        String name = in.nextLine();

        // Получаем логин
        System.out.print("Введите логин: ");
        String login = in.nextLine();

        // Получаем возраст
        System.out.print("Введите возраст: ");
        byte age = in.nextByte();

        // Получаем строку со всеми хобби
        System.out.print("Введите хобби через запятую: ");

        // В Джава есть одна проблема. Поскольку nextByte, nextInt, nextFloat... считывают только числа и не считываемт
        // последнего введенного символа, коим является переход на новую строку, то выходит проблема, когда программа не понимает
        // ввел ли пользователь все необходимое или же нет.

        //  Из-за этого после nextByte и прочих метод nextLine игнорируется и происходит это из-за
        // того что программа не может понять все ли было введено или есть ещё не введенные строки.

        // У нас получиться, что установка впервый раз hobby не сработает, зато установка в
        // hobby второй раз сработает, что нам как раз и нужно.

        // Выглядит не особо, но такая проблема присутсвует в Java.
        // В некоторых версиях такой ошибки нет, поэтому возможно в вашей версии Java вы можете просто
        // прописать String hobby = in.nextLine(); без дополнительной строки String hobby = in.nextLine();
        String hobby = in.nextLine();
        hobby = in.nextLine();

        try {
            // Открываем нужный файл
            FileOutputStream fos = new FileOutputStream("some.data");
            // Выполняем открытие файла для сериализации
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // Разбиваем строку с хобби по символу запятой
            String[] hobbyArr = hobby.split(",");
            // Преобразовываем обычный массив в список
            List<String> hobbies = new ArrayList<>(Arrays.asList(hobbyArr));
            // Сериализируем объект
            oos.writeObject(new User(name, login, age, hobbies));

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            // Выполняем считыванием данных
            FileInputStream fis = new FileInputStream("some.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Получаем нужный объект
            User user = (User) ois.readObject();
            // Выводим объект (будет использован переопределенный метод toString())
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
