package fr.diginamic.demo_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final ResourceBundle monFichierConf = ResourceBundle.getBundle("distante");
    private static final String DB_URL = monFichierConf.getString("database.url");
    private static final String DB_LOGIN = monFichierConf.getString("database.user");
    private static final String DB_PWD = monFichierConf.getString("database.password");
    
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
