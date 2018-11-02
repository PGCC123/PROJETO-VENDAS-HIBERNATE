
/*Conteúdo: Menu
 *Autor: Carpezani
 *Data: 16/03/2018
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public abstract class IMenu extends JFrame {

    public IMenu() {

        Menu();
    }

    private void Menu() {

        JMenu cadastro = new JMenu("Cadastros");
        JMenuItem cliente = new JMenuItem("Clientes");
        JMenuItem fornecedor = new JMenuItem("Fornecedores");
        JMenuItem formapagto = new JMenuItem("Formas de Pagamentos");
        JMenuItem produto = new JMenuItem("Produtos");

        cadastro.add(cliente);
        cliente.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dispose();
                ClienteView clienteview;
                clienteview = new ClienteView();
                clienteview.setVisible(true);
            }
        });

        cadastro.add(fornecedor);
        fornecedor.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                FornecedorView fornecedorview;
                fornecedorview = new FornecedorView();
                fornecedorview.setVisible(true);

            }
        });

        cadastro.add(formapagto);
        formapagto.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                FormaPagamentoView formapagto;
                formapagto = new FormaPagamentoView();
                formapagto.setVisible(true);
            }
        });

        cadastro.add(produto);
        produto.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
                ProdutoView produtoview;
                produtoview = new ProdutoView();
                produtoview.setVisible(true);

            }
        });

        JMenu opcoes = new JMenu("Ajuda");
        JMenuItem sobre = new JMenuItem("Sobre");
        JMenuItem sair = new JMenuItem("Sair");
        opcoes.add(sobre);
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(IMenu.this,
                        "Empresa: PLTEC LTDA"
                + "\nContato: 0800 725 7979"
                + "\nE-mail: contato@pltec.com.br");
            }
        }
        );

        opcoes.add(sair);
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sair = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Aviso", JOptionPane.YES_NO_OPTION);
                if (sair == JOptionPane.YES_NO_OPTION) {

                    System.exit(0);
                } else {

                }
            }
        }
        );

        JMenuBar barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);
        barraMenu.add(cadastro);
        barraMenu.add(opcoes);
        setJMenuBar(barraMenu);
    }
}
