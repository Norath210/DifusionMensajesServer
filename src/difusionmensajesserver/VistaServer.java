/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package difusionmensajesserver;

import clases.GrupoMensaje;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Castelao
 */
public class VistaServer extends javax.swing.JFrame {

    GrupoMensaje grupoEnvio;
    MulticastSocket ms;

    public VistaServer() {
        initComponents();
        try {
            ms = new MulticastSocket();
        } catch (IOException ex) {
            Logger.getLogger(VistaServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<GrupoMensaje> gmList = new ArrayList<>();
        gmList.add(new GrupoMensaje("230.1.4.1", "Ventas"));
        gmList.add(new GrupoMensaje("230.1.4.2", "Admin"));
        gmList.add(new GrupoMensaje("230.1.4.3", "Informáticos"));
        
        cBoxGrupo.setModel(new DefaultComboBoxModel(gmList.toArray()));
        grupoEnvio = (GrupoMensaje)cBoxGrupo.getSelectedItem();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cBoxGrupo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMensaje = new javax.swing.JTextArea();
        btnEnvio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cBoxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cBoxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBoxGrupoActionPerformed(evt);
            }
        });

        txtMensaje.setColumns(20);
        txtMensaje.setRows(5);
        txtMensaje.setBorder(javax.swing.BorderFactory.createTitledBorder("Mensaje"));
        jScrollPane1.setViewportView(txtMensaje);

        btnEnvio.setText("Enviar");
        btnEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEnvio)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBoxGrupo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(460, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cBoxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnvio)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBoxGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBoxGrupoActionPerformed
        grupoEnvio = (GrupoMensaje) cBoxGrupo.getSelectedItem();
        txtMensaje.setText("");
    }//GEN-LAST:event_cBoxGrupoActionPerformed

    private void btnEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvioActionPerformed
        try {
            InetAddress destinoMultiCast = InetAddress.getByName(grupoEnvio.getDireccion());
            ms.setTimeToLive(01);
            DatagramPacket dp;
            byte[] mensaje;
            mensaje = (txtMensaje.getText()).getBytes();
            dp = new DatagramPacket(mensaje, mensaje.length, destinoMultiCast, 22222);
            ms.send(dp);
        } catch (IOException ex) {
            Logger.getLogger(VistaServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnEnvioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnvio;
    private javax.swing.JComboBox<String> cBoxGrupo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMensaje;
    // End of variables declaration//GEN-END:variables
}
