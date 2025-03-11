package DP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    private static Singleton instance;
    private Connection connection;

    public Singleton() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees\", \"user\", \"password\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}

class SingletonExample{
    public static void main(String[] args){
        Connection connection1 = Singleton.getInstance().getConnection();
        Connection connection2 = Singleton.getInstance().getConnection();
        System.out.println(connection1 == connection2);
    }
}
