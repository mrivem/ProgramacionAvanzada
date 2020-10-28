package com.mrivem.pa_tallerclase.controlador;

import com.mrivem.pa_tallerclase.modelo.Equipo;
import com.mrivem.pa_tallerclase.modelo.OperacionEquipos;

import com.mrivem.pa_tallerclase.vista.P13_MostrarListadoConsolidado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ControladorP13 implements ActionListener {
    
    private final P13_MostrarListadoConsolidado frame;
    private final OperacionEquipos modC;
    
    public ControladorP13(P13_MostrarListadoConsolidado frame){
        this.frame = frame;
        this.modC = new OperacionEquipos();
        setListeners();
        getTableContents();
    }
    
    public void iniciar(){
        // Mostramos y centramos la pantalla
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Portal Profesor");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    
    private void setListeners(){
        this.frame.jButton_cerrar.addActionListener(this);
    }
    
    private void getTableContents(){
        ArrayList<Equipo> equipos = modC.listaConsolidada();
        
        if(equipos != null){
                    String[] tableHeaders = {"id", "id_sala", "tipo", "estado"};
                    Object[][] tableContents = new Object[equipos.size()][4];
                    for(int i = 0; i < equipos.size(); i++){
                        tableContents[i][0] = equipos.get(i).getId();
                        tableContents[i][1] = equipos.get(i).getId_sala();
                        tableContents[i][2] = equipos.get(i).getTipoStr();
                        tableContents[i][3] = equipos.get(i).getEstado();
                    }
                    frame.jTable_resultado.setModel(new DefaultTableModel(tableContents, tableHeaders));
                    
                    
                } else {
                    System.out.println("ID de usuario no encontrado");
                }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == frame.jButton_cerrar){
            frame.dispose();
        }
    }
    
}
