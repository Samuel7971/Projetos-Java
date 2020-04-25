/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filacadastrotela.filacadastrofilme;

import javafx.beans.binding.Bindings;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel
 */
public class TelaCadastroFilme extends javax.swing.JFrame {

    private Queue f;
    private Filme filme;
    
    public TelaCadastroFilme() {
        initComponents();
        f = new Queue(5);
    }
    
    public void limpar(){
        txtTitulo.setText("");
        txtPais.setText("");
        txtGenero.setText("");
        txtDiretor.setText("");
        txtAno.setText("");
        txtTitulo.requestFocus();
    }
    
    public void verificarCampos(){
        JOptionPane.showMessageDialog(null, "Todo os campos devem ser preenchidos!");
    }
    
    public void avisoFilaCheia(){
        JOptionPane.showMessageDialog(null, "Fila Cheia!");
        txtArea.setText("");
    }
    
    public void avisoFilaVazia(){
        JOptionPane.showMessageDialog(null, "Fila Vazia!");
        txtArea.setText("");
    }
     // Enqueue fila de filme inserção manual;
    public void enqueue(){
        if (!f.isFull()) {
            f.enqueue(filme = new Filme("Um Sonho de Liberdade", "Frank Darabont", "Drama", "EUA", 1994));
            f.enqueue(filme = new Filme("Rede social", "Davin Ficher", "Drama", "EUA", 2010));
            f.enqueue(filme = new Filme("Avengers", "Anthony Russo(I), Joe Russo(I)", "Ação", "EUA", 2019));
            f.enqueue(filme = new Filme("O jogo da imitação", "Morten Tyldum", "Drama", "Inglaterra", 2014));
            f.enqueue(filme = new Filme("O Auto da Compadecida", "Guel Arraes", "Aventura", "Brasil", 2000));
            txtArea.setText("Foi inserido na fila filme: \n\n" + filme.toString());
        }
    }
      // Enqueue fila de filme inserção pela tela;
//    public void enqueue(){
//        if (!f.isFull()) {
//            try {
//                filme = new Filme();
//                filme.setTitulo(txtTitulo.getText());
//                filme.setDiretor(txtDiretor.getText());
//                filme.setGenero(txtGenero.getText());
//                filme.setPais(txtPais.getText());
//                filme.setAno(Integer.parseInt(txtAno.getText()));
//                f.enqueue(filme);
//                txtArea.setText("Foi inserido na fila filme: \n\n" + filme.toString());
//                limpar();
//                
//            } catch (Exception ex) {
//                verificarCampos();
//            }  
//        }else{
//            avisoFilaCheia();
//        }      
//    }
    
    public void dequeue(){
        if (!f.isEmpty()) {
            Filme filme = (Filme)f.dequeue();
            txtArea.setText("Foi retirado da fila o filme: \n\n" + f.toString());
        }
    }
    
    public void peek(){
        Filme filme = (Filme)f.peek();
        txtArea.setText("Filme no início da fila: \n\n" + f.toString());
    }
    
    public void verFila(){
        txtArea.setText("Fila de Filmes: \n\n" + f.toString());
    }
    
    public void retirarFilme(){
        if (!f.isEmpty()) {
            String str = "ação";
            while(!str.equalsIgnoreCase(filme.getGenero())){
                txtArea.setText("");
                filme = (Filme)f.dequeue(); 
                if (str.equalsIgnoreCase(filme.getGenero())) {
                    txtArea.setText("Gênero  AÇÂO  encontrado: \n\n" + filme.toString());
                    break;
                }
                else {
                    if (f.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Gênero  AÇÂO  não encontrado!");
                        break;
                    }
                }     
            }
        }
    }
    
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        PanelTop = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbn_Titulo = new javax.swing.JLabel();
        lbDiretor = new javax.swing.JLabel();
        lbGenero = new javax.swing.JLabel();
        lbPais = new javax.swing.JLabel();
        lbnAno = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtDiretor = new javax.swing.JTextField();
        txtGenero = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextPane();
        btn_Cadastrar = new javax.swing.JButton();
        btn_ListaF = new javax.swing.JButton();
        btn_Reitrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 530));

        PanelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        PanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelTop.setBackground(new java.awt.Color(0, 204, 204));
        PanelTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fila de Filmes");
        PanelTop.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 180, 39));
        PanelTop.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 300, -1));

        PanelPrincipal.add(PanelTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 80));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Samuel Rodrigues de Souza - RGM: 22977996");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(601, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 900, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbn_Titulo.setText("Título:");
        jPanel2.add(lbn_Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 60, -1));

        lbDiretor.setText("Diretor:");
        jPanel2.add(lbDiretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        lbGenero.setText("Gênero:");
        jPanel2.add(lbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lbPais.setText("País");
        jPanel2.add(lbPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        lbnAno.setText("Ano:");
        jPanel2.add(lbnAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));
        jPanel2.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, -1));
        jPanel2.add(txtDiretor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 200, -1));
        jPanel2.add(txtGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 200, -1));
        jPanel2.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 100, -1));
        jPanel2.add(txtAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 100, -1));

        txtArea.setEditable(false);
        jScrollPane1.setViewportView(txtArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 620, 220));

        btn_Cadastrar.setText("Cadastra");
        btn_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CadastrarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 200, -1));

        btn_ListaF.setText("Listar Filmes");
        btn_ListaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ListaFActionPerformed(evt);
            }
        });
        jPanel2.add(btn_ListaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 180, -1));

        btn_Reitrar.setText("Retirar até encontrar");
        btn_Reitrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReitrarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Reitrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 180, -1));

        PanelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 900, 380));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CadastrarActionPerformed
        enqueue();
    }//GEN-LAST:event_btn_CadastrarActionPerformed

    private void btn_ListaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ListaFActionPerformed
        verFila();
    }//GEN-LAST:event_btn_ListaFActionPerformed

    private void btn_ReitrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReitrarActionPerformed
        retirarFilme();
    }//GEN-LAST:event_btn_ReitrarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JPanel PanelTop;
    private javax.swing.JButton btn_Cadastrar;
    private javax.swing.JButton btn_ListaF;
    private javax.swing.JButton btn_Reitrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiretor;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbPais;
    private javax.swing.JLabel lbnAno;
    private javax.swing.JLabel lbn_Titulo;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextPane txtArea;
    private javax.swing.JTextField txtDiretor;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
