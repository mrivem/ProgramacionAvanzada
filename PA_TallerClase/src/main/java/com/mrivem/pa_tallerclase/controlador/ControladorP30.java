package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.OperacionUsuarios;
import com.mrivem.pa_tallerclase.modelo.Usuario;
import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.mrivem.pa_tallerclase.vista.P30_VistaAdministrador;
import com.mrivem.pa_tallerclase.vista.P31_RegistrarUsuario;
import com.mrivem.pa_tallerclase.vista.P32_ConsultarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP30 implements ActionListener  {
    
    //private final Usuario mod;
    //private final OperacionUsuarios modC;
    private final P30_VistaAdministrador frame;
    
    public ControladorP30(P30_VistaAdministrador frame){
        this.frame = frame;
        setListeners();
    }
    
    private void setListeners(){
        this.frame.jButton_registroUsuario.addActionListener(this);
        this.frame.jButton_consultarUsuario.addActionListener(this);
        this.frame.jButton_cerrarSesion.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Portal Administrador");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_registroUsuario){
            ControladorP31 con = new ControladorP31(new P31_RegistrarUsuario());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_consultarUsuario){
            ControladorP32 con = new ControladorP32(new P32_ConsultarUsuario());
            con.iniciar();
        }
        
        if(e.getSource() == frame.jButton_cerrarSesion){
            ControladorP00 con = new ControladorP00(new Usuario(0,"",""), new OperacionUsuarios(), new P00_InicioSesion());
            con.iniciar();
            frame.dispose();
        }
    }
}
