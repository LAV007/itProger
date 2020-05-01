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

    //добавление данных в таблицу addOrder addUsers
    public void addItems(String title, int price, String category) throws ClassNotFoundException, SQLException {

        String sqlCmd = "INSERT INTO `items` (title, price, category) VALUES (?, ?, ?)";
        PreparedStatement ps = getDbCon().prepareStatement(sqlCmd);
        ps.setString(1, title);
        ps.setInt(2, price);
        ps.setString(3, category);
        ps.executeUpdate();

    }

    //выборка данных из таблицы
    public void getData(String table) throws ClassNotFoundException, SQLException {

        String sqlCmd = "SELECT * FROM " + table;
        Statement statement = getDbCon().createStatement();
        ResultSet res = statement.executeQuery(sqlCmd);
        while (res.next()) {
            System.out.println(res.getString("title"));
        }

    }

}
