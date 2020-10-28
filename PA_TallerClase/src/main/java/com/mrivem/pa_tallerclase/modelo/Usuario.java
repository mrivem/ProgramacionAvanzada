/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrivem.pa_tallerclase.modelo;

/**
 *
 * @author Mrivem
 */
public class Usuario {
    // FIELDS
    private int id;
    private String nombre;
    private String clave_acceso;
    
    // CONSTRUCTOR
    public Usuario(int id, String nombre, String clave_acceso){
        this.id = id;
        this.nombre = nombre;
        this.clave_acceso = clave_acceso;
    }
    
    // FUNCIONES
    
    // GETTERS & SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClave_acceso() {
        return clave_acceso;
    }

    public void setClave_acceso(String clave_acceso) {
        this.clave_acceso = clave_acceso;
    }
    
    public String getTipo(){
        String tipo = "NOTIPO";
        if(this instanceof Administrador) tipo = "administrador";
        if(this instanceof Encargado) tipo = "encargado";
        if(this instanceof Profesor) tipo = "profesor";
        return tipo;
    }
    
    
}
