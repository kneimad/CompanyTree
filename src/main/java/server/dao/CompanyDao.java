package server.dao;

import java.util.Collection;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import server.entity.CompEntity;
import server.persistence.HibernateUtil;
import server.tree.CompanyNode;

public class CompanyDao {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public Collection<CompEntity> readCompanies() {
        Session session = sessionFactory.openSession();
        System.out.println("Company tree: Maven + Hibernate + MySQL");
        Transaction tx = null;
        Collection<CompEntity> listCompanies = null;

        try{
            HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            listCompanies = (Collection<CompEntity>) session.createCriteria(CompEntity.class).list();
            for (CompEntity o : listCompanies) {
                System.out.println(o.getId() + "\t" + o.getName() + "\t" + o.getEarning()  + "\t" + o.getParentId());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return listCompanies;
    }

    public void removeCompany(int companyId) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            CompEntity company =
                    (CompEntity)session.get(CompEntity.class, companyId);
            session.delete(company);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void renameCompany(int companyId, String newCompanyName) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            CompEntity company =
                    (CompEntity)session.get(CompEntity.class, companyId);
            company.setName(newCompanyName);
            session.update(company);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public int createCompany(int parentId, String companyName, int earning) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer newCompanyId = null;
        try{
            tx = session.beginTransaction();
            CompEntity company = new CompEntity();
            company.setName(companyName);
            company.setParentId(parentId);
            company.setEarning(earning);
            newCompanyId = (int) session.save(company);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return newCompanyId;
    }
}
