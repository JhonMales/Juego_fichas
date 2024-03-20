/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

/**
 *
 * @author jhonm
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionDB {
    PreparedStatement s;
    String url= "jdbc:mysql://localhost:3306/score"+ "?useUnicode=true&use" + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + "serverTimezone=UTC";
    String driver = "com.mysql.jdbc.Driver";
    String user="root";
    String clave= "sub-zero00";
    
    
    public Connection Conectar(){
        Connection cn= null;

       try{
           Class.forName(driver);

           cn = DriverManager.getConnection(this.url, this.user, this.clave);

       }catch(Exception e){
           System.out.println("Exception: " + e);
       }
       return cn;

   }

}
