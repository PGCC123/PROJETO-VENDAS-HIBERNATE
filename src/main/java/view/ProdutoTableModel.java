package view;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.ProdutoModel;

public class ProdutoTableModel extends AbstractTableModel {

    private final ArrayList<ProdutoModel> linhas;
    private final NumberFormat NFC = NumberFormat.getCurrencyInstance();
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    String[] colunas = {"CÓDIGO", "NOME", "ESTOQUE", "UNIDADE", "PREÇO", "CUSTO", "ATACADO", "MIN", "MAX", "EMBALAGEM", "PESO", "CADASTRO",  "ATIVO"};

    public ProdutoTableModel(ArrayList<ProdutoModel> arrayproduto) {
        linhas = arrayproduto;
    }

    //Retorna a quantidade de colunas do modelo, que no caso será fixa
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //Retorna a quantidade de linhas atual do objeto, que no caso é o tamnho da lista
    @Override
    public int getRowCount() {
        return linhas.size();
    }

    //Retorna o nome da coluna, recebendo seu índice
    @Override
    public String getColumnName(int indiceColuna) {
        return colunas[indiceColuna];
    }

    @Override
    public Object getValueAt(int row, int col) {
        ProdutoModel produto = (ProdutoModel) linhas.get(row);
        switch (col) {
            case 0:
                return produto.getPRO_CODIGO();
            case 1:
                return produto.getPRO_NOME();
            case 2:
                return produto.getPRO_ESTOQUE();
            case 3:
                return produto.getPRO_UNIDADE();
            case 4:
                return NFC.format(produto.getPRO_PRECO());
            case 5:
                return NFC.format(produto.getPRO_CUSTO());
            case 6:
                return NFC.format(produto.getPRO_ATACADO());
            case 7:
                return NFC.format(produto.getPRO_MIN());
            case 8:
                return NFC.format(produto.getPRO_MAX());
            case 9:
                return produto.getPRO_EMBALAGEM();
            case 10:
                return produto.getPRO_PESO();
            case 11:
                return SDF.format(produto.getPRO_CADASTRO());
            case 12:
                return produto.getPRO_ATIVO();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de FormaPagamentoModel
    public void addLista(ArrayList<ProdutoModel> produto) {
        int tamanhoAntigo = getRowCount();

        //Adiciona as formas de pagamentos
        linhas.addAll(produto);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
