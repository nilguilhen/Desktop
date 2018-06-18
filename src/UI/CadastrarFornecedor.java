package UI;

import Controller.ConexaoBD;

import Model.Concessionaria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class CadastrarFornecedor extends javax.swing.JFrame {

    ConexaoBD banco = new ConexaoBD();
    ResultSet rsdados;
    Concessionaria cc;
    

    public CadastrarFornecedor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campoNome = new javax.swing.JTextField();
        labelRua = new javax.swing.JLabel();
        campoRua = new javax.swing.JTextField();
        labelNumero = new javax.swing.JLabel();
        campoNumero = new javax.swing.JTextField();
        labelCNPJ = new javax.swing.JLabel();
        campoCNPJ = new javax.swing.JTextField();
        bLimpar = new javax.swing.JButton();
        labelComplemento = new javax.swing.JLabel();
        campoComplemento = new javax.swing.JTextField();
        labelCidade = new javax.swing.JLabel();
        campoCidade = new javax.swing.JTextField();
        labelCEP = new javax.swing.JLabel();
        campoCEP = new javax.swing.JTextField();
        labelEstado = new javax.swing.JLabel();
        campoEstado = new javax.swing.JTextField();
        labelPais = new javax.swing.JLabel();
        campoPais = new javax.swing.JTextField();
        labelTarifa = new javax.swing.JLabel();
        campoTarifa = new javax.swing.JTextField();
        bCadastrar = new javax.swing.JButton();
        bAlterar = new javax.swing.JButton();
        bDeletar = new javax.swing.JButton();
        bVoltar = new javax.swing.JButton();
        bProximo = new javax.swing.JButton();
        bAnterior = new javax.swing.JButton();
        labelTittle = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        campoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeActionPerformed(evt);
            }
        });

        labelRua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelRua.setText("Rua");

        labelNumero.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNumero.setText("Número");

        labelCNPJ.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCNPJ.setText("CNPJ");

        bLimpar.setText("Limpar");
        bLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimparActionPerformed(evt);
            }
        });

        labelComplemento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelComplemento.setText("Complemento");

        labelCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCidade.setText("Cidade");

        labelCEP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelCEP.setText("CEP");

        labelEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelEstado.setText("Estado");

        labelPais.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelPais.setText("País");

        labelTarifa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelTarifa.setText("Tarífa");

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

        labelTittle.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        labelTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTittle.setText("Dados Concessionária");

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelNome.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelComplemento)
                            .addComponent(labelCidade)
                            .addComponent(labelCEP)
                            .addComponent(labelEstado)
                            .addComponent(labelPais)
                            .addComponent(labelCNPJ))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(campoPais)
                            .addComponent(campoEstado)
                            .addComponent(campoCidade)
                            .addComponent(campoComplemento)
                            .addComponent(campoCEP))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bProximo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bAnterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRua)
                            .addComponent(labelNome)
                            .addComponent(labelNumero))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                            .addComponent(campoRua)
                            .addComponent(campoNome, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(34, 34, 34)
                        .addComponent(bLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTarifa)
                .addGap(64, 64, 64)
                .addComponent(campoTarifa)
                .addGap(117, 117, 117))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(labelTittle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(labelTittle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRua)
                    .addComponent(campoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNumero)
                    .addComponent(campoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelComplemento)
                    .addComponent(campoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCidade)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDeletar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCEP)
                    .addComponent(campoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bVoltar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEstado)
                    .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bProximo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPais)
                    .addComponent(campoPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAnterior))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCNPJ)
                    .addComponent(campoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTarifa)
                    .addComponent(campoTarifa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 65, Short.MAX_VALUE))
        );

        setBounds(0, 0, 512, 455);
    }// </editor-fold>//GEN-END:initComponents

    public void limparCampos() {
        campoCEP.setText("");
        campoCNPJ.setText("");
        campoCidade.setText("");
        campoComplemento.setText("");
        campoEstado.setText("");
        campoTarifa.setText("");
        campoNome.setText("");
        campoNumero.setText("");
        campoPais.setText("");
        campoRua.setText("");
    }

    public Concessionaria pegarCampo() {
        Concessionaria c = new Concessionaria();
        c.setNome(campoNome.getText());
        c.setCnpj(campoCNPJ.getText());
        c.setTarifa(Integer.parseInt(campoTarifa.getText()));
        c.setRua(campoRua.getText());
        c.setNumero(Integer.parseInt(campoNumero.getText()));
        c.setComplemento(campoComplemento.getText());
        c.setCidade(campoCidade.getText());
        c.setCep(campoCEP.getText());
        c.setEstado(campoEstado.getText());
        c.setPais(campoPais.getText());

        return c;
    }

    
        public void ExibeRegistro(ResultSet rs) {
        try {
            //faz a leitura do registro corrento do ResutSet e atribui os valores lidos aos objetos visuais (Textfields)
            campoNome.setText(rs.getString("conc_nome"));
            campoCNPJ.setText(rs.getString("conc_cnpj"));
            campoTarifa.setText(rs.getString("conc_tarifa"));

        } catch (Exception erro) {
            System.out.println(erro);
        }
    }    

    private void campoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeActionPerformed

    private void bLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimparActionPerformed
        // TODO add your handling code here:
        limparCampos();
    }//GEN-LAST:event_bLimparActionPerformed

    private void bCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCadastrarActionPerformed
        
        cc = new Concessionaria();
        banco.cadastroConce(cc);
        
        rsdados = banco.consultaConce();
        
         try {
            if (rsdados != null) {
                if (!rsdados.isLast()) {
                    rsdados.last();
                    ExibeRegistro(rsdados);
                } else {
                    JOptionPane.showMessageDialog(this, "O ultimo registro ja esta selecionado.");
                }
            }
        } catch (Exception erro) {
            System.out.println(erro);
        }
        JOptionPane.showMessageDialog(null, "Concessionaria cadastrada!");
    }//GEN-LAST:event_bCadastrarActionPerformed

    private void bVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new Principal().setVisible(true);
    }//GEN-LAST:event_bVoltarActionPerformed

    private void bProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProximoActionPerformed
      
        try {
            if (rsdados != null) {
                if (!rsdados.isLast()) {
                    rsdados.next();
                    ExibeRegistro(rsdados);
                } else {
                    JOptionPane.showMessageDialog(this, "Nao existe proximo elemento.");
                }
            }
        } catch (Exception erro) {
            System.out.println(erro);
        }
        
    }//GEN-LAST:event_bProximoActionPerformed

    private void bAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnteriorActionPerformed

        
        try {
            if (rsdados != null) {
                if (!rsdados.isFirst()) {
                    rsdados.previous();
                    ExibeRegistro(rsdados);
                } else {
                    JOptionPane.showMessageDialog(this, "Nao existe registro anterior.");
                }
            }
        } catch (Exception erro) {
            System.out.println(erro);
        }
        
        
    }//GEN-LAST:event_bAnteriorActionPerformed

    private void bAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAlterarActionPerformed

    
    }//GEN-LAST:event_bAlterarActionPerformed

    private void bDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeletarActionPerformed

        
        try {
            banco.excluiConce(rsdados.getString("conc_cnpj"));
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        
        JOptionPane.showMessageDialog(null, "Removido!");
        limparCampos();

    }//GEN-LAST:event_bDeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlterar;
    private javax.swing.JButton bAnterior;
    private javax.swing.JButton bCadastrar;
    private javax.swing.JButton bDeletar;
    private javax.swing.JButton bLimpar;
    private javax.swing.JButton bProximo;
    private javax.swing.JButton bVoltar;
    private javax.swing.JTextField campoCEP;
    private javax.swing.JTextField campoCNPJ;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JTextField campoEstado;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNumero;
    private javax.swing.JTextField campoPais;
    private javax.swing.JTextField campoRua;
    private javax.swing.JTextField campoTarifa;
    private javax.swing.JLabel labelCEP;
    private javax.swing.JLabel labelCNPJ;
    private javax.swing.JLabel labelCidade;
    private javax.swing.JLabel labelComplemento;
    private javax.swing.JLabel labelEstado;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelPais;
    private javax.swing.JLabel labelRua;
    private javax.swing.JLabel labelTarifa;
    private javax.swing.JLabel labelTittle;
    // End of variables declaration//GEN-END:variables
}
