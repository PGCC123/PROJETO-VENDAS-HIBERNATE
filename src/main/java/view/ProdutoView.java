package view;

import controller.ProdutoController;
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
import model.ProdutoModel;

public class ProdutoView extends javax.swing.JFrame {

    private String operacao;
    private ArrayList<ProdutoModel> array;
    private ProdutoTableModel mtb;
    private ProdutoController produtocontroller;

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

    public ProdutoView() {
        produtocontroller = new ProdutoController();
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

        this.pack();
    }

    private boolean validacao() { // não completa. 
        String erroMessage = "Campos com * devem ser preenchidos!";

        if (edtPRO_NOME.getText() == null || edtPRO_NOME.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtPRO_NOME.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtPRO_NOME.setBorder(border);
        }

        if (edtPRO_PRECO.getText() == null || edtPRO_PRECO.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtPRO_PRECO.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtPRO_PRECO.setBorder(border);
        }

        if (edtPRO_CUSTO.getText() == null || edtPRO_CUSTO.getText().length() == 0) {
            Border border = BorderFactory.createLineBorder(Color.RED, (int) 1.5);
            edtPRO_CUSTO.setBorder(border);
        } else {
            Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
            edtPRO_CUSTO.setBorder(border);
        }

        if (erroMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public final void inativarCampos() {
        edtPRO_NOME.setEditable(false);
        edtPRO_ESTOQUE.setEditable(false);
        edtPRO_UNIDADE.setEditable(false);
        edtPRO_PRECO.setEditable(false);
        edtPRO_CUSTO.setEditable(false);
        edtPRO_ATACADO.setEditable(false);
        edtPRO_MIN.setEditable(false);
        edtPRO_MAX.setEditable(false);
        edtPRO_EMBALAGEM.setEditable(false);
        edtPRO_PESO.setEditable(false);
        edtPRO_OBS.setEditable(false);
        comboPRO_ATIVO.setEnabled(false);
    }

    public final void ativarCampos() {
         edtPRO_NOME.setEditable(true);
        edtPRO_ESTOQUE.setEditable(true);
        edtPRO_UNIDADE.setEditable(true);
        edtPRO_PRECO.setEditable(true);
        edtPRO_CUSTO.setEditable(true);
        edtPRO_ATACADO.setEditable(true);
        edtPRO_MIN.setEditable(true);
        edtPRO_MAX.setEditable(true);
        edtPRO_EMBALAGEM.setEditable(true);
        edtPRO_PESO.setEditable(true);
        edtPRO_OBS.setEditable(true);
        comboPRO_ATIVO.setEnabled(true);
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
        lblPRO_CODIGO = new javax.swing.JLabel();
        lblPRO_NOME = new javax.swing.JLabel();
        lblPRO_PRECO = new javax.swing.JLabel();
        edtPRO_CODIGO = new javax.swing.JTextField();
        edtPRO_NOME = new javax.swing.JTextField();
        edtPRO_PRECO = new javax.swing.JTextField();
        lblPRO_CUSTO = new javax.swing.JLabel();
        comboPRO_ATIVO = new javax.swing.JComboBox<>();
        lblPRO_ATIVO = new javax.swing.JLabel();
        lblPRO_OBS = new javax.swing.JLabel();
        lblPRO_ATACADO = new javax.swing.JLabel();
        lblPRO_MAX = new javax.swing.JLabel();
        lblPRO_MIN = new javax.swing.JLabel();
        edtPRO_ATACADO = new javax.swing.JTextField();
        edtPRO_CUSTO = new javax.swing.JTextField();
        edtPRO_MAX = new javax.swing.JTextField();
        edtPRO_MIN = new javax.swing.JTextField();
        edtPRO_OBS = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblPRO_ESTOQUE = new javax.swing.JLabel();
        edtPRO_ESTOQUE = new javax.swing.JTextField();
        lblPRO_EMBALAGEM = new javax.swing.JLabel();
        edtPRO_EMBALAGEM = new javax.swing.JTextField();
        lblPRO_PESO = new javax.swing.JLabel();
        edtPRO_PESO = new javax.swing.JTextField();
        edtPRO_UNIDADE = new javax.swing.JTextField();
        lblPRO_UNIDADE = new javax.swing.JLabel();
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
        setTitle("Sales System - Cadastro de Produtos");
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
        lblTitulo.setText("CADASTRO DE PRODUTOS");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 90, 1300, 29);

        lblPRO_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_CODIGO.setText("Código");

        lblPRO_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_NOME.setText("Nome");

        lblPRO_PRECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_PRECO.setText("Preço");

        edtPRO_CODIGO.setEditable(false);
        edtPRO_CODIGO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_NOME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_PRECO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPRO_CUSTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_CUSTO.setText("Custo");

        comboPRO_ATIVO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ATIVO", "INATIVO" }));

        lblPRO_ATIVO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_ATIVO.setText("Ativo?");

        lblPRO_OBS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_OBS.setText("Obs");

        lblPRO_ATACADO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_ATACADO.setText("Atacado");

        lblPRO_MAX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_MAX.setText("Max.");

        lblPRO_MIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_MIN.setText("Min.");

        edtPRO_ATACADO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_CUSTO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_MAX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_MIN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_OBS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPRO_PRECO)
                            .addComponent(lblPRO_ATACADO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edtPRO_ATACADO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(202, 202, 202))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(edtPRO_PRECO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(lblPRO_MAX)
                                .addGap(151, 151, 151)))
                        .addGap(65, 65, 65))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblPRO_CODIGO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtPRO_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPRO_NOME)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(edtPRO_MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblPRO_MIN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(edtPRO_MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(edtPRO_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblPRO_CUSTO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtPRO_CUSTO, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblPRO_OBS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtPRO_OBS, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPRO_ATIVO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboPRO_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtPRO_CODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_CODIGO)
                    .addComponent(comboPRO_ATIVO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_ATIVO)
                    .addComponent(edtPRO_NOME, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_NOME)
                    .addComponent(lblPRO_OBS)
                    .addComponent(edtPRO_OBS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_PRECO)
                    .addComponent(edtPRO_PRECO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_MIN)
                    .addComponent(edtPRO_MIN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtPRO_MAX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_MAX)
                    .addComponent(lblPRO_CUSTO)
                    .addComponent(edtPRO_CUSTO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_ATACADO)
                    .addComponent(edtPRO_ATACADO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dados do Produto", jPanel1);

        lblPRO_ESTOQUE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_ESTOQUE.setText("Estoque");

        edtPRO_ESTOQUE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPRO_EMBALAGEM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_EMBALAGEM.setText("Embalagem");

        edtPRO_EMBALAGEM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPRO_PESO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_PESO.setText("Peso");

        edtPRO_PESO.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        edtPRO_UNIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblPRO_UNIDADE.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPRO_UNIDADE.setText("Unidade");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(lblPRO_ESTOQUE)
                        .addGap(18, 18, 18)
                        .addComponent(edtPRO_ESTOQUE, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblPRO_EMBALAGEM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtPRO_EMBALAGEM, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPRO_PESO)
                    .addComponent(lblPRO_UNIDADE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edtPRO_UNIDADE, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(edtPRO_PESO))
                .addGap(634, 634, 634))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_UNIDADE)
                    .addComponent(edtPRO_ESTOQUE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_ESTOQUE)
                    .addComponent(edtPRO_UNIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPRO_EMBALAGEM)
                    .addComponent(edtPRO_EMBALAGEM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPRO_PESO)
                    .addComponent(edtPRO_PESO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estoque e Embalagem", jPanel5);

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
            JOptionPane.showMessageDialog(null, "Não existem produtos cadastrados!");
        } else {
            int selecionado = 0;
            tblConsulta.changeSelection(selecionado, 0, false, false);
        }
    }//GEN-LAST:event_btnPRIMEIROActionPerformed

    private void btnINCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINCLUIRActionPerformed
        limpar();
        setOperacao("incluir");
        edtPRO_NOME.setFocusable(true);
        this.ativarCampos();
    }//GEN-LAST:event_btnINCLUIRActionPerformed

    private void btnGRAVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGRAVARActionPerformed
        String mensagem;
        String mensagem2;
        if (JOptionPane.showConfirmDialog(null, "Deseja cadastrar esse produto?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            this.validacao();
            ProdutoModel produtomodel = new ProdutoModel();
            produtomodel.setPRO_CODIGO(Integer.parseInt(edtPRO_CODIGO.getText()));
            produtomodel.setPRO_NOME(edtPRO_NOME.getText());
            produtomodel.setPRO_ESTOQUE(Integer.parseInt(edtPRO_ESTOQUE.getText()));
            produtomodel.setPRO_UNIDADE(Integer.parseInt(edtPRO_UNIDADE.getText()));
            produtomodel.setPRO_PRECO(Double.parseDouble(edtPRO_PRECO.getText()));
            produtomodel.setPRO_CUSTO(Double.parseDouble(edtPRO_CUSTO.getText()));
            produtomodel.setPRO_ATACADO(Double.parseDouble(edtPRO_ATACADO.getText()));
            produtomodel.setPRO_MIN(Double.parseDouble(edtPRO_MAX.getText()));
            produtomodel.setPRO_MAX(Double.parseDouble(edtPRO_MAX.getText()));
            produtomodel.setPRO_EMBALAGEM(Double.parseDouble(edtPRO_EMBALAGEM.getText()));
            produtomodel.setPRO_PESO(Double.parseDouble(edtPRO_PESO.getText()));
            //produtomodel.setPRO_CADASTRO(textPRO_CADASTRO.getText());
            produtomodel.setPRO_OBS(edtPRO_OBS.getText());
            produtomodel.setPRO_ATIVO(comboPRO_ATIVO.getSelectedItem().toString());

            try {
                produtocontroller.gravar(produtomodel, getOperacao());
                mensagem = "Produto cadastrado com sucesso!";
                JOptionPane.showMessageDialog(null, mensagem);
                this.inativarCampos();
                this.consultar();
            } catch (Exception ex) {
                mensagem2 = "Os campos destacados em vermelho são obrigatórios!\n "
                        + "Erro ao cadastrar o produto.\n" + ex.getMessage();
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
       edtPRO_CODIGO.setText("0");
        edtPRO_NOME.setText("");
        edtPRO_ESTOQUE.setText("");
        edtPRO_UNIDADE.setText("");
        edtPRO_PRECO.setText("");
        edtPRO_CUSTO.setText("");
        edtPRO_ATACADO.setText("");
        edtPRO_MIN.setText("");
        edtPRO_MAX.setText("");
        edtPRO_EMBALAGEM.setText("");
        edtPRO_PESO.setText("");
        //textPRO_CADASTRO.setText("");
        edtPRO_OBS.setText("");
    }

    private void mostrar(ProdutoModel produto) {
        edtPRO_CODIGO.setText(String.valueOf(produto.getPRO_CODIGO()));
        edtPRO_NOME.setText(produto.getPRO_NOME());
        edtPRO_ESTOQUE.setText(String.valueOf(produto.getPRO_ESTOQUE()));
        edtPRO_UNIDADE.setText(String.valueOf(produto.getPRO_UNIDADE()));
        edtPRO_PRECO.setText(String.valueOf(produto.getPRO_PRECO()));
        edtPRO_CUSTO.setText(String.valueOf(produto.getPRO_CUSTO()));
        edtPRO_ATACADO.setText(String.valueOf(produto.getPRO_ATACADO()));
        edtPRO_MIN.setText(String.valueOf(produto.getPRO_MIN()));
        edtPRO_MAX.setText(String.valueOf(produto.getPRO_MAX()));
        edtPRO_EMBALAGEM.setText(String.valueOf(produto.getPRO_EMBALAGEM()));
        edtPRO_PESO.setText(String.valueOf(produto.getPRO_PESO()));
        //textPRO_CADASTRO.setText(produto.getPRO_CADASTRO());
        edtPRO_OBS.setText(produto.getPRO_OBS());
        comboPRO_ATIVO.setSelectedItem(produto.getPRO_ATIVO());
    }

    private String filtrar() {
        String condicao = "";
        if (!edtCONS_ID1.getText().trim().equals("")) {
            condicao += "(PRO_CODIGO >= " + edtCONS_ID1.getText() + ")";
        }
        if (!edtCONS_ID2.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_CODIGO <= " + edtCONS_ID2.getText() + ")";
        }
        if (!edtCONS_NOME.getText().trim().equals("")) {
            if (!condicao.isEmpty()) {
                condicao += " AND ";
            }
            condicao += "(PRO_NOME LIKE ('%" + edtCONS_NOME.getText() + "%'))";
        }

        if (!condicao.trim().equals("")) {
            condicao = " WHERE " + condicao;
        }
        return condicao;
    }

    private void consultar() {
        String condicao = filtrar();
        array = null;
        array = produtocontroller.consultar(condicao);
        if (array.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem produtos cadastrados!");
        } else {
            mtb =  new ProdutoTableModel(array);
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
        setOperacao("");
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir esse usuário?",
                "Confirmação", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            ProdutoModel produtomodel = new ProdutoModel();
            produtomodel.setPRO_CODIGO(Integer.parseInt(edtPRO_CODIGO.getText()));
            produtomodel.setPRO_NOME(edtPRO_NOME.getText());
            produtomodel.setPRO_ESTOQUE(Integer.parseInt(edtPRO_ESTOQUE.getText()));
            produtomodel.setPRO_UNIDADE(Integer.parseInt(edtPRO_UNIDADE.getText()));
            produtomodel.setPRO_PRECO(Double.parseDouble(edtPRO_PRECO.getText()));
            produtomodel.setPRO_CUSTO(Double.parseDouble(edtPRO_CUSTO.getText()));
            produtomodel.setPRO_ATACADO(Double.parseDouble(edtPRO_ATACADO.getText()));
            produtomodel.setPRO_MIN(Double.parseDouble(edtPRO_MAX.getText()));
            produtomodel.setPRO_MAX(Double.parseDouble(edtPRO_MAX.getText()));
            produtomodel.setPRO_EMBALAGEM(Double.parseDouble(edtPRO_EMBALAGEM.getText()));
            produtomodel.setPRO_PESO(Double.parseDouble(edtPRO_PESO.getText()));
            //produtomodel.setPRO_CADASTRO(textPRO_CADASTRO.getText());
            produtomodel.setPRO_OBS(edtPRO_OBS.getText());
            produtomodel.setPRO_ATIVO(comboPRO_ATIVO.getSelectedItem().toString());

            try {
                produtocontroller.excluir(produtomodel);
                mensagem = "Produto excluído com sucesso!";
                JOptionPane.showMessageDialog(null, mensagem);
                this.inativarCampos();
                this.consultar();
            } catch (Exception ex) {
                mensagem2 = "Erro na exclusão do produto!\n" + ex.getMessage();
                JOptionPane.showMessageDialog(null, mensagem2, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void btnIMPRIMIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMPRIMIRActionPerformed
        Exception retorno = produtocontroller.imprimir();
        if (retorno != null) {
            JOptionPane.showMessageDialog(null, "Erro na exibição do relatório de produtos!\n" + retorno.getMessage());
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
    private javax.swing.JComboBox<String> comboPRO_ATIVO;
    private javax.swing.JTextField edtCONS_ID1;
    private javax.swing.JTextField edtCONS_ID2;
    private javax.swing.JTextField edtCONS_NOME;
    private javax.swing.JTextField edtPRO_ATACADO;
    private javax.swing.JTextField edtPRO_CODIGO;
    private javax.swing.JTextField edtPRO_CUSTO;
    private javax.swing.JTextField edtPRO_EMBALAGEM;
    private javax.swing.JTextField edtPRO_ESTOQUE;
    private javax.swing.JTextField edtPRO_MAX;
    private javax.swing.JTextField edtPRO_MIN;
    private javax.swing.JTextField edtPRO_NOME;
    private javax.swing.JTextField edtPRO_OBS;
    private javax.swing.JTextField edtPRO_PESO;
    private javax.swing.JTextField edtPRO_PRECO;
    private javax.swing.JTextField edtPRO_UNIDADE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JLabel lblHORA;
    private javax.swing.JLabel lblPRO_ATACADO;
    private javax.swing.JLabel lblPRO_ATIVO;
    private javax.swing.JLabel lblPRO_CODIGO;
    private javax.swing.JLabel lblPRO_CUSTO;
    private javax.swing.JLabel lblPRO_EMBALAGEM;
    private javax.swing.JLabel lblPRO_ESTOQUE;
    private javax.swing.JLabel lblPRO_MAX;
    private javax.swing.JLabel lblPRO_MIN;
    private javax.swing.JLabel lblPRO_NOME;
    private javax.swing.JLabel lblPRO_OBS;
    private javax.swing.JLabel lblPRO_PESO;
    private javax.swing.JLabel lblPRO_PRECO;
    private javax.swing.JLabel lblPRO_UNIDADE;
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
