
package com.samuel_herancaproduto.pilhaveiculoform;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * @author Samuel
 */
public class Pilha extends javax.swing.JFrame {
    private Veiculo veiculo;
    private PilhaVeiculo pVeiculo;
    private int N;
    private int topo = 0;
    
    
    public Pilha() {
        initComponents();
        
        N = 5;
        pVeiculo = new PilhaVeiculo(N); // Iniciando Classe Pilha Veiculo;

        escondendoPilha();
    }
    
    //Método para esconder Pilha ao inicializar formulário 
    public void escondendoPilha(){
        //Campos da Pilha;
//        btn_CriaPilha.setFocusable(true);
        txtPilha0.setVisible(false);
        txtPilha1.setVisible(false);
        txtPilha2.setVisible(false);
        txtPilha3.setVisible(false);
        txtPilha4.setVisible(false);
        txt_NumTopo.setVisible(false);
        lb_NumTopo.setVisible(false);
        lb_Pilha.setVisible(false);
        
        //Campos de inserção;
        txt_Placa.setVisible(false);
        txt_Marca.setVisible(false);
        txt_Modelo.setVisible(false);
        txt_Ano.setVisible(false);
       
        
        //Campos de informações
        lbAviso.setVisible(false);
        txt_Aviso.setVisible(false);
        lbTopo.setVisible(false);
        txt_Topo.setVisible(false);
        btn_Push.setVisible(false);
        btn_Pop.setVisible(false);
        btn_Top1.setVisible(false);
        lbPlaca.setVisible(false);
        lbMarca.setVisible(false);
        lbModelo.setVisible(false);
        lbAno.setVisible(false);
    }
    
    //Método chamdo no botão para Criar Pilha;
    public void mostraPilha(){
        txtPilha0.setVisible(true);
        txtPilha1.setVisible(true);
        txtPilha2.setVisible(true);
        txtPilha3.setVisible(true);
        txtPilha4.setVisible(true);
        lb_Pilha.setVisible(true);
        txt_NumTopo.setVisible(true);
        lb_NumTopo.setVisible(true);
        btn_CriaPilha.setEnabled(false);
        
        //Campos de Inserção;
        txt_Placa.setVisible(true);
        txt_Placa.grabFocus();
        txt_Marca.setVisible(true);
        txt_Modelo.setVisible(true);
        txt_Ano.setVisible(true);
       
        
        //Campos de Informações;
        lbAviso.setVisible(true);
        txt_Aviso.setVisible(true);
        lbTopo.setVisible(true);
        txt_Topo.setVisible(true);
        btn_Push.setVisible(true);
        btn_Pop.setVisible(true);
        btn_Top1.setVisible(true);
        lbPlaca.setVisible(true);
        lbMarca.setVisible(true);
        lbModelo.setVisible(true);
        lbAno.setVisible(true);
    }
    
    //Método desabilitando campos de inserir
    public void inserirEnabled(){
        txt_Placa.setEnabled(false);
        txt_Marca.setEnabled(false);
        txt_Modelo.setEnabled(false);
        txt_Ano.setEnabled(false);
    }
    
    //Método abilitar campos de inserir
    public void inserirDados(){
        txt_Placa.setEnabled(true);
        txt_Marca.setEnabled(true);
        txt_Modelo.setEnabled(true);
        txt_Ano.setEnabled(true);
        txt_Placa.setText("");
        txt_Marca.setText("");
        txt_Modelo.setText("");
        txt_Ano.setText("");
    }
    
