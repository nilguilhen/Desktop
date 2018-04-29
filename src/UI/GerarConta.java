/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controller.ContaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ian Fraga Bitar
 */
public class GerarConta extends javax.swing.JFrame {

    /**
     * Creates new form GerarConta
     */
    public GerarConta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitulo = new javax.swing.JLabel();
        labelInformarCPF = new javax.swing.JLabel();
        labelInformarKWH = new javax.swing.JLabel();
        campocontaCPF = new javax.swing.JTextField();
        campocontaKWH = new javax.swing.JTextField();
        bGerar = new javax.swing.JButton();
        bSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        labelTitulo.setText("Conta de Energia");

        labelInformarCPF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelInformarCPF.setText("Informe seu cpf:");

        labelInformarKWH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelInformarKWH.setText("Informe seu Kwh/mes:");

        bGerar.setText("Gerar Conta");
        bGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGerarActionPerformed(evt);
            }
        });

        bSair.setText("Sair");
        bSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelInformarKWH)
                    .addComponent(labelInformarCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitulo)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bGerar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSair))
                        .addComponent(campocontaKWH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                        .addComponent(campocontaCPF, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInformarCPF)
                    .addComponent(campocontaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelInformarKWH)
                    .addComponent(campocontaKWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bGerar)
                    .addComponent(bSair))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        setBounds(0, 0, 475, 349);
    }// </editor-fold>//GEN-END:initComponents

    private void bSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Principal().setVisible(true);
    }//GEN-LAST:event_bSairActionPerformed

    private void bGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGerarActionPerformed
        // TODO add your handling code here:
        ContaController cc = new ContaController();
        try {
            if (cc.geraConta(campocontaCPF.getText(), (Float.parseFloat(campocontaKWH.getText()))) == 0) {
                JOptionPane.showMessageDialog(rootPane, "Erro!");
            } else
                JOptionPane.showMessageDialog(rootPane, cc.geraConta(campocontaCPF.getText(), (Float.parseFloat(campocontaKWH.getText()))));
                        
        } catch (Exception ex) {
            Logger.getLogger(GerarConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bGerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bGerar;
    private javax.swing.JButton bSair;
    private javax.swing.JTextField campocontaCPF;
    private javax.swing.JTextField campocontaKWH;
    private javax.swing.JLabel labelInformarCPF;
    private javax.swing.JLabel labelInformarKWH;
    private javax.swing.JLabel labelTitulo;
    // End of variables declaration//GEN-END:variables
}
