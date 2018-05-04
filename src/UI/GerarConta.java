package UI;

import Controller.ClienteController;
import Controller.ConcessionariaController;
import Controller.ContaController;
import Model.Cliente;
import Model.Concessionaria;
import Model.ContaEnergia;
import java.util.ArrayList;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class GerarConta extends javax.swing.JFrame {

    private int aux = -1;
    private ContaController contaController = null;
    private ArrayList<ContaEnergia> contas = new ArrayList();
    private File diretorio = null;

    public GerarConta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCPF = new javax.swing.JLabel();
        labelKWH = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        campoCpf = new javax.swing.JTextField();
        campoValor = new javax.swing.JTextField();
        campoKwh = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bDeletar = new javax.swing.JButton();
        bVoltar = new javax.swing.JButton();
        bProximo = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();
        bLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelCPF.setText("Cpf:");

        labelKWH.setText("Khw/mês:");

        labelValor.setText("Valor da conta:");

        campoCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCpfActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(bLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCPF)
                            .addComponent(labelKWH)
                            .addComponent(labelValor))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoCpf)
                            .addComponent(campoKwh)
                            .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bProximo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(bLimpar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bProximo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bAnterior))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCPF)
                            .addComponent(campoCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelKWH)
                            .addComponent(campoKwh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelValor)
                            .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        setBounds(0, 0, 466, 358);
    }// </editor-fold>//GEN-END:initComponents

    public Cliente clienteSelecionado() {
        //seleciona o cliente pelo cpf, para acharmos o estado dele e comparar com a conc e pegar a tarifa
        ClienteController cc = new ClienteController();
        File dir = new File("C:\\Users\\NiltonGuilhen\\Documents\\GitHub\\Desktop\\Arquivos\\Clientes");
        ObjectInputStream leitor = cc.CriaLeitorBinario(dir);
        ArrayList<Cliente> clientes = cc.carregaClientes(leitor);

        Cliente cliSelecionado = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(campoCpf.getText())) {
                cliSelecionado = clientes.get(i);
            }
        }
        return cliSelecionado;
    }

    public Concessionaria concessionariaSelecionado() {
        //estado que tem o estado igual do cliente
        ConcessionariaController cc = new ConcessionariaController();
        File dir = new File("C:\\Users\\NiltonGuilhen\\Documents\\GitHub\\Desktop\\Arquivos\\Conc");
        ObjectInputStream leitor = cc.CriaLeitorBinario(dir);
        ArrayList<Concessionaria> concessionarias = cc.carregaConcessionarias(leitor);

        Concessionaria concSelecionado = null;
        Cliente cliente = clienteSelecionado();
        for (int i = 0; i < concessionarias.size(); i++) {
            if (concessionarias.get(i).getEndereco().getEstado().equals(cliente.getEndereco().getEstado())) {
                concSelecionado = concessionarias.get(i);
            }
        }
        return concSelecionado;
    }

    public ContaEnergia pegarCampo(ContaEnergia c) {
        Concessionaria concSelecionado = concessionariaSelecionado();
        c.setCpf(campoCpf.getText());
        c.setKwh(Float.parseFloat(campoKwh.getText()));
        c.setValor((concSelecionado.getTarifa()) * (Float.parseFloat(campoKwh.getText())));

        return c;
    }

    public void limparCampos() {
        campoCpf.setText("");
        campoKwh.setText("");
        campoValor.setText("");
    }
    private void campoCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoCpfActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        aux++;
        //cadastrar o cliente no controlador de cliente

        if (diretorio == null) {
            contaController = new ContaController();
            diretorio = contaController.selecionaArquivo();
            ObjectOutputStream escritaBinario = contaController.CriaEscritorBinario(diretorio, false);

            ContaEnergia c = new ContaEnergia();
            c = pegarCampo(c);//setar todos os atributos do cliente
            contaController.setArray(c);
            contaController.EscreveObjeto(escritaBinario, contaController.getArray(), true);
            limparCampos();

        } else {
            //diretorio = clienteControle.selecionaArquivo();
            ObjectOutputStream escritaBinario = contaController.CriaEscritorBinario(diretorio, false);

            ContaEnergia c = new ContaEnergia();
            c = pegarCampo(c);//setar todos os atributos do cliente
            contaController.setArray(c);
            contaController.EscreveObjeto(escritaBinario, contaController.getArray(), true);
            limparCampos();// limpar  todos os campos
        }

        JOptionPane.showMessageDialog(null, "Conta gerada!");


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

        if (diretorio == null) {
            aux = 0;
            contaController = new ContaController();
            diretorio = contaController.selecionaArquivo();

            ObjectInputStream leitor = contaController.CriaLeitorBinario(diretorio);
            contas = contaController.carregaContas(leitor);

            campoCpf.setText(contas.get(aux).getCpf());
            campoKwh.setText(String.valueOf(contas.get(aux).getKwh()));
            campoValor.setText(String.valueOf(contas.get(aux).getValor()));
        } else if (aux < contas.size() - 1) {
            aux++;
            contaController = new ContaController();
            ObjectInputStream leitor = contaController.CriaLeitorBinario(diretorio);
            contas = contaController.carregaContas(leitor);

            campoCpf.setText(contas.get(aux).getCpf());
            campoKwh.setText(String.valueOf(contas.get(aux).getKwh()));
            campoValor.setText(String.valueOf(contas.get(aux).getValor()));
        }
    }//GEN-LAST:event_bProximoActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed


    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed

        limparCampos();
    }//GEN-LAST:event_bLimparActionPerformed

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
            java.util.logging.Logger.getLogger(GerarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerarConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerarConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bDeletar;
    private javax.swing.JButton bLimpar;
    private javax.swing.JButton bProximo;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField campoCpf;
    private javax.swing.JTextField campoKwh;
    private javax.swing.JTextField campoValor;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelKWH;
    private javax.swing.JLabel labelValor;
    // End of variables declaration//GEN-END:variables
}
