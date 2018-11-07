package view;

import controller.ClienteController;
import controller.FornecedorController;
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
import model.FornecedorModel;
import model.PessoaModel;

public class FornecedorView extends IMenu {

    private String operacao;
    private ArrayList<FornecedorModel> array;
    private FornecedorTableModel mtb;
    private FornecedorController fornecedorcontroller;

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

    public FornecedorView() {
        fornecedorcontroller = new FornecedorController();
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

        if (edtFOR_NOME.getText() == null || edtFOR_NOME.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtFOR_NOME.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtFOR_NOME.setBorder(border);
        }

        if (edtFOR_CNPJ.getText() == null || edtFOR_CNPJ.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtFOR_CNPJ.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtFOR_CNPJ.setBorder(border);
        }

        if (edtFOR_IE.getText() == null || edtFOR_IE.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtFOR_IE.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtFOR_IE.setBorder(border);
        }

        if (edtFOR_FANTASIA.getText() == null || edtFOR_FANTASIA.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtFOR_FANTASIA.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtFOR_FANTASIA.setBorder(border);
        }

        if (edtFOR_FONE1.getText() == null || edtFOR_FONE1.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtFOR_FONE1.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtFOR_FONE1.setBorder(border);
        }

        if (edtFOR_CELULAR.getText() == null || edtFOR_CELULAR.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtFOR_CELULAR.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtFOR_CELULAR.setBorder(border);
        }

        if (edtFOR_CONTATO.getText() == null || edtFOR_CONTATO.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtFOR_CONTATO.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtFOR_CONTATO.setBorder(border);
        }

        if (erroMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public final void inativarCampos() {
        edtFOR_NOME.setEditable(false);
        edtFOR_CNPJ.setEditable(false);
        edtFOR_IE.setEditable(false);
        edtFOR_ENDERECO.setEditable(false);
        edtFOR_NUMERO.setEditable(false);
        edtFOR_COMPLEMENTO.setEditable(false);
        edtFOR_BAIRRO.setEditable(false);
        edtFOR_CIDADE.setEditable(false);
        edtFOR_CEP.setEditable(false);
        edtFOR_FONE1.setEditable(false);
        edtFOR_FONE2.setEditable(false);
        edtFOR_CELULAR.setEditable(false);
        edtFOR_CONTATO.setEditable(false);
        edtFOR_FANTASIA.setEditable(false);
        edtFOR_SITE.setEditable(false);
        edtFOR_EMAIL.setEditable(false);

        comboFOR_ATIVO.setEnabled(false);
        comboFOR_FISICA.setEnabled(false);
        comboFOR_UF.setEnabled(false);

    }

    public final void ativarCampos() {
        edtFOR_NOME.setEditable(true);
        edtFOR_CNPJ.setEditable(true);
        edtFOR_IE.setEditable(true);
        edtFOR_ENDERECO.setEditable(true);
        edtFOR_NUMERO.setEditable(true);
        edtFOR_COMPLEMENTO.setEditable(true);
        edtFOR_BAIRRO.setEditable(true);
        edtFOR_CIDADE.setEditable(true);
        edtFOR_CEP.setEditable(true);
        edtFOR_FONE1.setEditable(true);
        edtFOR_FONE2.setEditable(true);
        edtFOR_CELULAR.setEditable(true);
        edtFOR_CONTATO.setEditable(true);
        edtFOR_FANTASIA.setEditable(true);
        edtFOR_SITE.setEditable(true);
        edtFOR_EMAIL.setEditable(true);

        comboFOR_ATIVO.setEnabled(true);
        comboFOR_FISICA.setEnabled(true);
        comboFOR_UF.setEnabled(true);
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
        lblFOR_CODIGO = new javax.swing.JLabel();
        lblFOR_NOME = new javax.swing.JLabel();
        edtFOR_CODIGO = new javax.swing.JTextField();
        edtFOR_NOME = new javax.swing.JTextField();
        comboFOR_ATIVO = new javax.swing.JComboBox<>();
        lblFOR_ATIVO = new javax.swing.JLabel();
        lblFOR_CNPJ = new javax.swing.JLabel();
        edtFOR_CNPJ = new javax.swing.JTextField();
        edtFOR_IE = new javax.swing.JTextField();
        lblFOR_IE = new javax.swing.JLabel();
        lblFOR_FISICA = new javax.swing.JLabel();
        comboFOR_FISICA = new javax.swing.JComboBox<>();
        lblFOR_FANTASIA = new javax.swing.JLabel();
        edtFOR_FANTASIA = new javax.swing.JTextField();
        edtPES_CODIGO = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblFOR_ENDERECO = new javax.swing.JLabel();
        edtFOR_ENDERECO = new javax.swing.JTextField();
        lblFOR_NUMERO = new javax.swing.JLabel();
        edtFOR_NUMERO = new javax.swing.JTextField();
        lblFOR_COMPLEMENTO = new javax.swing.JLabel();
        edtFOR_COMPLEMENTO = new javax.swing.JTextField();
        lblFOR_BAIRRO = new javax.swing.JLabel();
        edtFOR_BAIRRO = new javax.swing.JTextField();
        lblFOR_CIDADE = new javax.swing.JLabel();
        edtFOR_CIDADE = new javax.swing.JTextField();
        lblFOR_UF = new javax.swing.JLabel();
        comboFOR_UF = new javax.swing.JComboBox<>();
        lblFOR_CEP = new javax.swing.JLabel();
        edtFOR_CEP = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblFOR_FONE1 = new javax.swing.JLabel();
        edtFOR_FONE1 = new javax.swing.JTextField();
        lblFOR_FONE2 = new javax.swing.JLabel();
        edtFOR_FONE2 = new javax.swing.JTextField();
        lblFOR_CELULAR = new javax.swing.JLabel();
        edtFOR_CELULAR = new javax.swing.JTextField();
        edtFOR_CONTATO = new javax.swing.JTextField();
        lblFOR_EMAIL = new javax.swing.JLabel();
        edtFOR_EMAIL = new javax.swing.JTextField();
        lblFOR_CONTATO = new javax.swing.JLabel();
        edtFOR_SITE = new javax.swing.JTextField();
        lblFOR_SITE = new javax.swing.JLabel();
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
        setTitle("Sales System - Cadastro de Fornecedores");
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
        lblTitulo.setText("CADASTRO DE FORNECEDOR");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 90, 1300, 29);

        lblFOR_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CODIGO.setText("Código");

        lblFOR_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_NOME.setText("Nome");

        edtFOR_CODIGO.setEditable(false);
        edtFOR_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtFOR_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        comboFOR_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFOR_ATIVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));

