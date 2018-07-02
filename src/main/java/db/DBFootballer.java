package db;

import models.Footballer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBFootballer {

    private static Session session;
    private static Transaction transaction;

    public static void save(Footballer footballer){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(footballer);
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Footballer> getAll(){
        List<Footballer> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Footballer.class);
            results = criteria.list();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } return results;
    }

    public static void update(Footballer footballer){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.update(footballer);
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void delete(Footballer footballer) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(footballer);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void deleteAll(){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Footballer.class);
            List<Footballer> results = criteria.list();
            transaction = session.beginTransaction();
            for(Footballer footballer : results){
                session.delete(footballer);
            }
            transaction.commit();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally{
            session.close();
        }
    }

    public static Footballer find(int id){
        Footballer result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Footballer.class);
            criteria.add(Restrictions.eq("id", id));
            result = (Footballer)criteria.uniqueResult();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        } return result;
    }

    public static Footballer findByLastName(String lastName){
        Footballer result = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            Criteria criteria = session.createCriteria(Footballer.class);
            criteria.add(Restrictions.eq("lastName", lastName));
            result = (Footballer)criteria.uniqueResult();
        } catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally{
            session.close();
        } return result;
    }
}
