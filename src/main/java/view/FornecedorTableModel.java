package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.FornecedorModel;

public class FornecedorTableModel extends AbstractTableModel {

    private final ArrayList<FornecedorModel> linhas;
    String[] colunas = {"CÓDIGO", "NOME FANTASIA", "CNPJ", "INSCRIÇÃO ESTADUAL", "TELEFONE", "ATIVO"};

    public FornecedorTableModel(ArrayList<FornecedorModel> arrayfornecedor) {
        linhas = arrayfornecedor;
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
        FornecedorModel fornecedor = (FornecedorModel) linhas.get(row);
        switch (col) {
            case 0:
                return fornecedor.getFOR_CODIGO();
            case 1:
                return fornecedor.getPessoamodel().getPES_FANTASIA();
            case 2:
                return fornecedor.getPessoamodel().getPES_CPFCNPJ();
            case 3:
                return fornecedor.getPessoamodel().getPES_RGIE();
            case 4:
                return fornecedor.getPessoamodel().getPES_FONE1();
            case 5:
                return fornecedor.getPessoamodel().getPES_ATIVO();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de FornecedorModel
    public void addLista(ArrayList<FornecedorModel> fornecedor) {
        int tamanhoAntigo = getRowCount();

        //Adiciona os usuários
        linhas.addAll(fornecedor);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
