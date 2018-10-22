package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.FormaPagamentoModel;

public class FormaPagamentoTableModel extends AbstractTableModel {

    private final ArrayList<FormaPagamentoModel> linhas;
    String[] colunas = {"CÓDIGO", "NOME", "ATIVO"};

    public FormaPagamentoTableModel(ArrayList<FormaPagamentoModel> arrayformapagto) {
        linhas = arrayformapagto;
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
        FormaPagamentoModel formapagto = (FormaPagamentoModel) linhas.get(row);
        switch (col) {
            case 0:
                return formapagto.getFPG_CODIGO();
            case 1:
                return formapagto.getFPG_NOME();
            case 2:
                return formapagto.getFPG_ATIVO();
            default:
                return null;
        }
    }

    //Adicionamos várias linhas na tabela de uma vez, recebendo um List de FormaPagamentoModel
    public void addLista(ArrayList<FormaPagamentoModel> formapagto) {
        int tamanhoAntigo = getRowCount();

        //Adiciona as formas de pagamentos
        linhas.addAll(formapagto);

        //Aqui reportamos a mudança para o JTable, assim ele pode se redesenhar, para visualizarmos a alteração
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }
}
