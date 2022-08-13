
package Modelo;
import java.sql.*;
import java.sql.Connection;
//Se extiende la clase para no instanciar objeto
public class Consultas extends Conexion{
            
    private ResultSet Resultado=null;
            
    public ResultSet Reporte1(){
            
    Connection Con=ObtenerConexion();
    Statement ps=null;
    String consulta="SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia "
            + "FROM LIDER "
            + "ORDER BY Ciudad_Residencia ASC";
            
        try {
            ps=Con.createStatement();
            Resultado=ps.executeQuery(consulta); 
        } catch (Exception e) {
            System.err.println("No encontro query");
        }  
        return Resultado;     
    }
    
    public ResultSet Reporte2(){
            
    Connection Con=ObtenerConexion();
    Statement ps=null;
    String consulta="SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad FROM PROYECTO "
            + "WHERE Clasificacion = 'Casa Campestre' AND Ciudad IN ('Barranquilla', 'Santa Marta', 'Cartagena')";
            
        try {
            
            ps=Con.createStatement();
            Resultado=ps.executeQuery(consulta);
            
        } catch (Exception e) {
            
            System.err.println("No encontro query");
            
        }
            
        return Resultado;
            
    }
    
    public ResultSet Reporte3(){
    Connection Con=ObtenerConexion();
    Statement ps=null;
    String consulta="SELECT Y.ID_Compra, X.Constructora, X.Banco_Vinculado "
            + "FROM PROYECTO X JOIN COMPRA Y ON X.ID_Proyecto = Y.ID_Proyecto "
            + "WHERE Y.Proveedor = 'Homecenter' AND X.Ciudad = 'Salento'";
            
        try {
            
            ps=Con.createStatement();
            Resultado=ps.executeQuery(consulta);
            
        } catch (Exception e) {
            
            System.err.println("No encontro query");
            
        }
            
        return Resultado;
            
    }
}
