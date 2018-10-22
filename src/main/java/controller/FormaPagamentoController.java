package controller;

import dao.FormaPagamentoDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FormaPagamentoModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

public class FormaPagamentoController implements GenericController<FormaPagamentoModel> {

    FormaPagamentoDao formapagto;

    public FormaPagamentoController() {
        formapagto = new FormaPagamentoDao();
    }

    @Override
    public void incluir(FormaPagamentoModel obj) throws Exception {
        formapagto.incluir(obj);
    }

    @Override
    public void alterar(FormaPagamentoModel obj) throws Exception {
        formapagto.alterar(obj);
    }

    @Override
    public void excluir(FormaPagamentoModel obj) throws Exception {
        formapagto.excluir(obj);
    }

    @Override
    public ArrayList<FormaPagamentoModel> consultar(String filtro) {
        return formapagto.consultar(filtro);
    }

    @Override
    public void gravar(FormaPagamentoModel obj, String operacao) throws Exception {
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() throws Exception {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioFormaPagamento.jasper");
        // btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();

        List dados = consultar("");

        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Forma de Pagamento - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (JRException ex) {
            retorno = ex;
        }
        return retorno;
    }
}
