/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrivem.pa_tallerclase;

/**
 *
 * @author Mrivem
 */
public class Administrador extends Usuario{
    
    public static final int TIPO_PROFESOR = 1;
    public static final int TIPO_ADMINISTRADOR = 2;
    public static final int TIPO_ENCARGADO = 3;
    
    public Administrador(String nombre, int id, String clave_acceso){
        super(nombre, id, clave_acceso);
    }
    
    public String generarContraseña(){
        return "";
    }
    
    public void crearUsuario(String nombre, int id, int tipo){
        // switchear y crear segun tipo entregado
        // catch tipos no definidos y reportar
    }
    
    public void eliminarUsuario(){
        
    }
    
    public void actualizarUsuario(){
        
    }
    
    public void consultarUsuario(){
        
    }
}
