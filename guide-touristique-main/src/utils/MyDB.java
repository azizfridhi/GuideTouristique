/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author houss
 */
public class MyDB {
    private final String url = "jdbc:mysql://localhost:3306/guide_touristique";
    private final String user = "root";
    private final String pwd = "";
    private Connection connection;
    private static MyDB instance;
    
    public MyDB(Connection connection) {
        this.connection = connection;
    }
    
    
    
    private MyDB(){
        try {
            connection=DriverManager.getConnection(url,user,pwd);
            System.out.println("Connexion établie");
        }catch (SQLException ex){
            System.out.println("Erreur de connexion a la base de données");
        }
    }
    
    public static MyDB getInstance(){
        if (instance == null){
            instance = new MyDB();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
}
    
