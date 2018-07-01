package UI;

import Controller.ConexaoBD;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Principal extends javax.swing.JFrame {
    /**
     * Creates new form Principal
     */
    
    ConexaoBD banco = new ConexaoBD();
    
    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bChamarCliente = new javax.swing.JButton();
        bChamarConcessionaria = new javax.swing.JButton();
        bChamarCliente1 = new javax.swing.JButton();
        bChamarConcessionaria1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bChamarCliente.setText(" Cliente");
        bChamarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChamarClienteActionPerformed(evt);
            }
        });

        bChamarConcessionaria.setText("Concesionaria");
        bChamarConcessionaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChamarConcessionariaActionPerformed(evt);
            }
        });

        bChamarCliente1.setText("Relatório de Clientes");
        bChamarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChamarCliente1ActionPerformed(evt);
            }
        });

        bChamarConcessionaria1.setText("Relatório de Concesionarias");
        bChamarConcessionaria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChamarConcessionaria1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bChamarConcessionaria1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bChamarCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bChamarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bChamarConcessionaria, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(bChamarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bChamarCliente1)
                .addGap(42, 42, 42)
                .addComponent(bChamarConcessionaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bChamarConcessionaria1)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        setBounds(0, 0, 416, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void bChamarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChamarClienteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new CadastrarCliente().setVisible(true);
    }//GEN-LAST:event_bChamarClienteActionPerformed

    private void bChamarConcessionariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChamarConcessionariaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new CadastrarFornecedor().setVisible(true);
    }//GEN-LAST:event_bChamarConcessionariaActionPerformed

    private void bChamarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChamarCliente1ActionPerformed
        // TODO add your handling code here:
        visualizarRelatorio(null, rCliente);
    }//GEN-LAST:event_bChamarCliente1ActionPerformed

    private void bChamarConcessionaria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChamarConcessionaria1ActionPerformed
        // TODO add your handling code here:
        visualizarRelatorio(null, rConcessionaria);
    }//GEN-LAST:event_bChamarConcessionaria1ActionPerformed

    
        private void visualizarRelatorio(Map params, String relatorio){
    //  Foi criada uma thread caso o banco esteja muito lotado a thread não deixa o programa travado
        new Thread() {
            @Override
            public void run() {
                JasperPrint impressao;
                Connection conn = null;    
                try {
                    conn = banco.getConexao();
                    impressao = JasperFillManager.fillReport(
                            relatorio, params, conn);

                    JasperViewer.viewReport(impressao,false);
                } catch (JRException ex) {
                    System.err.println("Não foi possível exportar o relatório.\n\n");
                    ex.printStackTrace();
                } catch (Exception ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            }
	}.start();
    }
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bChamarCliente;
    private javax.swing.JButton bChamarCliente1;
    private javax.swing.JButton bChamarConcessionaria;
    private javax.swing.JButton bChamarConcessionaria1;
    // End of variables declaration//GEN-END:variables

    private static final String rCliente = 
            System.getProperty("user.dir")+"/src/relatorios/reportClientes.jasper";
    private static final String rConcessionaria = 
            System.getProperty("user.dir")+"/src/relatorios/reportConcessionaria.jasper";

}
