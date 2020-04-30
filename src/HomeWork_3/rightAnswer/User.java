package HomeWork_3.rightAnswer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// Класс что будет сериализирован
public class User implements Serializable {

    // Поля имя и логин
    private String name, login;
    // Поле возраст
    private byte age;
    // Поле для получения всех хобби
    private List<String> hobby = new ArrayList<>();

    // Конструктор для установки всех значений
    public User(String name, String login, byte age, List<String> hobby) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobby = hobby;
    }

    // Пустой конструктор
    public User() {
    }

    // Переопределение метода toString
    public String toString() {
        // Можно создать строку String info.
        // Мы создали через класс StringBuffer, так как тогда можно использовать
        // функцию append для объединения строк.

        // Создаем объект на основе StringBuffer и помещаем в него строку.
        // По сути создается обычная строка, но с некоторыми дополнительными функциями
        StringBuffer info = new StringBuffer("Пользователь: " + name + " с логином: " + login +
                ". Его возраст: " + age + ". Все хобби: ");

        // Перебираем список хобби
        for (String el: hobby) {
            // Добавляем к объекту строки переход на новую линию,
            info.append("\n");
            // а также добавляем элемент со списка хобби
            info.append(el);
        }

        // Возвращать необходимо объект на основе класса String,
        // поэтому объект info приводим к формату строки
        return info.toString();

        // Важно: можно было все записать через просто String
        // Мы сделали по-другому, дабы показать дополнительные классы и способы реализации
    }
}

