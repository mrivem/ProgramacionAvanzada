package com.mrivem.pa_tallerclase.modelo;

public class Equipo {
    private String estado = "";
    private int id = -1;
    private int id_sala = -1;
    public static enum Tipo {COMPUTADOR, IMPRESORA, OTRO};
    private Tipo tipo;
    
    public Equipo(){}
    
    public Equipo(int id, int id_sala, Tipo tipo, String estado){
        this.id = id;
        this.id_sala = id_sala;
        this.tipo = tipo;
        this.estado = estado;
    }
    
    public void estadoEquipo(){
        
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = Tipo.valueOf(tipo.toUpperCase());
    }
    
    public String getTipoStr(){        
        return tipo.toString().toLowerCase();
    }
}
