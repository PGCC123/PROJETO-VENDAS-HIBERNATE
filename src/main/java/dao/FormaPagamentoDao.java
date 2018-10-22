package dao;

import java.util.ArrayList;
import model.FormaPagamentoModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class FormaPagamentoDao implements GenericDao<FormaPagamentoModel> {

    @Override
    public void incluir(FormaPagamentoModel formapagto) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(formapagto);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(FormaPagamentoModel formapagto) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(formapagto);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<FormaPagamentoModel> consultar(String filtro) {
        String sql = "from " + FormaPagamentoModel.class.getName() + filtro;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<FormaPagamentoModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(FormaPagamentoModel formapagto) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(formapagto);
        t.commit();
        session.close();
    }

    @Override
    public FormaPagamentoModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (FormaPagamentoModel) session.load(FormaPagamentoModel.class, id);
    }
}
