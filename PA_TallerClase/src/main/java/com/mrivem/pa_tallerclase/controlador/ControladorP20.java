package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.Equipo;
import com.mrivem.pa_tallerclase.modelo.OperacionEquipos;
import com.mrivem.pa_tallerclase.modelo.OperacionUsuarios;
import com.mrivem.pa_tallerclase.modelo.Usuario;
import com.mrivem.pa_tallerclase.vista.P00_InicioSesion;
import com.mrivem.pa_tallerclase.vista.P20_VistaProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ControladorP20 implements ActionListener {
    
    private final P20_VistaProfesor frame;
    private final OperacionEquipos modC;
    
    public ControladorP20(P20_VistaProfesor frame){
        this.frame = frame;
        this.modC = new OperacionEquipos();
        setListeners();
    }
    
    private void setListeners(){
        this.frame.jButton_buscar.addActionListener(this);
        this.frame.jButton_cerrarSesion.addActionListener(this);
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Portal Profesor");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_buscar){
            try {
                String s_id = frame.jTextField_idSala.getText();
                int id_sala = Integer.parseInt(s_id);
                
                
                ArrayList<Equipo> equipos = modC.buscarPorSala(id_sala);
                
                if(equipos != null){
                    String[] tableHeaders = {"id", "id_sala", "tipo", "estado"};
                    Object[][] tableContents = new Object[equipos.size()][4];
                    for(int i = 0; i < equipos.size(); i++){
                        tableContents[i][0] = equipos.get(i).getId();
                        tableContents[i][1] = equipos.get(i).getId_sala();
                        tableContents[i][2] = equipos.get(i).getTipoStr();
                        tableContents[i][3] = equipos.get(i).getEstado();
                    }
                    frame.jTable_resultados.setModel(new DefaultTableModel(tableContents, tableHeaders));
                    
                    
                } else {
                    System.out.println("ID de usuario no encontrado");
                }

            
            } catch(NumberFormatException ex){
                System.out.println(ex);
            }
        }

        if(e.getSource() == frame.jButton_cerrarSesion){
            ControladorP00 con = new ControladorP00(new Usuario(0,"",""), new OperacionUsuarios(), new P00_InicioSesion());
            con.iniciar();
            frame.dispose();
        }

    }
    
}
