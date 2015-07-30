/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexion.Conexion;
import CustomerP.Customer;
import java.beans.Statement;
import java.sql.ResultSet;
import org.w3c.dom.Document;

public class IngresarDAO {

    public void ingresar(Customer customer) throws IOException {
        String SQLinsertar = "INSERT INTO Customer (name,address)"
                + " VALUES ('" + customer.getName() + "','" + customer.getAddress() + "');";
        Connection con = Conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQLinsertar); //precompilacion de sql
            ps.executeUpdate();// ejecutamos
            System.out.println("Registro Almacenado");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Document mostrar(Customer customer) throws SQLException {

        String SQL = "";
        if (customer.getOp() == 0) {
           SQL = "SELECT * from Customer";
        }
        if (customer.getOp() == 1) {
            SQL = "SELECT id,name,address from Customer where id= '" + customer.getId() + "'";
        }
        Document doc = null;
        System.out.println(SQL);
        Connection connection = null;
        PreparedStatement cmd = null;
        ResultSet rs = null;
        try {
            connection = Conexion.getConexion();
            cmd = connection.prepareStatement(SQL);
            rs = cmd.executeQuery();
            doc = JDBCUtil.toDocument(rs);
        } catch (Exception e) {
            try {
                connection.close();
                cmd.close();
            } catch (Exception ex) {
            }
        }
        return doc;
    }

    public void eliminar(Customer customer) throws IOException {
        String SQL = "delete from Customer where id= '" + customer.getId() + "'";
        Connection con = Conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL); //precompilacion de sql
            ps.executeUpdate();// ejecutamos
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Customer customer) throws IOException {
        String SQL = "UPDATE Customer set name='"+customer.getName()+"',address='"+customer.getAddress()+"' where id='"+customer.getId()+"';";


        Connection con = Conexion.getConexion();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(SQL); //precompilacion de sql
            ps.executeUpdate();// ejecutamos
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
