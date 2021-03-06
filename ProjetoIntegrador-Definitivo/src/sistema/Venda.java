/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;
import java.sql.*;
import javax.swing.*;
import conexao.Conexao;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 *
 * @author Rodrigo
 */
public class Venda extends javax.swing.JFrame {
    
    protected int codvenda;
    private String cpf;
    private String data;
    private String formapagamento;
    private double total;
    private double dinheirorecebido;
    private double troco;
    private int  parcelas;
    public int codproduto;
    
    
     void limpacampo(){
        jcpf.setText("");
        jdata.setText("");
        jproduto.setSelectedItem("Selecione");     
        jtotal.setText("");
        jrecebido.setText("");
        jtroco.setText("");
        jdinheiro.setSelected(false);
        jcredito.setSelected(false);
        jdebito.setSelected(false);
        jparcelas.setSelectedItem("1");
       
               
    }
    
    
    
    
    void novo(){
        jcpf.setEnabled(true);
        jproduto.setEnabled(true);
        jdata.setEnabled(true);
        jdinheiro.setEnabled(true);
        jcredito.setEnabled(true);
        jdebito.setEnabled(true);
        jtotal.setEnabled(true);
        jrecebido.setEnabled(true);       
        jtroco.setEnabled(true);        
        jcpf.requestFocus();
    }
    
     Connection conexao=null;
    PreparedStatement linguagem=null;
    ResultSet linha=null;
    
