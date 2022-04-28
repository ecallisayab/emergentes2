package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_biblio";
    static String usuario = "root";
    static String password = "";
    
    Connection conn = null;
    
    public ConexionDB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Conexión OK: "+conn);
            }     
        } catch (SQLException e) {
            System.out.println("Error de SQL: "+e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de conexión: "+ex.getMessage());
        }
    }
    
    public Connection conectar() {
        return conn;
    }
    
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en el cierre de conexión: "+e.getMessage());
        }
    }
}
