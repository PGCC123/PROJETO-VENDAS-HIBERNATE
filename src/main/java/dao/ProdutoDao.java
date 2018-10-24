package dao;

import java.util.ArrayList;
import model.ProdutoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProdutoDao implements GenericDao<ProdutoModel> {

    @Override
    public void incluir(ProdutoModel produto) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(produto);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(ProdutoModel produto) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(produto);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<ProdutoModel> consultar(String filtro) {
        String sql = "from " + ProdutoModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<ProdutoModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(ProdutoModel produto) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(produto);
        t.commit();
        session.close();
    }

    @Override
    public ProdutoModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (ProdutoModel) session.load(ProdutoModel.class, id);
    }
}
