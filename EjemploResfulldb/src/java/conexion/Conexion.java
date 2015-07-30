/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String BD = "DB_Ejemplo";
    private static final String DBURL = "jdbc:mysql://localhost/" + BD;
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConexion() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DBURL, USER, PASS);
            if (connection != null) {
                System.out.println("Conexion a base de datos " + BD + " ha sido establecida");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se a cargado el driver");
        } catch (SQLException e) {
            System.out.println("El servidor a rechazado la conexion");
        }
        return connection;
    }
}
