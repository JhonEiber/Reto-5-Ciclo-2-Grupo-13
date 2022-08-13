
package Modelo;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private final String url="jdbc:sqlite:ProyectosConstruccion.db";
    private final String user="root";
    private final String pass="";
    private Connection con=null;
    
    public Connection ObtenerConexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            con=DriverManager.getConnection(url, user, pass); //¿Por que hay que hacer un Cast?

        } catch (Exception e) {
             System.err.println("No hay BD");
        }
        return con;
    }
    
        
}
