package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.Administrador;
import com.mrivem.pa_tallerclase.modelo.Encargado;
import com.mrivem.pa_tallerclase.modelo.OperacionUsuarios;
import com.mrivem.pa_tallerclase.modelo.Profesor;
import com.mrivem.pa_tallerclase.modelo.Usuario;
import com.mrivem.pa_tallerclase.vista.P32_ConsultarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP32 implements ActionListener{
    private Usuario mod;
    private final OperacionUsuarios modC;
    private final P32_ConsultarUsuario frame;
    
    public ControladorP32(P32_ConsultarUsuario frame){
        this.frame = frame;
        this.mod = new Usuario(0,"","");
        this.modC = new OperacionUsuarios();
        setListeners();
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Consulta de usuario");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private void setListeners(){
        this.frame.jButton_buscar.addActionListener(this);
        this.frame.jButton_eliminar.addActionListener(this);
        this.frame.jButton_modificar.addActionListener(this);
        this.frame.jButton_cancelar.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_buscar){
            try {
                String s_id = frame.jTextField_id.getText();
                int id = Integer.parseInt(s_id);
                mod.setId(id);
                
                Usuario usuarioEncontrado = modC.buscar(mod);
                
                if(usuarioEncontrado != null){
                    frame.jTextField_nombre.setText(usuarioEncontrado.getNombre());
                    frame.jTextField_claveAcceso.setText(usuarioEncontrado.getClave_acceso());
                    frame.jComboBox_tipoUsuario.setSelectedItem(usuarioEncontrado.getTipo());
                    System.out.println("Usuario encontrado");
                } else {
                    System.out.println("ID de usuario no encontrado");
                }

            
            } catch(NumberFormatException ex){
                System.out.println(ex);
            }
        }
        if(e.getSource() == frame.jButton_eliminar){
            try {
                String s_id = frame.jTextField_id.getText();
                int id = Integer.parseInt(s_id);
                
                mod.setId(id);
                
                boolean estado = modC.eliminar(mod);
                if(estado) System.out.println("Usuario eliminado con exito");
                else System.out.println("Hubo un error al eliminar al usuario");
            } catch(NumberFormatException ex){
                System.out.println(ex);
            }
        }
        if(e.getSource() == frame.jButton_modificar){
            if(frame.jTextField_id.getText().length() == 0 || 
                    frame.jTextField_nombre.getText().length() == 0 || 
                    frame.jTextField_claveAcceso.getText().length() == 0){
                System.out.println("No pueden existir campos en blanco");
                return;
            }
            
            try {
                String s_id = frame.jTextField_id.getText();
                int id = Integer.parseInt(s_id);
                
                switch(frame.jComboBox_tipoUsuario.getSelectedItem().toString()){
                    case "profesor":
                        mod = new Profesor(id, frame.jTextField_nombre.getText(), frame.jTextField_claveAcceso.getText());
                        break;
                    case "encargado":
                        mod = new Encargado(id, frame.jTextField_nombre.getText(), frame.jTextField_claveAcceso.getText());
                        break;
                    case "administrador":
                        mod = new Administrador(id, frame.jTextField_nombre.getText(), frame.jTextField_claveAcceso.getText());
                        break;
                    default:
                        System.out.println("Error al seleccionar tipo de usuario");
                        return;
                }
                
                boolean estado = modC.modificar(mod);
                if(estado) System.out.println("Usuario modificado con exito");
                else System.out.println("Hubo un error al modificar al usuario");
            } catch(NumberFormatException ex){
                System.out.println(ex);
            }
        }
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }
    
}
