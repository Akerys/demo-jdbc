package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {

	private static final ResourceBundle monFichierConf = ResourceBundle.getBundle("distante");
    private static final String DB_URL = monFichierConf.getString("database.url");
    private static final String DB_LOGIN = monFichierConf.getString("database.user");
    private static final String DB_PWD = monFichierConf.getString("database.password");
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try(Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );) {
            System.out.println(connection);
            Statement monStatement = connection.createStatement();
            System.out.println(monStatement.executeUpdate("UPDATE FOURNISSEUR SET NOM='La Maison des Peintures' WHERE NOM='La Maison de la Peinture'"));
        } catch ( SQLException e ) {
            System.err.println(e.getMessage());
        }
	}

}
