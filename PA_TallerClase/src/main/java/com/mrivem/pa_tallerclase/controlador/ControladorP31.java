package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.Administrador;
import com.mrivem.pa_tallerclase.modelo.Encargado;
import com.mrivem.pa_tallerclase.modelo.OperacionUsuarios;
import com.mrivem.pa_tallerclase.modelo.Profesor;
import com.mrivem.pa_tallerclase.modelo.Usuario;
import com.mrivem.pa_tallerclase.vista.P31_RegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP31 implements ActionListener {
    
    private Usuario mod;
    private final OperacionUsuarios modC;
    private final P31_RegistrarUsuario frame;
    
    public ControladorP31(P31_RegistrarUsuario frame){
        this.frame = frame;
        this.mod = new Usuario(0,"","");
        this.modC = new OperacionUsuarios();
        setListeners();
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Registro de usuario");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private void setListeners(){
        this.frame.jButton_cancelar.addActionListener(this);
        this.frame.jButton_registrar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_registrar){
            switch(frame.jComboBox_tipoUsuario.getSelectedItem().toString()){
                case "profesor":
                    mod = new Profesor(0, frame.jTextField_nombre.getText(), frame.jTextField_claveAcceso.getText());
                    break;
                case "encargado":
                    mod = new Encargado(0, frame.jTextField_nombre.getText(), frame.jTextField_claveAcceso.getText());
                    break;
                case "administrador":
                    mod = new Administrador(0, frame.jTextField_nombre.getText(), frame.jTextField_claveAcceso.getText());
                    break;
                default:
                    System.out.println("Error al seleccionar tipo de usuario");
                    return;
            }
            
            boolean estadoRegistro = modC.registrar(mod);
            if(estadoRegistro){
                System.out.println("usuario registrado exitosamente");
            } else {
                System.out.println("Hubo un error con el registro de usuario");
            }
        }
        
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }



    
}
