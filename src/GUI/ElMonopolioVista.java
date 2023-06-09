/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.*;
import controlador.*;



/**
 *
 * @author Omar
 */
public class ElMonopolioVista extends javax.swing.JFrame implements Vista {

    MonopolioJuego juego;
    
    public void setMonopolioJuego(MonopolioJuego j){
        this.juego = j;
        setVisible(true);
    }
    
    /**
     * Creates new form ElMonopolioVista
     */
    public ElMonopolioVista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMonopolio = new javax.swing.JLabel();
        jugadorPanel1 = new GUI.JugadorPanel();
        CasillaInfo = new javax.swing.JTextField();
        siguienteOperacion = new javax.swing.JTextField();
        labelOperacion = new javax.swing.JLabel();
        labelRanking = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ranking = new javax.swing.JTextArea();
        tirada = new javax.swing.JTextField();
        dadoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelMonopolio.setText("El Monopolio");

        CasillaInfo.setEditable(false);

        siguienteOperacion.setEditable(false);
        siguienteOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteOperacionActionPerformed(evt);
            }
        });

        labelOperacion.setText("Operación");

        labelRanking.setText("Ranking");

        ranking.setEditable(false);
        ranking.setColumns(20);
        ranking.setRows(5);
        jScrollPane1.setViewportView(ranking);

        dadoLabel.setText("Tirada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dadoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelOperacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(siguienteOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelMonopolio)
                            .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 694, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelRanking)
                                .addGap(73, 73, 73))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CasillaInfo)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMonopolio)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelOperacion)
                            .addComponent(siguienteOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dadoLabel)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tirada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jugadorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CasillaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelRanking)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteOperacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteOperacionActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CasillaInfo;
    private javax.swing.JLabel dadoLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.JugadorPanel jugadorPanel1;
    private javax.swing.JLabel labelMonopolio;
    private javax.swing.JLabel labelOperacion;
    private javax.swing.JLabel labelRanking;
    private javax.swing.JTextArea ranking;
    private javax.swing.JTextField siguienteOperacion;
    private javax.swing.JTextField tirada;
    // End of variables declaration//GEN-END:variables

    public void actualiza(){
        labelRanking.setVisible(false);
        ranking.setVisible(false);
        jugadorPanel1.SetJugador(juego.getJugadorActual());
        // casillaInfo.setText(juego.getTablero().getCasilla(juego.getJugadorActual().getCasillaActual()).toString())
        CasillaInfo.setText(juego.getTablero().getCasillas().get(juego.getJugadorActual().getCasillaActual()).toString());
        tirada.setText(String.valueOf(Dado.getInstance().getUltimoResultado()));
        if(juego.finalDelJuego()){
            labelRanking.setVisible(true);
            ranking.setVisible(true);
            String cadena = "";
            ArrayList<Jugador> jugadores = juego.ranking();
            int i = 0;
            for(Jugador jugador : jugadores){
                if(i == 0)
                    cadena += jugador.toString();
                else
                    cadena += "\n" + jugador.toString();
                i++;
            }
            ranking.setText(cadena);
        }
        repaint();
        revalidate();
    };
    public void pausa(){
        int val = JOptionPane.showConfirmDialog(null, "¿Continuar?", "Siguiente paso", JOptionPane.YES_NO_OPTION);
        if(val==1)
            System.exit(0);
    };
    public Respuesta comprar(){
        int opcion = 1-JOptionPane.showConfirmDialog(null, "¿Quiere comprar la calle actual?", "Compra", JOptionPane.YES_NO_OPTION);
        if(opcion == 0)
            return Respuesta.NO;
        else
            return Respuesta.SI;
    };
    public OperacionInmobiliaria elegirOperacion(){
        GestionarDialog dialog = new GestionarDialog(this);
        return OperacionInmobiliaria.values()[dialog.getGestionElegida()];
    };
    public int elegirPropiedad(){
        PropiedadDialog dialog = new PropiedadDialog(this, juego.getJugadorActual());
        return dialog.getPropiedadElegida();
    };
    public void mostrarSiguienteOperacion(OperacionJuego operacion){
        siguienteOperacion.setText(operacion.toString());
        if(operacion == OperacionJuego.AVANZAR)
            Dado.createInstance(this);
        repaint();
    };
    
    public void mostrarEventos(){
        if(!Diario.getInstance().getEventos().isEmpty()){
            DiarioDialog diarioD = new DiarioDialog(this);
        }
    };
}
