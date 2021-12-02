package fr.diginamic.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
	//test
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/compta";
    private static final String DB_LOGIN = "root";
    private static final String DB_PWD = "nprspa3417";
    
    public static void main( String[] args )
    {
        try(Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD )) {
            System.out.println(connection);
        } catch ( SQLException e ) {
            System.err.println(e.getMessage());
        }
        
        // Connection connection = null;
        // try {
        //     connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );
        //     System.out.println(connection);
        // } catch ( SQLException throwables ) {
        //     throwables.printStackTrace();
        // } finally {
        //     try {
        //         connection.close();
        //     } catch ( SQLException throwables ) {
        //         throwables.printStackTrace();
        //     }
        // }
    }
}