        lblFOR_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_ATIVO.setText("Ativo?");

        lblFOR_CNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CNPJ.setText("CNPJ");

        edtFOR_CNPJ.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_CNPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtFOR_CNPJKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtFOR_CNPJKeyTyped(evt);
            }
        });

        edtFOR_IE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_IE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtFOR_IEKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtFOR_IEKeyTyped(evt);
            }
        });

        lblFOR_IE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_IE.setText("Inscirção Estadual");

        lblFOR_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_FISICA.setText("Física?");

        comboFOR_FISICA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFOR_FISICA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO" }));

        lblFOR_FANTASIA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_FANTASIA.setText("Fantasia");

        edtFOR_FANTASIA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

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
                    .addComponent(lblFOR_NOME)
                    .addComponent(lblFOR_CODIGO)
                    .addComponent(lblFOR_CNPJ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(edtFOR_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtFOR_NOME, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(edtFOR_CNPJ))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFOR_FANTASIA)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtFOR_FANTASIA, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFOR_IE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtFOR_IE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFOR_ATIVO)
                                .addGap(18, 18, 18)
                                .addComponent(comboFOR_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFOR_FISICA)
                                .addGap(18, 18, 18)
                                .addComponent(comboFOR_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(240, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtFOR_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_CODIGO)
                    .addComponent(edtPES_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFOR_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboFOR_FISICA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFOR_NOME)
                        .addComponent(edtFOR_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFOR_FANTASIA)
                        .addComponent(edtFOR_FANTASIA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboFOR_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFOR_ATIVO))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(edtFOR_CNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFOR_CNPJ)
                        .addComponent(lblFOR_IE)
                        .addComponent(edtFOR_IE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do Fornecedor", jPanel1);

        lblFOR_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_ENDERECO.setText("Endereço");

        edtFOR_ENDERECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_NUMERO.setText("N°");

        edtFOR_NUMERO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_COMPLEMENTO.setText("Complemento");

        edtFOR_COMPLEMENTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_BAIRRO.setText("Bairro");

        edtFOR_BAIRRO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CIDADE.setText("Cidade");

        edtFOR_CIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_UF.setText("UF");

        comboFOR_UF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboFOR_UF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lblFOR_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CEP.setText("CEP");

        edtFOR_CEP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_CEP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtFOR_CEPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtFOR_CEPKeyTyped(evt);
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
                            .addComponent(lblFOR_CIDADE)
                            .addComponent(lblFOR_BAIRRO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtFOR_BAIRRO)
                            .addComponent(edtFOR_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblFOR_ENDERECO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtFOR_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblFOR_NUMERO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtFOR_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFOR_CEP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtFOR_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFOR_COMPLEMENTO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtFOR_COMPLEMENTO, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                        .addGap(151, 151, 151))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblFOR_UF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboFOR_UF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFOR_COMPLEMENTO)
                            .addComponent(edtFOR_COMPLEMENTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFOR_CEP)
                            .addComponent(edtFOR_CEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFOR_ENDERECO)
                        .addComponent(edtFOR_ENDERECO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFOR_NUMERO)
                        .addComponent(edtFOR_NUMERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_BAIRRO)
                    .addComponent(edtFOR_BAIRRO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFOR_UF)
                        .addComponent(comboFOR_UF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFOR_CIDADE)
                        .addComponent(edtFOR_CIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Endereço", jPanel5);

        lblFOR_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_FONE1.setText("Telefone 1");

        edtFOR_FONE1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_FONE1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtFOR_FONE1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtFOR_FONE1KeyTyped(evt);
            }
        });

        lblFOR_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_FONE2.setText("Telefone 2");

        edtFOR_FONE2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_FONE2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtFOR_FONE2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtFOR_FONE2KeyTyped(evt);
            }
        });

        lblFOR_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CELULAR.setText("Celular");

        edtFOR_CELULAR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edtFOR_CELULAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                edtFOR_CELULARKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                edtFOR_CELULARKeyTyped(evt);
            }
        });

        edtFOR_CONTATO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_EMAIL.setText("E-mail");

        edtFOR_EMAIL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_CONTATO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_CONTATO.setText("Contato");

        edtFOR_SITE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFOR_SITE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFOR_SITE.setText("Site");

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
                                .addComponent(lblFOR_CELULAR)
                                .addGap(18, 18, 18)
                                .addComponent(edtFOR_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lblFOR_FONE1)
                                .addGap(18, 18, 18)
                                .addComponent(edtFOR_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lblFOR_FONE2)
                        .addGap(18, 18, 18)
                        .addComponent(edtFOR_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFOR_CONTATO)
                        .addGap(18, 18, 18)
                        .addComponent(edtFOR_CONTATO, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblFOR_EMAIL)
                        .addGap(18, 18, 18)
                        .addComponent(edtFOR_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFOR_SITE)
                        .addGap(18, 18, 18)
                        .addComponent(edtFOR_SITE, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_FONE1)
                    .addComponent(edtFOR_FONE1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_FONE2)
                    .addComponent(edtFOR_FONE2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_CONTATO)
                    .addComponent(edtFOR_CONTATO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_CELULAR)
                    .addComponent(edtFOR_CELULAR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFOR_EMAIL)
                    .addComponent(edtFOR_EMAIL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtFOR_SITE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFOR_SITE))
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
            JOptionPane.showMessageDialog(null, "Não existem fornecedores cadastrados!");
        } else {
            int selecionado = 0;
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtFOR_NOME.setFocusable(true);
        this.ativarCampos();
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        String mensagem;
        String mensagem2;
        if (JOptionPane.showConfirmDialog(null, "Deseja cadastrar esse fornecedor?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                this.validacao();
                PessoaModel objpessoa = new PessoaModel();
                FornecedorModel objfornecedor = new FornecedorModel();

                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtFOR_NOME.getText());
                objpessoa.setPES_FANTASIA(edtFOR_FANTASIA.getText());
                objpessoa.setPES_FISICA(comboFOR_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtFOR_CNPJ.getText());
                objpessoa.setPES_RGIE(edtFOR_IE.getText());
                objpessoa.setPES_ENDERECO(edtFOR_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtFOR_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtFOR_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtFOR_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtFOR_CIDADE.getText());
                objpessoa.setPES_UF(comboFOR_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtFOR_CEP.getText());
                objpessoa.setPES_FONE1(edtFOR_FONE1.getText());
                objpessoa.setPES_FONE2(edtFOR_FONE2.getText());
                objpessoa.setPES_CELULAR(edtFOR_CELULAR.getText());
                objpessoa.setPES_EMAIL(edtFOR_EMAIL.getText());
                objpessoa.setPES_SITE(edtFOR_SITE.getText());
                objpessoa.setPES_ATIVO(comboFOR_ATIVO.getSelectedItem().toString());
                objfornecedor.setPessoamodel(objpessoa);

                objfornecedor.setFOR_CODIGO(Integer.parseInt(edtFOR_CODIGO.getText()));
                objfornecedor.setFOR_CONTATO(edtFOR_CONTATO.getText());

                FornecedorController fornecedorcontroller = new FornecedorController();
                fornecedorcontroller.gravar(objfornecedor, getOperacao());

                mensagem = "Fornecedor cadastrado com sucesso!";
                JOptionPane.showMessageDialog(null, mensagem);
                this.inativarCampos();
                this.consultar();
            } catch (Exception ex) {
                mensagem2 = "Os campos destacados em vermelho são obrigatórios!\n "
                        + "Erro ao cadastrar o fornecedor.\n" + ex.getMessage();
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
        int sair = JOptionPane.showConfirmDialog(null, "Deseja realizar log off?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_NO_OPTION) {

            dispose();
            LoginView loginview;
            loginview = new LoginView();
            loginview.setVisible(true);

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
        edtFOR_CODIGO.setText("0");
        edtPES_CODIGO.setText("0");
        edtFOR_NOME.setText("");
        edtFOR_CNPJ.setText("");
        edtFOR_IE.setText("");
        edtFOR_ENDERECO.setText("");
        edtFOR_NUMERO.setText("");
        edtFOR_COMPLEMENTO.setText("");
        edtFOR_BAIRRO.setText("");
        edtFOR_CIDADE.setText("");
        edtFOR_CEP.setText("");
        edtFOR_FONE1.setText("");
        edtFOR_FONE2.setText("");
        edtFOR_CELULAR.setText("");
        edtFOR_CONTATO.setText("");
        edtFOR_FANTASIA.setText("");
        edtFOR_EMAIL.setText("");
        edtFOR_SITE.setText("");
    }

    private void mostrar(FornecedorModel fornecedor) {
        edtFOR_CODIGO.setText(String.valueOf(fornecedor.getFOR_CODIGO()));
        edtPES_CODIGO.setText(String.valueOf(fornecedor.getPessoamodel().getPES_CODIGO()));
        edtFOR_NOME.setText(fornecedor.getPessoamodel().getPES_NOME());
        comboFOR_FISICA.setSelectedItem(fornecedor.getPessoamodel().getPES_FISICA());
        edtFOR_CNPJ.setText(fornecedor.getPessoamodel().getPES_CPFCNPJ());
        edtFOR_IE.setText(fornecedor.getPessoamodel().getPES_RGIE());
        edtFOR_ENDERECO.setText(fornecedor.getPessoamodel().getPES_ENDERECO());
        edtFOR_NUMERO.setText(fornecedor.getPessoamodel().getPES_NUMERO());
        edtFOR_COMPLEMENTO.setText(fornecedor.getPessoamodel().getPES_COMPLEMENTO());
        edtFOR_BAIRRO.setText(fornecedor.getPessoamodel().getPES_BAIRRO());
        edtFOR_CIDADE.setText(fornecedor.getPessoamodel().getPES_CIDADE());
        comboFOR_UF.setSelectedItem(fornecedor.getPessoamodel().getPES_UF());
        edtFOR_CEP.setText(fornecedor.getPessoamodel().getPES_CEP());
        edtFOR_FONE1.setText(fornecedor.getPessoamodel().getPES_FONE1());
        edtFOR_FONE2.setText(fornecedor.getPessoamodel().getPES_FONE2());
        edtFOR_CELULAR.setText(fornecedor.getPessoamodel().getPES_CELULAR());
        edtFOR_EMAIL.setText(fornecedor.getPessoamodel().getPES_EMAIL());
        comboFOR_ATIVO.setSelectedItem(fornecedor.getPessoamodel().getPES_ATIVO());
        edtFOR_FANTASIA.setText(String.valueOf(fornecedor.getPessoamodel().getPES_FANTASIA()));
        edtFOR_SITE.setText(fornecedor.getPessoamodel().getPES_SITE());
    }

    private String filtrar() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(FOR_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(FOR_CODIGO <= " + edtCONS_ID2.getText() + ")";
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
        array = fornecedorcontroller.consultar(condicao);
        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem fornecedores cadastrados!");
        } else {
            mtb = new FornecedorTableModel(array);
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
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse fornecedor?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PessoaModel objpessoa = new PessoaModel();
                FornecedorModel objfornecedor = new FornecedorModel();

                objpessoa.setPES_CODIGO(Integer.parseInt(edtPES_CODIGO.getText()));
                objpessoa.setPES_NOME(edtFOR_NOME.getText());
                objpessoa.setPES_FANTASIA(edtFOR_FANTASIA.getText());
                objpessoa.setPES_FISICA(comboFOR_FISICA.getSelectedItem().toString());
                objpessoa.setPES_CPFCNPJ(edtFOR_CNPJ.getText());
                objpessoa.setPES_RGIE(edtFOR_IE.getText());
                objpessoa.setPES_ENDERECO(edtFOR_ENDERECO.getText());
                objpessoa.setPES_NUMERO(edtFOR_NUMERO.getText());
                objpessoa.setPES_COMPLEMENTO(edtFOR_COMPLEMENTO.getText());
                objpessoa.setPES_BAIRRO(edtFOR_BAIRRO.getText());
                objpessoa.setPES_CIDADE(edtFOR_CIDADE.getText());
                objpessoa.setPES_UF(comboFOR_UF.getSelectedItem().toString());
                objpessoa.setPES_CEP(edtFOR_CEP.getText());
                objpessoa.setPES_FONE1(edtFOR_FONE1.getText());
                objpessoa.setPES_FONE2(edtFOR_FONE2.getText());
                objpessoa.setPES_CELULAR(edtFOR_CELULAR.getText());
                objpessoa.setPES_EMAIL(edtFOR_EMAIL.getText());
                objpessoa.setPES_SITE(edtFOR_SITE.getText());
                objpessoa.setPES_ATIVO(comboFOR_ATIVO.getSelectedItem().toString());
                objfornecedor.setPessoamodel(objpessoa);

                objfornecedor.setFOR_CODIGO(Integer.parseInt(edtFOR_CODIGO.getText()));
                objfornecedor.setFOR_CONTATO(edtFOR_CONTATO.getText());

                FornecedorController fornecedorcontroller = new FornecedorController();
                fornecedorcontroller.excluir(objfornecedor);

                mensagem = "Fornecedor excluido com sucesso!";
                JOptionPane.showMessageDialog(null, mensagem);
                this.inativarCampos();
                this.consultar();
            } catch (Exception ex) {
                mensagem2 = "Os campos destacados em vermelho são obrigatórios!\n "
                        + "Erro ao cadastrar o fornecedor.\n" + ex.getMessage();
                JOptionPane.showMessageDialog(null, mensagem2, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void btnIMPRIMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMPRIMIRActionPerformed
        Exception retorno = fornecedorcontroller.imprimir();
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

    private void edtFOR_CNPJKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_CNPJKeyReleased
        String campo = edtFOR_CNPJ.getText();
        if (campo.length() == 14) {
            String cnpj;
            cnpj = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + "." + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + "." + campo.charAt(5) + campo.charAt(6) + campo.charAt(7) + "/" + campo.charAt(8) + campo.charAt(9) + campo.charAt(10) + campo.charAt(11) + "-" + campo.charAt(12) + campo.charAt(13));
            edtFOR_CNPJ.setText(cnpj);
        }
    }//GEN-LAST:event_edtFOR_CNPJKeyReleased

    private void edtFOR_CNPJKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_CNPJKeyTyped
        int quantidade = 14;
        if (edtFOR_CNPJ.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtFOR_CNPJKeyTyped

    private void edtFOR_IEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_IEKeyReleased
        String campo = edtFOR_IE.getText();
        if (campo.length() == 12) {
            String ie;
            ie = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + campo.charAt(2) + "." + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "." + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + "." + campo.charAt(9) + campo.charAt(10) + campo.charAt(11));
            edtFOR_IE.setText(ie);
        }
    }//GEN-LAST:event_edtFOR_IEKeyReleased

    private void edtFOR_IEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_IEKeyTyped
        int quantidade = 12;
        if (edtFOR_IE.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtFOR_IEKeyTyped

    private void edtFOR_CEPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_CEPKeyReleased
        String campo = edtFOR_CEP.getText();
        if (campo.length() == 8) {
            String cep;
            cep = String.valueOf("" + campo.charAt(0) + campo.charAt(1) + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + "-" + campo.charAt(5) + campo.charAt(6) + campo.charAt(7));
            edtFOR_CEP.setText(cep);
        }
    }//GEN-LAST:event_edtFOR_CEPKeyReleased

    private void edtFOR_CEPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_CEPKeyTyped
        int quantidade = 8;
        if (edtFOR_CEP.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtFOR_CEPKeyTyped

    private void edtFOR_FONE1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_FONE1KeyReleased
        String campo = edtFOR_FONE1.getText();
        if (campo.length() == 10) {
            String fone1;
            fone1 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtFOR_FONE1.setText(fone1);
        }
    }//GEN-LAST:event_edtFOR_FONE1KeyReleased

    private void edtFOR_FONE1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_FONE1KeyTyped
        int quantidade = 10;
        if (edtFOR_FONE1.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtFOR_FONE1KeyTyped

    private void edtFOR_FONE2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_FONE2KeyReleased
        String campo = edtFOR_FONE2.getText();
        if (campo.length() == 10) {
            String fone2;
            fone2 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtFOR_FONE2.setText(fone2);
        }
    }//GEN-LAST:event_edtFOR_FONE2KeyReleased

    private void edtFOR_FONE2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_FONE2KeyTyped
        int quantidade = 10;
        if (edtFOR_FONE2.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtFOR_FONE2KeyTyped

    private void edtFOR_CELULARKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_CELULARKeyReleased
        String campo = edtFOR_CELULAR.getText();
        if (campo.length() == 10) {
            String fone2;
            fone2 = String.valueOf("" + "(" + campo.charAt(0) + campo.charAt(1) + ") " + campo.charAt(2) + campo.charAt(3) + campo.charAt(4) + campo.charAt(5) + "-" + campo.charAt(6) + campo.charAt(7) + campo.charAt(8) + campo.charAt(9));
            edtFOR_CELULAR.setText(fone2);
        }
    }//GEN-LAST:event_edtFOR_CELULARKeyReleased

    private void edtFOR_CELULARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtFOR_CELULARKeyTyped
        int quantidade = 10;
        if (edtFOR_CELULAR.getText().length() >= quantidade) {
            evt.consume();
        }
    }//GEN-LAST:event_edtFOR_CELULARKeyTyped

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
    private javax.swing.JComboBox<String> comboFOR_ATIVO;
    private javax.swing.JComboBox<String> comboFOR_FISICA;
    private javax.swing.JComboBox<String> comboFOR_UF;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_NOME;
    private javax.swing.JTextField edtFOR_BAIRRO;
    private javax.swing.JTextField edtFOR_CELULAR;
    private javax.swing.JTextField edtFOR_CEP;
    private javax.swing.JTextField edtFOR_CIDADE;
    private javax.swing.JTextField edtFOR_CNPJ;
    private javax.swing.JTextField edtFOR_CODIGO;
    private javax.swing.JTextField edtFOR_COMPLEMENTO;
    private javax.swing.JTextField edtFOR_CONTATO;
    private javax.swing.JTextField edtFOR_EMAIL;
    private javax.swing.JTextField edtFOR_ENDERECO;
    private javax.swing.JTextField edtFOR_FANTASIA;
    private javax.swing.JTextField edtFOR_FONE1;
    private javax.swing.JTextField edtFOR_FONE2;
    private javax.swing.JTextField edtFOR_IE;
    private javax.swing.JTextField edtFOR_NOME;
    private javax.swing.JTextField edtFOR_NUMERO;
    private javax.swing.JTextField edtFOR_SITE;
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
    private javax.swing.JLabel lblCONS_ID;
    private javax.swing.JLabel lblCONS_NOME;
    private javax.swing.JLabel lblCodigo2;
    private javax.swing.JLabel lblDATA;
    private javax.swing.JLabel lblFOR_ATIVO;
    private javax.swing.JLabel lblFOR_BAIRRO;
    private javax.swing.JLabel lblFOR_CELULAR;
    private javax.swing.JLabel lblFOR_CEP;
    private javax.swing.JLabel lblFOR_CIDADE;
    private javax.swing.JLabel lblFOR_CNPJ;
    private javax.swing.JLabel lblFOR_CODIGO;
    private javax.swing.JLabel lblFOR_COMPLEMENTO;
    private javax.swing.JLabel lblFOR_CONTATO;
    private javax.swing.JLabel lblFOR_EMAIL;
    private javax.swing.JLabel lblFOR_ENDERECO;
    private javax.swing.JLabel lblFOR_FANTASIA;
    private javax.swing.JLabel lblFOR_FISICA;
    private javax.swing.JLabel lblFOR_FONE1;
    private javax.swing.JLabel lblFOR_FONE2;
    private javax.swing.JLabel lblFOR_IE;
    private javax.swing.JLabel lblFOR_NOME;
    private javax.swing.JLabel lblFOR_NUMERO;
    private javax.swing.JLabel lblFOR_SITE;
    private javax.swing.JLabel lblFOR_UF;
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
