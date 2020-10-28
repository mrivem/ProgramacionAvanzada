package com.mrivem.pa_tallerclase.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacionEquipos extends Conexion {
    // registro de un nuevo equipo
    public boolean registrar(Equipo equipo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO equipos (id,id_sala,tipo,estado) VALUES (?,?,?,?)";
        try {
            
            
            ps = con.prepareStatement(sql);
            ps.setString(1, null);
            ps.setInt(2, equipo.getId_sala());
            ps.setString(3, equipo.getTipoStr());
            ps.setString(4, equipo.getEstado());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    // modificar equipo existente
    public boolean modificar(Equipo equipo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE equipos SET id_sala=?,tipo=?,estado=? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getId_sala());
            ps.setString(2, equipo.getTipoStr());
            ps.setString(3, equipo.getEstado());
            ps.setInt(4, equipo.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    // Eliminar equipo
    public boolean eliminar(Equipo equipo) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM equipos WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    
    public Equipo buscar(Equipo equipo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM equipos WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, equipo.getId());
            rs = ps.executeQuery();
            if (rs.next()){                
                int id = rs.getInt("id");
                int id_sala = rs.getInt("id_sala");
                String tipo = rs.getString("tipo");
                String estado = rs.getString("estado");
                
                equipo.setId(id);
                equipo.setId_sala(id_sala);
                equipo.setTipo(tipo);
                equipo.setEstado(estado);
     
                return equipo;
            } 
            return null;       
        }catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
