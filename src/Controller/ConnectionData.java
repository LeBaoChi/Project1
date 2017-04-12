/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author PhuDX
 * Lớp kết nối để thao tác với CSDL
 */
public class ConnectionData {
    private final String classname = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3306/managelibrary";
    private final String user = "root";
    private final String pass = "phu1996@A";

    private Connection connection;

    //Hàm này sẽ trả về một Connection để sử dụng truy vấn SQL
    public Connection getConnect() {
        Connection conn;
        try {
            Class.forName(classname);
            connection = (Connection) DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    /**
    * @author PhuDX
    * Hàm đóng kết nối
    */
    public void getClose(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
