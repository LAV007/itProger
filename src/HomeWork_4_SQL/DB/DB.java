package HomeWork_4_SQL.DB;

import java.sql.*;

public class DB {

    private final String host = "localhost";
    private final String port = "3307";
    private final String name = "firstdatabase";
    private final String login = "root";
    private final String password = "root";

    private Connection dbCon = null;

    private Connection getDbCon() throws ClassNotFoundException, SQLException { //подключение к БД
        String str = "jdbc:mysql://" + host + ":" + port + "/" + name + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver"); //какую используем технологию для подключения к БД

        dbCon = DriverManager.getConnection(str, login, password); //помещаем подключение в переменную
        return dbCon;
    }

    public void isCon() throws ClassNotFoundException, SQLException { //проверка работы БД
        dbCon = getDbCon();
        System.out.println(dbCon.isValid(1000));

    }

    //создание таблицы с помощью кода Java
    public void createNewTable(String newTableName) throws ClassNotFoundException, SQLException {

        String strSql = "CREATE TABLE IF NOT EXISTS " + newTableName +
                        " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(50))" +
                        " ENGINE=MYISAM;";
        Statement statement = getDbCon().createStatement();
        statement.executeUpdate(strSql);
    }

    //добавление данных в таблицу
    public void addItems(String title, int price, String category) throws ClassNotFoundException, SQLException {

        String sqlCmd = "INSERT INTO `items` (title, price, category) VALUES (?, ?, ?)";
        PreparedStatement ps = getDbCon().prepareStatement(sqlCmd);
        ps.setString(1, title);
        ps.setInt(2, price);
        ps.setString(3, category);
        ps.executeUpdate();

    }

    public void addIntoUsers(String login, String password) throws ClassNotFoundException, SQLException {

        String sqlCmd = "INSERT INTO `users` (login, password) VALUES (?, ?)";
        PreparedStatement ps = getDbCon().prepareStatement(sqlCmd);
        ps.setString(1, login);
        ps.setString(2, password);
        ps.executeUpdate();

    }

    public void addIntoOrders(int userId, int itemsId) throws ClassNotFoundException, SQLException {

        String sqlCmd = "INSERT INTO `orders` (user_id, items_id) VALUES (?, ?)";
        PreparedStatement ps = getDbCon().prepareStatement(sqlCmd);
        ps.setInt(1, userId);
        ps.setInt(2, itemsId);

        ps.executeUpdate();

    }

    //выборка данных из таблицы
    public String userLogin;
    public int getUser(String table) throws ClassNotFoundException, SQLException {
        int user = 0;
        String sqlCmd = "SELECT * FROM " + table + " WHERE `login` = 'john'";
        Statement statement = getDbCon().createStatement();
        ResultSet res = statement.executeQuery(sqlCmd);
        while (res.next()) {
            user = res.getInt("id");
            userLogin = res.getString("login");
            System.out.print(userLogin + " - ");
        }
        return user;

    }

    private String itemCategory;
    public int getItems(String table) throws ClassNotFoundException, SQLException {
        int item = 0;
        String sqlCmd = "SELECT * FROM " + table + " WHERE `category` = 'hats'";
        Statement statement = getDbCon().createStatement();
        ResultSet res = statement.executeQuery(sqlCmd);
        while (res.next()) {
            item = res.getInt("id");
            itemCategory = res.getString("title");
            System.out.println(itemCategory);
            //System.out.println(res.getString("title"));
        }
        return item;
    }

    public void getOrders(String table) throws ClassNotFoundException, SQLException {
        String sqlCmd = "SELECT * FROM " + table;
        Statement statement = getDbCon().createStatement();
        ResultSet res = statement.executeQuery(sqlCmd);
        while (res.next()) {
            System.out.print(userLogin);
            System.out.print(" - ");
            System.out.print(itemCategory);
        }
    }

}
