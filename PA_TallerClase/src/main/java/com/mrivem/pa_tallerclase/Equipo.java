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
public class Equipo {
    private String estado = "";
    private int id = -1;
    private int id_sala = -1;
    public static enum Tipo {COMPUTADOR, IMPRESORA, OTRO};
    private Tipo tipo;
    
    public Equipo(String estado, int id, int id_sala, Tipo tipo){
        this.estado = estado;
        this.id = id;
        this.id_sala = id_sala;
        this.tipo = tipo;
    }
    
    public void estadoEquipo(){
        
    }
}
