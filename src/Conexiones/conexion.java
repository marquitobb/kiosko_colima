package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class conexion {
    
    static Connection contacto = null;
    
    
    public static Connection getConexion(){
        String url = "jdbc:sqlserver://DESKTOP-75HTEFS:1433;databaseName=kiosko";
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
        }catch(ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "no se pudo establecer la conexion...revisa el driver" + e.getMessage(),
            "eror de conexion",JOptionPane.ERROR_MESSAGE);
        }try{
            contacto = DriverManager.getConnection(url,"sa","123");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 1" + e.getMessage(),
            "eror de conexion",JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }
       
    public static ResultSet Consulta(String consulta){
        Connection con= getConexion();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
            
        }catch (SQLException e){
            /*JOptionPane.showMessageDialog(null, "error 2" + e.getMessage(),
            "eror de conexion",JOptionPane.ERROR_MESSAGE);*/
        }
        return null;
    }
}
   
        