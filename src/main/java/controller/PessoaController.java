package controller;

import dao.PessoaDao;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.PessoaModel;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import util.ReportUtils;

public class PessoaController implements GenericController<PessoaModel>{
  PessoaDao pessoadao;

    public PessoaController() {
        pessoadao = new PessoaDao();
    }

    @Override
    public void incluir(PessoaModel obj) throws Exception{
        pessoadao.incluir(obj);
    }

    @Override
    public void alterar(PessoaModel obj) throws Exception{
        pessoadao.alterar(obj);
    }

    @Override
    public void excluir(PessoaModel obj) throws Exception{
        pessoadao.excluir(obj);
    }

    @Override
    public ArrayList<PessoaModel> consultar(String filtro) {
        return pessoadao.consultar(filtro);
    }

    @Override
    public void gravar(PessoaModel obj, String operacao) throws Exception{
        if (operacao.equals("incluir")) {
            incluir(obj);
        } else {
            alterar(obj);
        }
    }

    @Override
    public Exception imprimir() {
        Exception retorno = null;
        InputStream inputStream = getClass().getResourceAsStream("/relatorios/RelatorioUsuario.jasper");
//        btnPRIMEIRO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/primeiro.png"))); // NOI18N

        Map parametros = new HashMap();
        
        List dados = consultar("");
        
        // criando o datasource com os dados criados
        JRDataSource ds = new JRBeanCollectionDataSource(dados);

        try {
            // passando o datasource para o método de criação e exibição do relatório
            ReportUtils.openReport("Usuários - Bean Collection Data Source", inputStream, parametros, ds);

        } catch (Exception ex) {
            retorno =  ex;
        }
        return retorno;
    }

}
