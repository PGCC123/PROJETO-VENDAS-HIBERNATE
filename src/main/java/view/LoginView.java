package view;

import conexao.Conexao;
import dao.LoginDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginView extends javax.swing.JFrame {
    
    private final char senha;

    public LoginView() {
        initComponents();
        this.setLocationRelativeTo(null);
        senha = passUSU_SENHA.getEchoChar();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iconLogo = new javax.swing.JLabel();
        textUSU_LOGIN = new javax.swing.JTextField();
        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        passUSU_SENHA = new javax.swing.JPasswordField();
        chkUSU_MOSTRA = new javax.swing.JCheckBox();
        iconMOSTAR = new javax.swing.JLabel();
        buttonEntrar = new javax.swing.JButton();
        buttonCadastrar = new javax.swing.JButton();
        labelAjuda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sale System - Login ");
        setResizable(false);

        iconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconeTela.png"))); // NOI18N
        iconLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        textUSU_LOGIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textUSU_LOGIN.setToolTipText("");

        labelLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconeFisico_1.png"))); // NOI18N
        labelLogin.setText("Login");

        labelSenha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconeChave.png"))); // NOI18N
        labelSenha.setText("Senha");

        passUSU_SENHA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passUSU_SENHA.setToolTipText("");

        chkUSU_MOSTRA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkUSU_MOSTRA.setText("Mostrar Senha");
        chkUSU_MOSTRA.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        chkUSU_MOSTRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUSU_MOSTRAActionPerformed(evt);
            }
        });

        iconMOSTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ocultarSenha.png"))); // NOI18N

        buttonEntrar.setText("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        buttonCadastrar.setText("Cadastrar");
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        labelAjuda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelAjuda.setText("Ajuda");
        labelAjuda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAjudaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(iconLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelAjuda)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconMOSTAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkUSU_MOSTRA))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(textUSU_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passUSU_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(112, 112, 112)
                            .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(labelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUSU_LOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passUSU_SENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconMOSTAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chkUSU_MOSTRA, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(iconLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkUSU_MOSTRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUSU_MOSTRAActionPerformed
        if (chkUSU_MOSTRA.isSelected()) {
            passUSU_SENHA.setEchoChar('\u0000'); // tem como funcionalidade remover a mascara da senha e mostrar a senha.
            iconMOSTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exibirSenha.png")));
        } else {
            passUSU_SENHA.setEchoChar(senha);
            iconMOSTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ocultarSenha.png")));
        }
    }//GEN-LAST:event_chkUSU_MOSTRAActionPerformed

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed

        LoginDao executar = new LoginDao();

        try {
            if (executar.checkLogin(textUSU_LOGIN.getText(), passUSU_SENHA.getText())) {
                this.dispose();
                MenuView menuview;
                menuview = new MenuView();
                menuview.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usúario ou senha incorreta, tente novamente!", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Por motivos deconhecidos não foi possivel logar" + ex.getMessage());
        }
    }//GEN-LAST:event_buttonEntrarActionPerformed

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        Conexao objconexao;
        objconexao = new Conexao();

        UsuarioView usuarioview;
        usuarioview = new UsuarioView();
        usuarioview.setVisible(true);
    }//GEN-LAST:event_buttonCadastrarActionPerformed

    private void labelAjudaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAjudaMouseClicked
        JOptionPane.showMessageDialog(null, "Para logar insira seu e-mail e sua senha corporativa.", "Menssagem", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_labelAjudaMouseClicked
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JCheckBox chkUSU_MOSTRA;
    private javax.swing.JLabel iconLogo;
    private javax.swing.JLabel iconMOSTAR;
    private javax.swing.JLabel labelAjuda;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPasswordField passUSU_SENHA;
    private javax.swing.JTextField textUSU_LOGIN;
    // End of variables declaration//GEN-END:variables
}
