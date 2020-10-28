package com.mrivem.pa_tallerclase.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OperacionUsuarios extends Conexion {
    // registro de un nuevo usuario
    public boolean registrar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO usuarios (id,nombre,clave_acceso,tipo) VALUES (?,?,?,?)";
        try {
            String tipo = "NOTIPO";
            if(usuario instanceof Encargado) tipo = "encargado";
            else if(usuario instanceof Profesor) tipo = "profesor";
            else if(usuario instanceof Administrador) tipo = "administrador";
            
            
            ps = con.prepareStatement(sql);
            ps.setString(1, null);
            ps.setString(2, usuario.getNombre());
            ps.setString(3, usuario.getClave_acceso());
            ps.setString(4, tipo);
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
    
    // autenticacion de usuario
    public Usuario autenticar(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        //String sql = "INSERT INTO usuarios (id,nombre,clave_acceso,tipo) VALUES (?,?,?,?)";
        String sql = "select * from usuarios where nombre=? and clave_acceso=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getClave_acceso());
            rs = ps.executeQuery();
            
            if (rs.next()){
                String tipo = rs.getString("tipo");
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String clave_acceso = rs.getString("clave_acceso");
                
                switch (tipo) {
                    case "profesor":
                        usuario = new Profesor(id, nombre, clave_acceso);
                        break;
                    case "encargado":
                        usuario = new Encargado(id, nombre, clave_acceso);
                        break;
                    case "administrador":
                        usuario = new Administrador(id, nombre, clave_acceso);
                        break;
                    default:
                        break;
                }
     
                return usuario;
            } 
            return null;
        } catch (SQLException e) {
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
    
    // modificar usuario existente
    public boolean modificar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE usuarios SET nombre=?,clave_acceso=?,tipo=? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getClave_acceso());
            ps.setString(3, usuario.getTipo());
            ps.setInt(4, usuario.getId());
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
    
    // Eliminar usuario
    public boolean eliminar(Usuario usuario) {
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "DELETE FROM usuarios WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
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
    
    
    public Usuario buscar(Usuario usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            rs = ps.executeQuery();
            if (rs.next()){
                String tipo = rs.getString("tipo");
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String clave_acceso = rs.getString("clave_acceso");
                
                switch (tipo) {
                    case "profesor":
                        usuario = new Profesor(id, nombre, clave_acceso);
                        break;
                    case "encargado":
                        usuario = new Encargado(id, nombre, clave_acceso);
                        break;
                    case "administrador":
                        usuario = new Administrador(id, nombre, clave_acceso);
                        break;
                    default:
                        break;
                }
     
                return usuario;
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
