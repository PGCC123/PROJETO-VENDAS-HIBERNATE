package view;

import controller.ClienteController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.ClienteModel;
import model.PessoaModel;

public class ClienteView extends javax.swing.JFrame {

    private String operacao;
    private ArrayList<ClienteModel> array;
    private ClienteTableModel mtb;
    private ClienteController clientecontroller;

    private String getOperacao() {
        return operacao;
    }

    private void setOperacao(String operacao) {
        Boolean ativar = (operacao.equals("") ? false : true);
        // operacao=""(consulta), operacao="incluir"(inclusão), operacao="alterar"(alteração)
        this.operacao = operacao;
        btnGRAVAR.setEnabled(ativar);
        btnGRAVAR.setEnabled(ativar);

       
    }

    public ClienteView() {
        clientecontroller = new ClienteController();
        this.setPreferredSize(new Dimension(1300, 700));
        initComponents();
        setOperacao(""); // inicializa o form no modo CONSULTA
        setLocationRelativeTo(null);
        tblConsulta.getTableHeader().setBackground(Color.GRAY);
        consultar();
        this.inativarCampos();
        // adiciona evento para que qdo navegar no JTable, atualize o registro nos JTextField´s
        tblConsulta.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                int selecionado = tblConsulta.getSelectedRow();
                if (selecionado >= 0) {
                    mostrar(array.get(selecionado));
                }
            }
        });
        edtPES_CODIGO.setVisible(false);
        this.pack();
    }

    private boolean validacao() {
        String erroMessage = "Campos com * devem ser preenchidos!";

        if (edtCLI_NOME.getText() == null || edtCLI_NOME.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtCLI_NOME.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtCLI_NOME.setBorder(border);
        }

        if (edtCLI_CPF.getText() == null || edtCLI_CPF.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtCLI_CPF.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtCLI_CPF.setBorder(border);
        }

        if (edtCLI_RG.getText() == null || edtCLI_RG.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtCLI_RG.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtCLI_RG.setBorder(border);
        }

        if (edtCLI_LIMITECRED.getText() == null || edtCLI_LIMITECRED.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtCLI_LIMITECRED.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtCLI_LIMITECRED.setBorder(border);
        }

        if (edtCLI_FONE1.getText() == null || edtCLI_FONE1.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtCLI_FONE1.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtCLI_FONE1.setBorder(border);
        }

        if (edtCLI_CELULAR.getText() == null || edtCLI_CELULAR.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtCLI_CELULAR.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtCLI_CELULAR.setBorder(border);
        }

        if (erroMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final void inativarCampos() {
        edtCLI_NOME.setEditable(false);
        edtCLI_CPF.setEditable(false);
        edtCLI_RG.setEditable(false);
        edtCLI_ENDERECO.setEditable(false);
        edtCLI_NUMERO.setEditable(false);
        edtCLI_COMPLEMENTO.setEditable(false);
        edtCLI_BAIRRO.setEditable(false);
        edtCLI_CIDADE.setEditable(false);
        edtCLI_CEP.setEditable(false);
        edtCLI_FONE1.setEditable(false);
        edtCLI_FONE2.setEditable(false);
        edtCLI_CELULAR.setEditable(false);
        edtCLI_EMAIL.setEditable(false);
        edtCLI_LIMITECRED.setEditable(false);
    }

    public final void ativarCampos() {
        edtCLI_NOME.setEditable(true);
        edtCLI_CPF.setEditable(true);
        edtCLI_RG.setEditable(true);
        edtCLI_ENDERECO.setEditable(true);
        edtCLI_NUMERO.setEditable(true);
        edtCLI_COMPLEMENTO.setEditable(true);
        edtCLI_BAIRRO.setEditable(true);
        edtCLI_CIDADE.setEditable(true);
        edtCLI_CEP.setEditable(true);
        edtCLI_FONE1.setEditable(true);
        edtCLI_FONE2.setEditable(true);
        edtCLI_CELULAR.setEditable(true);
        edtCLI_EMAIL.setEditable(true);
        edtCLI_LIMITECRED.setEditable(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        btnPRIMEIRO = new javax.swing.JButton();
        btnANTERIOR = new javax.swing.JButton();
        btnPROXIMO = new javax.swing.JButton();
        btnULTIMO = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnINCLUIR = new javax.swing.JButton();
        btnALTERAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnGRAVAR = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnIMPRIMIR = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        btnSAIR = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblCLI_CODIGO = new javax.swing.JLabel();
        lblCLI_NOME = new javax.swing.JLabel();
        edtCLI_CODIGO = new javax.swing.JTextField();
        edtCLI_NOME = new javax.swing.JTextField();
        comboCLI_ATIVO = new javax.swing.JComboBox<>();
        lblCLI_ATIVO = new javax.swing.JLabel();
        lblCLI_CPF = new javax.swing.JLabel();
        edtCLI_CPF = new javax.swing.JTextField();
        edtCLI_RG = new javax.swing.JTextField();
        lblCLI_RG = new javax.swing.JLabel();
        lblCLI_FISICA = new javax.swing.JLabel();
        comboCLI_FISICA = new javax.swing.JComboBox<>();
        lblCLI_LIMITECRED = new javax.swing.JLabel();
        edtCLI_LIMITECRED = new javax.swing.JTextField();
        edtPES_CODIGO = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblCLI_ENDERECO = new javax.swing.JLabel();
        edtCLI_ENDERECO = new javax.swing.JTextField();
        lblCLI_NUMERO = new javax.swing.JLabel();
        edtCLI_NUMERO = new javax.swing.JTextField();
        lblCLI_COMPLEMENTO = new javax.swing.JLabel();
        edtCLI_COMPLEMENTO = new javax.swing.JTextField();
        lblCLI_BAIRRO = new javax.swing.JLabel();
        edtCLI_BAIRRO = new javax.swing.JTextField();
        lblCLI_CIDADE = new javax.swing.JLabel();
        edtCLI_CIDADE = new javax.swing.JTextField();
        lblCLI_UF = new javax.swing.JLabel();
        comboCLI_UF = new javax.swing.JComboBox<>();
        lblCLI_CEP = new javax.swing.JLabel();
        edtCLI_CEP = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblCLI_FONE1 = new javax.swing.JLabel();
        edtCLI_FONE1 = new javax.swing.JTextField();
        lblCLI_FONE2 = new javax.swing.JLabel();
        edtCLI_FONE2 = new javax.swing.JTextField();
        lblCLI_CELULAR = new javax.swing.JLabel();
        edtCLI_CELULAR = new javax.swing.JTextField();
        edtCLI_EMAIL = new javax.swing.JTextField();
        lblCLI_EMAIL = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblCONS_ID = new javax.swing.JLabel();
        edtCONS_ID1 = new javax.swing.JTextField();
        lblCodigo2 = new javax.swing.JLabel();
        edtCONS_ID2 = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        lblCONS_NOME = new javax.swing.JLabel();
        edtCONS_NOME = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblDATA = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblHORA = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales System - Cadastro de Clientes");
        setFocusable(false);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);

        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N
        btnPRIMEIRO.setText("Primeiro");
        btnPRIMEIRO.setFocusable(false);
        btnPRIMEIRO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPRIMEIRO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPRIMEIRO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPRIMEIROActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPRIMEIRO);

        btnANTERIOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/anterior.png"))); // NOI18N
        btnANTERIOR.setText("Anterior");
        btnANTERIOR.setFocusable(false);
        btnANTERIOR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnANTERIOR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnANTERIOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnANTERIORActionPerformed(evt);
            }
        });
        jToolBar1.add(btnANTERIOR);

        btnPROXIMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/proximo.png"))); // NOI18N
        btnPROXIMO.setText("Próximo");
        btnPROXIMO.setFocusable(false);
        btnPROXIMO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPROXIMO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPROXIMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPROXIMOActionPerformed(evt);
            }
        });
        jToolBar1.add(btnPROXIMO);

        btnULTIMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ultimo.png"))); // NOI18N
        btnULTIMO.setText("Último");
        btnULTIMO.setFocusable(false);
        btnULTIMO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnULTIMO.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnULTIMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnULTIMOActionPerformed(evt);
            }
        });
        jToolBar1.add(btnULTIMO);

        jSeparator1.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator1);

        btnINCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnINCLUIR.setText("Novo");
        btnINCLUIR.setFocusable(false);
        btnINCLUIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnINCLUIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnINCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINCLUIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnINCLUIR);

        btnALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        btnALTERAR.setText("Alterar");
        btnALTERAR.setFocusable(false);
        btnALTERAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnALTERAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });
        jToolBar1.add(btnALTERAR);

        btnEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/excluir.png"))); // NOI18N
        btnEXCLUIR.setText("Excluir");
        btnEXCLUIR.setFocusable(false);
        btnEXCLUIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEXCLUIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEXCLUIR);

        jSeparator2.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator2);

        btnGRAVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        btnGRAVAR.setText("Gravar");
        btnGRAVAR.setFocusable(false);
        btnGRAVAR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGRAVAR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGRAVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGRAVARActionPerformed(evt);
            }
        });
        jToolBar1.add(btnGRAVAR);

        jSeparator3.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator3);

        btnIMPRIMIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imprimir.png"))); // NOI18N
        btnIMPRIMIR.setText("Imprimir");
        btnIMPRIMIR.setFocusable(false);
        btnIMPRIMIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIMPRIMIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIMPRIMIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIMPRIMIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnIMPRIMIR);

        jSeparator4.setSeparatorSize(new java.awt.Dimension(30, 30));
        jToolBar1.add(jSeparator4);

        btnSAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/log off.png"))); // NOI18N
        btnSAIR.setFocusable(false);
        btnSAIR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSAIR.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });
        jToolBar1.add(btnSAIR);

        getContentPane().add(jToolBar1);
        jToolBar1.setBounds(0, 0, 1300, 71);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CADASTRO DE CLIENTES");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 90, 1300, 29);

        lblCLI_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CODIGO.setText("Código");

        lblCLI_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_NOME.setText("Nome");

        edtCLI_CODIGO.setEditable(false);
        edtCLI_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtCLI_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboCLI_ATIVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));

        lblCLI_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_ATIVO.setText("Ativo?");

        lblCLI_CPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CPF.setText("CPF");

        edtCLI_CPF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_CPFKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_CPFKeyTyped(evt);
            }
        });

        edtCLI_RG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_RG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_RGKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_RGKeyTyped(evt);
            }
        });

        lblCLI_RG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_RG.setText("RG");

        lblCLI_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_FISICA.setText("Física?");

        comboCLI_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCLI_FISICA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SIM" }));

        lblCLI_LIMITECRED.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_LIMITECRED.setText("Limite de Crédito ");

        edtCLI_LIMITECRED.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPES_CODIGO.setEditable(false);
        edtPES_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtPES_CODIGO.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblCLI_NOME)
                    .addComponent(lblCLI_CODIGO)
                    .addComponent(lblCLI_CPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edtCLI_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(edtCLI_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblCLI_RG)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(edtCLI_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCLI_ATIVO)
                            .addGap(18, 18, 18)
                            .addComponent(comboCLI_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(edtCLI_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCLI_LIMITECRED)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(edtCLI_LIMITECRED, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblCLI_FISICA)
                            .addGap(18, 18, 18)
                            .addComponent(comboCLI_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtCLI_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_CODIGO)
                    .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCLI_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCLI_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCLI_NOME)
                        .addComponent(edtCLI_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCLI_LIMITECRED)
                        .addComponent(edtCLI_LIMITECRED, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboCLI_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCLI_ATIVO))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtCLI_CPF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCLI_CPF)
                        .addComponent(lblCLI_RG)
                        .addComponent(edtCLI_RG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do Cliente", jPanel1);

        lblCLI_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_ENDERECO.setText("Endereço");

        edtCLI_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_NUMERO.setText("N°");

        edtCLI_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_COMPLEMENTO.setText("Complemento");

        edtCLI_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_BAIRRO.setText("Bairro");

        edtCLI_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CIDADE.setText("Cidade");

        edtCLI_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_UF.setText("UF");

        comboCLI_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboCLI_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lblCLI_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CEP.setText("CEP");

        edtCLI_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_CEPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_CEPKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCLI_CIDADE)
                            .addComponent(lblCLI_BAIRRO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtCLI_BAIRRO)
                            .addComponent(edtCLI_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblCLI_ENDERECO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCLI_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblCLI_NUMERO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCLI_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCLI_COMPLEMENTO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCLI_COMPLEMENTO, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addGap(312, 312, 312))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblCLI_UF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCLI_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(lblCLI_CEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtCLI_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_ENDERECO)
                    .addComponent(edtCLI_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_NUMERO)
                    .addComponent(edtCLI_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_COMPLEMENTO)
                    .addComponent(edtCLI_COMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCLI_CEP)
                        .addComponent(edtCLI_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCLI_BAIRRO)
                        .addComponent(edtCLI_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCLI_UF)
                        .addComponent(comboCLI_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCLI_CIDADE)
                        .addComponent(edtCLI_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Endereço", jPanel5);

        lblCLI_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_FONE1.setText("Telefone 1");

        edtCLI_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_FONE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_FONE1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_FONE1KeyTyped(evt);
            }
        });

        lblCLI_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_FONE2.setText("Telefone 2");

        edtCLI_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_FONE2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_FONE2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_FONE2KeyTyped(evt);
            }
        });

        lblCLI_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_CELULAR.setText("Celular");

        edtCLI_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtCLI_CELULAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtCLI_CELULARKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtCLI_CELULARKeyTyped(evt);
            }
        });

        edtCLI_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCLI_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCLI_EMAIL.setText("E-mail");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblCLI_CELULAR)
                                .addGap(18, 18, 18)
                                .addComponent(edtCLI_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblCLI_FONE1)
                                .addGap(18, 18, 18)
                                .addComponent(edtCLI_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblCLI_FONE2)
                        .addGap(18, 18, 18)
                        .addComponent(edtCLI_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblCLI_EMAIL)
                        .addGap(18, 18, 18)
                        .addComponent(edtCLI_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(495, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_FONE1)
                    .addComponent(edtCLI_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCLI_FONE2)
                    .addComponent(edtCLI_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_CELULAR)
                    .addComponent(edtCLI_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCLI_EMAIL)
                    .addComponent(edtCLI_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Contato", jPanel4);

        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 120, 970, 140);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCONS_ID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_ID.setText("Código");

        edtCONS_ID1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblCodigo2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodigo2.setText("à");

        edtCONS_ID2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconePesquisa.png"))); // NOI18N
        btnConsulta.setText("Buscar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lblCONS_NOME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCONS_NOME.setText("Nome");

        edtCONS_NOME.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCONS_ID)
                    .addComponent(lblCONS_NOME))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(edtCONS_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCodigo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtCONS_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(edtCONS_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCONS_ID)
                    .addComponent(edtCONS_ID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo2)
                    .addComponent(edtCONS_ID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edtCONS_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCONS_NOME)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsulta)
                    .addComponent(btnLimpar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(tblConsulta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Consulta", jPanel2);

        getContentPane().add(jTabbedPane2);
        jTabbedPane2.setBounds(10, 280, 970, 370);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Data Atual:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1110, 130, 70, 30);

        lblDATA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblDATA);
        lblDATA.setBounds(1190, 130, 100, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Hora Atual:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1110, 170, 70, 30);

        lblHORA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(lblHORA);
        lblHORA.setBounds(1190, 170, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPRIMEIROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPRIMEIROActionPerformed
        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem clientes cadastrados!");
        } else {
            int selecionado = 0;
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtCLI_NOME.setFocusable(true);
        this.ativarCampos();
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        String mensagem;
        String mensagem2;
        if (JOptionPane.showConfirmDialog(null, "Deseja cadastrar esse cliente?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                this.validacao();
                PessoaModel objpessoa = new PessoaModel();
                ClienteModel objcliente = new ClienteModel();

                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtCLI_NOME.getText());
                objpessoa.setPES_FISICA(comboCLI_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtCLI_CPF.getText());
                objpessoa.setPES_RGIE(edtCLI_RG.getText());
                objpessoa.setPES_ENDERECO(edtCLI_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtCLI_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtCLI_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtCLI_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtCLI_CIDADE.getText());
                objpessoa.setPES_UF(comboCLI_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtCLI_CEP.getText());
                objpessoa.setPES_FONE1(edtCLI_FONE1.getText());
                objpessoa.setPES_FONE2(edtCLI_FONE2.getText());
                objpessoa.setPES_CELULAR(edtCLI_CELULAR.getText());
                objpessoa.setPES_EMAIL(edtCLI_EMAIL.getText());
                objpessoa.setPES_ATIVO(comboCLI_ATIVO.getSelectedItem().toString());
                objcliente.setPessoamodel(objpessoa);

                objcliente.setCLI_CODIGO(Integer.parseInt(edtCLI_CODIGO.getText()));
                objcliente.setCLI_LIMITECRED(Double.parseDouble(edtCLI_LIMITECRED.getText()));

                ClienteController clientecontroller = new ClienteController();
                clientecontroller.gravar(objcliente, getOperacao());

                mensagem = "Cliente cadastrado com sucesso!";
                JOptionPane.showMessageDialog(null, mensagem);
                this.inativarCampos();
                this.consultar();
            } catch (Exception ex) {
                mensagem2 = "Os campos destacados em vermelho são obrigatórios!\n "
                        + "Erro ao cadastrar o cliente.\n" + ex.getMessage();
                JOptionPane.showMessageDialog(null, mensagem2, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnGRAVARActionPerformed

    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed
        setOperacao("alterar");
        this.ativarCampos();
    }//GEN-LAST:event_btnALTERARActionPerformed

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        consultar();
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        int sair = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_btnSAIRActionPerformed

    private void btnANTERIORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnANTERIORActionPerformed
        int selecionado = tblConsulta.getSelectedRow() - 1;
        if (selecionado >= 0) {
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnANTERIORActionPerformed

    private void limpar() {
        edtCLI_CODIGO.setText("0");
        edtPES_CODIGO.setText("0");
        edtCLI_NOME.setText("");
        edtCLI_CPF.setText("");
        edtCLI_RG.setText("");
        edtCLI_ENDERECO.setText("");
        edtCLI_NUMERO.setText("");
        edtCLI_COMPLEMENTO.setText("");
        edtCLI_BAIRRO.setText("");
        edtCLI_CIDADE.setText("");
        edtCLI_CEP.setText("");
        edtCLI_FONE1.setText("");
        edtCLI_FONE2.setText("");
        edtCLI_CELULAR.setText("");
        edtCLI_EMAIL.setText("");
        edtCLI_LIMITECRED.setText("");
    }

    private void mostrar(ClienteModel cliente) {
        edtCLI_CODIGO.setText(String.valueOf(cliente.getCLI_CODIGO()));
        edtPES_CODIGO.setText(String.valueOf(cliente.getPessoamodel().getPES_CODIGO()));
        edtCLI_NOME.setText(cliente.getPessoamodel().getPES_NOME());
        comboCLI_FISICA.setSelectedItem(cliente.getPessoamodel().getPES_FISICA());
        edtCLI_CPF.setText(cliente.getPessoamodel().getPES_CPFCNPJ());
        edtCLI_RG.setText(cliente.getPessoamodel().getPES_RGIE());
        edtCLI_ENDERECO.setText(cliente.getPessoamodel().getPES_ENDERECO());
        edtCLI_NUMERO.setText(cliente.getPessoamodel().getPES_NUMERO());
        edtCLI_COMPLEMENTO.setText(cliente.getPessoamodel().getPES_COMPLEMENTO());
        edtCLI_BAIRRO.setText(cliente.getPessoamodel().getPES_BAIRRO());
        edtCLI_CIDADE.setText(cliente.getPessoamodel().getPES_CIDADE());
        comboCLI_UF.setSelectedItem(cliente.getPessoamodel().getPES_UF());
        edtCLI_CEP.setText(cliente.getPessoamodel().getPES_CEP());
        edtCLI_FONE1.setText(cliente.getPessoamodel().getPES_FONE1());
        edtCLI_FONE2.setText(cliente.getPessoamodel().getPES_FONE2());
        edtCLI_CELULAR.setText(cliente.getPessoamodel().getPES_CELULAR());
        edtCLI_EMAIL.setText(cliente.getPessoamodel().getPES_EMAIL());
        comboCLI_ATIVO.setSelectedItem(cliente.getPessoamodel().getPES_ATIVO());
        edtCLI_LIMITECRED.setText(String.valueOf(cliente.getCLI_LIMITECRED()));
    }

    private String filtrar() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(CLI_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(CLI_CODIGO <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PES_NOME LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }

        if (!condicao.trim().equals("")) {
            condicao = " WHERE " + condicao;
        }
        return condicao;
    }

    private void consultar() {
        String condicao = filtrar();
        array = null;
        array = clientecontroller.consultar(condicao);
        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem clientes cadastrados!");
        } else {
            mtb = new ClienteTableModel(array);
            tblConsulta.setModel(mtb);
            tblConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tblConsulta.changeSelection(0, 0, false, false);
            mostrar();
        }
    }

    private void mostrar() {
        int selecionado = tblConsulta.getSelectedRow();
        if (selecionado >= 0) {
            mostrar(array.get(selecionado));
        }
    }
    private void btnPROXIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPROXIMOActionPerformed
        int selecionado = tblConsulta.getSelectedRow() + 1;
        if (selecionado < array.size()) {
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnPROXIMOActionPerformed

    private void btnULTIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnULTIMOActionPerformed
        int selecionado = array.size() - 1;
        tblConsulta.changeSelection(selecionado, 0, false, false);
    }//GEN-LAST:event_btnULTIMOActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        edtCONS_ID1.setText("");
        edtCONS_ID2.setText("");
        edtCONS_NOME.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
       String mensagem;
        String mensagem2;
        if (JOptionPane.showConfirmDialog(null, "Deseja cadastrar esse cliente?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PessoaModel objpessoa = new PessoaModel();
                ClienteModel objcliente = new ClienteModel();

                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtCLI_NOME.getText());
                objpessoa.setPES_FISICA(comboCLI_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtCLI_CPF.getText());
                objpessoa.setPES_RGIE(edtCLI_RG.getText());
                objpessoa.setPES_ENDERECO(edtCLI_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtCLI_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtCLI_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtCLI_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtCLI_CIDADE.getText());
                objpessoa.setPES_UF(comboCLI_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtCLI_CEP.getText());
                objpessoa.setPES_FONE1(edtCLI_FONE1.getText());
                objpessoa.setPES_FONE2(edtCLI_FONE2.getText());
                objpessoa.setPES_CELULAR(edtCLI_CELULAR.getText());
                objpessoa.setPES_EMAIL(edtCLI_EMAIL.getText());
                objpessoa.setPES_ATIVO(comboCLI_ATIVO.getSelectedItem().toString());
                objcliente.setPessoamodel(objpessoa);

                objcliente.setCLI_CODIGO(Integer.parseInt(edtCLI_CODIGO.getText()));
                objcliente.setCLI_LIMITECRED(Double.parseDouble(edtCLI_LIMITECRED.getText()));

                ClienteController clientecontroller = new ClienteController();
                clientecontroller.excluir(objcliente);

                mensagem = "Cliente cadastrado com sucesso!";
                JOptionPane.showMessageDialog(null, mensagem);
                this.inativarCampos();
                this.consultar(); 
            } catch (Exception ex) {
                mensagem2 = "Os campos destacados em vermelho são obrigatórios!\n "
                        + "Erro ao cadastrar o cliente.\n" + ex.getMessage();
                JOptionPane.showMessageDialog(null, mensagem2, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void btnIMPRIMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMPRIMIRActionPerformed
        Exception retorno = clientecontroller.imprimir();
        if (retorno != null) {
            JOptionPane.showMessageDialog(null, "Erro na exibição do relatório de clientes!\n" + retorno.getMessage());
        }
    }//GEN-LAST:event_btnIMPRIMIRActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //funcionalidade de mostrar a data atual.
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        lblDATA.setText(data.format(new Date()));
        //funcionalidade de mostar a hora atual. 
        Timer time = new Timer(1000, new hora());
        time.start();
    }//GEN-LAST:event_formWindowOpened

    private void edtCLI_CPFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CPFKeyReleased
        String campo = edtCLI_CPF.getText();
        if (campo.length() == 11) {
            String cpf;
            cpf = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + campo.charAt(2) + "." + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "." + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + "-" + campo.charAt(9) + campo.charAt(10));
            edtCLI_CPF.setText(cpf);
        }
    }//GEN-LAST:event_edtCLI_CPFKeyReleased

    private void edtCLI_CPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CPFKeyTyped
        int quantidade = 11;
        if (edtCLI_CPF.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_CPFKeyTyped

    private void edtCLI_RGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_RGKeyReleased
        String campo = edtCLI_RG.getText();
        if (campo.length() == 9) {
            String rg;
            rg = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + "." + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + "." + campo.charAt(5) + campo.charAt(6) + campo.charAt(7) + "-" + campo.charAt(8));
            edtCLI_RG.setText(rg);
        }
    }//GEN-LAST:event_edtCLI_RGKeyReleased

    private void edtCLI_RGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_RGKeyTyped
        int quantidade = 9;
        if (edtCLI_RG.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_RGKeyTyped

    private void edtCLI_CEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CEPKeyReleased
        String campo = edtCLI_CEP.getText();
        if (campo.length() == 8) {
            String cep;
            cep = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + "-" + campo.charAt(5) + campo.charAt(6) + campo.charAt(7));
            edtCLI_CEP.setText(cep);
        }
    }//GEN-LAST:event_edtCLI_CEPKeyReleased

    private void edtCLI_CEPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CEPKeyTyped
        int quantidade = 8;
        if (edtCLI_CEP.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_CEPKeyTyped

    private void edtCLI_FONE1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE1KeyReleased
        String campo = edtCLI_FONE1.getText();
        if (campo.length() == 10) {
            String fone1;
            fone1 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtCLI_FONE1.setText(fone1);
        }
    }//GEN-LAST:event_edtCLI_FONE1KeyReleased

    private void edtCLI_FONE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE1KeyTyped
        int quantidade = 10;
        if (edtCLI_FONE1.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_FONE1KeyTyped

    private void edtCLI_FONE2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE2KeyReleased
        String campo = edtCLI_FONE2.getText();
        if (campo.length() == 10) {
            String fone2;
            fone2 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtCLI_FONE2.setText(fone2);
        }
    }//GEN-LAST:event_edtCLI_FONE2KeyReleased

    private void edtCLI_FONE2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_FONE2KeyTyped
        int quantidade = 10;
        if (edtCLI_FONE2.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_FONE2KeyTyped

    private void edtCLI_CELULARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CELULARKeyReleased
        String campo = edtCLI_CELULAR.getText();
        if (campo.length() == 10) {
            String fone2;
            fone2 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtCLI_CELULAR.setText(fone2);
        }
    }//GEN-LAST:event_edtCLI_CELULARKeyReleased

    private void edtCLI_CELULARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtCLI_CELULARKeyTyped
        int quantidade = 10;
        if (edtCLI_CELULAR.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtCLI_CELULARKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnANTERIOR;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnGRAVAR;
    private javax.swing.JButton btnIMPRIMIR;
    private javax.swing.JButton btnINCLUIR;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPRIMEIRO;
    private javax.swing.JButton btnPROXIMO;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JButton btnULTIMO;
    private javax.swing.JComboBox<String> comboCLI_ATIVO;
    private javax.swing.JComboBox<String> comboCLI_FISICA;
    private javax.swing.JComboBox<String> comboCLI_UF;
    private javax.swing.JTextField edtCLI_BAIRRO;
    private javax.swing.JTextField edtCLI_CELULAR;
    private javax.swing.JTextField edtCLI_CEP;
    private javax.swing.JTextField edtCLI_CIDADE;
    private javax.swing.JTextField edtCLI_CODIGO;
    private javax.swing.JTextField edtCLI_COMPLEMENTO;
    private javax.swing.JTextField edtCLI_CPF;
    private javax.swing.JTextField edtCLI_EMAIL;
    private javax.swing.JTextField edtCLI_ENDERECO;
    private javax.swing.JTextField edtCLI_FONE1;
    private javax.swing.JTextField edtCLI_FONE2;
    private javax.swing.JTextField edtCLI_LIMITECRED;
    private javax.swing.JTextField edtCLI_NOME;
    private javax.swing.JTextField edtCLI_NUMERO;
    private javax.swing.JTextField edtCLI_RG;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_NOME;
    private javax.swing.JTextField edtPES_CODIGO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblCLI_ATIVO;
    private javax.swing.JLabel lblCLI_BAIRRO;
    private javax.swing.JLabel lblCLI_CELULAR;
    private javax.swing.JLabel lblCLI_CEP;
    private javax.swing.JLabel lblCLI_CIDADE;
    private javax.swing.JLabel lblCLI_CODIGO;
    private javax.swing.JLabel lblCLI_COMPLEMENTO;
    private javax.swing.JLabel lblCLI_CPF;
    private javax.swing.JLabel lblCLI_EMAIL;
    private javax.swing.JLabel lblCLI_ENDERECO;
    private javax.swing.JLabel lblCLI_FISICA;
    private javax.swing.JLabel lblCLI_FONE1;
    private javax.swing.JLabel lblCLI_FONE2;
    private javax.swing.JLabel lblCLI_LIMITECRED;
    private javax.swing.JLabel lblCLI_NOME;
    private javax.swing.JLabel lblCLI_NUMERO;
    private javax.swing.JLabel lblCLI_RG;
    private javax.swing.JLabel lblCLI_UF;
    private javax.swing.JLabel lblCONS_ID;
    private javax.swing.JLabel lblCONS_NOME;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblDATA;
    private javax.swing.JLabel lblHORA;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblConsulta;
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
