package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

	private static final ResourceBundle monFichierConf = ResourceBundle.getBundle("distante");
    private static final String DB_URL = monFichierConf.getString("database.url");
    private static final String DB_LOGIN = monFichierConf.getString("database.user");
    private static final String DB_PWD = monFichierConf.getString("database.password");
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        try(Connection connection = DriverManager.getConnection( DB_URL, DB_LOGIN, DB_PWD );) {
            System.out.println(connection);
            Statement monStatement = connection.createStatement();
            ResultSet curseur = monStatement.executeQuery("SELECT ID, NOM FROM FOURNISSEUR");
            ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
            while (curseur.next()) {
            	Integer id = curseur.getInt("ID");
            	String nom = curseur.getString("NOM");
            	Fournisseur clientCourant = new Fournisseur(id, nom);
            	fournisseurs.add(clientCourant);
            }
            for(Fournisseur f : fournisseurs) {
            	System.out.println(f.toString());
            }
        } catch ( SQLException e ) {
            System.err.println(e.getMessage());
        }
	}

}
