package dao;

import java.util.ArrayList;
import model.FornecedorModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class FornecedorDao implements GenericDao<FornecedorModel> {
        
    @Override
    public void incluir(FornecedorModel fornecedor) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(fornecedor);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(FornecedorModel fornecedor) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(fornecedor);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<FornecedorModel> consultar(String filtro) {
        String sql = "from  FornecedorModel f inner join fetch f.pessoamodel as p " + filtro;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<FornecedorModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(FornecedorModel fornecedor) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(fornecedor);
        t.commit();
        session.close();
    }

    @Override
    public FornecedorModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (FornecedorModel) session.load(FornecedorModel.class, id);
    }
}
