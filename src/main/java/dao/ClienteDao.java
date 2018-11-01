package dao;

import java.util.ArrayList;
import model.ClienteModel;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ClienteDao implements GenericDao<ClienteModel> {

    @Override
    public void incluir(ClienteModel cliente) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(cliente);
        t.commit();
        session.close();
    }

    @Override
    public void alterar(ClienteModel cliente) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(cliente);
        t.commit();
        session.close();
    }

    @Override
    public ArrayList<ClienteModel> consultar(String filtro) {
        String sql = "from  ClienteModel c inner join fetch c.pessoamodel as p " + filtro;
       // String sql = "from  ClienteModel " + filtro;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        ArrayList lista = (ArrayList<ClienteModel>) session.createQuery(sql).list();
        t.commit();
        session.close();
        return lista;
    }

    @Override
    public void excluir(ClienteModel cliente) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(cliente);
        t.commit();
        session.close();
    }

    @Override
    public ClienteModel get(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (ClienteModel) session.load(ClienteModel.class, id);
    }
}
