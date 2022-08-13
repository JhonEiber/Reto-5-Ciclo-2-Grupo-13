
package Controlador;

import java.awt.event.*;
import Modelo.Consultas;
import Vista.Aplicacion_Vista;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Controller implements ActionListener{
    
    private Consultas Consulta;
    private Aplicacion_Vista vista;
    
    DefaultTableModel dtm= new DefaultTableModel();
    Object [] datos=new  Object[4];
    
    public Controller(Consultas Consulta,Aplicacion_Vista vista){
    
        this.Consulta=Consulta;
        this.vista=vista;
        this.vista.Reporte1.addActionListener(this);
        this.vista.Reporte2.addActionListener(this);
        this.vista.Reporte3.addActionListener(this);

    }
    
    public void Iniciar(){
    vista.setTitle("CONSULTAS RETO 5");
    vista.setLocationRelativeTo(null);  
    }
    
    public void CrearReporte1(ResultSet Resultado){
    
    String[] cabecera={"ID","Nombre","Apellido","Ciudad_Residencia"};
    dtm.setColumnIdentifiers(cabecera);
    vista.jTable1.setModel(dtm);
    dtm.setRowCount(0);
    
    try {
            while (Resultado.next()){
                datos[0]=Resultado.getString("ID_Lider");
                datos[1]=Resultado.getString("Nombre");
                datos[2]=Resultado.getString("Primer_Apellido");
                datos[3]=Resultado.getString("Ciudad_Residencia");

                dtm.addRow(datos);
    
    }
        } catch (Exception e) {
            System.err.println("No se coneto");
        }
    }
    
    public void CrearReporte2(ResultSet Resultado){
 
    String[] cabecera={"Proyecto","Constructora","Habitaciones","Ciudad"};
    dtm.setColumnIdentifiers(cabecera);
    vista.jTable1.setModel(dtm);
    dtm.setRowCount(0);

        try {
            while (Resultado.next()){
                datos[0]=Resultado.getString("ID_Proyecto");
                datos[1]=Resultado.getString("Constructora");
                datos[2]=Resultado.getInt("Numero_Habitaciones");
                datos[3]=Resultado.getString("Ciudad");

                dtm.addRow(datos);
                
    }
        } catch (Exception e) {
            System.err.println("No se coneto");
        }
    }
    
    public void CrearReporte3(ResultSet Resultado){
 
    String[] cabecera={"Compra","Constructora","Banco"};
    Object [] datos2=new  Object[3];
    dtm.setColumnIdentifiers(cabecera);
    vista.jTable1.setModel(dtm);
    dtm.setRowCount(0);
    
        try {
            while (Resultado.next()){
                datos2[0]=Resultado.getString("ID_Compra");
                datos2[1]=Resultado.getString("Constructora");
                datos2[2]=Resultado.getString("Banco_Vinculado");

                dtm.addRow(datos2);
                
    }
        } catch (Exception e) {
            System.err.println("No se coneto");
        }
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        ResultSet Resultado;
        if (e.getSource()==vista.Reporte1) {
            Resultado=Consulta.Reporte1();
            CrearReporte1(Resultado);
            
        }else if (e.getSource()==vista.Reporte2) {
            Resultado=Consulta.Reporte2();
            CrearReporte2(Resultado);
            
        }else if (e.getSource()==vista.Reporte3) {
            Resultado=Consulta.Reporte3();
            CrearReporte3(Resultado);
        }

    }
}
