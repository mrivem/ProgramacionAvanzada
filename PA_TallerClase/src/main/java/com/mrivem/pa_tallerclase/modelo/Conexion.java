/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrivem.pa_tallerclase.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mrivem
 */
public class Conexion {
    
    private final String base = "taller2";
    private final String user = "root";
    private final String password = "qo$kYK5#uSeJE5IRT2zRC8sc1";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("conectado a la BBDD");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            System.out.println("Error en la conexión a la BBDD");
        }

        return con;
    }
    
}
