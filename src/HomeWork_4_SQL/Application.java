package HomeWork_4_SQL;

import HomeWork_4_SQL.DB.DB;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        DB db = new DB();
        try {
            db.isCon();
            db.createNewTable("createNewTable");
            db.addItems("one", 50, "hat");
            db.getData("items");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
