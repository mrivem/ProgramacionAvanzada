package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.Equipo;
import com.mrivem.pa_tallerclase.modelo.OperacionEquipos;
import com.mrivem.pa_tallerclase.vista.P11_RegistrarEquipamiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP11 implements ActionListener {
    
    private Equipo mod;
    private final OperacionEquipos modC;
    private final P11_RegistrarEquipamiento frame;
    
    public ControladorP11(P11_RegistrarEquipamiento frame){
        this.frame = frame;
        this.mod = new Equipo();
        this.modC = new OperacionEquipos();
        setListeners();
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Registro de equipo");
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
            
            if(frame.jTextField_idSala.getText().length() == 0 || frame.jTextArea_estado.getText().length() == 0){
                System.out.println("No deben haber campos en blanco");
                return;
            }
            
            
            try {
                int id_sala = Integer.parseInt(frame.jTextField_idSala.getText());
                mod.setId_sala(id_sala);
                
                String tipo = frame.jComboBox_tipoEquipo.getSelectedItem().toString();
                mod.setTipo(tipo);
                
                mod.setEstado(frame.jTextArea_estado.getText());
                
                boolean estadoRegistro = modC.registrar(mod);
                if(estadoRegistro){
                    System.out.println("equipo registrado exitosamente");
                } else {
                    System.out.println("Hubo un error con el registro de equipo");
                }
            } catch (NumberFormatException ex){
                System.out.println(ex);
            }
        }
        
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }
    
}