    //Método para verificar campos vazios;
    public void campoVazio(){
        if (txt_Placa.getText().isEmpty() || txt_Marca.getText().isEmpty() || txt_Modelo.getText().isEmpty() || txt_Ano.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, " TODOS OS CAMPOS DEVEM SER PREENCHIDOS! ");
        }
    }
    
    //Método para limpar informações trazidas pela consulta ( TOP );
    public void limpar(){
        txt_Topo.setText("");
    }
    
    //Método que verifica Pilha Cheia;
    public void avisoPilhaCheia(boolean aviso){
        if (!aviso) {
            txt_Aviso.setText("Pilha Cheia!");
        }
    }
    
    //Método para informar Pilha Vazia;
    public void avisoPilhaVazia(){
        if(pVeiculo.isEmpty()){
            JOptionPane.showMessageDialog(null, "Pilha Vazia!");
        }
    }
    
    //Método para trazer valor do TOPO;
    public int valorTopo(int t){ //1 - 0
        return t; //1 - 0
    }
    
    //Método push inserindo na Pilha;
    public void push(){ //Inserindo dados na Pilha;
         boolean pilhaCheia;
             
        if (!pVeiculo.isFull()) {
            pilhaCheia = true;
            veiculo = new Veiculo();
            veiculo.setPlaca((String)txt_Placa.getText());
            veiculo.setMarca((String)txt_Marca.getText());
            veiculo.setModelo((String)txt_Modelo.getText());
            veiculo.setAno(Integer.parseInt(txt_Ano.getText()));
            pVeiculo.push(veiculo.toString());
            topo = valorTopo(topo); 
            topo++;
            txt_NumTopo.setText(Integer.toString(topo));
            String controle = veiculo.toString();
                       
            novoIndiceDaPilha(controle);
            inserirEnabled();
            valorTopo(topo);
        }
        else{
            pilhaCheia = false;
            avisoPilhaCheia(pilhaCheia);
            inserirEnabled(); 
            txt_Placa.setText("");
            txt_Marca.setText("");
            txt_Modelo.setText("");
            txt_Ano.setText("");
        }
    }
    
    //Método para mostrar ordem da Pilha  
    public void novoIndiceDaPilha(String cont){
        
        if (txtPilha0.getText().equals("")) {
            txtPilha0.setText(cont);     
        }
        else if (txtPilha1.getText().equals("")) {
            txtPilha1.setText(cont);     
        }
        else if (txtPilha2.getText().equals("")) {
            txtPilha2.setText(cont);
        }
        else if (txtPilha3.getText().equals("")) {
            txtPilha3.setText(cont);   
        }
        else{
            txtPilha4.setText(cont);   
        }
    }
    
    //Método para retirar Elemento da Pilha;
    public void pop(){
        
        if (!pVeiculo.isEmpty()) {
            topo = valorTopo(topo);
            switch(topo){
                case 5:
                    pVeiculo.pop();
                    inserirDados();
                    txtPilha4.setText("");
                    valorTopo(topo--);
                    txt_Aviso.setText("");
                    txt_NumTopo.setText(Integer.toString(topo));
                    
                    break;

                case 4:
                     pVeiculo.pop();
                    txtPilha3.setText("");
                    valorTopo(topo--);
                    txt_NumTopo.setText(Integer.toString(topo));
                   
                    break;

                case 3:
                     pVeiculo.pop();
                    txtPilha2.setText("");
                    valorTopo(topo--);
                    txt_NumTopo.setText(Integer.toString(topo));
                    
                    break;

                case 2:
                     pVeiculo.pop();
                    txtPilha1.setText("");
                    valorTopo(topo--);
                    txt_NumTopo.setText(Integer.toString(topo));
                    
                    break;

                case 1:
                     pVeiculo.pop();
                    txtPilha0.setText("");
                    valorTopo(topo--);
                    txt_NumTopo.setText(Integer.toString(topo));
                    
                    break;
            }
        }
        
    }
    
    //Método para Mostrar elemento do Topo da Pilha;
    public void top(){
          if (!pVeiculo.isEmpty()) {
            topo = valorTopo(topo);
            switch(topo){
                case 5:
                    pVeiculo.top();
                    txt_Topo.setText(txtPilha4.getText());
                    break;

                case 4:
                    pVeiculo.top();
                    txt_Topo.setText(txtPilha3.getText());
                    break;

                case 3:
                    pVeiculo.top();
                    txt_Topo.setText(txtPilha2.getText());
                    break;

                case 2:
                    pVeiculo.top();
                    txt_Topo.setText(txtPilha1.getText());
                    break;

                case 1:
                    pVeiculo.top();
                    txt_Topo.setText(txtPilha0.getText());
                    break;
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_Push = new javax.swing.JButton();
        btn_Pop = new javax.swing.JButton();
        btn_CriaPilha = new javax.swing.JButton();
        lbPlaca = new javax.swing.JLabel();
        lbMarca = new javax.swing.JLabel();
        lbAno = new javax.swing.JLabel();
        lbModelo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbAviso = new javax.swing.JLabel();
        lbTopo = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txt_Topo = new javax.swing.JTextPane();
        lb_Pilha = new javax.swing.JLabel();
        txtPilha4 = new javax.swing.JTextField();
        txtPilha0 = new javax.swing.JTextField();
        txtPilha1 = new javax.swing.JTextField();
        txtPilha3 = new javax.swing.JTextField();
        txtPilha2 = new javax.swing.JTextField();
        btn_Top1 = new javax.swing.JButton();
        txt_NumTopo = new javax.swing.JTextField();
        lb_NumTopo = new javax.swing.JLabel();
        txt_Placa = new javax.swing.JTextField();
        txt_Marca = new javax.swing.JTextField();
        txt_Modelo = new javax.swing.JTextField();
        txt_Ano = new javax.swing.JTextField();
        txt_Aviso = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("TelaPilha"); // NOI18N
        setResizable(false);

        btn_Push.setText("Push");
        btn_Push.setFocusable(false);
        btn_Push.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PushActionPerformed(evt);
            }
        });

        btn_Pop.setText("Pop");
        btn_Pop.setFocusable(false);
        btn_Pop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PopActionPerformed(evt);
            }
        });

        btn_CriaPilha.setText("Criar Pilha");
        btn_CriaPilha.setFocusable(false);
        btn_CriaPilha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CriaPilhaActionPerformed(evt);
            }
        });

        lbPlaca.setText("Placa:");

        lbMarca.setText("Marca:");

        lbAno.setText("Ano de Fabricação");

        lbModelo.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("Pilha de Veículos");

        lbAviso.setForeground(new java.awt.Color(255, 0, 0));
        lbAviso.setText("AVISO:");

        lbTopo.setForeground(new java.awt.Color(0, 102, 51));
        lbTopo.setText("Topo:");

        txt_Topo.setFocusable(false);
        jScrollPane7.setViewportView(txt_Topo);

        lb_Pilha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_Pilha.setForeground(new java.awt.Color(0, 51, 153));
        lb_Pilha.setText("Pilha 5 Posições:");

        txtPilha4.setEditable(false);
        txtPilha4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPilha4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPilha4.setFocusable(false);
        txtPilha4.setMargin(new java.awt.Insets(1, 1, 1, 1));

        txtPilha0.setEditable(false);
        txtPilha0.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPilha0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPilha0.setFocusable(false);
        txtPilha0.setMargin(new java.awt.Insets(1, 1, 1, 1));

        txtPilha1.setEditable(false);
        txtPilha1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPilha1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPilha1.setFocusable(false);
        txtPilha1.setMargin(new java.awt.Insets(1, 1, 1, 1));

        txtPilha3.setEditable(false);
        txtPilha3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPilha3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPilha3.setFocusable(false);
        txtPilha3.setMargin(new java.awt.Insets(1, 1, 1, 1));

        txtPilha2.setEditable(false);
        txtPilha2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPilha2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPilha2.setFocusable(false);
        txtPilha2.setMargin(new java.awt.Insets(1, 1, 1, 1));

        btn_Top1.setText("Top");
        btn_Top1.setFocusable(false);
        btn_Top1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Top1ActionPerformed(evt);
            }
        });

        txt_NumTopo.setEditable(false);
        txt_NumTopo.setFocusable(false);
        txt_NumTopo.setRequestFocusEnabled(txt_Topo.isFocusable());

        lb_NumTopo.setForeground(new java.awt.Color(0, 153, 51));
        lb_NumTopo.setText("Topo:");

        txt_Placa.setFocusAccelerator(txt_Placa.getFocusAccelerator());

        txt_Aviso.setEditable(false);
        txt_Aviso.setForeground(new java.awt.Color(204, 0, 0));
        txt_Aviso.setFocusable(false);
        txt_Aviso.setRequestFocusEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_CriaPilha, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(btn_Push, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(btn_Pop, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Top1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPilha4)
                            .addComponent(txtPilha0)
                            .addComponent(txtPilha1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPilha3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbTopo)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lb_Pilha)
                                            .addGap(21, 21, 21)
                                            .addComponent(lb_NumTopo)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txt_NumTopo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtPilha2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbModelo)
                                                .addComponent(lbPlaca)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txt_Placa, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                    .addComponent(txt_Modelo)))
                                            .addGap(91, 91, 91)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbAno)
                                                .addComponent(txt_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txt_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbMarca))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbAviso)
                                                        .addComponent(txt_Aviso, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(84, 84, 84)))))
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPlaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(lbModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbMarca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Marca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbAviso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_Aviso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(lbAno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Ano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(lbTopo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CriaPilha, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Push, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Pop, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Top1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_Pilha)
                    .addComponent(txt_NumTopo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lb_NumTopo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPilha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPilha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPilha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPilha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPilha0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        btn_Push.getAccessibleContext().setAccessibleName("btn_Push");
        btn_Pop.getAccessibleContext().setAccessibleName("btn_pop");
        btn_CriaPilha.getAccessibleContext().setAccessibleName("btn_CriarPilha");
        lbPlaca.getAccessibleContext().setAccessibleName("lb_Placa");
        lbMarca.getAccessibleContext().setAccessibleName("lb_Marca");
        lbAno.getAccessibleContext().setAccessibleName("lb_Ano");
        lbModelo.getAccessibleContext().setAccessibleName("lb_Modelo");
        lbAviso.getAccessibleContext().setAccessibleName("bl_Aviso");
        lbTopo.getAccessibleContext().setAccessibleName("lb_Topo");

        getAccessibleContext().setAccessibleName("TelaPilha");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CriaPilhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CriaPilhaActionPerformed
        mostraPilha();   
    }//GEN-LAST:event_btn_CriaPilhaActionPerformed

    private void btn_PushActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PushActionPerformed
        campoVazio();
        push();
        inserirDados();
        limpar();
    }//GEN-LAST:event_btn_PushActionPerformed

    private void btn_PopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PopActionPerformed
        avisoPilhaVazia();
        pop();
        inserirDados();
        limpar();
    }//GEN-LAST:event_btn_PopActionPerformed

    private void btn_Top1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Top1ActionPerformed
        avisoPilhaVazia();
        top();
    }//GEN-LAST:event_btn_Top1ActionPerformed

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
            java.util.logging.Logger.getLogger(Pilha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pilha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pilha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pilha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pilha().setVisible(true);   
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CriaPilha;
    private javax.swing.JButton btn_Pop;
    private javax.swing.JButton btn_Push;
    private javax.swing.JButton btn_Top1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbAno;
    private javax.swing.JLabel lbAviso;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbModelo;
    private javax.swing.JLabel lbPlaca;
    private javax.swing.JLabel lbTopo;
    private javax.swing.JLabel lb_NumTopo;
    private javax.swing.JLabel lb_Pilha;
    private javax.swing.JTextField txtPilha0;
    private javax.swing.JTextField txtPilha1;
    private javax.swing.JTextField txtPilha2;
    private javax.swing.JTextField txtPilha3;
    private javax.swing.JTextField txtPilha4;
    private javax.swing.JTextField txt_Ano;
    private javax.swing.JTextField txt_Aviso;
    private javax.swing.JTextField txt_Marca;
    private javax.swing.JTextField txt_Modelo;
    private javax.swing.JTextField txt_NumTopo;
    private javax.swing.JTextField txt_Placa;
    private javax.swing.JTextPane txt_Topo;
    // End of variables declaration//GEN-END:variables
}
