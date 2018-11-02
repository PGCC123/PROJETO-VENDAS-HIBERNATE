package view;

public class MenuView extends javax.swing.JFrame {

    public MenuView() {
        System.out.println(getClass().getResource("/imagens/primeiro.png"));
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BARRA_MENU = new javax.swing.JToolBar();
        btnUSUARIOS = new javax.swing.JButton();
        btnCLIENTES = new javax.swing.JButton();
        btnFORNECEDORES = new javax.swing.JButton();
        btnPRODUTOS = new javax.swing.JButton();
        btnPAGAMENTOS = new javax.swing.JButton();
        iconTELA_INICIO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BARRA_MENU.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BARRA_MENU.setOrientation(javax.swing.SwingConstants.VERTICAL);
        BARRA_MENU.setRollover(true);

        btnUSUARIOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconUsuarios.png"))); // NOI18N
        btnUSUARIOS.setText("Usuários");
        btnUSUARIOS.setFocusable(false);
        btnUSUARIOS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnUSUARIOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUSUARIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUSUARIOSActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnUSUARIOS);

        btnCLIENTES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconeFisico_1.png"))); // NOI18N
        btnCLIENTES.setText("Clientes");
        btnCLIENTES.setFocusable(false);
        btnCLIENTES.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnCLIENTES.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCLIENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLIENTESActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnCLIENTES);

        btnFORNECEDORES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconFornecedores.png"))); // NOI18N
        btnFORNECEDORES.setText("Fornecedores");
        btnFORNECEDORES.setFocusable(false);
        btnFORNECEDORES.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnFORNECEDORES.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFORNECEDORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFORNECEDORESActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnFORNECEDORES);

        btnPRODUTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconProduto.png"))); // NOI18N
        btnPRODUTOS.setText("Produtos");
        btnPRODUTOS.setFocusable(false);
        btnPRODUTOS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnPRODUTOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPRODUTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRODUTOSActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnPRODUTOS);

        btnPAGAMENTOS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPAGAMENTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconPagamentos.png"))); // NOI18N
        btnPAGAMENTOS.setText("Pagamentos");
        btnPAGAMENTOS.setFocusable(false);
        btnPAGAMENTOS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnPAGAMENTOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPAGAMENTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAGAMENTOSActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnPAGAMENTOS);

        iconTELA_INICIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconFundoTela.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BARRA_MENU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconTELA_INICIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BARRA_MENU, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
            .addComponent(iconTELA_INICIO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUSUARIOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUSUARIOSActionPerformed
        this.dispose();
        UsuarioView usuarioview;
        usuarioview = new UsuarioView();
        usuarioview.setVisible(true);
    }//GEN-LAST:event_btnUSUARIOSActionPerformed

    private void btnCLIENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCLIENTESActionPerformed
        this.dispose();
        ClienteView clienteview;
        clienteview = new ClienteView();
        clienteview.setVisible(true);
    }//GEN-LAST:event_btnCLIENTESActionPerformed

    private void btnFORNECEDORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFORNECEDORESActionPerformed
       this.dispose();
        FornecedorView fornecedorview;
       fornecedorview = new FornecedorView();
       fornecedorview.setVisible(true);
    }//GEN-LAST:event_btnFORNECEDORESActionPerformed

    private void btnPRODUTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRODUTOSActionPerformed
        this.dispose();
        ProdutoView produtoview;
        produtoview = new ProdutoView();
        produtoview.setVisible(true);
    }//GEN-LAST:event_btnPRODUTOSActionPerformed

    private void btnPAGAMENTOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPAGAMENTOSActionPerformed
        this.dispose();
        FormaPagamentoView formapagamentoview;
        formapagamentoview = new FormaPagamentoView();
        formapagamentoview.setVisible(true);
    }//GEN-LAST:event_btnPAGAMENTOSActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar BARRA_MENU;
    private javax.swing.JButton btnCLIENTES;
    private javax.swing.JButton btnFORNECEDORES;
    private javax.swing.JButton btnPAGAMENTOS;
    private javax.swing.JButton btnPRODUTOS;
    private javax.swing.JButton btnUSUARIOS;
    private javax.swing.JLabel iconTELA_INICIO;
    // End of variables declaration//GEN-END:variables
}
