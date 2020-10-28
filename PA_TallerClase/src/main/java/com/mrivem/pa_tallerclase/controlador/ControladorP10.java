package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.OperacionUsuarios;
import com.mrivem.pa_tallerclase.modelo.Usuario;
import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.mrivem.pa_tallerclase.vista.P10_VistaEncargado;
import com.mrivem.pa_tallerclase.vista.P11_RegistrarEquipamiento;
import com.mrivem.pa_tallerclase.vista.P12_ConsultarEquipamiento;
import com.mrivem.pa_tallerclase.vista.P13_MostrarListadoConsolidado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP10 implements ActionListener {
    
    private final P10_VistaEncargado frame;
    
    public ControladorP10(P10_VistaEncargado frame){
        this.frame = frame;
        setListeners();
    }
    
    private void setListeners(){
        this.frame.jButton_registroEquipo.addActionListener(this);
        this.frame.jButton_consultarEquipo.addActionListener(this);
        this.frame.jButton_cerrarSesion.addActionListener(this);
        this.frame.jButton_listadoConsolidado.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Portal Encargado");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_registroEquipo){
            ControladorP11 con = new ControladorP11(new P11_RegistrarEquipamiento());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_consultarEquipo){
            ControladorP12 con = new ControladorP12(new P12_ConsultarEquipamiento());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_listadoConsolidado){
            ControladorP13 con = new ControladorP13(new P13_MostrarListadoConsolidado());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_cerrarSesion){
            ControladorP00 con = new ControladorP00(new Usuario(0,"",""), new OperacionUsuarios(), new P00_InicioSesion());
            con.iniciar();
            frame.dispose();
        }
    }
}
