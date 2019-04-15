/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 94616
 */
public class Conexao {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String HOST = "127.0.0.1";
    public static final String PORT = "3306";
    public static final String USER = "root";
    public static final  String PASSWORD = "";
    
    public static Connection connection;
    
    public static Connection conectar(){
        try{
        Class.forName(DRIVER);
        connection = DriverManager
                .getConnection(HOST,USER,PASSWORD);
          return connection;
    }catch(ClassNotFoundException e){
        e.printStackTrace();
    }catch(SQLException e){
        e.printStackTrace();
        
    }
    return null;
    }
    public static void desconectar(){
        if (connection!=null){
            try{
                connection.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
    
    

