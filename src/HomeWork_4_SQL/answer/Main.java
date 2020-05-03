package HomeWork_4_SQL.answer;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        // Создаем объект на основе класса для работы с БД
        DB db = new DB();

        try {
            // Вызываем функцию и облачаем все в оператор try - catch
            db.setOrders();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
