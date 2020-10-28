package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.Administrador;
import com.mrivem.pa_tallerclase.modelo.Encargado;
import com.mrivem.pa_tallerclase.modelo.OperacionUsuarios;
import com.mrivem.pa_tallerclase.modelo.Profesor;
import com.mrivem.pa_tallerclase.modelo.Usuario;
import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.mrivem.pa_tallerclase.vista.P10_VistaEncargado;
import com.mrivem.pa_tallerclase.vista.P20_VistaProfesor;
import com.mrivem.pa_tallerclase.vista.P30_VistaAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP00 implements ActionListener {
    
    private final Usuario mod;
    private final OperacionUsuarios modC;
    private final P00_InicioSesion frame;
    
    public ControladorP00(Usuario mod, OperacionUsuarios modC, P00_InicioSesion frame){
        this.mod = mod;
        this.modC = modC;
        this.frame = frame;
        setListeners();
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Inicio de sesión");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private void setListeners(){
        this.frame.jButton_ingresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_ingresar){
            mod.setNombre(frame.jTextField_nombre.getText());
            mod.setClave_acceso(String.valueOf(frame.jPasswordField_contrasena.getPassword()));

            Usuario loggedUser = modC.autenticar(mod);
            if(loggedUser != null){
                System.out.println("Usuario autenticado exitosamente");
                if(loggedUser instanceof Encargado){
                    ControladorP10 con = new ControladorP10(new P10_VistaEncargado());
                    con.iniciar();
                } else if (loggedUser instanceof Profesor){
                    P20_VistaProfesor newFrame = new P20_VistaProfesor();
                    newFrame.setTitle("Vista de profesor");
                    newFrame.setVisible(true);
                    newFrame.setLocationRelativeTo(null);
                } else if (loggedUser instanceof Administrador){
                    ControladorP30 con = new ControladorP30(new P30_VistaAdministrador());
                    con.iniciar();
                }
                frame.dispose();
            } else {
                System.out.println("Nombre de usuario o contraseña incorrecta");
            }
        }
    }
}
