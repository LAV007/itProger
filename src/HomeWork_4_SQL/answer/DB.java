package HomeWork_4_SQL.answer;;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {

    // Подключение к БД (укажите ваши значения)
    private final String HOST = "localhost";
    private final String PORT = "8889";
    private final String DB_NAME = "simple";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    // Получение подключения к базе данных
    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    // Проверка на подключение к БД
    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }


    public void setOrders() throws SQLException, ClassNotFoundException {
        // Выборка всех необходимых значений и помещение этих данных в переменные
        String sql = "SELECT `id` FROM `users` WHERE `login` = ? LIMIT 1";

        // Подставляем значение в SQL
        PreparedStatement prUsers = getDbConnection().prepareStatement(sql);
        // Выбираем пользователя с логином «john»
        prUsers.setString(1, "john");

        // Получаем выборку записей
        ResultSet resUsers = prUsers.executeQuery();

        // В эту переменную укажем id пользователя
        int user_id = 0;
        // Мы получаем лишь одну запись, но даже одну запись всегда проще обработать через цикл while
        while(resUsers.next())
            // Получаем id первого выбранного пользователя
            user_id = resUsers.getInt("id");

        // Можем посмотреть на результат
        // System.out.println(user_id);

        // Выборка всех необходимых значений из таблицы items
        sql = "SELECT `id` FROM `items` WHERE `category` = ?";

        // Подставляем значение в SQL
        PreparedStatement prTovar = getDbConnection().prepareStatement(sql);
        // Выбираем все товары в категории «hats»
        prTovar.setString(1, "hats");

        // Получаем выборку записей
        ResultSet resTovar = prTovar.executeQuery();

        // Сюда поместим все выбранные записи
        List<Integer> arr_items_id = new ArrayList();

        // Добавляем все id в массив arr_items_id
        while(resTovar.next())
            // Получаем id товара и добавляем в массив
            arr_items_id.add(resTovar.getInt("id"));

        // Можем проверить какие записи были получены
        // Для этого перебираем список
//        for (int el: arr_items_id) {
//            System.out.println(el);
//        }

        // Добавление всех записей в таблицу orders
        // Нам необходимо делать добавление в цикле, ведь нам нужно добавить
        // все заказы тех товаров, что прописаны в массиве arr_items_id
        // В качестве id пользователя у нас постоянно один и тот же пользователь
        for (int item_id: arr_items_id) {
            sql = "INSERT INTO `orders` (user_id, item_id) VALUES (?, ?)";

            // В качестве первого параметра устанавливаем id пользователя
            // В качестве второго id товара
            PreparedStatement prOrders = getDbConnection().prepareStatement(sql);
            prOrders.setInt(1, user_id);
            prOrders.setInt(2, item_id);

            // Выполняем добавление записи
            prOrders.executeUpdate();
        }

        // Вывод записей
        // Сначала получаем все записи из таблицы orders.
        sql = "SELECT * FROM `orders`";
        Statement statement = getDbConnection().createStatement();
        ResultSet result = statement.executeQuery(sql);

        System.out.println("Все заказы\n");

        // Далее выводим их, плюс получаем соответствующие записи из других таблиц
        while(result.next()) {
            // Получаем имя пользователя
            sql = "SELECT `login` FROM `users` WHERE `id` = ?";

            PreparedStatement prUserOrder = getDbConnection().prepareStatement(sql);
            // Выбираем пользователя с id который мы взяли из таблицы orders
            prUserOrder.setInt(1, result.getInt("user_id"));

            // Получаем выборку записей
            ResultSet resUserOrder = prUserOrder.executeQuery();

            // Получаем лишь логин пользователя
            String userLogin = "";
            while(resUserOrder.next())
                userLogin = resUserOrder.getString("login");


            // --------------
            // Получаем название товара
            sql = "SELECT `title` FROM `items` WHERE `id` = ?";

            PreparedStatement prTovarOrder = getDbConnection().prepareStatement(sql);
            // Выбираем товары с id который мы взяли из таблицы orders
            prTovarOrder.setInt(1, result.getInt("item_id"));

            // Получаем выборку записей
            ResultSet resTovarOrder = prTovarOrder.executeQuery();

            // Получаем лишь название товара
            String tovarName = "";
            while(resTovarOrder.next())
                tovarName = resTovarOrder.getString("title");


            // Вывод будет в формате: имя пользователя - название товара
            System.out.println(userLogin + " - " + tovarName);
        }

    }

}
