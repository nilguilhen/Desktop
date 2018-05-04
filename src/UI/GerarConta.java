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

    float resultado = 0;
    
    public GerarConta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        labelTitulo = new javax.swing.JLabel();
        labelInformarCPF = new javax.swing.JLabel();
        labelInformarKWH = new javax.swing.JLabel();
        campocontaCPF = new javax.swing.JTextField();
        campocontaKWH = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bDeletar = new javax.swing.JButton();
        bVoltar = new javax.swing.JButton();
        bProximo = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();
        bLimpar = new javax.swing.JButton();
        campoValor = new javax.swing.JTextField();
        labelValor = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelTitulo.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        labelTitulo.setText("Conta de Energia");

        labelInformarCPF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelInformarCPF.setText("Informe seu cpf:");

        labelInformarKWH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelInformarKWH.setText("Informe seu Kwh/mes:");

        bCadastrar.setText("Cadastrar");
        bCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCadastrarActionPerformed(evt);
            }
        });

        bAlterar.setText("Alterar");
        bAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAlterarActionPerformed(evt);
            }
        });

        bDeletar.setText("Deletar");
        bDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeletarActionPerformed(evt);
            }
        });

        bVoltar.setText("Home");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        bProximo.setText("Próximo");
        bProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProximoActionPerformed(evt);
            }
        });

        bAnterior.setText("Anterior");
        bAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnteriorActionPerformed(evt);
            }
        });

        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        labelValor.setText("Valor da Conta:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("O valor da conta é gerado após ser cadastrado os dados\nNÃO É POSSIVEL ALTERAR OU DELETAR O VALOR DA CONTA\nPARA ALTERAR O VALOR, NECESSARIO ALTERAR O KWH.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campocontaCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(campocontaKWH)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelInformarCPF)
                            .addComponent(labelValor)
                            .addComponent(labelInformarKWH))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitulo)
                            .addComponent(campoValor, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bProximo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addGap(47, 47, 47)
                        .addComponent(labelInformarCPF))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bLimpar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bDeletar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bVoltar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bProximo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bAnterior)
                                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(campocontaCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelInformarKWH)
                                    .addComponent(campocontaKWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addComponent(labelValor)
                                .addGap(9, 9, 9)))))
                .addGap(31, 31, 31)
                .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 523, 383);
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
      
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed

    }//GEN-LAST:event_bAlterarActionPerformed

    private void bDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarActionPerformed


    }//GEN-LAST:event_bDeletarActionPerformed

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Principal().setVisible(true);
    }//GEN-LAST:event_bVoltarActionPerformed

    private void bProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProximoActionPerformed
    
    }//GEN-LAST:event_bProximoActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed

    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed

    }//GEN-LAST:event_bLimparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bDeletar;
    private javax.swing.JButton bLimpar;
    private javax.swing.JButton bProximo;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField campoValor;
    private javax.swing.JTextField campocontaCPF;
    private javax.swing.JTextField campocontaKWH;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelInformarCPF;
    private javax.swing.JLabel labelInformarKWH;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelValor;
    // End of variables declaration//GEN-END:variables
}
