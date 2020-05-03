package HomeWork_4_SQL;

import HomeWork_4_SQL.DB.DB;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        DB db = new DB();
        try {
            //db.isCon();

            //db.createNewTable("createNewTable");

            //db.addItems("Красна футболка", 850, "shirts");
            //db.addIntoUsers("john", "some_pass");
            //db.addIntoUsers("alex", "some_pass");

            db.getUser("users");
            db.getItems("items");

            //db.addIntoOrders(db.getUser("users"), db.getItems("items"));

            //db.getOrders("orders");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
