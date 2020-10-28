package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.Equipo;
import com.mrivem.pa_tallerclase.modelo.OperacionEquipos;
import com.mrivem.pa_tallerclase.vista.P12_ConsultarEquipamiento;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class ControladorP12 implements ActionListener {
    private Equipo mod;
    private final OperacionEquipos modC;
    private final P12_ConsultarEquipamiento frame;
    
    public ControladorP12(P12_ConsultarEquipamiento frame){
        this.frame = frame;
        this.mod = new Equipo();
        this.modC = new OperacionEquipos();
        setListeners();
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Consulta de equipo");
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
                
                Equipo equipoEncontrado = modC.buscar(mod);
                
                if(equipoEncontrado != null){
                    frame.jTextField_idSala.setText(equipoEncontrado.getId_sala() + "");
                    frame.jTextArea_estado.setText(equipoEncontrado.getEstado());
                    frame.jComboBox_tipoEquipo.setSelectedItem(equipoEncontrado.getTipoStr());
                    System.out.println("Equipo encontrado");
                } else {
                    System.out.println("ID de Equipo no encontrado");
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
                if(estado) System.out.println("Equipo eliminado con exito");
                else System.out.println("Hubo un error al eliminar el Equipo");
            } catch(NumberFormatException ex){
                System.out.println(ex);
            }
        }
        if(e.getSource() == frame.jButton_modificar){
            if(frame.jTextField_id.getText().length() == 0 || 
                    frame.jTextField_idSala.getText().length() == 0 || 
                    frame.jTextArea_estado.getText().length() == 0){
                System.out.println("No pueden existir campos en blanco");
                return;
            }
            
            try {
                String s_id = frame.jTextField_id.getText();
                String s_id_sala = frame.jTextField_idSala.getText();
                int id = Integer.parseInt(s_id);
                int id_sala = Integer.parseInt(s_id_sala);
                
                mod.setId(id);
                mod.setId_sala(id_sala);
                mod.setTipo(frame.jComboBox_tipoEquipo.getSelectedItem().toString());
                mod.setEstado(frame.jTextArea_estado.getText());
                
                
                boolean estado = modC.modificar(mod);
                if(estado) System.out.println("Equipo modificado con exito");
                else System.out.println("Hubo un error al modificar el Equipo");
            } catch(NumberFormatException ex){
                System.out.println(ex);
            }
        }
        if(e.getSource() == frame.jButton_cancelar){
            frame.dispose();
        }
    }
    
}
