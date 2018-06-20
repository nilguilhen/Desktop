
package UI;

import Controller.ConexaoBD;
import Model.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Conta;


public class GeraConta extends javax.swing.JFrame {
    
    ConexaoBD banco = new ConexaoBD();
    ResultSet rsdadoscliente,rscontas;
    Conta conta;


    public GeraConta() {
        initComponents();
    }
    
    public Conta pegarCampo() throws SQLException {
        Conta gc = new Conta();
        rsdadoscliente = banco.consultaCliente();
        
        gc.setCPF(rsdadoscliente.getString("Cli_CPF"));
        gc.setKwh(campoKWH.getText());
        gc.setValor(String.valueOf(valorTarifa()));
        
        return gc;
    }

    
    public float valorTarifa(){
        Float resultado = null;
        try {
            resultado = Float.parseFloat(rscontas.getString("Conc_Tarifa")) * Float.parseFloat(campoKWH.getText());
        } catch (SQLException ex) {
            Logger.getLogger(GeraConta.class.getName()).log(Level.SEVERE, null, ex);
        }

    return resultado;
    }
    
    private void primeiroRegistro(){  
        rsdadoscliente = banco.consultaCliente();
        try {
            if (rsdadoscliente != null) {
                if (!rsdadoscliente.isFirst()) {
                    rsdadoscliente.first();;
                    ExibeRegistroConta(rsdadoscliente);                 
                } else {
                    JOptionPane.showMessageDialog(this, "Primeiro cliente ja mostrado");
                }
            }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }
    
    public void ultimoRegistro() {
        try {
            if (rsdadoscliente != null) {
                if (!rsdadoscliente.isLast()) {
                    rsdadoscliente.last();
                    ExibeRegistroConta(rsdadoscliente);
                } else {
                    JOptionPane.showMessageDialog(this, "O ultimo registro ja esta selecionado.");
                }
            }
        } catch (SQLException erro) {
            System.out.println(erro);
        }
    }
    
    
    public void ExibeRegistroConta(ResultSet rs) {
        try {
        campoCPF.setText(rs.getString("Cli_CPF"));
        campoKWH.setText(campoKWH.getText());
        campoValor.setText(String.valueOf(valorTarifa()));
        } catch (SQLException err) {
            System.out.println(err);
        }
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bCadastrar = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bDeletar = new javax.swing.JButton();
        labelKWH = new javax.swing.JLabel();
        bVoltar = new javax.swing.JButton();
        campoValor = new javax.swing.JTextField();
        labelValor = new javax.swing.JLabel();
        campoKWH = new javax.swing.JTextField();
        labelTittle = new javax.swing.JLabel();
        bLimpar = new javax.swing.JButton();
        campoCPF = new javax.swing.JTextField();
        labelCPF = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        labelKWH.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelKWH.setText("Kw/h");

        bVoltar.setText("Home");
        bVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVoltarActionPerformed(evt);
            }
        });

        labelValor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelValor.setText("Valor");

        labelTittle.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        labelTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTittle.setText("Gera Conta");

        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        campoCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCPFActionPerformed(evt);
            }
        });

        labelCPF.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCPF.setText("CPF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelTittle)
                .addGap(173, 173, 173))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCPF)
                                .addGap(18, 18, 18)
                                .addComponent(campoCPF))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelKWH)
                        .addGap(18, 18, 18)
                        .addComponent(campoKWH, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bLimpar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(labelTittle)
                .addGap(42, 42, 42)
                .addComponent(bLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCadastrar)
                    .addComponent(labelCPF)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(bAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bVoltar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelValor))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelKWH)
                        .addComponent(campoKWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed

        try {
            conta = pegarCampo();
        } catch (SQLException ex) {
            Logger.getLogger(GeraConta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //banco.cadastroConce(cc);
        rsdadoscliente = banco.consultaCliente();
        try {
            rscontas = banco.pegaTarifa(rsdadoscliente.getString("Cli_CPF"));
        } catch (SQLException ex) {
            Logger.getLogger(GeraConta.class.getName()).log(Level.SEVERE, null, ex);
        }
        ExibeRegistroConta(rscontas);
        
        banco.cadastroConta(conta);
        primeiroRegistro();

        
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed

//        cc = pegarCampo();
//        banco.alteraConce(cc);
//        primeiroRegistro();
//        JOptionPane.showMessageDialog(this, "Fornecedor(a) " + campoNome.getText() + " foi alterada com sucesso!");
    }//GEN-LAST:event_bAlterarActionPerformed

    private void bDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarActionPerformed

//        try {
//            banco.excluiConce(rsdadosconce.getString("Conc_CNPJ"));
//        } catch (SQLException ex) {
//            Logger.getLogger(CadastrarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        JOptionPane.showMessageDialog(null, "Removido!");
//        limparCampos();
//        rsdadosconce = banco.consultaConce();
//        primeiroRegistro();
    }//GEN-LAST:event_bDeletarActionPerformed

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new CadastrarCliente().setVisible(true);
    }//GEN-LAST:event_bVoltarActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
        // TODO add your handling code here:
        //limparCampos();
    }//GEN-LAST:event_bLimparActionPerformed

    private void campoCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCPFActionPerformed

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
            java.util.logging.Logger.getLogger(GeraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeraConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeraConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bDeletar;
    private javax.swing.JButton bLimpar;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField campoCPF;
    private javax.swing.JTextField campoKWH;
    private javax.swing.JTextField campoValor;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelKWH;
    private javax.swing.JLabel labelTittle;
    private javax.swing.JLabel labelValor;
    // End of variables declaration//GEN-END:variables
}
