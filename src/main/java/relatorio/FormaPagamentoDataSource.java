package relatorio;

import java.util.Iterator;
import java.util.List;
import model.FormaPagamentoModel;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class FormaPagamentoDataSource implements JRDataSource {

    private final Iterator itrPagamento;
    private Object valorAtual;

    private int i = 0;

    private boolean irParaProximoPagamento = true;

    /**
     * @param campos
     * @param itr
     */
    public FormaPagamentoDataSource(List lista) {
        super();
        this.itrPagamento = lista.iterator();
    }

    public boolean next() throws JRException {
        valorAtual = itrPagamento.hasNext() ? itrPagamento.next() : null;
        irParaProximoPagamento = (valorAtual != null);
        return irParaProximoPagamento;
    }

    public Object getFieldValue(JRField campo) throws JRException {
        Object valor = null;
        FormaPagamentoModel pagamento = (FormaPagamentoModel) valorAtual;

        if ("FPG_CODIGO".equals(campo.getName())) {
            valor = pagamento.getFPG_CODIGO();
        } else if ("FPG_NOME".equals(campo.getName())) {
            valor = pagamento.getFPG_NOME();
        } else if ("FPG_ATIVO".equals(campo.getName())) {
            valor = pagamento.getFPG_ATIVO();
        }

        return valor;
    }
}