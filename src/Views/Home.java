package Views;

import desktop.Teste;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Ian Fraga Bitar e Nilton Guilhen
 */
public class Home extends javax.swing.JFrame {

    ArrayList<Teste> testeArray = new ArrayList();

    ArrayList<JTextArea> jtextArray = new ArrayList();

    private JTabbedPane tp = new JTabbedPane();

    public Home() {

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        FIle = new javax.swing.JMenu();
        abrir = new javax.swing.JMenuItem();
        salvar = new javax.swing.JMenuItem();
        salvarComo = new javax.swing.JMenuItem();
        sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        FIle.setText("File");

        abrir.setText("Abrir");
        abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirActionPerformed(evt);
            }
        });
        FIle.add(abrir);

        salvar.setText("Salvar");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });
        FIle.add(salvar);

        salvarComo.setText("Salvar Como");
        salvarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarComoActionPerformed(evt);
            }
        });
        FIle.add(salvarComo);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        FIle.add(sair);

        jMenuBar1.add(FIle);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirActionPerformed

        tp.setSize(416, 305);
        this.add(tp);
        Teste test = new Teste();

        test.setEntrada(test.abrirarquivo());

        if (test.getEntrada() != null) {
            criaAba(test);
        }

    }//GEN-LAST:event_abrirActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed

        if (tp.getSelectedIndex() == 0) {

            testeArray.get(0).Salvar(jtextArray.get(tp.getSelectedIndex()).getText(), false, testeArray.get(0).getArquivo());

        } else {
            testeArray.get(tp.getSelectedIndex()).Salvar(jtextArray.get(tp.getSelectedIndex() - 1).getText(), false, testeArray.get(tp.getSelectedIndex()).getArquivo());
        }

    }//GEN-LAST:event_salvarActionPerformed

    private void salvarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarComoActionPerformed
        // TODO add your handling code here:
        
        if (tp.getSelectedIndex() == 0) {

            testeArray.get(0).escreveComo(jtextArray.get(tp.getSelectedIndex()).getText(), false);

        } else {
            testeArray.get(tp.getSelectedIndex()).escreveComo(jtextArray.get(tp.getSelectedIndex() - 1).getText(), false);
        }
    }//GEN-LAST:event_salvarComoActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    public void criaAba(Teste t) {
        JTextArea txt = new JTextArea();
        txt.setText(t.Le());
        jtextArray.add(txt);
        testeArray.add(t);
        tp.addTab(t.getArquivo().getName(), txt);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu FIle;
    private javax.swing.JMenuItem abrir;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem sair;
    private javax.swing.JMenuItem salvar;
    private javax.swing.JMenuItem salvarComo;
    // End of variables declaration//GEN-END:variables
}
