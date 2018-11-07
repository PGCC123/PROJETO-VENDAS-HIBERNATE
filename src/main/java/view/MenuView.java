package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

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
        btnSAIR = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblHORA = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDATA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        iconTELA_INICIO = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales System - Menu");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        BARRA_MENU.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BARRA_MENU.setOrientation(javax.swing.SwingConstants.VERTICAL);
        BARRA_MENU.setRollover(true);

        btnUSUARIOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconUsuarios.png"))); // NOI18N
        btnUSUARIOS.setText("Usuários");
        btnUSUARIOS.setFocusable(false);
        btnUSUARIOS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUSUARIOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUSUARIOS.setMaximumSize(new java.awt.Dimension(110, 45));
        btnUSUARIOS.setMinimumSize(new java.awt.Dimension(110, 45));
        btnUSUARIOS.setPreferredSize(new java.awt.Dimension(110, 45));
        btnUSUARIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUSUARIOSActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnUSUARIOS);

        btnCLIENTES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconeFisico_1.png"))); // NOI18N
        btnCLIENTES.setText("Clientes");
        btnCLIENTES.setFocusable(false);
        btnCLIENTES.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCLIENTES.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnCLIENTES.setMaximumSize(new java.awt.Dimension(110, 45));
        btnCLIENTES.setMinimumSize(new java.awt.Dimension(110, 45));
        btnCLIENTES.setPreferredSize(new java.awt.Dimension(110, 45));
        btnCLIENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCLIENTESActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnCLIENTES);

        btnFORNECEDORES.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconFornecedores.png"))); // NOI18N
        btnFORNECEDORES.setText("Fornecedores");
        btnFORNECEDORES.setFocusable(false);
        btnFORNECEDORES.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFORNECEDORES.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFORNECEDORES.setMaximumSize(new java.awt.Dimension(110, 45));
        btnFORNECEDORES.setMinimumSize(new java.awt.Dimension(110, 45));
        btnFORNECEDORES.setPreferredSize(new java.awt.Dimension(110, 45));
        btnFORNECEDORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFORNECEDORESActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnFORNECEDORES);

        btnPRODUTOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconProduto.png"))); // NOI18N
        btnPRODUTOS.setText("Produtos");
        btnPRODUTOS.setFocusable(false);
        btnPRODUTOS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPRODUTOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPRODUTOS.setMaximumSize(new java.awt.Dimension(110, 45));
        btnPRODUTOS.setMinimumSize(new java.awt.Dimension(110, 45));
        btnPRODUTOS.setPreferredSize(new java.awt.Dimension(110, 45));
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
        btnPAGAMENTOS.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPAGAMENTOS.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPAGAMENTOS.setMaximumSize(new java.awt.Dimension(110, 45));
        btnPAGAMENTOS.setMinimumSize(new java.awt.Dimension(110, 45));
        btnPAGAMENTOS.setPreferredSize(new java.awt.Dimension(110, 45));
        btnPAGAMENTOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPAGAMENTOSActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnPAGAMENTOS);

        btnSAIR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconSair.png"))); // NOI18N
        btnSAIR.setText("Log Off");
        btnSAIR.setFocusable(false);
        btnSAIR.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSAIR.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnSAIR.setMaximumSize(new java.awt.Dimension(110, 45));
        btnSAIR.setMinimumSize(new java.awt.Dimension(110, 45));
        btnSAIR.setPreferredSize(new java.awt.Dimension(110, 45));
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });
        BARRA_MENU.add(btnSAIR);

        getContentPane().add(BARRA_MENU);
        BARRA_MENU.setBounds(0, 0, 112, 283);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Hora:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(560, 50, 40, 30);

        lblHORA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblHORA);
        lblHORA.setBounds(600, 50, 80, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(560, 10, 40, 30);

        lblDATA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblDATA);
        lblDATA.setBounds(600, 10, 80, 30);

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jLabel2.setText("Acesse: www.pltec.com.br");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(560, 260, 140, 20);

        iconTELA_INICIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconFundoTela.jpg"))); // NOI18N
        getContentPane().add(iconTELA_INICIO);
        iconTELA_INICIO.setBounds(100, 0, 600, 280);

        setSize(new java.awt.Dimension(704, 310));
        setLocationRelativeTo(null);
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

    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Deseja realizar log off?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_NO_OPTION) {

            dispose();
            LoginView loginview;
            loginview = new LoginView();
            loginview.setVisible(true);

        } else {

        }
    }//GEN-LAST:event_btnSAIRActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //funcionalidade de mostrar a data atual.
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        lblDATA.setText(data.format(new Date()));
        //funcionalidade de mostar a hora atual. 
        Timer time = new Timer(1000, new MenuView.hora());
        time.start();
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar BARRA_MENU;
    private javax.swing.JButton btnCLIENTES;
    private javax.swing.JButton btnFORNECEDORES;
    private javax.swing.JButton btnPAGAMENTOS;
    private javax.swing.JButton btnPRODUTOS;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JButton btnUSUARIOS;
    private javax.swing.JLabel iconTELA_INICIO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblDATA;
    private javax.swing.JLabel lblHORA;
    // End of variables declaration//GEN-END:variables

    //classe interna com funcionalidade de mostrar a hora atual.
    class hora implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            Calendar now = Calendar.getInstance();
            lblHORA.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }
}