    void produto(){
        
        String sql="select produto from produtos";try{
            linguagem=conexao.prepareStatement(sql); 
            linha=linguagem.executeQuery(); 
            while(linha.next()){
                   jproduto.addItem(linha.getString("produto"));
		}
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    void cadastrar(){
        cpf=jcpf.getText();
        data=jdata.getText();
        total=Double.parseDouble(jtotal.getText());
        //dinheirorecebido=Double.parseDouble(jrecebido.getText());
        //troco=Double.parseDouble(jtroco.getText());
        parcelas=jparcelas.getSelectedIndex();
        codproduto=Integer.parseInt(jcodproduto.getText());
        
        
        String sql="insert into venda(cpf,cod_produto,data_compra,forma_pagamento,parcelas,total) values(?,?,?,?,?,?)";
         try{
            linguagem=conexao.prepareStatement(sql);
            linguagem.setString(1, cpf);
            linguagem.setString(2, String.valueOf(codproduto));
            linguagem.setString(3, data);
            linguagem.setString(4, formapagamento);
            if(jcredito.isFocusable()){
            linguagem.setString(5, String.valueOf(parcelas));}
            else{
                linguagem.setString(5, String.valueOf(""));
            }            
            linguagem.setString(6, String.valueOf(total));
            linguagem.executeUpdate();
            JOptionPane.showMessageDialog(null,"Dados Salvos");
            limpacampo();
         }
         catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    
     void pesquisar(){
        String sql="select * from venda where cpf=?";
       
        try{
            linguagem=conexao.prepareStatement(sql);
            linguagem.setString(1, jcpf.getText());
            linha=linguagem.executeQuery();
            if(linha.next()){
                jnomeproduto.setText(linha.getString("cod_produto"));
                jdata.setText(linha.getString("data_compra"));
                jforma.setText(linha.getString("forma_pagamento"));
                jtotal.setText(linha.getString("total"));
               
               
               
                
               
            }else{
                JOptionPane.showMessageDialog(null, "Dados não encontrados");
                jcpf.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
      
        
    /**
     * Creates new form Venda
     */
    public Venda() {
        initComponents();
        conexao=Conexao.conexao();
    }

        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnnovo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcpf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jproduto = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jdata = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jdinheiro = new javax.swing.JRadioButton();
        jcredito = new javax.swing.JRadioButton();
        jdebito = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jparcelas = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jtotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jrecebido = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtroco = new javax.swing.JTextField();
        btncadastrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jcodvenda = new javax.swing.JTextField();
        jcodproduto = new javax.swing.JLabel();
        btnmenu = new javax.swing.JButton();
        jforma = new javax.swing.JLabel();
        jnomeproduto = new javax.swing.JLabel();
        btntroco = new javax.swing.JButton();
        btnpesquisar = new javax.swing.JButton();
        jeditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Vendas ");
        setBackground(new java.awt.Color(255, 102, 204));
        setResizable(false);

        btnnovo.setText("Novo");
        btnnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnovoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("CPF");

        try {
            jcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jcpf.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Produto");

        jproduto.setEditable(true);
        jproduto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jproduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Bolo Simples (Pouco confeito)", "Bolo Confeitado", "Bolo Personalizado cerveja", "Cupkakes", "Mini Brownie" }));
        jproduto.setEnabled(false);
        jproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jprodutoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Data");

        try {
            jdata.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jdata.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Forma de Pagamento");

        jdinheiro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jdinheiro.setText("Dinheiro");
        jdinheiro.setEnabled(false);
        jdinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdinheiroActionPerformed(evt);
            }
        });

        jcredito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jcredito.setText("Cartão de Crédito");
        jcredito.setEnabled(false);
        jcredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcreditoActionPerformed(evt);
            }
        });

        jdebito.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jdebito.setText("Cartão de Débito");
        jdebito.setEnabled(false);
        jdebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdebitoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Parcelas");

        jparcelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
        jparcelas.setEnabled(false);
        jparcelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jparcelasActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Total");

        jtotal.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Dinheiro Recebido");

        jrecebido.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Troco");

        jtroco.setEnabled(false);

        btncadastrar.setText("Cadastrar Venda");
        btncadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadastrarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Código da Venda");

        jcodvenda.setEditable(false);

        jcodproduto.setText("jcodproduto");

        btnmenu.setText("Menu");
        btnmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmenuActionPerformed(evt);
            }
        });

        jforma.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jforma.setText("j");

        jnomeproduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jnomeproduto.setText("j");

        btntroco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btntroco.setText("Calcular Troco");
        btntroco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntrocoActionPerformed(evt);
            }
        });

        btnpesquisar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnpesquisar.setText("Pesquisar");
        btnpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarActionPerformed(evt);
            }
        });

        jeditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jeditar.setText("Editar");
        jeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(29, 29, 29)
                                .addComponent(jforma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                                .addComponent(jeditar)
                                .addGap(56, 56, 56)
                                .addComponent(btnpesquisar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdinheiro)
                                .addGap(18, 18, 18)
                                .addComponent(jcredito)
                                .addGap(18, 18, 18)
                                .addComponent(jdebito)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jparcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcodproduto)
                        .addGap(33, 33, 33)
                        .addComponent(jnomeproduto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncadastrar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnnovo)
                                .addGap(30, 30, 30))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jdata, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnmenu)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(btntroco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jcodvenda, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jrecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jtroco, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnnovo)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jcodvenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btncadastrar)
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jproduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcodproduto)
                            .addComponent(jnomeproduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnmenu))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jforma)
                    .addComponent(btnpesquisar)
                    .addComponent(jeditar))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdinheiro)
                    .addComponent(jcredito)
                    .addComponent(jdebito)
                    .addComponent(jLabel5)
                    .addComponent(jparcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jrecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jtroco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btntroco)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jprodutoActionPerformed
        String sql1="select cod_produto from produtos where produto='"+jproduto.getSelectedItem()+"'";
        try{
            linguagem=conexao.prepareStatement(sql1);
            linha=linguagem.executeQuery();
            
            while(linha.next()){
                jcodproduto.setText(linha.getString("cod_produto"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }                                 
    }//GEN-LAST:event_jprodutoActionPerformed

    private void jparcelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jparcelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jparcelasActionPerformed

    private void btnnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnovoActionPerformed
       novo();
    }//GEN-LAST:event_btnnovoActionPerformed

    private void btnmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmenuActionPerformed
        new Menu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnmenuActionPerformed

    private void jdinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdinheiroActionPerformed
        formapagamento="dinheiro";
        jparcelas.setEnabled(false);
        jcredito.setSelected(false);
        jdebito.setSelected(false);
    }//GEN-LAST:event_jdinheiroActionPerformed

    private void jcreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcreditoActionPerformed
        formapagamento="cartão de crédito";
        jparcelas.setEnabled(true);
        jdebito.setSelected(false);
        jdinheiro.setSelected(false);
    }//GEN-LAST:event_jcreditoActionPerformed

    private void jdebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdebitoActionPerformed
        formapagamento="débito";
        jcredito.setSelected(false);
        jdinheiro.setSelected(false);
    }//GEN-LAST:event_jdebitoActionPerformed

    private void btncadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadastrarActionPerformed
        cadastrar();
    }//GEN-LAST:event_btncadastrarActionPerformed

    private void btntrocoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntrocoActionPerformed
       double total=Double.parseDouble(jtotal.getText());
       double recebido=Double.parseDouble(jrecebido.getText());
       double troco=recebido-total;
       jtroco.setText(String.valueOf(troco));//converte valores em String
       
    }//GEN-LAST:event_btntrocoActionPerformed

    private void btnpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarActionPerformed
        pesquisar();
    }//GEN-LAST:event_btnpesquisarActionPerformed

    private void jeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeditarActionPerformed
        try{
      Class.forName("com.mysql.jdbc.Driver");
    Connection conexao=DriverManager.getConnection
            ("jdbc:mysql://localhost/sistema_loja","root","");
    Statement sql=conexao.createStatement();
         
         
         String cpf=jcpf.getText();
         String data=jdata.getText();
         double total=Double.parseDouble(jtotal.getText());
         
         int registro=sql.executeUpdate("update venda set cpf='"+cpf+"',data_compra='"+data+"',total='"+total+"',forma_pagamento='"+formapagamento+"' where cpf='"+cpf+"'");
         
         if(registro!=0){
         JOptionPane.showMessageDialog(null, "dados atualizados","confirmação",JOptionPane.INFORMATION_MESSAGE);
         limpacampo();
         }
          
         else{
         
              JOptionPane.showMessageDialog(null, "erro ao atualizar","atenção",JOptionPane.ERROR);
         }
         
         }catch(ClassNotFoundException e){
      JOptionPane.showMessageDialog(null, "erro no driver"+e.getMessage());
      
      }catch(SQLException e){
     JOptionPane.showMessageDialog(null, "erro no comando sql"+e.getMessage());
     
      }
                 
                 
   
    }//GEN-LAST:event_jeditarActionPerformed

        
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
    produto();
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
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncadastrar;
    private javax.swing.JButton btnmenu;
    private javax.swing.JButton btnnovo;
    private javax.swing.JButton btnpesquisar;
    private javax.swing.JButton btntroco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jcodproduto;
    private javax.swing.JTextField jcodvenda;
    private javax.swing.JFormattedTextField jcpf;
    private javax.swing.JRadioButton jcredito;
    private javax.swing.JFormattedTextField jdata;
    private javax.swing.JRadioButton jdebito;
    private javax.swing.JRadioButton jdinheiro;
    private javax.swing.JButton jeditar;
    private javax.swing.JLabel jforma;
    private javax.swing.JLabel jnomeproduto;
    private javax.swing.JComboBox jparcelas;
    private javax.swing.JComboBox jproduto;
    private javax.swing.JTextField jrecebido;
    private javax.swing.JTextField jtotal;
    private javax.swing.JTextField jtroco;
    // End of variables declaration//GEN-END:variables
}
