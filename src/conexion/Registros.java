/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author jhonm
 */
public class Registros {
    
    private ConexionDB cn = new ConexionDB();
    
    public int InsertarPuntaje(String[] puntaje){
        int filasA = 0;
        
        try{
            Connection con = cn.Conectar();
            Statement SentenciaInsert = con.createStatement();
            filasA=SentenciaInsert.executeUpdate("insert into score values ('"+puntaje[0]+"')");
            
            System.out.println("Almacenado");
        }catch(Exception e){
            System.out.println("Error :"+e);
            
        }
        
        
        return filasA;
        
        
        
    }

    
}
